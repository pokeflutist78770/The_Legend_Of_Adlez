package gameObjects;

import java.awt.Point;

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
	public Scorpion(Point position, int movePattern) {
		super(position, movePattern);
		this.setTotalHP(10);
    setCurrentHP(10);
    setMoneyDrop(7);
		this.setAttack(1);
		this.setImage("assets/scorp.png");		
	}
}
