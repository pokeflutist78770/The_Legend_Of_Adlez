package gameObjects;

import javafx.geometry.Point2D;

/**
 * SmallMoney class that gives the user 5 currency.
 * @author Tito Vasquez
 *
 */
public class SmallMoney extends Money {

	/**
	 * Constructor for the lowest amount of money and assigns it to have 5 currency.
	 * @param position Point2D The position on the map.
	 */
	public SmallMoney(Point2D position) {
		super(position);
		super.setAmount(5);
		this.setImage("assets/smallMoney.png");
	}

}
