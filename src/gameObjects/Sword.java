package gameObjects;

import enums.Attack;
import javafx.geometry.Point2D;



/**
 * Sword weapon. This weapon attacks one block in front of the current
 * Direction, as well as the block to the left and right of that one, performing
 * a sweeping motion, damaging any CharacterClass in that path.
 * @author Angel Aguayo
 *
 */
public class Sword extends Weapon {
	
	/**
	 * Constructor for Sword weapon
	 */
	public Sword(Point2D position) {
		super(position);
		this.setImage("assets/sword.png");
		COST=5;
		name="sword";
		
		DAMAGE=3;
		attackType=Attack.SWEEP;
	}
}
