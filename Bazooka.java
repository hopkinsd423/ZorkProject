/**
 * ---------------------------------------------------------------------------
 * File name: Bazooka.java
 * Project name: ZorkD
 * ---------------------------------------------------------------------------
 * Creator's name and email: Dustin Hopkins, hopkinsd@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 3, 2018
 * ---------------------------------------------------------------------------
 */

package zork;


/**
 * To create instances of the bazooka class
 *
 * <hr>
 * Date created: Nov 3, 2018
 * <hr>
 * @author Dustin Hopkins
 */
public class Bazooka extends Weapon
{


	
	
	/**
	 * Constructor (default)       
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * 
	 */
	public Bazooka()
	{
		//Bazooka subclass default damage bonus and weapon name
		this.setWeaponDamage (10);
		this.setWeaponName ("BZ");
	}
	
	/**
	 * Method to get weapon damage      
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 * @return weaponDamage, the damage done
	 * 
	 */
	public int getWeaponDamage()
	{	
		return this.weaponDamage;
	}
	
	/**
	 * Method to get weapon name      
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 * @return weaponName, the weapon's name
	 */
	public String getWeaponName()
	{
		return this.weaponName;
	}	
} //end public class Bazooka extends Weapon
