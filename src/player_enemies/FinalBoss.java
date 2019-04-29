package player_enemies;

import javafx.geometry.Point2D;

/**
 * Class for the enemy type "FinalBoss".
 * @author Tito Vasquez
 *
 */
public class FinalBoss extends EnemyClass{

	/**
	 * Constructor for the FinalBoss Class.
	 * @param currentHP int The boss's current HP.
	 * @param totalHP int The boss's totalHP;
	 * @param attack int The boss's attack power.
	 * @param position int[] The boss's position on the game map.
	 */
	public FinalBoss(int currentHP, int totalHP, int attack, Point2D position) {
		super(currentHP, totalHP, attack, position);
	}
	
	/**
	 * Separate constructor that hard codes in the stats of the FinalBoss for consistency.
	 * @param position int[] The current position of the FinalBoss on the game map.
	 */
	public FinalBoss(Point2D position) {
		super(position);
		this.setHP(255);
		this.setAttack(10);
		this.setImage(null);
	}
}
