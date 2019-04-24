package Items;

import enums.Attack;



/**
 * Sword weapon. This weapon attacks one block in front of the current
 * Direction, as well as the block to the left and right of that one, performing
 * a sweeping motion, damaging any CharacterClass in that path.
 * @author Angel Aguayo
 *
 */
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
