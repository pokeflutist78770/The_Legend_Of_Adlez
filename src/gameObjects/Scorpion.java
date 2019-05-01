package gameObjects;

import java.awt.Point;

/**
 * Class for the enemy type "Scorpion".
 * @author Tito Vasquez
 *
 */
public class Scorpion extends Enemy {
	
	/**
	 * Constructor for the Scorpion class.
	 * @param currentHP int The currentHP of the Scorpion.
	 * @param totalHP int The totalHP of the Scorpion.
	 * @param attack int The attack power of the Scorpion.
	 * @param position Point2D The current position of the Scorpion.
	 */
	public Scorpion(int currentHP, int totalHP, int attack, Point position) {
		super(currentHP, totalHP, attack, position);
		super.setAttackSound("scorpion");
	}

	/**
	 * Separate constructor that hard codes in the stats of the Slime for consistency.
	 * @param position Point2D The current position of the Slime on the game map.
	 * @param n int The type of movement pattern that the Scorpion will have.
	 */
	public Scorpion(Point position, int n) {
		super(position, n);
		super.setAttackSound("scorpion");
		this.setTotalHP(10);
		this.setAttack(1);
		this.setImage("assets/scorp.png");		
	}
}
