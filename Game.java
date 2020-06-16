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
 * Provides for the construction of Game instances with randomized features;
 * Provides functionality necessary to modify the state of any number of game instances
 *
 * <hr>
 * Date created: Nov 1, 2018
 * <hr>
 * @author Dustin Hopkins, Audrey Chaffin, Reid Connor
 */
public class Game
{
	//attributes; for tracking number of cells and cell contents
	private boolean[] hasMonster; //cell contains monster
	private boolean[] hasWeapon; //cell contains weapon
	private int cellCount; //number of cells in game
	private String[] cells; //for specifying/modifying contents of each cell
	private int playerCell = 0; //location of the player
	private Weapon gameWeapon = null; //weapon spawned for a game instance
	private final int cellSpace = 6; //two cell walls and four spaces between walls; can adjust to add or remove content from game

	
	/**
	 * Constructor (default): The design (layout, features) of any game instance upon initialization ('game start')      
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * 
	 */
	public Game()
	{	
		int weaponCell; //used to temporarily track which cell the weapon is in
		
		char[] cellBreak;	//for modifying cell in which weapon is added (immutable strings in java)
		String weaponAdded = ""; // for converting char[] cellBreak back into a String cell
		
		Random rng = new Random ();
		cellCount = rng.nextInt(6) + 5; //determine number of cells
		
		//set array attributes' lengths according to how many cells game has
		hasMonster = new boolean[cellCount];
		hasWeapon = new boolean[cellCount];
		cells = new String[cellCount];	
		
		for (int i = 0; i < cellCount; i++) //for as many cells as game as..
		{
			//create the actual cells
			if (i == 0)
			{										
				cells[i] = "|P___|  ";		
			}
			
			else if (Monster.spawnMonster()) //if monster spawns (50% chance)
			{
				cells[i] = "|_M__|  ";
				hasMonster[i] = true; // track monster for fighting purposes
			}
			
			
			else
			{
				cells[i] = "|____|  ";
			}
		} //end for (int i = 0; i < cellCount; i++)
		
		//determine by chance which cell contains the weapon, and add it to the cell:
		weaponCell = Weapon.weaponSpawnLocation(cellCount);
		gameWeapon = (Weapon.spawnWeapon());
		
		//player will have weapon for cell the weapon was in and for any fights in all cells afterward, so set all proceeding cells accordingly	:
		for (int i = weaponCell; i < cellCount; i++)
		{
			hasWeapon[i] = true;
		}

		//String are immutable in Java; Convert cell contents to a character array (char[] cellBreak) in order to 'add' a weapon to a randomly chosen cell:
		cellBreak = new char[cellSpace];
						
		for (int i = 0; i < cellSpace; i++)
		{
			cellBreak[i] = cells[weaponCell].charAt(i);
		}
		
		//Note: weapon names are 2 characters in length.  Insert weapon name into the last spaces in the chosen cell:
		cellBreak[3] = gameWeapon.getWeaponName().charAt(0);
		cellBreak[4] = gameWeapon.getWeaponName().charAt(1);
		
		//convert our character array (char[] cellBreak) back to a string in order to overwrite cell contents with the cell containing the weapon name:
		for (int i = 0; i < cellSpace; i++)
		{
			weaponAdded += Character.toString(cellBreak[i]);
		}
		
		weaponAdded += "  "; //add space between cells back in
		
		cells[weaponCell] = new String(weaponAdded); //overwrite (update) previous contents
		
	} //end public game()
	
	
	/**
	 * Displays (prints) the current state of a game instance;
	 * toString override has been avoided in this display so that it is available to provide a list of game features without the 'game" format
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 * @return String game
	 */
	public String displayGame()
	{
		String game = "";
		
		for (int i = 0; i < cellCount; i++) //for as many cells as game as..
		{
			game += cells[i]; //concatenate each cell to one String (String game)
		}
		
		return game;
	} //end public String displayGame()
	
	/*
	** 
	The following methods are for player movement.  While all directional movement can be accomplished with a single method that accepts, for example,
	an integer or String as a parameter, a different method for each direction is present as to provide clarity in their usage
	**
	*/
	
	/**
	 * Moves the player one cell to the right      
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 */
	public void movePlayerEast()
	{
		char[] cellBreak;	//for modifying cell in which weapon is added (immutable strings in java)
		String reversion = ""; //for changing our char[] cell back to a String after it has been modified to represent player's location
		
		cellBreak = new char[cellSpace];
		
		cells[playerCell] = cells[playerCell].replace('P', '_'); //remove player from current cell
		
		playerCell++; //player is moving one cell over; access contents of next cell
		
		for (int i = 0; i < cellSpace; i++)
		{
			cellBreak[i] = cells[playerCell].charAt(i);
		}
		
		
		cellBreak[cellSpace - (cellSpace - 1)] = 'P'; //add player to contents of next cell
		
		//convert the cell back to a String and modify the 
		for (int i = 0; i < cellSpace; i++)
		{
			reversion += Character.toString(cellBreak[i]);
		}
		reversion += "  "; //add space between cells back in
		
		cells[playerCell] = new String(reversion);
	} //end public void movePlayerEast()
	
	
	/**
	 * Moves the player one cell to the west         
	 *
	 * <hr>
	 * Date created: Nov 1, 2018
	 *
	 * <hr>
	 */
	public void movePlayerWest()
	{
		char[] cellBreak;	//for modifying cell in which weapon is added (immutable strings in java)
		String reversion = ""; //for changing our char[] cell back to a String after it has been modified to represent player's location
		
		cellBreak = new char[cellSpace];
		
		cells[playerCell] = cells[playerCell].replace('P', '_'); //remove player from current cell
		
		playerCell--; //player is moving one cell back; access contents of previous cell
		
		for (int i = 0; i < cellSpace; i++)
		{
			cellBreak[i] = cells[playerCell].charAt(i);
		}
		
		
		cellBreak[cellSpace - (cellSpace - 1)] = 'P'; //add player to contents of next cell
		
		//convert the cell back to a String and modify the 
		for (int i = 0; i < cellSpace; i++)
		{
			reversion += Character.toString(cellBreak[i]);
		}
		reversion += "  "; //add space between cells back in
		
		cells[playerCell] = new String(reversion);
	} //end public void movePlayerEast()
	
	
	/**
	 * @return integer cellCount attribute --> the number of Cells
	 */
	public int getCellCount()
	{
		return this.cellCount;
	}
	
	
	/**
	 * @return integer playerCell attribute --> the cell in which the Player is currently in
	 */
	public int getPlayerCell()
	{
		return this.playerCell;
	}
	
	
	/**
	 * @param int cellNumber
	 * @return boolean hasMonster[cellNumber] --> whether or not the cellNumber passed in as a parameter contains a monster
	 */
	public boolean getHasMonster(int cellNumber)
	{
		return this.hasMonster[cellNumber];
	}
	
	
	/**
	 * @param cellNumber --> the cell in which a monster no longer exists
	 */
	public void setHasMonster(int cellNumber)
	{
		this.hasMonster[cellNumber] = false;
	}
	
	
	/**
	 * @param int cellNumber
	 * @return boolean HasWeapon[cellNumber] --> whether or not the cell has a weapon
	 */
	public boolean getHasWeapon(int cellNumber)
	{
		return this.hasWeapon[cellNumber];
	}
	
	/**
	 * @return gameWeapon -- the weapon that was/is randomly selected to be generated in the game instance
	 */
	public Weapon getGameWeapon()
	{
		return this.gameWeapon; //there exists no need to create separate object instance
	}
} //end public class Game
