/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Buyer;



import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import DataStore.Meteorites;
import DataStore.Pin;
import DataStore.MeteorImageMap;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BuyerToolMenu extends JFrame implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	JMenuItem menuItemSave;
	JMenuItem menuItemLoad;
	JMenuItem menuItemExit;
	JMenuItem menuItemAbout; 
        JMenuItem menuItemBuy;
        JMenuItem menuItemScramble;
        JMenuItem menuItemCreate;
	JMenuItem menuItemUpdate;	
	JMenuItem menuItemRemove;
	Buyer buyer;
	BuyerTool starter = new BuyerTool();
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
		Image newSave = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
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
		
		JMenu bMenu = new JMenu("Buy a Meteorite");
                mb.add(bMenu);
                
		menuItemBuy = new JMenuItem("Buy");
                menuItemBuy.addActionListener(this);
                bMenu.add(menuItemBuy);
		
		JMenu sMenu=new JMenu("Buyer");
		mb.add(sMenu);		
		menuItemCreate=new JMenuItem("Create a Buyer");
		menuItemCreate.addActionListener(this);
                menuItemUpdate=new JMenuItem("Update a Buyer");
                menuItemUpdate.addActionListener(this);
		menuItemRemove=new JMenuItem("Remove a Buyer");
		menuItemRemove.addActionListener(this);
		
		sMenu.add(menuItemCreate);
		sMenu.add(menuItemUpdate);
		sMenu.add(menuItemRemove);
		
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
                           Object[] LoadOptions = {"Load Buyer", "Load Meteorites", "Cancel"};
                            int resultLoad = JOptionPane.showOptionDialog(null, panel1, "Choose a file to Load", JOptionPane.OK_CANCEL_OPTION,
                                              JOptionPane.QUESTION_MESSAGE, null, LoadOptions, LoadOptions[2]);
                           if(resultLoad == 0)
                           {
                               buyer = new Buyer(0,0,null);
                                buyer.loadBuyer();
                           }
                         else if(resultLoad == 1)
                            {
				starter.loadbuytool();
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
                                buyer.saveBuyer();
                            }
                            else if(resultSave == 1)
                            { 
				starter.savebuytool();
                            }
                            else if(resultSave == 2)
                            {
                                System.out.println("Cancel"); 
                            } 
                            break;
			case "Exit":
				System.exit(0);
				break;
			case "Create a Buyer":
				buyer = new Buyer(0,0,null);
				buyer.setVisible(true);
				buyer.addBuyer();
				break;
			case "Update a Buyer":
				buyer = new Buyer(buyer.person.lonCoord,buyer.person.latCoord,buyer.name);
				buyer.setVisible(true);
				buyer.updateBuyer();
				
				break;
			case "Remove a Buyer":
				buyer = new Buyer(buyer.person.lonCoord,buyer.person.latCoord,buyer.name);
				buyer.setVisible(true);
				buyer.deleteBuyer();
				break;
                        case "Buy":
                            try{
                                int findit = starter.Buy();
                                if(findit != -1)
                                {
                                    System.out.println(starter.meteoriteList.size());
                                    temp2= starter.meteoriteList.get(findit);
                                    temp2.sold = true;
                                    myPin=new Pin(temp2.location.lonCoord,temp2.location.latCoord,temp2.sold);
                                    mim.addPin(myPin);
                                }
                            }
                            catch(Exception get)
                            {
                                get.printStackTrace();
                            }
                                break;
			case "About Box":
				System.out.println("here");
				
				break;
                        case "Scramble Map":
                               starter.Scramble();
                               break;
			}
			
				
	}
		
}
	

