
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
 * Parent class of all weapons in the Zork-style game.
 * A weapon is spawned in the game and provides a damage bonus to the player when fighting monsters.
 *
 * <hr>
 * Date created: Nov 1, 2018
 * <hr>
 * @author Dustin Hopkins, Audrey Chaffin, Reid Connor
 */
public class Weapon
{
	//attributes of an unspecified Weapon object
	int weaponDamage = 0;
	String weaponName = "";
	

	/**
	 * Constructor (default)       
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * 
	 */
	public Weapon ()
	{
		//no default values for Weapon attributes are set here as the specific weapon type unspecified at super level
	}
	
	
	/**
	 * Used to get the weapon damage of any sub-class weapon (specified weapon type);     
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 * @return int damageValue
	 */
	public int getWeaponDamage()
	{	
		int damageValue = 0; //damage for superclass / unspecified weapon type; overwritten if the referenced weapon is specified/exists
		
		//passes the subclass name of the referenced Weapon object and get its specified damage
		
		if (this.getClass ( ).getName().equals("Stick"))
		{
			damageValue = ((Stick)this).getWeaponDamage();
		}
		
		else if (this.getClass ( ).getName().equals("Sword"))
		{
			damageValue = ((Sword)this).getWeaponDamage();
		}
		
		else if (this.getClass ( ).getName().equals("Bazooka"))
		{
			damageValue = ((Bazooka)this).getWeaponDamage();
		}
		
		else if (this.getClass ( ).getName().equals("AtomicBomb"))
		{
			damageValue = ((AtomicBomb)this).getWeaponDamage();
		}
		
		else if (this.getClass ( ).getName().equals("PotatoCannon"))
		{
			damageValue = ((PotatoCannon)this).getWeaponDamage();
		}
		
		
		return damageValue;
	} //end public int getWeaponDamage()
	
	
	/**
	 * Used to retrieve the name of any Weapon object       
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 * @return String weaponName
	 */
	public String getWeaponName()
	{
		return this.weaponName;
	} //end public String getWeaponName()
	
	
	/**
	 * @param weaponDamage the weaponDamage to set
	 */
	public void setWeaponDamage (int weaponDamage)
	{
		this.weaponDamage = weaponDamage;
	}

	
	/**
	 * @param weaponName the weaponName to set
	 */
	public void setWeaponName (String weaponName)
	{
		this.weaponName = weaponName;
	}

	
	/**
	 * Used to randomly determine the cell (see Game class) in which the weapon spawns,
	 * based upon the number of cells that are generated for any game instance        
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 * @param cellCount
	 * @return rng.nextInt(cellCount); a random integer in the bounds of cellCount (how many cells there are)
	 */
	public static int weaponSpawnLocation(int cellCount)
	{
		Random rng = new Random ();	
		return rng.nextInt(cellCount);
	} //end public static int weaponSpawnLocation(int cellCount)
	
	
	/**
	 * Randomly selects a weapon to be used in the game instance     
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 * 
	 * <hr>
	 * @return (weapons[randomWeapon]) -- a random Weapon subclass object from a Weapon array
	 */
	public static Weapon spawnWeapon()
	{
		final int numberOfWeapons = 5; //update as weapons are added
		
		//Create weapons in order to access attributes / randomly select a weapon
		Sword sword = new Sword();
		Stick stick = new Stick();
		Bazooka bazooka = new Bazooka();
		AtomicBomb atomicBomb = new AtomicBomb();
		PotatoCannon potatoCannon = new PotatoCannon();
		
		
		
		Weapon[] weapons = new Weapon[] {sword, stick,bazooka,atomicBomb,potatoCannon}; //store weapons in an array to randomly grab one to use in Game
		
		int randomWeapon; //weapon chosen		
		Random rng = new Random (); //create generator based upon current number of weapons
		randomWeapon = rng.nextInt(numberOfWeapons); //get a weapon object at random from array

		return (weapons[randomWeapon]); //we have no need to create separate instance
	} //end public String spawnWeapon()
	
} //end public class Weapon
