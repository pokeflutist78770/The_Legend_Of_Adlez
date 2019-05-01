package gameObjects;

import javafx.geometry.Point2D;

/**
 * Class for the enemy type "Poe".
 * @author Tito Vasquez
 *
 */
public class Poe extends Enemy {

	/**
	 * Constructor for the Poe class.
	 * @param currentHP int The currentHP of the Poe.
	 * @param totalHP int The totalHP of the Poe.
	 * @param attack int The attack power of the Poe.
	 * @param position Point2D The current position of the Poe.
	 */
	public Poe(int currentHP, int totalHP, int attack, Point2D position) {
		super(currentHP, totalHP, attack, position);
	}

	/**
	 * Separate constructor that hard codes in the stats of the Poe for consistency.
	 * @param position Point2D The current position of the Poe on the game map.
	 * @param int n The type of movement pattern that the Poe will have.
	 */
	public Poe(Point2D position, int movement) {
		super(position, movement);
		this.setCurrentHP(10);
		this.setAttack(1);
		this.setImage("assets/idleDark.png");		
	}
}
