package Items;

import Enums.Attack;

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
