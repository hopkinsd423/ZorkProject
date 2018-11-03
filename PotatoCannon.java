/**
 * ---------------------------------------------------------------------------
 * File name: PotatoCannon.java
 * Project name: ZorkD
 * ---------------------------------------------------------------------------
 * Creator's name and email: Dustin Hopkins, hopkinsd@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 3, 2018
 * ---------------------------------------------------------------------------
 */

package zork;


/**
 * To create instancesof the PotatoCannon class
 *
 * <hr>
 * Date created: Nov 3, 2018
 * <hr>
 * @author Dustin Hopkins
 */
public class PotatoCannon extends Weapon
{	
	
	
	
	/**
		 * Constructor (default)       
		 *
		 * <hr>
		 * Date created: Nov 1, 2018
		 *
		 * 
		 */
		public PotatoCannon()
		{
			//PotatoCannon subclass default damage bonus and weapon name
			this.setWeaponDamage (6);
			this.setWeaponName ("PC");
		}
		
		/**
		 * Gets the weapon damage        
		 *
		 * <hr>
		 * Date created: Nov 1, 2018
		 *
		 * <hr>
		 * @return weaponDamage    The damage done
		 *
		 *
		 */
		public int getWeaponDamage()
		{	
			return this.weaponDamage;
		}
		
		/**
		 * Gets the weapon name     
		 *
		 * <hr>
		 * Date created: Nov 1, 2018
		 *
		 * <hr>
		 * @return weaponName    The name of the weapon
		 *
		 *
		 */
		public String getWeaponName()
		{
			return this.weaponName;
		}	
	} //end public class PotatoCannon extends Weapon
