package gameObjects;

import java.awt.Point;

import enums.Direction;
import javafx.geometry.Point2D;

/**
 * Class for all enemies in the game.
 * @author Tito Vasquez
 *
 */
public class Enemy extends Creature {

	private String attackSound;
	
	
	/**
	 * Constructor for the EnemyClass of enemies.
	 * @param currentHP int The currentHP of the enemy
	 * @param totalHP int The totalHP of the enemy
	 * @param attack int The attack power of the enemy
	 * @param position int[] The current position of the enemy
	 */
	
	private Direction EAST = Direction.EAST;
	private Direction WEST = Direction.WEST;
	private Direction SOUTH = Direction.SOUTH;
	private Direction NORTH = Direction.NORTH;
	private int moneyDrop;
	
	private Direction[] horizontal = {EAST, EAST, EAST, EAST, EAST, WEST, WEST, WEST, WEST, WEST};
	private Direction[] vertical = {SOUTH, SOUTH, SOUTH, SOUTH, SOUTH, NORTH, NORTH, NORTH, NORTH, NORTH};
	private Direction[] square = {SOUTH, SOUTH, EAST, EAST, EAST, NORTH, NORTH, NORTH, WEST, WEST, WEST, SOUTH};
	private Direction[] boss = {SOUTH, SOUTH, SOUTH, SOUTH, SOUTH, SOUTH, SOUTH, WEST, WEST, WEST, WEST, NORTH, 
								NORTH, NORTH, NORTH, NORTH, NORTH, NORTH, EAST, EAST, EAST, NORTH, NORTH, 
								NORTH, EAST, EAST, SOUTH, SOUTH, SOUTH, SOUTH, SOUTH, SOUTH, SOUTH, SOUTH, 
								SOUTH, EAST, EAST, EAST, EAST, NORTH, NORTH, NORTH, NORTH, NORTH, NORTH, 
								NORTH, WEST, WEST, WEST, NORTH, NORTH, NORTH, WEST, WEST, SOUTH, SOUTH};
	private Direction[] current; 
	private int index = 0;
	private boolean dropped = false;

	/**
	 * Constructor for the EnemyClass of enemies.
	 * @param currentHP int The currentHP of the enemy
	 * @param totalHP int The totalHP of the enemy
	 * @param attack int The attack power of the enemy
	 * @param position Point2D The current position of the enemy
	 */

	public Enemy(Point position, int movePattern) {
		super(position);
		setMovementPattern(movePattern);
	}
	
	/**
	 * Sets the movement pattern of the enemy given an integer.
	 * @param n int The type of pattern that an enemy will have.
	 */
	public void setMovementPattern(int n) {
		if (n == 1)
			current = horizontal;
		else if (n == 2)
			current = vertical;
		else if (n == 3) 
			current = square;
		else if (n == 4)
			current = boss; 
	}
	
	/**
	 * Gets the movment pattern of the enemy.
	 * @return current Direction[] The specific movement pattern that the enemy will follow.
	 */
	public Direction[] getMovementPattern() {
		return current;
	}
	
	
	/**
	 * Gets the next move of the enemy based on a specific pattern. 
	 * @return currentDirection Direction The next direction that the enemy will move.
	 */ 
	public Direction getNextMove() { 
		Direction currentDirection = current[index];
		index = (index + 1) % current.length;
		return currentDirection;
	}
	

	public void setAttackSound(String attackSound) {
		this.attackSound = attackSound;
	}


	public void setMoneyDrop(int amt) {
		moneyDrop = amt;
	}
	
	public int getMoneyDrop(int amt) {
		return moneyDrop;
	}


	/**
	 * @return the dropped
	 */
	public boolean hasDropped() {
		return dropped;
	}

	/**
	 * @param dropped the dropped to set
	 */
	public void setDropped(boolean dropped) {
		this.dropped = dropped;
	}
	
	public String getAttackSound(){
		return attackSound;
	}
}

