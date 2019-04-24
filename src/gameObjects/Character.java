package gameObjects;

import enums.Direction;
import javafx.geometry.Point2D;
import javafx.scene.Node;

public class Character extends GameObject{
	private int currentHP;
	private int totalHP;
	private int attack;
	private Direction direction;
	
	public Character(Node node) {
		super(node);
		direction = Direction.SOUTH;
		// TODO Auto-generated constructor stub
	}
	
	public Character(Point2D position) {
		super(position);
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction dir) {
		direction = dir;
	}
	public void move(Direction dir) {
		int x = 0, y = 0;
		switch(dir) {
		case NORTH:
			x = 0;
			y= -1;
			break;
		case SOUTH:
			x = 0;
			y = 1;
			break;
		case EAST:
			x = 1;
			y = 0;
			break;
		case WEST:
			x = -1;
			y = 0;
			break;	
		}
		setPosition(getPosition().add(x, y));
		Node node = getNode();
		node.setTranslateX(node.getTranslateX() + x * 48);
		node.setTranslateY(node.getTranslateY() + y * 48);
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
	
	/**
	 * Setter for the character's HP
	 * @param hp int The HP of the character.
	 */
	public void setHP(int hp) {
		this.currentHP = hp;
	}
	
	/**
	 * Setter for the character's attack.
	 * @param attack int The attack power of the character.
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	/**
	 * Getter for character's HP.
	 * @return currentHP int The character's current HP.
	 */
	public int getcurrentHP() {
		return currentHP;
	}
	
	/**
	 * Getter for character's total HP.
	 * @return totalHP int The character's total HP.
	 */
	public int getTotalHP() {
		return totalHP;
	}
	
	/**
	 * Getter for character's attack power.
	 * @return attack int The character's current attack power.
	 */
	public int getAttack() {
		return attack;
	}

}
