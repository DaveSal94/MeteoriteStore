/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;

/**
 *
 * @author Erwin Dave Salinas
 */

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Pin {
	
	//Image Files
	ImageIcon soldIcon;
	ImageIcon unsoldIcon;
	
	Image soldImage;
	Image unsoldImage;
	
	BufferedImage sold_image;
	BufferedImage unsold_image;
	
	//Position on the Map
	public Position pos;
	
	//Sold or Unsold
	public boolean sold;
        public boolean check;
	
	
	public Pin(double lon,double lat,boolean status)
	{
                check = true;
		sold=status;
		pos=new Position(lon,lat);
		
		
		soldIcon= new ImageIcon("sold.png");
		unsoldIcon= new ImageIcon("unsold.png");
		File soldFile=null;
		File unsoldFile=null;
		unsold_image=null;
		sold_image=null;
		try
		{
			soldFile=new File("Sold.png");
			sold_image=ImageIO.read(soldFile);
			
			unsoldFile=new File("Unsold.png");
			unsold_image=ImageIO.read(unsoldFile);
			
		}
		catch(Exception e)
		{
			
		}
		//=========================
		
		//Taken From:
		//http://stackoverflow.com/questions/14097386/how-to-make-drawn-images-transparent-in-java
		
	     ImageFilter filter = new RGBImageFilter() {
	         int transparentColor = Color.white.getRGB() | 0xFF000000;

	         public final int filterRGB(int x, int y, int rgb) {
	            if ((rgb | 0xFF000000) == transparentColor) {
	               return 0x00FFFFFF & rgb;
	            } else {
	               return rgb;
	            }
	         }
	      };

	      ImageProducer filteredImgProd = new FilteredImageSource(soldIcon.getImage().getSource(), filter);
	      soldImage = Toolkit.getDefaultToolkit().createImage(filteredImgProd);
	      
	      filteredImgProd = new FilteredImageSource(unsoldIcon.getImage().getSource(), filter);
	      unsoldImage = Toolkit.getDefaultToolkit().createImage(filteredImgProd);
	     
	      
		//=========================
		
		
		
		
		
		
		
		
	}
	
	public Image getIcon()
	{
		if (sold )
			
			return soldImage;
		else
			return unsoldImage;
	}
	
	public BufferedImage getImage()
	{
            if (sold )
			return sold_image;
		else
			return unsold_image;
	}

}