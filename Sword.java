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
 * A specific weapon (Sword) that can spawn in an instance of Game; A subclass of the Weapon Class
 *
 * <hr>
 * Date created: Nov 1, 2018
 * <hr>
 * @author Dustin Hopkins, Audrey Chaffin, Reid Connor
 */
public class Sword extends Weapon 
{	
	
	
	
	/**
	 * Constructor (default)       
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * 
	 */
	public Sword()
	{
		//Sword subclass default damage bonus and weapon name
		this.setWeaponDamage (3);
		this.setWeaponName ("Sw");
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
