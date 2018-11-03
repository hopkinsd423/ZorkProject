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

import java.util.Scanner;

//test edit here

/**
 * Creates a Game instance which responds to user input accordingly
 *
 * <hr>
 * Date created: Nov 1, 2018
 * <hr>
 * @author // add author
 */
public class GameDriver
{
	public static void main (String [ ] args)
	{		
		Scanner userInput = new Scanner(System.in);
		
		String directionIndicated = "Unspecified"; //direction the player/user wishes to go
		
		
		Game currentGame = new Game(); //game instance user will play in forever
		Player player = new Player(); //represents the user
		Monster monsterSpawn; //monsters are generally spawned as game progresses
		
		
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
			
			
			if(currentGame.getHasMonster(currentGame.getPlayerCell())) //if there is a monster in the same cell as the player which remains undefeated
			{
				monsterSpawn = new Monster();
				System.out.println(currentGame.displayGame());
				System.out.println("\nA monster is found in the cell and a battle begins!\n");
				
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
