package gameObjects;

import java.awt.Point;

/**
 * Class for the enemy type "Poe".
 * @author Tito Vasquez
 *
 */
public class Poe extends Enemy {

	/**
	 * Separate constructor that hard codes in the stats of the Poe for consistency.
	 * @param position Point2D The current position of the Poe on the game map.
	 * @param int n The type of movement pattern that the Poe will have.
	 */
	public Poe(Point position, int movement) {
		super(position, movement);
		this.setCurrentHP(10);
		setTotalHP(10);
		setMoneyDrop(15);
		this.setAttack(1);
		this.setImage("assets/poe.png");	
		
		super.setAttackSound("poe");
	}
}
