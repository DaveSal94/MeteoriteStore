/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;

/**
 *
 * @author Erwin Dave Salinas
 */

/*************************************************
* Class: SellerGridSquares
* Description: This class represents the x, y coordinates, and maptype
* 
* int x - defines the row on the grid
* int y - defines the column on the grid
* int mapType - defines the map type if its either land or sea on the grid.
**************************************************/
public class GridPoints {
	
	
	public int x;
	public int y;
	private int mapType;
	
	public GridPoints (int newx,int newy,int newMapType)
	{
		x=newx;
		y=newy;
		mapType=newMapType;
	}
	
	/*******************************************************
	* Function: setMapType
	* Parameters: 	int newMapType- the map type if its either 
	* Description:  Since the value mapType is private there needs to be a set function that sets the mapType. 
	* Inputs: N/A
	* Outputs: N/A
	/*******************************************/
	public void setMapType(int newMapType)
	{
		mapType=newMapType;
	}
	
	/*******************************************************
	* Function: setMapType
	* Parameters: 	N/A 
	* Description:  Since the value mapType is private there needs to be a get function that sets the gets the mapType. 
	* Inputs: N/A
	* Outputs: mapType
	/*******************************************/
	public int getMapType()
	{
		return mapType;
	}
}

