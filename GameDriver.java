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
import java.util.Scanner;



/**
 * Creates a Game instance which responds to user input accordingly
 *
 * <hr>
 * Date created: Nov 1, 2018
 * <hr>
 * @author Dustin Hopkins, Audrey Chaffin, Reid Connor
 */
public class GameDriver
{
	/**
	 * Main method for the game. This handles all functionality of the game. 
	 *
	 * <hr>
	 * Date created: Nov 2, 2018
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{		
		Scanner userInput = new Scanner(System.in);
		
		String directionIndicated = "Unspecified"; //direction the player/user wishes to go
		
		
		Game currentGame = new Game(); //game instance user will play in
		Player player = new Player(); //represents the user
		Monster monsterSpawn =
		null; //monsters are generally spawned as game progresses
		
		
		for (int i = 0; i < currentGame.getCellCount( ) + 1; i = currentGame.getPlayerCell()) //for each cell in the instantiated game, with each cycle pulling the players location
		{
			System.out.println("\n" + currentGame.displayGame());
			System.out.println("Player Health Remaining: " + player.getHealth());
			
			//loop if input is invalid, until input is valid;  loop is always entered at least one time to obtain user data
			while (!directionIndicated.equalsIgnoreCase("go west") && !directionIndicated.equalsIgnoreCase("west") && !directionIndicated.equalsIgnoreCase("go east") && !directionIndicated.equalsIgnoreCase("east"))
			{
				System.out.println("\nWould you like to go East or West?  Enter 'go east' or 'go west':");
				directionIndicated = userInput.nextLine ( );
				
				if(directionIndicated.equalsIgnoreCase("go east") || directionIndicated.equalsIgnoreCase("east")) //if player indicates he/she wishes to travel east
				{	
					 //if player is in the last cell in the dungeon, skip cell reconstruction (movement) as player is leaving the last cell in the game.
					//we still want the for loop to run on this step so that the player can indicate to move east, or in case the player wants to backtrack to the west
					if (i == currentGame.getCellCount() - 1)
					{
						break;
					}
					
					currentGame.movePlayerEast ( );
					
					//cellTracker += 1; //update backtrack amount
				}
				
				else if (directionIndicated.equalsIgnoreCase("go west") || directionIndicated.equalsIgnoreCase("west")) //if player indicates he/she wishes to travel west
				{
					if (currentGame.getPlayerCell() != 0)
					{
						currentGame.movePlayerWest ( );
						//cellTracker -= 1; //back-tracking 1 cell
					}
					
					else
					{
						System.out.println("Sorry, but I can't go West from here!");
						directionIndicated = "invalid";  //reset user input
						continue; //restart loop
					}
				}
				
				else
				{
					System.out.println("I do not know what you mean.");
				}
			} //end while invalid
			
			
			if (i == currentGame.getCellCount() - 1  && currentGame.getPlayerCell() == i)  //i.e. if player is leaving the last cell in the game
			{
				break; //terminate the for loop (user input - monster fight loop)
			}
			
	/**
	 * *******CHANGES************************
	 * 
	 * 
	 * 
	 * 
	 *  *******CHANGES************************

	 * 
	 * 
	 *  *******CHANGES************************

	 * 
	 * 
	 * 
	 *  *******CHANGES************************

	 * 
	 * 
	 */
			if(currentGame.getHasMonster(currentGame.getPlayerCell())) //if there is a monster in the same cell as the player which remains undefeated
			{
				Random rand = new Random();//Create an object from the random class 
				
				int randomNum = rand.nextInt((3 - 1) + 1) + 1;//generate a random number between 1 2 and 3 here. 
																								// This will be used to determine which of the three monsters will spawn
			
						if (randomNum ==1)
						{
							monsterSpawn = new Hitler();                 //Hitler is spawned
							System.out.println(currentGame.displayGame());
							System.out.println("\nYou're fighing Hitler!!!!!\n");
						}
							else if(randomNum==2)
							{
								monsterSpawn = new Godzilla();              //godzilla is spawned
								System.out.println(currentGame.displayGame());
								System.out.println("\nYou're fighing GODZILLA!!!!!\n");
							}
							else if(randomNum==3)
							{
								monsterSpawn = new Thanos();//thanos is spawned 
								System.out.println(currentGame.displayGame());
								System.out.println("\nYou're fighing THANOS!!!!!!!!\n");
							}
						
				/**
				 * END OF CHANGES
				 * 
				 * 
				 * * END OF CHANGES
				 * 
				 * 
				 * * END OF CHANGES
				 * 
				 * 
				 * * END OF CHANGES
				 * 
				 */
				while((monsterSpawn.getHealth() > 0) && player.getHealth() > 0) //while both the player and monster are alive
				{		

					if (player.attack() == 0) //if player misses his/her attack
					{
						System.out.println("The player has missed an attack on the monster!  Monster Health remaining: " + monsterSpawn.getHealth());
					}
					
					else //if player doesn't miss his/her attack
					{
						if (currentGame.getHasWeapon(currentGame.getPlayerCell())) //if player has a weapon
						{
							monsterSpawn.isAttacked(player.getDamage() + currentGame.getGameWeapon().getWeaponDamage());	
							
							if (monsterSpawn.getHealth() < 0) //if monster is over-killed (negative health remaining)
							{
								monsterSpawn.setHealth(0); //set remaining health to zero
							}
							System.out.println("The Player hit the Monster for " + (player.getDamage() + currentGame.getGameWeapon().getWeaponDamage()) + " damage.  Monster Health remaining: " + monsterSpawn.getHealth());
						}
						else //if player does not currently have a weapon
						{
							monsterSpawn.isAttacked(player.getDamage());
							System.out.println("The Player hit the Monster for " + (player.getDamage()) + " damage.  Monster Health remaining: " + monsterSpawn.getHealth());
						}
					} //end root else
					
					if ((monsterSpawn.getHealth() > 0) && monsterSpawn.attack() == 0) //if monster is still alive and misses its attack
					{
						System.out.println("The monster has missed its attack on the player!  Player Health remaining: " + player.getHealth());
					}
					
					else if (monsterSpawn.getHealth() > 0)//if monster is alive (and doesn't miss its attack)
					{
						player.isAttacked(player.getDamage());	
						System.out.println("The Monster hit the Player for " + (monsterSpawn.getDamage()) + " damage.  Player Health remaining: " + player.getHealth());
					}
				} //end while((monsterSpawn.getHealth() > 0) && player.getHealth() > 0)  i.e. monster-player fight 
				
				
				if (monsterSpawn.getHealth() == 0)
				{
					System.out.println("\nHurrah! You have defeated the monster!\n");
					currentGame.setHasMonster(currentGame.getPlayerCell()); //set boolean for a monster being in this cell to false, as it has been defeated
				}	
				
				else if (player.getHealth() == 0)
				{
					System.out.println("\nUnfortunately, the player has been killed by the monster.  You did not make it through the dungeon.\nGAME OVER");
					System.exit(-1);
				}
		
			} //end if(currentGame.getHasMonster(i))
			
			directionIndicated = "Unspecified"; //reset user input
			
		} //end for (int i = 0; i < currentGame.getCellCount ( ); i++)
		
		System.out.println("\nCongratulation, you have made it out of the dungeon!\nYOU WIN");
		userInput.close ( );

	}//end main

}//end public class GameDriver
