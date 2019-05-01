/**
 * 
 */
package gameObjects;

import java.awt.Point;

import enums.Attack;

/**
 * @author Ben Bauer
 *
 */
public class Dagger extends Weapon {
	

	public Dagger(Point position) {
		super(position);
		this.setImage("assets/sword.png");
		COST=5;
		name="dagger";
		
		DAMAGE=1;
		attackType=Attack.JAB;
	}

}
