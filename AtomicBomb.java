/**
 * ---------------------------------------------------------------------------
 * File name: AtomicBomb.java
 * Project name: ZorkD
 * ---------------------------------------------------------------------------
 * Creator's name and email: Dustin Hopkins, hopkinsd@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 3, 2018
 * ---------------------------------------------------------------------------
 */

package zork;


/**
 * subclass used to spawn bombs from the parent class weapon
 *
 * <hr>
 * Date created: Nov 3, 2018
 * <hr>
 * @author Dustin Hopkins
 */
public class AtomicBomb extends Weapon
{
		
		/**
		 * Constructor (default)       
		 *
		 * <hr>
		 * Date created: Nov 1, 2018
		 *
		 * 
		 */
		public AtomicBomb()
		{
			//AtomicBomb  subclass default damage bonus and weapon name
			this.setWeaponDamage (999999995);
			this.setWeaponName ("AB");
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
		 * @return weaponName, the weapons name
	
		 */
		public String getWeaponName()
		{
			return this.weaponName;
		}	
	} //end public class AtomicBomb extends Weapon
