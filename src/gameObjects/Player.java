package gameObjects;

import java.util.ArrayList;
import java.util.List;

import enums.Direction;
import javafx.geometry.Point2D;

/**
 * Class for the playable main character.
 * @author Tito Vasquez
 *
 */
public class Player extends Creature {
	int currentMoney;
	int maxMoney;
	Item equippedItem;
	List<Item> inventory = new ArrayList<Item>();
	
	/**
	 * Alternate constructor for the PlayerClass with stats hardcoded.
	 * @param position int[] The position of the player character on the game board.
	 */
	public Player(Point2D position) {
		super(position);
		this.setTotalHP(20);
		this.setCurrentHP(20);
		this.setAttack(1);
		currentMoney = 0;
		maxMoney = 500;
		setDirection(Direction.SOUTH);
		setImage("assets/adlez1.png");
	}
	
	public void setEquippedItem(Item item) {
		equippedItem = item;
	}
	public Item getEquippedItem() {
		return equippedItem;
	}
	
	/**
	 * Setter for the player's current money amount.
	 */
	public void setCurrentMoney(int amount) {
		currentMoney = Math.min(maxMoney, amount);
	}
	/**
	 * Getter for the player's money.
	 * @return currentMoney int The current amount of money that the player is holding.
	 */
	public int getCurrentMoney() {
		return currentMoney;
	}

	public void addInventory(Item item) {
		inventory.add(item);
	}
	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}
	public List<Item> getInventory(){
		return inventory;
	}
}
