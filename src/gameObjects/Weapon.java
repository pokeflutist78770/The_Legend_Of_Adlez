package gameObjects;

import java.awt.Point;

import enums.Attack;
import javafx.geometry.Point2D;



/**
 * Weapon base class. Serves as the base weapon, storing all common characteristics
 * such as damage and range (represented by blocks). It also stores what type 
 * of attack the weapon performs.
 * @author ANgel Aguayo
 *
 */
public abstract class Weapon extends Item {
	protected int DAMAGE;
	protected Attack attackType;
	
	public Weapon(Point position) {
		super(position);
	}

	/**
	 * Get the damage a weapon can do
	 * @return int representing amount of damage a weapon can do
	 */
	public int getDamage() {
		return DAMAGE;
	}
	
	/**
	 * Gets the weapon attack type
	 * @return Attack enum representing what type of attack
	 * the weapon does
	 */
	public Attack getAttackType() {
		return attackType;
	}
}
