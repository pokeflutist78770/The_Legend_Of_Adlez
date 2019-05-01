package gameObjects;

import java.awt.Point;



/**
 * SmallPotion class. This potion only heals a small amount, and is
 * relatively cheap compared to BigPotion
 * @author Angel Aguayo
 *
 */
public class BigPotion extends Item implements Consumable{
	private static final int HEAL=20;
	
	
	/**
	 * Constructor for BigPotion item
	 */
	public BigPotion(Point position) {
		super(position);
		this.setImage("assets/potion.png");
		COST=10;
		name="Big_potion";
	}

	/**
	 * Uses the consumable SmallPotion. This heals 
	 * the player by a small amount
	 * @param person CharacterClass character that item is used on
	 * @return boolean representing if item usage was successful
	 */
	@Override
	public boolean use(Creature person) {
		
		//health is full, can't use potion
		if(person.getCurrentHP()==person.getTotalHP()) {
			return false;
		}
		
		person.incrementHP(HEAL);
		
		return true;
	}
}
