/**
 * Class for the enemy type "Slime".
 * @author Tito Vasquez
 *
 */
public class Slime extends EnemyClass {

	/**
	 * Constructor for the Slime class.
	 * @param currentHP int The currentHP of the Slime.
	 * @param totalHP int The totalHP of the Slime.
	 * @param attack int The attack power of the Slime.
	 * @param position int[] The current position of the Slime.
	 */
	public Slime(int currentHP, int totalHP, int attack, int[] position) {
		super(currentHP, totalHP, attack, position);
	}

	/**
	 * Separate constructor that hard codes in the stats of the Slime for consistency.
	 * @param position int[] The current position of the Slime on the game map.
	 */
	public Slime(int[] position) {
		super(position);
		this.setHP(10);
		this.setAttack(1);
		this.setImage(null);		
	}
}
