package gameObjects;

import enums.Direction;
import javafx.geometry.Point2D;
import javafx.scene.Node;

public class Creature extends GameObject{
	private int currentHP;
	private int totalHP;
	private int attack;
	private Direction direction = Direction.SOUTH;
	
	public Creature(Point2D position) {
		super(position);
	}
	
	public Creature(int currentHP, int totalHP, int attack, Point2D position) {
		super(position);
		this.currentHP = currentHP;
		this.totalHP = totalHP;
		this.attack = attack;
	}

	public void setDirection(Direction dir) {
		direction = dir;
	}
	public Direction getDirection() {
		return direction;
	}

	/**
	 * Setter for the character's HP
	 * @param hp int The HP of the character.
	 */
	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}
	/**
	 * Getter for character's HP.
	 * @return currentHP int The character's current HP.
	 */
	public int getCurrentHP() {
		return currentHP;
	}
	
	/**
	 * Setter for character's total HP.
	 * @param totalHP int The character's total HP.
	 */
	public void setTotalHP(int totalHP) {
		this.totalHP = totalHP;
	}
	/**
	 * Getter for character's total HP.
	 * @return totalHP int The character's total HP.
	 */
	public int getTotalHP() {
		return totalHP;
	}
	
	/**
	 * Setter for the character's attack.
	 * @param attack int The attack power of the character.
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}
	/**
	 * Getter for character's attack power.
	 * @return attack int The character's current attack power.
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * Reduces the HP of the character by a given amount.
	 * @param n int The number of HP to reduce.
	 */
	public void decrementHP(int n) {
		currentHP -= n;
		if (currentHP < 0) {
			currentHP = 0;
		}
	}
	/**
	 * Increases the HP of the character by a given amount.
	 * @param n int The number of HP to increase.
	 */
	public void incrementHP(int n) {
		currentHP += n;
		if (currentHP > totalHP) {
			currentHP = totalHP;
		}
	}
	
}
