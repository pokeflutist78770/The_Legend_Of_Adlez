/**
 * Object for any "character" that can appear on the map.
 * @author Tito Vasquez
 *
 */
public class CharacterClass extends GameObjectClass {
	private int currentHP;
	private int totalHP;
	private int attack;
	private int[] position;
	
	/**
	 * Sets all the values that a possible character can have.
	 * @param currentHP int The amount of HP the character has.
	 * @param attack int The attack power of the character.
	 * @param position int[] An array of length 2 that gives the x and y coordinate of the character's
	 * position on the overworld.
	 */
	public CharacterClass(int currentHP, int totalHP, int attack, int[] position) {
		this.currentHP = currentHP;
		this.totalHP = totalHP;
		this.attack = attack;
		this.position = position.clone();
	}
	
	/**
	 * Alternate constructor mainly used for the EnemyClass
	 * @param position int[] The current position of the character on the game map.
	 */
	public CharacterClass(int[] position) {
		this.position = position.clone();
	}
	
	/**
	 * Reduces the HP of the character by a given amount.
	 * @param n int The number of HP to reduce.
	 */
	public void decrementHP(int n) {
		currentHP -= n;
		if (currentHP < 0) {
			currentHP = 0;
		}
	}
	
	/**
	 * Increases the HP of the character by a given amount.
	 * @param n int The number of HP to increase.
	 */
	public void incrementHP(int n) {
		currentHP += n;
		if (currentHP > totalHP) {
			currentHP = totalHP;
		}
	}
	
	/**
	 * Setter for the character's HP
	 * @param hp int The HP of the character.
	 */
	public void setHP(int hp) {
		this.currentHP = hp;
	}
	
	/**
	 * Setter for the character's attack.
	 * @param attack int The attack power of the character.
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	/**
	 * Setter for the character's position.
	 * @param position int[] The x and y coordinate in an array of length 2.
	 */
	public void setPosition(int[] position) {
		this.position = position.clone();
	}
	
	/**
	 * Getter for character's HP.
	 * @return currentHP int The character's current HP.
	 */
	public int getcurrentHP() {
		return currentHP;
	}
	
	/**
	 * Getter for character's total HP.
	 * @return totalHP int The character's total HP.
	 */
	public int getTotalHP() {
		return totalHP;
	}
	
	/**
	 * Getter for character's attack power.
	 * @return attack int The character's current attack power.
	 */
	public int getAttack() {
		return attack;
	}
	
	/**
	 * Getter for the character's position on the overworld map.
	 * @return position int[] Array of length 2 with x and y coordinate.
	 */
	public int[] getPosition() {
		return position;
	}
}
