package Items;

import player_enemies.CharacterClass;

public class BigPotion extends Item implements Consumable{
	private static final int HEAL=20;
	
	/**
	 * Constructor for BigPotion item
	 */
	public BigPotion() {
		COST=23;
		name="big_potion";
	}

	/**
	 * Uses the consumable SmallPotion. This heals 
	 * the player by a small amount
	 * @param person CharacterClass character that item is used on
	 * @return boolean representing if item usage was successful
	 */
	@Override
	public boolean use(CharacterClass person) {
		
		//health is full, can't use potion
		if(person.getcurrentHP()==person.getTotalHP()) {
			return false;
		}
		
		person.incrementHP(HEAL);
		
		return true;
	}
}
