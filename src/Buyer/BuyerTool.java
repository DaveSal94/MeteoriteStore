/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Buyer;

/**
 *
 * @author Erwin Dave Salinas
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

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
import DataStore.SpaceJunk;
import DataStore.Stony;
import DataStore.StonyIron;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/*************************************************
* Class: BuyerTool
* Description: This class has several function that are usual for the user
*               to buy meteorites from a given file.
*  Meteorite Arraylist - defines the list of meteorites.
*  Map Arraylist - defines the list of coordinates from the file given.
**************************************************/
public class BuyerTool extends JDialog implements ActionListener{
	ArrayList <GridPoints> gridSquares=new ArrayList();
	ArrayList <Meteorites> meteoriteList=new ArrayList();
	
	Scanner keyboard = new Scanner(System.in);
	
	
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
   
	   
	    /*****************************************
		* Function: buyMeteorite
		* Parameters: N/A
		* Description:This function shows the user a list of available meteorites and their identification numbers.The user 
		* 			is asked to select a meteorite, when selected the user will be asked for a confirmation.
		* Inputs: ID Number
		* Outputs: N/A
		********************************************/
         public int Buy()
	 {
	       String [] meteoritesArray = new String[meteoriteList.size()];
                JComboBox comboBoxMeteorite = new JComboBox();	
                int foundit = -1;
                  JPanel panel2 = new JPanel();
	      panel2.setLayout(new GridLayout(5,0,10,5)); 
                       
                for (int i =0; i<meteoriteList.size(); i++)
                {
                        Meteorites temp2= meteoriteList.get(i);
                        switch(temp2.type)
                        {
                            case 1:
                                    String s = String.valueOf(temp2.price);
                                    meteoritesArray[i] = "Achondrite:" + " " + s;
                                    break;
                            case 2:
                                    s = String.valueOf(temp2.price);
                                    meteoritesArray[i] = "LunarAchondrite:" + " " + s;
                                    break;
                            case 3:
                                    s = String.valueOf(temp2.price);
                                    meteoritesArray[i] = "MartianAchondrite:" + " " + s;
                                    break;
                            case 4:
                                    s = String.valueOf(temp2.price);
                                    meteoritesArray[i] = "AsteroidalAchondrite:" + " " + s;
                                    break;
                            case 5:
                                    s = String.valueOf(temp2.price);
                                    meteoritesArray[i] = "Iron:" + " " + s;
                                    break;
                            case 6:
                                    s = String.valueOf(temp2.price);
                                    meteoritesArray[i] = "Stony:" + " " + s;
                                    break;
                            case 7:
                                    s = String.valueOf(temp2.price);
                                    meteoritesArray[i] = "StonyIron:" + " " + s;
                                    break;
                            case 8:
                                    s = String.valueOf(temp2.price);
                                    meteoritesArray[i] = "Pallasite:" + " " + s;
                                    break;
                            case 9:
                                    s = String.valueOf(temp2.price);
                                    meteoritesArray[i] = "Chondrite:" + " " + s;
                                    break;
                            case 10:
                                    s = String.valueOf(temp2.price);
                                    meteoritesArray[i] = "SpaceJunk:" + " " + s;
                                    break;
                       }
                      

              }
                
               comboBoxMeteorite.removeAllItems();
               for(int y = 0; y <meteoritesArray.length; y++)
               {
                   comboBoxMeteorite.addItem(meteoritesArray[y]);
               }
              
             
	      
              panel2.add(comboBoxMeteorite);
              panel2.setVisible(true);
              
               Object[] options = {"Purchase", "Reject"};
               int result = JOptionPane.showOptionDialog(null, panel2, "Choose a meteorite to buy", JOptionPane.OK_CANCEL_OPTION,
                                              JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
               if(result == 0)
               {
                   String s = (String) comboBoxMeteorite.getSelectedItem();
                     for(int j = 0; j<meteoriteList.size(); j++)
                     {
                           Meteorites GetMeteorite = meteoriteList.get(j);
                           String thePrice = Float.toString(GetMeteorite.price);
                           String meteoriteNameAndID = null;
                           
                           switch(GetMeteorite.type)
                           {
                                  case 1:
                                          meteoriteNameAndID = "Achondrite:" + " " + thePrice;
                                          break;
                                  case 2:
                                          meteoriteNameAndID = "LunarAchondrite:" + " " + thePrice;
                                          break;
                                  case 3:
                                          meteoriteNameAndID = "MartianAchondrite:" + " " + thePrice;
                                          break;
                                  case 4:
                                          meteoriteNameAndID = "AsteroidalAchondrite:" + " " + thePrice;
                                          break;
                                  case 5:
                                          meteoriteNameAndID = "Iron:" + " " + thePrice;
                                          break;
                                  case 6:
                                          meteoriteNameAndID = "Stony:" + " " + thePrice;
                                          break;
                                  case 7:
                                          meteoriteNameAndID = "StonyIron:" + " " + thePrice;
                                          break;
                                  case 8:
                                          meteoriteNameAndID = "Pallasite:" + " " + thePrice;
                                          break;
                                  case 9:
                                          meteoriteNameAndID = "Chondrite:" + " " + thePrice;
                                          break;
                                  case 10:
                                          meteoriteNameAndID = "SpaceJunk:" + " " + thePrice;
                                          break;
                            }
                            if(meteoriteNameAndID.equals(s) == true)
                            {
                                foundit = j;
                                dispose();
                            }
                     }
               }
               else if(result == 1)
               {
                       System.out.println("Cancel"); 
                       dispose();
               }
              return foundit;
}          
   
	 
		/*****************************************
		* Function: savebuytool
		* Parameters: N/A
		* Description:This function saves the list of meteorites to a file that the user inputs. The file is comma separated
	 	*				values with one meteorite per line. Each meteorite line includes its original location,
	 	*				price, ID Number,and whether or not it has been sold.  
		* Inputs: File name
		* Outputs: A new file that is made.
		********************************************/
	    public void savebuytool()
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
                else if(userSelection == JFileChooser.CANCEL_OPTION){
                    System.out.println("Cancel");
                    dispose();
                }
	    }
	    /*****************************************
		* Function: loadbuytool
		* Parameters: N/A
		* Description:This function loads a file that the user inputs,to the list of meteorites. The file is comma separated
	    *				values with one meteorite per line. Each meteorite line includes its original location, its price, its ID Number, 
	    *				and whether or not it has been sold.  
		* Inputs: File name
		* Outputs: N/A
		********************************************/
	    public void loadbuytool()
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
	        catch (Exception e) {
			    e.printStackTrace();
			}
		}
		else if (userSelection == JFileChooser.CANCEL_OPTION) {
		      System.out.println("Canceled");
		    }
	    	

	    }
	    /*****************************************
		* Function: Scramble
		* Parameters: N/A
		* Description:This function takes all Positions and scrambles the map using the Random functions.
		* 				All the types of meteorites are scrambled and put
		*				back on the map where meteorites land on land.
		* Inputs: N/A
		* Outputs: new locations of the Position class.
		********************************************/
	    public void Scramble()
		{
				/*Random randomGenerator = new Random();
				Continents cont = new Continents();
				Meteorites temp;
				for(int i =0; i<meteoriteList.size(); i++)
				 {
					 	temp= meteoriteList.get(i);
					 	temp.location.x=randomGenerator.nextInt(800);
						temp.location.y=randomGenerator.nextInt(400);
						
						boolean done = false;
						while(!done)
						{
							if(cont.onContinent(temp.location) == false)
                                                        {	
                                                                temp.location.x=randomGenerator.nextInt(59);
								temp.location.y=randomGenerator.nextInt(19);
                                                                done=false;
							}
							else 
								done=true;
						
						}
						
						temp.location.lonCoord=(int)((temp.location.x-30)*((double)(360.0/60)));
						temp.location.latCoord=(int)((temp.location.y-10)*((double)(-180.0/20)));
						
						
				} */
					
						
				
				
				
				
			
		}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
