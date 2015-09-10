/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Buyer;

/**
 *
 * @author Erwin Dave Salnas
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import DataStore.Position;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JFileChooser;


public class Buyer extends JDialog implements ActionListener {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Position person;
	public String name;
	
	Buyer record;
	 
	JButton buttonOk;
	JButton buttonOk1;
	JButton buttonCancel;
	JTextField tfName;
	JTextField tfRow;
	JTextField tfCol;
	JPanel panel;
	JPanel buttonPanel;
	JPanel radioButtonPanel;
	JPanel textFieldPanel;
	
	
	JTextField textFieldName;
	JTextField textFieldRow;
	JTextField textFieldCol;
	
	public Buyer( double lonCoord, double latCoord , String newname)
	{
		person = new Position(lonCoord,latCoord);
		name = newname;
	}
	/*****************************************
	* Function: addSeller1
	* Parameters: N/A
	* Description:  This function will prompt the user for the coordinates and name of seller. When this is done, a new seller 
	* 				will be added.
	* Inputs: coordinates(longitude,latitude), name.
	* Outputs: N/A
	/*******************************************/
	public void addBuyer()
	{
		this.setTitle("Create Buyer");
		
		
		panel=new JPanel();
		buttonPanel=new JPanel();
		textFieldPanel=new JPanel();
		
		
		GridLayout gltf=new GridLayout(6,2);
		GridLayout glb=new GridLayout(1,2);
		
		textFieldPanel.setLayout(gltf);
		buttonPanel.setLayout(glb);

		
		textFieldRow=makeTextField("Longitude",true);
		textFieldCol=makeTextField("Latitude",true);
		textFieldName=makeTextField("Name",true);
	
	
		buttonOk=makeButton("OK");
		buttonCancel=makeButton("Cancel");
		
		panel.add(textFieldPanel);
		panel.add(buttonPanel);
		this.add(panel);
		this.setSize(400,200);
	}
	public void updateBuyer()
	{
		
		this.setTitle("Update Buyer");
		
		
		panel=new JPanel();
		buttonPanel=new JPanel();
		textFieldPanel=new JPanel();
		
		
		GridLayout gltf=new GridLayout(6,2);
		GridLayout glb=new GridLayout(1,2);
		
		textFieldPanel.setLayout(gltf);
		buttonPanel.setLayout(glb);

		
		textFieldRow=makeTextField("New longitude",true);
		textFieldCol=makeTextField("New latitude",true);
		textFieldName=makeTextField("New name",true);
	
	
		buttonOk=makeButton("OK");
		buttonCancel=makeButton("Cancel");
		
		panel.add(textFieldPanel);
		panel.add(buttonPanel);
		this.add(panel);
		this.setSize(400,200);
		
	}
	public void deleteBuyer()
	{
		int dialogButton = JOptionPane.YES_NO_OPTION;
		JOptionPane.showConfirmDialog(this, "Are you sure you want to remove?","Remove Seller", dialogButton);
		if(dialogButton == JOptionPane.YES_OPTION)
		{
			
		person = null;
		name = null;
		
		}
		
		
	}
        
        public void loadBuyer()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Load File");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		File fileToOpen = null;
                double lonCoord =0;
                double latCoord =0;
                String loadname=null;
		
		int userSelection = fileChooser.showOpenDialog(this);
		if(userSelection == JFileChooser.APPROVE_OPTION)
		{
			
			fileToOpen = fileChooser.getSelectedFile();
			System.out.println("Load as File: "+fileToOpen.getAbsolutePath());
			try
                        {
                                Scanner grabMeteorite = new Scanner(fileToOpen);
                                while(grabMeteorite.hasNext())
                                {
                                    String eachline = grabMeteorite.nextLine();
                                    String[] eachlineArray = eachline.split(",");
                                    lonCoord = Double.parseDouble(eachlineArray[0]);
                                    latCoord = Double.parseDouble(eachlineArray[1]);
                                    loadname= eachlineArray[2];
                                }
                                System.out.println("File has been loaded with Seller");
                        }          
                        catch (FileNotFoundException fe) {
                                System.out.println("File not found!\n");
                        }
                    person = new Position(lonCoord,latCoord);
                    name = loadname;
                    System.out.printf("%.2f,%.2f  %s\n",person.lonCoord,person.latCoord,name);
                }
                else if(userSelection == JFileChooser.CANCEL_OPTION)
                {
                    System.out.println("Cancel");
                    dispose();
                }
	
}
	private JButton makeButton(String string) {
		JButton b= new JButton();
		b.setText(string);
		b.addActionListener(this);
		buttonPanel.add(b);
		return b;
	}
	private JTextField makeTextField(String string,boolean enable) {
		JTextField tf=new JTextField();
		JLabel l=new JLabel(string);
	
		textFieldPanel.add(l);
		textFieldPanel.add(tf);
		l.setEnabled(enable);
		tf.setEnabled(enable);
		return tf;
	}

    public void saveBuyer()
    {
                 JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save File");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                File fileToSave = null;
                
                int userSelection = fileChooser.showSaveDialog(this);
                if(userSelection == JFileChooser.APPROVE_OPTION){
                    fileToSave = fileChooser.getSelectedFile();
                    System.out.println("Save as File: " + fileToSave.getAbsolutePath());
                    try{
			Formatter fout=new Formatter(fileToSave);
			fout.format("%.2f,%.2f,%s",person.lonCoord,person.latCoord,name);
			
			
			fout.flush();
			fout.close();
                        }
                    catch(Exception e)
                    {
			e.printStackTrace();
                    }
                }
                else if(userSelection == JFileChooser.CANCEL_OPTION){
                    System.out.println("Cancel");
                    dispose();
                }
    }
	
	 public void actionPerformed(ActionEvent arg0)
	 {
		double lonCoord;
		double latCoord;
		Object source=null;
		source=arg0.getSource();
		
		if (source==buttonOk)
		{
			System.out.println("OK");
			lonCoord=Double.parseDouble(this.textFieldRow.getText());
			latCoord=Double.parseDouble(this.textFieldCol.getText());
			person = new Position (lonCoord, latCoord);
			name=this.textFieldName.getText();
			
			
			System.out.printf("%.2f,%.2f   %s\n",person.lonCoord,person.latCoord,name);
			dispose();
			
		}
		
		else if (source==buttonCancel)
		{
			System.out.println("Cancel");
			this.dispose();
		 
		}
		
	

	}
}