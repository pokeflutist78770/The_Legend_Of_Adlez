
package gameObjects;

import java.awt.Point;

import javafx.geometry.Point2D;

/**
 * Class for the enemy type "FinalBoss".
 * @author Tito Vasquez
 *
 */
public class FinalBoss extends Enemy{

	/**
	 * Separate constructor that hard codes in the stats of the FinalBoss for consistency.
	 * @param position Point2D The current position of the FinalBoss on the game map.
	 * @param n int The type of movement pattern that the Boss will have.
	 */

	public FinalBoss(Point position, int movement) {
		super(position, movement);
		setTotalHP(255);
		this.setCurrentHP(10);
		this.setAttack(0);
		this.setImage("assets/boss.png");
		super.setAttackSound("boss");
	}
}
