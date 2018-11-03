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
 * Enter type purpose here
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
		//Sword subclass default damage bonus and weapon name
		this.setWeaponDamage (10);
		this.setWeaponName ("BZ");
	}
	
	/**
	 * Enter method description here         
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 * @return
	 * @see zorkesque.Weapon#getWeaponDamage()
	 * @override
	 */
	public int getWeaponDamage()
	{	
		return this.weaponDamage;
	}
	
	/**
	 * Enter method description here         
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 * @return
	 * @see zorkesque.Weapon#getWeaponName()
	 * @override
	 */
	public String getWeaponName()
	{
		return this.weaponName;
	}	
} //end public class Sword extends Weapon
