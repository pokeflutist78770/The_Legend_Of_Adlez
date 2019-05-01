package gameObjects;

import javafx.geometry.Point2D;
import player_enemies.CharacterClass;



/**
 * SmallPotion class. This potion only heals a small amount, and is
 * relatively cheap compared to BigPotion
 * @author Angel Aguayo
 *
 */
public class SmallPotion extends Item implements Consumable{
	private static final int HEAL=5;
	
	
	/**
	 * Constructor for SmallPotion item
	 */
	public SmallPotion(Point2D position) {
		super(position);
		this.setImage("assets/potion.png");
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
	public boolean use(Creature person) {
		
		//health is full, can't use potion
		if(person.getCurrentHP()==person.getTotalHP()) {
			return false;
		}
		
		person.incrementHP(HEAL);
		
		return true;
	}
}
