/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;


/*************************************************************************
Authors: Danali Sanchez 1000741033, Erwin Dave Salinas 1000785308
* Date: November 4, 2013
* Description: This program is a buyer tool that allows to buy
* 		containing meteorites. This tool allows user to also sell and buy meteorites.
************************************************************************************/




import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
/*************************************************
* Class: Continents
* Description: This class has several function that will be used to determine
* 				on which continent the meteorites is on and the price determined by the continent.
*  integer 2d array - containing values to know if its on land.
**************************************************/


 public class Continents {
     
BufferedImage NorthAmerica;
      BufferedImage SouthAmerica;
      BufferedImage Asia;
      BufferedImage Antarctica;
      BufferedImage Europe;
      BufferedImage Austrailia;
      BufferedImage Africa;
      
      int NorthAmericaPrice = 150;
      int SouthAmericaPrice = 200;
      int AsiaPrice = 200;
      int AntarcticaPrice =1000;
      int EuropePrice = 100;
      int AustrailiaPrice = 500;
      int AfricaPrice = 100;
      
      public Continents(){
          NorthAmerica = LoadContinent("NorthAmerica.png");
          Antarctica = LoadContinent("Antarctica.png");
          Asia = LoadContinent("Asia.png");
          Europe = LoadContinent("Europe.png");
          Africa = LoadContinent("Africa.png");
          SouthAmerica = LoadContinent("SouthAmerica.png");
          Austrailia = LoadContinent("Austrailia.png");
          
      } 
      
      BufferedImage LoadContinent(String filename)
      {
          BufferedImage ContinentName = null;
           try 
           {
               ContinentName = ImageIO.read(new File(filename));
           } 
           catch (Exception e) 
           {
               e.printStackTrace();
           }
          return ContinentName;
     }
      
      public int LoadFile(Position location)
      {
          try{
       	   Raster r = NorthAmerica.getData();
        if(r.getSample(location.x, location.y, 0)== 1)
              return NorthAmericaPrice;
         r = SouthAmerica.getData();
         if(r.getSample(location.x, location.y, 0)== 1)
               return SouthAmericaPrice;
       r = Africa.getData();
        if(r.getSample(location.x, location.y, 0) == 1)
               return AfricaPrice; 
         r = Asia.getData();
         if(r.getSample(location.x, location.y, 0)==1)
               return AsiaPrice;
         r = Europe.getData(); 
         if(r.getSample(location.x, location.y, 0)== 1)
               return EuropePrice;
         r = Antarctica.getData();
         if(r.getSample(location.x, location.y, 0)== 1)
               return AntarcticaPrice;
         r = Austrailia.getData();
         if(r.getSample(location.x, location.y, 0)== 1)
              return AustrailiaPrice; 
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
          
          return 0;
      } 
      
      	/*******************************************************
	* Function: onContinent
	* Parameters: N/A
	* Description:  This function returns a boolean to check if its on a continent of not.
	* Inputs: Position object
	* Outputs: If its on any continent or not.
	/*******************************************/
	public boolean onContinent(Position pos)
	{
		
		if(LoadFile(pos) != 0)
					return true;
		else
					return false;
		
		
	} 

 } 
                
     
   
     
     
     
     
     
     
     
     

/* int [][] booleanmap= new int [20][60];
	
	boolean type;
	Position BoolMeteorite;
	BufferedImage img;
	String [] FileName = {"Africa.png","Asia.png","Austrailia.png","Europe.png","SouthAmerica.png","NorthAmerica.png","Antarctica.png"};
	int [] prices={100,200,500,100,200,150,1000}; */
	/*******************************************************
	* Function: LoadFile
	* Parameters: N/A
	* Description:  This function loads data from a file from string array that reads each 
	* 				file of continents and checks if it lands on continent to return price at that 
	* 				continent.
	* Inputs: Position
	* Outputs: price at certain continent
	/*******************************************/
	/* public int LoadFile( Position BoolMeteorite)
	{
		int sample;
		Color c=null;
		int red;
		int green;
		int blue;
			for(int a=0;a<FileName.length;a++)
			{
			
			try {
				
				img = ImageIO.read(new File(FileName[a]));
				c = new Color(img.getRGB(BoolMeteorite.x,BoolMeteorite.y));
                                red = c.getRed();
                                green = c.getGreen();
                                blue=c.getBlue();
				    if( (red == 255) & (green == 255 ) & (blue == 255))
				    {
					return prices[a];
                                    }
                                    else if((red == 0) & (green == 0) & (blue == 0))
                                    {
                                        return 0;
                                    }
								
						
						
				}
				
				
			
			
			
				
			catch (IOException e) {
				System.out.println("File not found!");
			}
		}
			return -1;
	} */
	/*******************************************************
	* Function: onContinent
	* Parameters: N/A
	* Description:  This function returns a boolean to check if its on a continent of not.
	* Inputs: Position object
	* Outputs: If its on any continent or not.
	/*******************************************/
	/* public boolean onContinent(Position pos)
	{
		
		if(LoadFile(pos) != -1)
					return true;
		else
					return false;
		
		
	} */

 

 
