package Items;

import Enums.Attack;



/**
 * Staff weapon. This weapon can attack two blocks ahead of the current
 * Direction, damaging anything that resides in those two blocks
 * @author Angel Aguayo
 *
 */
public class Staff extends Weapon{
	
	/**
	 * Constructor for Staff weapon
	 */
	public Staff() {
		name="staff";
		COST=10;
		
		RANGE=2;
		DAMAGE=5;		
		attackType=Attack.JAB;
	}
}
