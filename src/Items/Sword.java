package Items;

import Enums.Attack;

public class Sword extends Weapon{
	
	/**
	 * Constructor for Sword weapon
	 */
	public Sword() {
		COST=5;
		name="sword";
		
		RANGE=1;
		DAMAGE=3;
		attackType=Attack.SWEEP;
	}
}
