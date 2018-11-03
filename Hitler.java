/**
 * ---------------------------------------------------------------------------
 * File name: Hitler.java
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
 * Enter type purpose here
 *
 * <hr>
 * Date created: Nov 2, 2018
 * <hr>
 * @author Dustin Hopkins
 */
public class Hitler extends Monster
{

	public Hitler()
	{
		this.setHealth(10);
		this.setDamage(2);	
	}
	
	
	
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
