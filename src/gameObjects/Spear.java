package gameObjects;

import java.awt.Point;

import enums.Attack;
import javafx.geometry.Point2D;


/**
 * Staff weapon. This weapon can attack two blocks ahead of the current
 * Direction, damaging anything that resides in those two blocks
 * @author Angel Aguayo
 *
 */
public class Spear extends Weapon{
	
	/**
	 * Constructor for Staff weapon
	 */
	public Spear(Point position) {
		super(position);
		this.setImage("assets/spear.png");
		name="staff";
		COST=10;
		DAMAGE=5;		
		attackType=Attack.JAB;
		
	}
}
