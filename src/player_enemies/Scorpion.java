package player_enemies;

import javafx.geometry.Point2D;

/**
 * Class for the enemy type "Scorpion".
 * @author Tito Vasquez
 *
 */
public class Scorpion extends EnemyClass {

	/**
	 * Constructor for the Scorpion class.
	 * @param currentHP int The currentHP of the Scorpion.
	 * @param totalHP int The totalHP of the Scorpion.
	 * @param attack int The attack power of the Scorpion.
	 * @param position int[] The current position of the Scorpion.
	 */
	public Scorpion(int currentHP, int totalHP, int attack, Point2D position) {
		super(currentHP, totalHP, attack, position);
	}

	/**
	 * Separate constructor that hard codes in the stats of the Slime for consistency.
	 * @param position int[] The current position of the Slime on the game map.
	 */
	public Scorpion(Point2D position) {
		super(position);
		this.setHP(10);
		this.setAttack(1);
		this.setImage(null);		
	}
}
