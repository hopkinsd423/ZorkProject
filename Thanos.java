/**
 * ---------------------------------------------------------------------------
 * File name: Thanos.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Dustin Hopkins, hopkinsd@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 2, 2018
 * ---------------------------------------------------------------------------
 */

package zork;

import java.util.Random;

/**
 * To create instances of the Thanos class
 *
 * <hr>
 * Date created: Nov 2, 2018
 * <hr>
 * @author Dustin Hopkins
 */
public class Thanos extends Monster
{

	

	/**
	 * default constructor
	 *
	 * <hr>
	 * Date created: Nov 2, 2018
	 * <hr>
	 * 
	 */
	public Thanos()
	{
		this.setHealth(20);
		this.setDamage(6);	
	}
	

	/**
	 * Method to handle the attack and to get the damage
	 *
	 * <hr>
	 * Date created: Nov 2, 2018
	 * <hr>
	 * @return damage, the damage done by Thanos
	 */
	public int attack()
	{
	int damage = this.getDamage();
	
	Random rng = new Random ();	
	
	if (rng.nextInt(10) <= 1 ) //20% chance to miss
	{
		damage = 0;
	}
	
	return damage;
	}
	
}
