package gameObjects;

import java.awt.Point;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Money class for currency.
 * @author Tito Vasquez
 *
 */

public class Money extends GameObject {
	private int amount;
	private int index;
	
	
	/**
	 * Creates a Money objects that will be used for the player's currency.
	 * @param position Point2D The position on the map.
	 */
	public Money(Point position) {
		super(position);
	}

	/**
	 * Gets the amount of money that is assigned.
	 * @return amount int The amount of money.
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Sets the amount of money for this particular object.
	 * @param amount int The amount of money that this object will have.
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getIndex() {
		return index;
	}
	
	

}
