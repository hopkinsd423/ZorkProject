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

import java.util.Random;


/**
 * A specialized (subclass of) Participant, this class is used to create Monsters that the Player encounters in the game
 *
 * <hr>
 * Date created: Nov 1, 2018
 * <hr>
 * @author Dustin Hopkins, Audrey Chaffin, Reid Connor
 */
public class Monster extends Participant
{

	
	/**
	 * Constructor (default)        
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * 
	 */
	public Monster()
	{
					//not used because each subclass will set it's own health
	}
	
	/**
	 * Assists in the determination of whether or not a monster will be spawned (A 50% chance)        
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 * @return boolean spawn
	 */
	public static boolean spawnMonster()
	{
		boolean spawn;
		
		Random rng = new Random ();
		
		if (rng.nextInt(10) <= 4 ) //50% chance for spawn
		{
			spawn = true; //i.e. monster is to be spawned
		}
		else
		{
			spawn = false;  //i.e. no monster is to be spawned
		}
		
		return spawn;	
	} //end public static boolean spawnMonster()
	
	
	/**
	 * Used to calculate the damage a monster deals to another participant;
	 * Includes a calculated 20% chance to miss an attack       
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 * @return int damage
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
	} //end public int monsterAttack()
	
} //end public class Monster extends Participant
