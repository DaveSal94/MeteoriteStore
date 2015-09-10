/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Seller;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import DataStore.Achondrite;
import DataStore.AsteroidalAchondrite;
import DataStore.Chondrite;
import DataStore.Continents;
import DataStore.GridPoints;
import DataStore.Iron;
import DataStore.LunarAchondrite;
import DataStore.MartianAchondrite;
import DataStore.Meteorites;
import DataStore.Pallasite;
import DataStore.Position;
import DataStore.SpaceJunk;
import DataStore.Stony;
import DataStore.StonyIron;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DataStore.Pin;
import DataStore.MeteorImageMap;
import java.util.Formatter;



/*************************************************************************
Authors: Danali Sanchez 1000741033, Erwin Dave Salinas 1000785308
* Date: November 4, 2013
* Description: This program is a seller tool that allows to create, update, remove, save, load files, and scramble
* 		containing meteorites. This tool allows user to also sell and buy meteorites.
************************************************************************************/


/*************************************************
* Class: SellerTool
* Description: This class has several function that are usual for the user
*               to manipulate the meteorites that the user wants to sell
*  Meteorite Arraylist - defines the list of meteorites.
*  Map Arraylist - defines the list of coordinates from the file given. 
*  All Meteorite types-defines the type of meteorites there are; 
**************************************************/
public class SellerTool extends JDialog implements ActionListener {

	JPanel textFieldPanel;
	ArrayList <Meteorites> meteoriteList;
	Scanner keyboard = new Scanner(System.in);
	Seller sell;
	public Achondrite achondrite;
    public AsteroidalAchondrite asteroidalachondrite;
    public Chondrite chondrite;
    public Iron iron;
    public LunarAchondrite lunarachondrite;
    public MartianAchondrite martianachondrite;
    public Pallasite pallasite;
    public SpaceJunk spacejunk;
    public Stony stony;
    public StonyIron stonyiron;
	
    JButton buttonOk ;
    JButton buttonCancel;
    JTextField textFieldlon;
	 JTextField textFieldlat;
	 JTextField textFieldID;
	 Meteorites temp2;
	 Pin myPin;
	MeteorImageMap mim=new MeteorImageMap(); 
	 
	 JTextField text;
	  double lonCoord11;
	 double latCoord11;
	 float priceval11;
       
	private static final long serialVersionUID = 1L;
	JPanel mapPanel;
	
	public SellerTool()
	{
		 meteoriteList=new ArrayList();
	}
	
