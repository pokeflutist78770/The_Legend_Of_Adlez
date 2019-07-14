package gameObjects;

/**
 * Consumable interface. This allows an item to become consumable, 
 * where it can then be used on a specific CharacterClass with various 
 * effects
 * @author Angel Aguayo
 */
public interface Consumable {

	boolean use(Creature person);
	
}
