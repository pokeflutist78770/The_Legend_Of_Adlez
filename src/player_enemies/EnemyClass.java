package player_enemies;

import javafx.geometry.Point2D;

/**
 * Class for all enemies in the game.
 * @author Tito Vasquez
 *
 */
public class EnemyClass extends CharacterClass {
	
	private Direction[] horizontal = {EAST, EAST, EAST, EAST, EAST, WEST, WEST, WEST, WEST, WEST};
	private Direction[] vertical = {SOUTH, SOUTH, SOUTH, SOUTH, SOUTH, NORTH, NORTH, NORTH, NORTH, NORTH};
	private Direction[] square = {SOUTH, SOUTH, EAST, EAST, NORTH, NORTH, WEST, WEST};
	private Direction[] current; 
	private int index = 0;
	

	/**
	 * Constructor for the EnemyClass of enemies.
	 * @param currentHP int The currentHP of the enemy
	 * @param totalHP int The totalHP of the enemy
	 * @param attack int The attack power of the enemy
	 * @param position Point2D The current position of the enemy
	 */
	public EnemyClass(int currentHP, int totalHP, int attack, Point2D position) {
		super(currentHP, totalHP, attack, position);
	}
	
	/**
	 * Separate constructor for the EnemyClass for specific enemy types.
	 * @param position Point2D The current position of the enemy on the game map.
	 */
	public EnemyClass(Point2D position) {
		super(position);
	}
	
	/**
	 * Sets the movement pattern of the enemy given an integer.
	 */
	public void setMovementPattern(int n) {
		if (n == 0)
			current = horizontal;
		else if (n == 1)
			current = vertical;
		else if (n == 2) 
			current = square;
	}
	
	/**
	 * Gets the movment pattern of the enemy.
	 * @return Direction[] The specific movement pattern that the enemy will follow.
	 */
	public Direction[] getMovementPattern() {
		return current;
	}
		
	/**
	 * Gets the next move of the enemy based on a specific pattern. 
	 * @return Direction The next direction that the enmy will move.
	 */ 
	public Direction getNextMove() { 
		if (index == current.length)
			index = 0;
		return current[index];
	}
}
