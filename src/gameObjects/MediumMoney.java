package gameObjects;

import javafx.geometry.Point2D;

/**
 * MediumMoney class that gives the user 15 currency.
 * @author Tito Vasquez
 *
 */
public class MediumMoney extends Money {

	/**
	 * Constructor for the lowest amount of money and assigns it to have 15 currency.
	 * @param position Point2D The position on the map.
	 */
	public MediumMoney(Point2D position) {
		super(position);
		super.setAmount(15);
		this.setImage("assets/mediumMoney.png");
	}

}
