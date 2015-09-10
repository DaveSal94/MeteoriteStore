/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;

/**
 *
 * @author daveshizzzle
 */

/*************************************************************************
Authors: Danali Sanchez 1000741033, Erwin Dave Salinas 1000785308
* Date: November 4, 2013
* Description: This program is a data store package that allows all the data to be in one package.
* 		containing meteorites. This tool allows user to also sell and buy meteorites.
************************************************************************************/
import java.util.Scanner;

import javax.swing.JOptionPane;
/*************************************************
* Class: Iron
* Description: This class a subclass of asteroidal achondrite with data member of type 
* 	Position, a price, and an id of some kind.Also includes more members as percent of iron
* 		percent of stone and percent of crystal. Also has a public abstract function that all
* 		subclasses will be able to use.
*  Position coordinates (longitude,latitude) - defines longitude and latitude coordinate
*  Id number-defines type of meteorites.
*  sold - defines if meteorites has been sold or not.
*  percent iron - defines percent of iron
*  percent of stone - defines percent of stone 
*  percent of crystal - defines percent of crystal
**************************************************/
public class Iron extends AsteroidalAchondrite{
	Continents cont = new Continents();
	public Iron(double newlongitude, double newlatitude, float newprice,int newIDnum,int newtype, boolean newSold, int newPercentIron, int newPercentStone,int newPercentCrystal) {
		super(newlongitude, newlatitude, newprice , newIDnum,newtype,newSold, 75,25, 0);
		// TODO Auto-generated constructor stub
	}
	/*******************************************************
	* Function: pricefunction
	* Parameters: N/A
	* Description:  This abstract function automatically generate a base price of the 
	* 				meteorite when it is created.The operator then has the 
	* 				option of overriding the suggested meteorite price.
	* 				Cost will be a combined function of the kind of meteorite and the location of a meteorite.
	* Inputs: price given from user, and location of meteorite created.
	* Outputs: suggested price
	/*******************************************/
	public float pricefunction(float priceval,Position location)
	{
		
		float currentprice =(float) 500.00 + cont.LoadFile(location) ;//+ cont price
		int n = JOptionPane.showConfirmDialog(
			    null,
			    "Would you like to update to suggested price?\n"+"                                "+"$"+currentprice,"Update Price", JOptionPane.YES_NO_OPTION);
		 
	     if(n == JOptionPane.YES_OPTION)
	     {
	         super.price = currentprice;
	         return currentprice;
	     }
	     else if(n == JOptionPane.NO_OPTION)
	     {
	         super.price = priceval;
	         return priceval;
	     }
		return priceval;
	}
}

