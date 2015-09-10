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
* Class: Position
* Description: This class Position has data members longitude and
*			latitude, and a constructor that takes longitude and latitude as parameters. 
*			All elements of this system,the user, the creatures, and the map positions, will use this class.
*  longitude,latitude - defines longitude and latitude coordinate
*  row,column-defines row and column coordinates converted from longitude and latitude
**************************************************/
public class Position {

	public double lonCoord;
	public double latCoord;
	public int x;
	public int y;
	
	public Position (double newlonCoord, double newlatCoord)
	{
		lonCoord = newlonCoord;
		latCoord = newlatCoord;
		
		x = (int) (lonCoord*((double)799.0 /360) + 400);
		y = (int) (latCoord*((double)-399.0 /180) + 200);
		
	}
	
}

