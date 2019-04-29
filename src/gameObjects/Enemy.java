package gameObjects;

import javafx.geometry.Point2D;

/**
 * Class for all enemies in the game.
 * @author Tito Vasquez
 *
 */
public class Enemy extends Creature {

	/**
	 * Constructor for the EnemyClass of enemies.
	 * @param currentHP int The currentHP of the enemy
	 * @param totalHP int The totalHP of the enemy
	 * @param attack int The attack power of the enemy
	 * @param position int[] The current position of the enemy
	 */
	public Enemy(int currentHP, int totalHP, int attack, Point2D position) {
		super(currentHP, totalHP, attack, position);
	}
	
	/**
	 * Separate constructor for the EnemyClass for specific enemy types.
	 * @param position int[] The current position of the enemy on the game map.
	 */
	public Enemy(Point2D position) {
		super(position);
	}

	public Enemy() {
		super(new Point2D(0,0));
	}
}
