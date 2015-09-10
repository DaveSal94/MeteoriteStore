/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class MeteorImageMap extends Component{


	 BufferedImage img;
	  ArrayList <Pin> thesePins = new ArrayList<Pin>();
	    
          
	  public void paint(Graphics g) {
	        g.drawImage(img, 0, 0, 800,400,null);
	        int pinLoop=0;
	        int pinMax=0;
	        Pin thisPin;
	        
	        pinMax=thesePins.size();
	        for (pinLoop=0;pinLoop<pinMax;pinLoop++)
	        {
	        	thisPin=thesePins.get(pinLoop);
	        	
	        	g.drawImage(thisPin.getIcon(),thisPin.pos.x,thisPin.pos.y,null);	
	        }
                        repaint();
			validate();
	        
	    }
	 
	    public MeteorImageMap() 
	    {
	    	
	       try {
	           img = ImageIO.read(new File("WorldMapSimple.png"));
	       } 
	       catch (IOException e)
	       {
	    	   
	       }
	 
	    }
	 
	    public Dimension getPreferredSize() 
	    {
	    	
	        if (img == null) {
	             return new Dimension(100,100);
	        } else {
	           return new Dimension(800, 400);
	       }
	    }
	    public void addPin(Pin myPin) {
			
			thesePins.add(myPin);
		} 
	    public void removepin(int i) {
			
			thesePins.remove(i);
		} 
	
}
