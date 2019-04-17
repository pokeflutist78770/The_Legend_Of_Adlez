package player_enemies;

/**
 * Class for all enemies in the game.
 * @author Tito Vasquez
 *
 */
public class EnemyClass extends CharacterClass {
	String image;

	/**
	 * Constructor for the EnemyClass of enemies.
	 * @param currentHP int The currentHP of the enemy
	 * @param totalHP int The totalHP of the enemy
	 * @param attack int The attack power of the enemy
	 * @param position int[] The current position of the enemy
	 */
	public EnemyClass(int currentHP, int totalHP, int attack, int[] position) {
		super(currentHP, totalHP, attack, position);
	}
	
	/**
	 * Separate constructor for the EnemyClass for specific enemy types.
	 * @param position int[] The current position of the enemy on the game map.
	 */
	public EnemyClass(int[] position) {
		super(position);
	}
	
	/**
	 * Set the image to a specific file location as a string.
	 * @param url String The location of the image file.
	 */
	public void setImage(String url) {
		image = url;
	}
	
	/**
	 * Getter for the image of the enemy.
	 * @return image String The file location of the jpg.
	 */
	public String getImage() {
		return image;
	}

	
}
