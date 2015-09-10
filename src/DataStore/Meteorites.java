/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;


/*************************************************************************
Authors: Danali Sanchez 1000741033, Erwin Dave Salinas 1000785308
* Date: November 4, 2013
* Description: This program is a data store package that allows all the data to be in one package.
* 		containing meteorites. This tool allows user to also sell and buy meteorites.
************************************************************************************/

/*************************************************
* Class: Meteorites
* Description: The superclass of all meteorites. This class should have a data member of type 
* 	Position, a price, and an id of some kind. Also has a public abstract function that all
* 		subclasses will be able to use.
*  Position coordinates (longitude,latitude) - defines longitude and latitude coordinate
*  Id number-defines type of meteorites.
*  sold - defines if meteorites has been sold or not.
**************************************************/
public abstract class Meteorites {
		
	 	public Position location;
	    public float price;
	    public int IDnum;
	    public boolean sold;
	   public int type;


		public Meteorites(double newlongitude, double newlatitude, float newprice,int newIDnum,int newtype, boolean newSold) {
			location = new Position(newlongitude,newlatitude);
			price = newprice;
	    	IDnum = newIDnum;
	    	sold = newSold;
           
	    	type=newtype;
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
	public abstract float pricefunction(float priceval,Position location);

}
