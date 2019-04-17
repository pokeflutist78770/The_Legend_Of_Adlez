package Items;

public abstract class Weapon extends Item {
	protected int DAMAGE;
	protected int RANGE;
	
	
	/**
	 * Performs an attack with this weapon. This method takes a current position
	 * that is where the attack will be performed from, as well as a direction for the
	 * attack. It then calculates is anything is located within the range of the weapon,
	 * and deals the attack onto the items.
	 * @return boolean determining if the attack was successful.
	 */
	public boolean attactk() {
		
	}


	public int getRange() {
		return RANGE;
	}
}
