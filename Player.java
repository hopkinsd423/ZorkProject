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
 * A specialized (subclass of) Participant: the Player of the game
 *
 * <hr>
 * Date created: Nov 1, 2018
 * <hr>
 * @author Dustin Hopkins, Audrey Chaffin, Reid Connor
 */
public class Player extends Participant
{	
	
	
	/**
	 * Constructor  (default)      
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * 
	 */
	public Player ()
	{
		//player starting health and damage dealt
		this.setHealth(100);
		this.setDamage(5);	
	} //end default constructor

	
	/**
	 * Used to calculate the damage a player deals to another participant (a monster);
	 * Includes a calculated 10% chance to miss an attack       
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 * @return damage
	 */
	public int attack()
	{
		int damage = this.getDamage(); //player's attack power
		
		Random rng = new Random ();
		
		if (rng.nextInt(10) == 0 ) //10% chance to miss
		{
			damage = 0; //missing causes 0 damage
		}
		
		return damage;
	} //end public int attack()

} //end public class Player extends Participant
