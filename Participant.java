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
 *Parent class for all living things in the game (Currently, monsters and players)
 *
 * <hr>
 * Date created: Nov 1, 2018
 * <hr>
 * @author Dustin Hopkins
 */
public class Participant
{
	//attributes of a Participant; protected so that subclasses can inherit
	private int healthPoints;
	private int damage;
	
	
	/**
	 * Constructor (default)   
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * 
	 */
	public Participant()
	{
		//attributes not initialized here as any weapon spawned will be specific subclass
	}
	
	
	/**
	 * For retrieving the damage attribute value of a participant          
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 * @return this.damage (an attribute of Participant)
	 */
	public int getDamage()
	{
		return this.damage;
	}
	
	
	/**
	 * For setting or modifying the damage of a Participant or its subclasses         
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 * @return this.damage (an attribute of Participant)
	 */
	public void setDamage(int damage)
	{
		this.damage = damage;
	}
	
	
	/**
	 * Used to retrieve the health value of a Participant       
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 * @return this.healthPoints (an attribute of Participant)
	 */
	public int getHealth()
	{
		return this.healthPoints;
	}
	
	
	/**
	 * For setting or modifying a the health total of a participant.  Useful for correcting over-kill         
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 * @param health
	 */
	public void setHealth(int health)
	{
		this.healthPoints = health;
	}
	
	
	/**
	 * Used to modify remaining health of a participant that is attacked.  This is essentially a specialized setter, as health needs to be changed
	 * when a participant is attacked.  Health totals can be changed in subclasses respective to each participant type
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 * @param damage
	 */
	public void isAttacked (int damage)
	{
		this.healthPoints -= damage;
	}
	
} //end public class Participant
