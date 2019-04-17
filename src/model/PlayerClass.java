package model;

/**
 * Class for the playable main character.
 * @author Tito Vasquez
 *
 */
public class PlayerClass extends CharacterClass {
	String image; 
	int currentMoney;
	int maxMoney;
	
	/**
	 * Constructor for the PlayerClass object.
	 * @param currentHP int The currentHP of the player.
	 * @param totalHP int The totalHP of the player.
	 * @param attack int The attack power of the player.
	 * @param position int[] The current position of the player.
	 */
	public PlayerClass(int currentHP, int totalHP, int attack, int[] position) {
		super(currentHP, totalHP, attack, position);
		currentMoney = 0;
		maxMoney = 500;
	}
	
	/**
	 * Alternate constructor for the PlayerClass with stats hardcoded.
	 * @param position int[] The position of the player character on the game board.
	 */
	public PlayerClass(int[] position) {
		super(position);
		this.setHP(20);
		this.setAttack(1);
		this.image = (null);
		currentMoney = 0;
		maxMoney = 500;
	}
	
	/**
	 * Setter for the player's current money amount.
	 */
	public void setCurrentMoney(int amount) {
		currentMoney = amount;
		if (currentMoney > maxMoney) {
			currentMoney = maxMoney;
		}
	}
	
	/**
	 * Getter for the player's money.
	 * @return currentMoney int The current amount of money that the player is holding.
	 */
	public int getCurrentMoney() {
		return currentMoney;
	}
	
	

}
