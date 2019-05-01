package gameObjects;

import javafx.geometry.Point2D;

/**
 * Class for the enemy type "Slime".
 * @author Tito Vasquez
 *
 */
public class Slime extends Enemy {

	/**
	 * Constructor for the Slime class.
	 * @param currentHP int The currentHP of the Slime.
	 * @param totalHP int The totalHP of the Slime.
	 * @param attack int The attack power of the Slime.
	 * @param position int[] The current position of the Slime.
	 */
	public Slime(int currentHP, int totalHP, int attack, Point2D position) {
		super(currentHP, totalHP, attack, position);
	}

	/**
	 * Separate constructor that hard codes in the stats of the Slime for consistency.
	 * @param position int[] The current position of the Slime on the game map.
	 */
	public Slime(Point2D position, int movement) {
		super(position, movement);
		setCurrentHP(10);
		setAttack(1);
		setImage("assets/idleDark.png");
	}
}
