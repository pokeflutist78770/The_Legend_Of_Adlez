package gameObjects;

import javafx.geometry.Point2D;

/**
 * Class for the enemy type "FinalBoss".
 * @author Tito Vasquez
 *
 */
public class FinalBoss extends Enemy{

	/**
	 * Constructor for the FinalBoss Class.
	 * @param currentHP int The boss's current HP.
	 * @param totalHP int The boss's totalHP;
	 * @param attack int The boss's attack power.
	 * @param position Point2D The boss's position on the game map.
	 */
	public FinalBoss(int currentHP, int totalHP, int attack, Point2D position) {
		super(currentHP, totalHP, attack, position);
	}
	
	/**
	 * Separate constructor that hard codes in the stats of the FinalBoss for consistency.
	 * @param position Point2D The current position of the FinalBoss on the game map.
	 * @param n int The type of movement pattern that the Boss will have.
	 */
	public FinalBoss(Point2D position, int n) {
		super(position, n);
		this.setTotalHP(255);
		this.setAttack(10);
		this.setImage("assets/boss.png");
	}
}
