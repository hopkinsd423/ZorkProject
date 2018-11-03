/**
 * ---------------------------------------------------------------------------
 * File name: GameDriver.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Dustin Hopkins, hopkinsd@etsu.edu, 
 * 													Audrey Chaffin CHAFFINA@mail.etsu.edu 
 * 													Reid Conner	CONNERRM@mail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 1, 2018
 * ---------------------------------------------------------------------------
 */
package zork;


/**
 * A specific weapon (stick) that can spawn in an instance of Game; A subclass of the Weapon Class
 *
 * <hr>
 * Date created: Nov 1, 2018
 * <hr>
 * @author Dustin Hopkins
 */
public class Stick extends Weapon
{
	
	/**
	 * Constructor (default)   
	 *
	 * <hr>
	 * Date created: Nov 1, 2018 
	 *
	 * 
	 */
	public Stick()
	{
		//Stick subclass default damage bonus and weapon name
		this.setWeaponDamage (1);
		this.setWeaponName ("St");
	}
	
	
	/**
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 * @return int weaponDamage
	 * @see zorkesque.Weapon#getWeaponDamage()
	 * @override
	 */
	public int getWeaponDamage()
	{	
		return this.weaponDamage;
	}
	
	
	/**
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 * @return String weaponName
	 * @see zorkesque.Weapon#getWeaponName()
	 * @override
	 */
	public String getWeaponName()
	{
		return this.weaponName;
	}
} //end public class Stick extends Weapon
