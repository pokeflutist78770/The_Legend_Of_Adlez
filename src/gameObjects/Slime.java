
package gameObjects;

import java.awt.Point;

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
	 * @param position Point2D The current position of the Slime.
	 */
	public Slime(int currentHP, int totalHP, int attack, Point position) {
		super(currentHP, totalHP, attack, position);
	}

	/**

	 * Separate constructor that hard codes in the stats of the Slime for consistency.
	 * @param position Point2D The current position of the Slime on the game map.
	 * @param n int The type of movement pattern that the Slime will have.
	 */
	public Slime(Point position, int movement) {
		super(position, movement);
		setTotalHP(10);
		setCurrentHP(10);
		setAttack(1);
		setImage("assets/slime.png");
	}
}
