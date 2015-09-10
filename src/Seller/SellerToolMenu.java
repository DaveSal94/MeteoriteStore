/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Seller;


import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import DataStore.Meteorites;
import DataStore.Pin;
import DataStore.MeteorImageMap;
import java.awt.GridLayout;
import javax.swing.JOptionPane;


public class SellerToolMenu extends JFrame implements ActionListener 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuItem menuItemSave;
	JMenuItem menuItemLoad;
	JMenuItem menuItemExit;
	JMenuItem menuItemCreate;
	JMenuItem menuItemUpdate;	
	JMenuItem menuItemRemove;	
	JMenuItem menuItemCreateMet;
	JMenuItem menuItemCreateMetLn;
	JMenuItem menuItemUpdateMet;
	JMenuItem menuItemRemoveMet;
        JMenuItem menuItemScramble;
	JMenuItem menuItemAbout; 
	Seller seller;
	SellerTool starter = new SellerTool();
	Pin myPin;
	MeteorImageMap mim=new MeteorImageMap(); 
    
        
	public void makeGui()
	{
		
		this.setTitle("Phase 3");
	
		JMenuBar mb=new JMenuBar();
		this.setJMenuBar(mb);

		
		//Load and Save
		ImageIcon saveicon=new ImageIcon("save.png");
		Image image = saveicon.getImage(); // transform it 
		Image newSave = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		saveicon = new ImageIcon(newSave); 
	
		
		ImageIcon loadicon=new ImageIcon("load.png");
		Image imageload = loadicon.getImage(); // transform it 
		Image newLoad = imageload.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		loadicon = new ImageIcon(newLoad); 
		
                ImageIcon exiticon=new ImageIcon("exit.png");
		Image imageExit = exiticon.getImage(); // transform it 
		Image newExit = imageExit.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		exiticon = new ImageIcon(newExit); 
		
                JMenu fMenu=new JMenu("File");
		mb.add(fMenu);	
		
		menuItemSave=new JMenuItem("Save",saveicon);
		menuItemSave.addActionListener(this);
		
		menuItemLoad=new JMenuItem("Load",loadicon);
		menuItemLoad.addActionListener(this);
		menuItemExit=new JMenuItem("Exit",exiticon);
		menuItemExit.addActionListener(this);
		
		fMenu.add(menuItemSave);
		fMenu.add(menuItemLoad);
		fMenu.add(menuItemExit);
		
                JMenu sMenu=new JMenu("Seller");
		mb.add(sMenu);		
		menuItemCreate=new JMenuItem("Create a Seller");
		menuItemCreate.addActionListener(this);
        menuItemUpdate=new JMenuItem("Update a Seller");
        menuItemUpdate.addActionListener(this);
		menuItemRemove=new JMenuItem("Remove a Seller");
		menuItemRemove.addActionListener(this);
		
		sMenu.add(menuItemCreate);
		sMenu.add(menuItemUpdate);
		sMenu.add(menuItemRemove);
		
		
		
		//Handle Menu
		JMenu hMenu=new JMenu("Handle Meteorite");
		mb.add(hMenu);		
		menuItemCreateMet=new JMenuItem("Create a meteorite");
		menuItemCreateMet.addActionListener(this);
		menuItemCreateMetLn=new JMenuItem("Create a meteorite in a single line");
		menuItemCreateMetLn.addActionListener(this);
		menuItemUpdateMet=new JMenuItem("Update a meteorite");
		menuItemUpdateMet.addActionListener(this);
		menuItemRemoveMet=new JMenuItem("Remove a meteorite");
		menuItemRemoveMet.addActionListener(this);
		//
		hMenu.add(menuItemCreateMet);
		hMenu.add(menuItemCreateMetLn);
		hMenu.add(menuItemUpdateMet);
		hMenu.add(menuItemRemoveMet);
                
                JMenu scrambleMenu = new JMenu("Scramble");
		mb.add(scrambleMenu);
                menuItemScramble = new JMenuItem("Scramble Map");
                menuItemScramble.addActionListener(this);
		scrambleMenu.add(menuItemScramble);
		
		//About Menu
		JMenu aMenu=new JMenu("About");
		mb.add(aMenu);
		menuItemAbout = new JMenuItem("About Box");
		menuItemAbout.addActionListener(this);
	
		aMenu.add(menuItemAbout);		
		
		
		JPanel tPanel=new JPanel();
		this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
		
		this.add(tPanel);
		tPanel.add(mim);
		this.pack();
		this.setSize(new Dimension(800,470));
		this.setVisible(true);
		
	
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
                       
                        JPanel panel1 = new JPanel();
                        panel1.setLayout(new GridLayout(5,0,10,5)); 
                        panel1.setVisible(true); 
                        
			Meteorites temp2;
			System.out.println(e.getActionCommand());
			switch(e.getActionCommand())
			{
			case "Load": 
                           Object[] LoadOptions = {"Load Seller", "Load Meteorites", "Cancel"};
                            int resultLoad = JOptionPane.showOptionDialog(null, panel1, "Choose a file to Load", JOptionPane.OK_CANCEL_OPTION,
                                              JOptionPane.QUESTION_MESSAGE, null, LoadOptions, LoadOptions[2]);
                           if(resultLoad == 0)
                           {
                                seller = new Seller(0,0,null);
                                seller.loadSeller();
                           }
                         else if(resultLoad == 1)
                            {
				starter.Load();
				System.out.println(starter.meteoriteList.size());
				for (int i =0; i<starter.meteoriteList.size(); i++)
				{
					temp2= starter.meteoriteList.get(i);
					myPin=new Pin(temp2.location.lonCoord,temp2.location.latCoord,temp2.sold);
					mim.addPin(myPin);
					
				}
                                
                            }
                            else if(resultLoad == 2)
                            {
                                System.out.println("Cancel"); 
                            } 
                            break;
			case "Save":
                           Object[] SaveOptions = {"Save Seller", "Save Meteorites", "Cancel"};
                             int resultSave = JOptionPane.showOptionDialog(null, panel1, "Choose a file to save", JOptionPane.OK_CANCEL_OPTION,
                                              JOptionPane.QUESTION_MESSAGE, null, SaveOptions, SaveOptions[2]); 
                           if(resultSave== 0)
                            {
                                seller.save();
                            }
                            else if(resultSave == 1)
                            { 
				starter.save();
                            }
                            else if(resultSave == 2)
                            {
                                System.out.println("Cancel"); 
                            } 
                            break;
			case "Exit":
				System.exit(0);
				break;
			case "Create a Seller":
				seller = new Seller(0,0,null);
				seller.setVisible(true);
				seller.addSeller();
				break;
			case "Update a Seller":
				seller = new Seller(seller.person.lonCoord,seller.person.latCoord,seller.name);
				seller.setVisible(true);
				seller.updateSeller();
				
				break;
			case "Remove a Seller":
				seller = new Seller(seller.person.lonCoord,seller.person.latCoord,seller.name);
				seller.setVisible(true);
				seller.deleteSeller();
				 
				break;
			case "Create a meteorite":
				starter.create();
                                try{
                                    System.out.println(starter.meteoriteList.size());
                                    temp2= starter.meteoriteList.get(starter.meteoriteList.size()-1);
                                    myPin=new Pin(temp2.location.lonCoord,temp2.location.latCoord,temp2.sold);
                                    mim.addPin(myPin);
                                }
                                catch(Exception get)
                                {
                                    get.getStackTrace();
                                }
                                break;
			case "Create a meteorite in a single line":
		    		starter.createoneln();
                                try{
		    		System.out.println(starter.meteoriteList.size());
		    		temp2= starter.meteoriteList.get(starter.meteoriteList.size()-1);
		    		myPin=new Pin(temp2.location.lonCoord,temp2.location.latCoord,temp2.sold);
			        mim.addPin(myPin);
                                }
                                catch(Exception get)
                                {
                                    get.getStackTrace();
                                }
				break;
			case "Update a meteorite":
				
                                int findit = starter.update();
                                try{
                                if(findit != -1)
                                 {
                                    temp2= starter.meteoriteList.get(findit);
                                    myPin=new Pin(temp2.location.lonCoord,temp2.location.latCoord,temp2.sold);
                                    mim.removepin(findit);
                                    mim.addPin(myPin);
                                  } 
                                }
                                catch(Exception get)
                                {
                                    get.getStackTrace();
                                }
                                
				break;
			case "Remove a meteorite":
				int findit1=starter.remove();
				if(findit1 != -1)
					mim.removepin(starter.meteoriteList.size()); 
				break;
			case "About Box":
				System.out.println("here");
				
				break;
                        case "Scramble Map":
                               starter.ScrambleMeteorite();
                               for(int i =0 ; i<starter.meteoriteList.size(); i++)
                               {
                                    temp2= starter.meteoriteList.get(i);
                                    myPin=new Pin(temp2.location.lonCoord,temp2.location.latCoord,temp2.sold);
    
                                    mim.removepin(i);
                                    mim.addPin(myPin);
                               }
                               
                               break;
                                
                         
		}
			
				
	}
		
}
	

