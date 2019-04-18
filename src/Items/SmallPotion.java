package Items;

public class SmallPotion extends Item implements Consumable{
	private static final int HEAL=5;
	
	
	/**
	 * Constructor for SmallPotion item
	 */
	public SmallPotion() {
		COST=5;
		name="small_potion";
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
		if(person.getCurrentHP()==person.getTotalHP()) {
			return false;
		}
		
		person.incrementHP(HEAL);
		
		return true;
	}
}