	/*******************************************************
	* Function: LoadTheWorldMap
	* Parameters: N/A
	* Description:  This function loads data from a file given and sets them into an ArrayList 
	* 				GridSquares of map grid points.The grid points of the map will be in a class 
	* 				that contains the coordinates and the map type.
	* Inputs: N/A
	* Outputs: N/A
	/*******************************************/
	public void Load()
	{
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Load File");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		File fileToOpen = null;
		
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
	                double lonCoord = Double.parseDouble(eachlineArray[0]);
	                double latCoord = Double.parseDouble(eachlineArray[1]);
	                float priceval = Float.parseFloat(eachlineArray[2]);
	                int ID = Integer.parseInt(eachlineArray[3]);
	                int type= Integer.parseInt(eachlineArray[4]);
	                boolean issold = Boolean.parseBoolean(eachlineArray[5]);
	                
	                switch(type)
	                {
	                case 1:
	                	achondrite = new Achondrite(lonCoord,latCoord,priceval,ID,type,issold);
	                	meteoriteList.add(achondrite);
	                	
	                	break;
	                case 2:
	                	lunarachondrite= new LunarAchondrite(lonCoord,latCoord,priceval,ID,type,issold);
	                	meteoriteList.add(lunarachondrite);
	                	
	                	break;
	                case 3:
	                	martianachondrite = new MartianAchondrite(lonCoord,latCoord,priceval,ID,type,issold);
	                	meteoriteList.add(martianachondrite);
	                	
	                	break;
	                case 4:
	                	asteroidalachondrite = new AsteroidalAchondrite(lonCoord,latCoord,priceval,ID,type,issold,0,0,0);
	                	meteoriteList.add(asteroidalachondrite);
	                	
	                	break;
	                case 5:
	                	iron = new Iron(lonCoord,latCoord,priceval,ID,type,issold,75,25,0);
	                	meteoriteList.add(iron);
	                	
	                	break;
	                case 6:
	                	stony = new Stony(lonCoord,latCoord,priceval,ID,type,issold,75,25,0);
	                	meteoriteList.add(stony);
	                	
	                	break;
	                case 7:
	                	stonyiron = new StonyIron(lonCoord,latCoord,priceval,ID,type,issold,50,50,0);
	                	meteoriteList.add(stonyiron);
	                
	                	break;
	                case 8:
	                	pallasite = new Pallasite(lonCoord,latCoord,priceval,ID,type,issold,45,45,10);
	                	meteoriteList.add(pallasite);
	                	
	                	break;
	                case 9:
	                	chondrite= new Chondrite(lonCoord,latCoord,priceval,ID,type,issold);
	                	meteoriteList.add(chondrite);
	                	
	                	break;
	                case 10:
	                	spacejunk = new SpaceJunk(lonCoord,latCoord,priceval,ID,type,issold);
	                	meteoriteList.add(spacejunk);
	                	
	                	break;
	                
	                }
	            }
	            System.out.println("File has been loaded to the list of meteorites");
	        	
	        }
	        catch (FileNotFoundException fe) {
			    System.out.println("File not found!\n");
			}
		}
		else if (userSelection == JFileChooser.CANCEL_OPTION) {
		      System.out.println("Canceled");
		    }
		
	
	
	}
	
	/*****************************************
	* Function: create
	* Parameters: N/A
	* Description:  This function will prompt the user for the coordinates, the price, 
	* 				and an identification number. When this is done, a new meteorite 
	* 				will be added to a collection type ArrayList that stores this information.
	* Inputs: ID Number, coordinates(longitude,latitude), and price.
	* Outputs: N/A
	/*******************************************/
	
	
	public void createoneln()
    {

		double lonCoord =0;
	 	double latCoord=0;
	 	int type=0;
	 	int ID =0;
	 	float priceval =(float)0.00;
	 	boolean issold = false;
		Position location=null;
		
		String input =JOptionPane.showInputDialog("Create meteorites(longitude,latidue,ID,type,price)");
		if (input != null ) 
		{
			String [] wordsplit = input.split(",");
		 	lonCoord = Double.parseDouble(wordsplit[0]);
                        latCoord = Double.parseDouble(wordsplit[1]);
                        ID = Integer.parseInt(wordsplit[2]);
                        type = Integer.parseInt(wordsplit[3]);
                        priceval = Float.parseFloat(wordsplit[4]);
                        location = new Position (lonCoord,latCoord);
		}
		
       switch(type)
        {
        case 1:
        	achondrite = new Achondrite(lonCoord,latCoord,priceval,ID,type,issold);
        	meteoriteList.add(achondrite);
        	achondrite.pricefunction(priceval,location);
        	break;
        case 2:
        	lunarachondrite= new LunarAchondrite(lonCoord,latCoord,priceval,ID,type,issold);
        	meteoriteList.add(lunarachondrite);
        	lunarachondrite.pricefunction(priceval,location);
        	break;
        case 3:
        	martianachondrite = new MartianAchondrite(lonCoord,latCoord,priceval,ID,type,issold);
        	meteoriteList.add(martianachondrite);
        	martianachondrite.pricefunction(priceval,location);
        	break;
        case 4:
        	asteroidalachondrite = new AsteroidalAchondrite(lonCoord,latCoord,priceval,ID,type,issold,0,0,0);
        	meteoriteList.add(asteroidalachondrite);
            asteroidalachondrite.pricefunction(priceval,location);
        	
        	break;
        case 5:
        	iron = new Iron(lonCoord,latCoord,priceval,ID,type,issold,75,25,0);
        	meteoriteList.add(iron);
        	iron.pricefunction(priceval,location);
        	break;
        case 6:
        	stony = new Stony(lonCoord,latCoord,priceval,ID,type,issold,75,25,0);
        	meteoriteList.add(stony);
           stony.pricefunction(priceval,location);
        	break;
        case 7:
        	stonyiron = new StonyIron(lonCoord,latCoord,priceval,ID,type,issold,50,50,0);
        	meteoriteList.add(stonyiron);
        	stonyiron.pricefunction(priceval,location);
        	break;
        case 8:
        	pallasite = new Pallasite(lonCoord,latCoord,priceval,ID,type,issold,45,45,10);
        	meteoriteList.add(pallasite);
        	pallasite.pricefunction(priceval,location);
        	break;
        case 9:
        	chondrite= new Chondrite(lonCoord,latCoord,priceval,ID,type,issold);
        	meteoriteList.add(chondrite);
        	chondrite.pricefunction(priceval,location);
        	break;
        case 10:
        	spacejunk = new SpaceJunk(lonCoord,latCoord,priceval,ID,type,issold);
        	meteoriteList.add(spacejunk);
           spacejunk.pricefunction(priceval,location);
        	break;
        
        }
   
		
	 	
	 	
	 	
    }
	

	public void create()
	{
		
		
		 String[] meteorites ={"(no meteorite selected)","Chondrite","Achondrite","Lunar Achondrite","Martian Achondrite",
				 "Asteroidal Achondrite","Iron","Stony","Stony-Iron","Pallasite","Space Junk"};  
              
              JComboBox comboBox;
	      //Use combobox to create drop down menu
	      comboBox=new JComboBox(meteorites);
	     
	      JPanel panel1 = new JPanel();
	      panel1.setLayout(new GridLayout(5,0,10,5)); 
	      text = new JTextField("Price",20);
	      textFieldlon= new JTextField("Longitude",20);
	      textFieldlat =new JTextField("Latitude",20);
	      textFieldID = new JTextField("ID Number",20);
	     
	      panel1.add(textFieldlon);
	      panel1.add(textFieldlat);
	      panel1.add(textFieldID);
	      panel1.add(text);
	     panel1.setVisible(true);
             panel1.add(comboBox);
	      //Create a JFrame that will be use to put JComboBox into it 
	      
	     boolean issold = false;
	      
	
	     int result = JOptionPane.showConfirmDialog(null,panel1,"Create a Meteorite",JOptionPane.OK_CANCEL_OPTION);
	     if(result == JOptionPane.OK_OPTION)
	     {
	    	 double lonCoord = Double.parseDouble(textFieldlon.getText());
		     double latCoord=Double.parseDouble(textFieldlat.getText());
		    float priceval=Float.parseFloat(text.getText());
		    int ID = Integer.parseInt(textFieldID.getText());
		      String x = String.valueOf(comboBox.getSelectedItem());
		      Position location = new Position (lonCoord,latCoord);
		      switch(x)
		        {
		        case "Achondrite":
		        	achondrite = new Achondrite(lonCoord,latCoord,priceval,ID,1,issold);
		        	meteoriteList.add(achondrite);
		        	achondrite.pricefunction(priceval,location);
		        	break;
		        case "Lunar Achondrite":
		        	lunarachondrite= new LunarAchondrite(lonCoord,latCoord,priceval,ID,2,issold);
		        	meteoriteList.add(lunarachondrite);
		        	lunarachondrite.pricefunction(priceval,location);
		        	break;
		        case "Martian Achondrite":
		        	martianachondrite = new MartianAchondrite(lonCoord,latCoord,priceval,ID,3,issold);
		        	meteoriteList.add(martianachondrite);
		        	martianachondrite.pricefunction(priceval,location);
		        	break;
		        case "Asteroidal Achondrite":
		        	asteroidalachondrite = new AsteroidalAchondrite(lonCoord,latCoord,priceval,ID,4,issold,0,0,0);
		        	meteoriteList.add(asteroidalachondrite);
		        	asteroidalachondrite.pricefunction(priceval,location);
		        	
		        	break;
		        case "Iron":
		        	iron = new Iron(lonCoord,latCoord,priceval,ID,5,issold,75,25,0);
		        	meteoriteList.add(iron);
		        	iron.pricefunction(priceval,location);
		        	break;
		        case "Stony":
		        	stony = new Stony(lonCoord,latCoord,priceval,ID,6,issold,75,25,0);
		        	meteoriteList.add(stony);
		        	stony.pricefunction(priceval,location);
		        	break;
		        case "Stony-Iron":
		        	stonyiron = new StonyIron(lonCoord,latCoord,priceval,ID,7,issold,50,50,0);
		        	meteoriteList.add(stonyiron);
		        	stonyiron.pricefunction(priceval,location);
		        	break;
		        case "Pallasite":
		        	pallasite = new Pallasite(lonCoord,latCoord,priceval,ID,8,issold,45,45,10);
		        	meteoriteList.add(pallasite);
		        	pallasite.pricefunction(priceval,location);
		        	break;
		        case "Chondrite":
		        	chondrite= new Chondrite(lonCoord,latCoord,priceval,ID,9,issold);
		        	meteoriteList.add(chondrite);
		        	chondrite.pricefunction(priceval,location);
		        	break;
		        case "Space Junk":
		        	spacejunk = new SpaceJunk(lonCoord,latCoord,priceval,ID,10,issold);
		        	meteoriteList.add(spacejunk);
		        	spacejunk.pricefunction(priceval,location);
		        	break;
		        
		        }
		      dispose();
	     }
	     if(result == JOptionPane.CANCEL_OPTION)
	     {
	    	System.out.println("Cancel"); 
	    	dispose();
	     }
    }
	     
	    
	
	
	

	/*****************************************
	* Function: update
	* Parameters: N/A
	* Description:This function shows the user a list of available meteorites and their identification numbers. Then
				the user to select a meteorite, when selected the user will be asked for price changes of the meteorite. 
				This meteorite price change will be automatically changed in the Arraylist of meteorites.
	* Inputs: ID Number, new price, nad new location coordinates.
	* Outputs: N/A
	/*******************************************/
         public int update()/* */
	 {
                
                String [] meteoritesArray = new String[meteoriteList.size()];
                JComboBox comboBoxMeteorite = new JComboBox();	
                int foundit = -1;
                for (int i =0; i<meteoriteList.size(); i++)
                {
                        Meteorites temp2= meteoriteList.get(i);
                        System.out.println("Type: " + temp2.type);
                        switch(temp2.type)
                        {
                            case 1:
                                    String s = String.valueOf(temp2.IDnum);
                                    meteoritesArray[i] = "Achondrite:" + " " + s;
                                    break;
                            case 2:
                                    s = String.valueOf(temp2.IDnum);
                                    meteoritesArray[i] = "LunarAchondrite:" + " " + s;
                                    break;
                            case 3:
                                    s = String.valueOf(temp2.IDnum);
                                    meteoritesArray[i] = "MartianAchondrite:" + " " + s;
                                    break;
                            case 4:
                                    s = String.valueOf(temp2.IDnum);
                                    meteoritesArray[i] = "AsteroidalAchondrite:" + " " + s;
                                    break;
                            case 5:
                                    s = String.valueOf(temp2.IDnum);
                                    meteoritesArray[i] = "Iron:" + " " + s;
                                    break;
                            case 6:
                                    s = String.valueOf(temp2.IDnum);
                                    meteoritesArray[i] = "Stony:" + " " + s;
                                    break;
                            case 7:
                                    s = String.valueOf(temp2.IDnum);
                                    meteoritesArray[i] = "StonyIron:" + " " + s;
                                    break;
                            case 8:
                                    s = String.valueOf(temp2.IDnum);
                                    meteoritesArray[i] = "Pallasite:" + " " + s;
                                    break;
                            case 9:
                                    s = String.valueOf(temp2.IDnum);
                                    meteoritesArray[i] = "Chondrite:" + " " + s;
                                    break;
                            case 10:
                                    s = String.valueOf(temp2.IDnum);
                                    meteoritesArray[i] = "SpaceJunk:" + " " + s;
                                    break;
                       }
                      

              }
                
               comboBoxMeteorite.removeAllItems();
               for(int y = 0; y <meteoritesArray.length; y++)
               {
                  // System.out.println(meteoritesArray[y]);
                   comboBoxMeteorite.addItem(meteoritesArray[y]);
               }
              
              
              
              JPanel panel2 = new JPanel();
	      panel2.setLayout(new GridLayout(5,0,10,5)); 
	      
              panel2.add(comboBoxMeteorite);
              panel2.setVisible(true);
              
              int theresult = JOptionPane.showConfirmDialog(null,panel2,"Choose a Meteorite",JOptionPane.OK_CANCEL_OPTION);
              if(theresult == JOptionPane.OK_OPTION)
              {
                    String s = (String) comboBoxMeteorite.getSelectedItem();
                     for(int j = 0; j<meteoriteList.size(); j++)
                     {
                           Meteorites GetMeteorite = meteoriteList.get(j);
                           String theID = Integer.toString(GetMeteorite.IDnum);
                           String meteoriteNameAndID = null;
                           
                           switch(GetMeteorite.type)
                           {
                                  case 1:
                                          meteoriteNameAndID = "Achondrite:" + " " + theID;
                                          break;
                                  case 2:
                                          meteoriteNameAndID = "LunarAchondrite:" + " " + theID;
                                          break;
                                  case 3:
                                          meteoriteNameAndID = "MartianAchondrite:" + " " + theID;
                                          break;
                                  case 4:
                                          meteoriteNameAndID = "AsteroidalAchondrite:" + " " + theID;
                                          break;
                                  case 5:
                                          meteoriteNameAndID = "Iron:" + " " + theID;
                                          break;
                                  case 6:
                                          meteoriteNameAndID = "Stony:" + " " + theID;
                                          break;
                                  case 7:
                                          meteoriteNameAndID = "StonyIron:" + " " + theID;
                                          break;
                                  case 8:
                                          meteoriteNameAndID = "Pallasite:" + " " + theID;
                                          break;
                                  case 9:
                                          meteoriteNameAndID = "Chondrite:" + " " + theID;
                                          break;
                                  case 10:
                                          meteoriteNameAndID = "SpaceJunk:" + " " + theID;
                                          break;
                            }
                            if(meteoriteNameAndID.equals(s) == true)
                            {
      
                                      foundit = j;
                                      String[] meteorites ={"(no meteorite selected)","Chondrite","Achondrite","Lunar Achondrite","Martian Achondrite",
                                            "Asteroidal Achondrite","Iron","Stony","Stony-Iron","Pallasite","Space Junk"};  

                                      JComboBox comboBox2=new JComboBox(meteorites);
                                      JPanel panel1 = new JPanel();
                                      panel1.setLayout(new GridLayout(5,0,10,5)); 
                                      JTextField textp = new JTextField("Price",20);
                                      JTextField textFieldlon2= new JTextField("Longitude",20);
                                      JTextField textFieldlat2 =new JTextField("Latitude",20);
                                              
                                      panel1.add(textFieldlon2);
                                      panel1.add(textFieldlat2);
                                      panel1.add(comboBox2);
                                      panel1.add(textp);
                                      panel1.setVisible(true);
                                      
                                                
                                      int result = JOptionPane.showConfirmDialog(null,panel1,"Update a Meteorite",JOptionPane.OK_CANCEL_OPTION);
                                      if(result == JOptionPane.OK_OPTION)
                                      {
                                            double lonCoord = Double.parseDouble(textFieldlon2.getText());
                                            double latCoord=Double.parseDouble(textFieldlat2.getText());
                                            float priceval=Float.parseFloat(textp.getText());
                                            String x = String.valueOf(comboBox2.getSelectedItem());
                                            int newtype = 0;
                                                    
                                            switch(x)
                                            {
                                                    case "Achondrite":
                                                            newtype = 1;
                                                            break;
                                                    case "Lunar Achondrite":
                                                            newtype = 2;
                                                            break;
                                                    case "Martian Achondrite":
                                                            newtype = 3;
                                                            break;
                                                    case "Asteroidal Achondrite":
                                                            newtype = 4;
                                                            break;
                                                    case "Iron":
                                                            newtype = 5;
                                                            break;
                                                    case "Stony":
                                                            newtype = 6;
                                                            break;
                                                    case "Stony-Iron":
                                                            newtype = 7;
                                                            break;
                                                    case "Pallasite":
                                                            newtype = 8;
                                                            break;
                                                    case "Chondrite":
                                                            newtype = 9;
                                                            break;
                                                    case "Space Junk":
                                                            newtype = 10;
                                                            break;

                                            }
                                            
                                            Meteorites GetFoundit = meteoriteList.get(foundit);
                                            GetFoundit.location.lonCoord = lonCoord;
                                            GetFoundit.location.latCoord = latCoord;
                                            GetFoundit.price = priceval;
                                            GetFoundit.type = newtype;
                                            dispose();
                                            }
                                            if(result == JOptionPane.CANCEL_OPTION)
                                            {
                                                    System.out.println("Cancel"); 
                                                    dispose();
                                            }      
                             }
                      
                        
                        } 
                    
                    }
                   else if(theresult == JOptionPane.CANCEL_OPTION)
                   {
                       System.out.println("Cancel"); 
                       dispose();
                   }
                         
                
              
              
              return foundit;
               
}
	  public int remove()
	 {
		 
		int foundit = -1;
		
		JComboBox combo1;
		Meteorites temp;
		String id;
		String[] meteorites = new String [meteoriteList.size()];
		System.out.println("here"+meteoriteList.size());
		for(int i=0;i<meteoriteList.size();i++)
		{
			
			temp = meteoriteList.get(i);
			id = String.valueOf(temp.IDnum);
			meteorites[i]=id;
		}

	      //Use combobox to create drop down menu
	      combo1=new JComboBox<String>(meteorites);
	     
	      JPanel panel1 = new JPanel();
	      panel1.setLayout(new GridLayout(2,0,10,5)); 
	     panel1.add(combo1);
	    panel1.setVisible(true);
	      //Create a JFrame that will be use to put JComboBox into it 
	      
	     
	      
	      
	     int result = JOptionPane.showConfirmDialog(null,panel1,"Remove a Meteorite",JOptionPane.OK_CANCEL_OPTION);
	     if(result == JOptionPane.OK_OPTION)
	     {
	    	int IDNum = Integer.parseInt((String) combo1.getSelectedItem());
	    	System.out.println(IDNum);
	    	
		    
	    	 for (int i = 0; i <meteoriteList.size() ; i++) 
				{
							temp=meteoriteList.get(i);
							
							if (temp.IDnum == IDNum ) 
							{
								foundit = i;
								meteoriteList.remove(i);
								
							}
				}
						
				
				
	     }
		 return foundit;
	 }
	 
	 /*****************************************
		* Function: save
		* Parameters: N/A
		* Description:This function saves the list of meteorites to a file that the user inputs. The file is comma separated
	 	*				values with one meteorite per line. Each meteorite line includes its original location,
	 	*				price, ID Number,and whether or not it has been sold.  
		* Inputs: File name
		* Outputs: A new file that is made.
		********************************************/
	 public void save()/* */
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
				
				for (int i =0; i<meteoriteList.size(); i++)
				{
					Meteorites temp2= meteoriteList.get(i);
					fout.format("%.2f,%.2f,%.2f,%d,%d,%b\r\n",temp2.location.lonCoord,temp2.location.latCoord,temp2.price,temp2.IDnum,temp2.type,temp2.sold);
				}
				
				fout.flush();
				fout.close();
				}
		    catch(Exception e)
			{
				e.printStackTrace();
			} 
                }
                else if(userSelection == JFileChooser.CANCEL_OPTION)
                {
                     System.out.println("Cancel");
                     dispose();
                }
	    
	    }
	    
	    
	    /*****************************************
		* Function: ScrambleMeteorites
		* Parameters: N/A
		* Description:This function takes all Positions and scrambles the map using the Random functions.
		* 				All the types of meteorites are scrambled and put
		*				back on the map where meteorites land on land.
		* Inputs: N/A
		* Outputs: new locations of the Position class.
		********************************************/
	    public void ScrambleMeteorite()
		{
				Random randomGenerator = new Random();
				Continents cont = new Continents();
				Meteorites temp;
				for(int i =0; i<meteoriteList.size(); i++)
				 {
					 	temp= meteoriteList.get(i);
					 	temp.location.x=randomGenerator.nextInt(799);
						temp.location.y=randomGenerator.nextInt(399);
						
						boolean done = false;
						while(!done)
						{
							if(cont.onContinent(temp.location) == false)
                                                        {	
                                                                temp.location.x=randomGenerator.nextInt(799);
								temp.location.y=randomGenerator.nextInt(399);
                                                                done=false;
							}
							else 
								done=true;
						
						}
						
						temp.location.lonCoord=(int)((temp.location.x-400)*((double)(360.0/800)));
						temp.location.latCoord=(int)((temp.location.y-200)*((double)(-180.0/400)));
						
						
				} 
				
				
				
				
			
		}
	    /*****************************************
		* Function: distance
		* Parameters: sellers longitude and latitude.
		* Description:This function finds the distance between two points on a globe in miles 
		* 				given longitude and latitude. This function must be called from the main menu 
		* 				of the Seller tool and include Buyer information by loading in their file.
		* Inputs: buyers file
		* Outputs: distance
		********************************************/
	    public double upsdistance(double sellerlon,double sellerlat)
		{
	    	
			 System.out.print("Put a file name for buyer:");
	         String fileName = keyboard.next();
	         File inputFile = new File(fileName);
	         double lonCoord =0;
	         double latCoord =0;
	         try
	         {
	             Scanner grabMeteorite = new Scanner(inputFile);
	             while(grabMeteorite.hasNext())
	             {
	                 String eachline = grabMeteorite.nextLine();
	                 String[] eachlineArray = eachline.split(",");
	                 lonCoord = Double.parseDouble(eachlineArray[0]);
	                 latCoord = Double.parseDouble(eachlineArray[1]);
	                 String name= eachlineArray[2];
	             }
	             System.out.println("File has been loaded\n");
	         }
	        catch (FileNotFoundException fe) {
		    System.out.println("File not found!\n");
	       		
	        }
			//buyer - seller
	         double theta = latCoord - sellerlat;	
			 
	         double distance = (
				        Math.sin(Math.toRadians(lonCoord)) * Math.sin(Math.toRadians(sellerlon)))+(
				        		
				        Math.cos(Math.toRadians(lonCoord)) * Math.cos(Math.toRadians(sellerlon)) * Math.cos(Math.toRadians(theta))
				        );
			    distance = Math.acos(distance);
			    distance = Math.toDegrees(distance);
			    distance = distance * 60 * 1.1515;
			    return distance;
			}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		
}
