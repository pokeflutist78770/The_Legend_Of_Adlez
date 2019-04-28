package player_enemies;

import javafx.geometry.Point2D;

/**
 * Class for all enemies in the game.
 * @author Tito Vasquez
 *
 */
public class EnemyClass extends CharacterClass {

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
		
}
