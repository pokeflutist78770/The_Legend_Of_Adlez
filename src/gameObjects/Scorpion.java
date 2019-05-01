package gameObjects;

import javafx.geometry.Point2D;

/**
 * Class for the enemy type "Scorpion".
 * @author Tito Vasquez
 *
 */
public class Scorpion extends Enemy {

	/**
	 * Separate constructor that hard codes in the stats of the Slime for consistency.
	 * @param position Point2D The current position of the Slime on the game map.
	 * @param n int The type of movement pattern that the Scorpion will have.
	 */
	public Scorpion(Point2D position, int movePattern) {
		super(position, movePattern);
		setTotalHP(10);
		setCurrentHP(10);
		setAttack(1);
		setImage("assets/scorp.png");		
	}
}
