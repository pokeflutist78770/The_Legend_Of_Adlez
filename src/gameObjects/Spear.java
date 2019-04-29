package gameObjects;

import enums.Attack;



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
	public Spear() {
		name="staff";
		COST=10;
		DAMAGE=5;		
		attackType=Attack.JAB;
		
	}
}
