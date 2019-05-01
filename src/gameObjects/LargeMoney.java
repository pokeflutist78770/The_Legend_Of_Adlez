package gameObjects;

import javafx.geometry.Point2D;

/**
 * LargeMoney class that gives the user 40 currency.
 * @author Tito Vasquez
 *
 */
public class LargeMoney extends Money {

	/**
	 * Constructor for the lowest amount of money and assigns it to have 40 currency.
	 * @param position Point2D The position on the map.
	 */
	public LargeMoney(Point2D position) {
		super(position);
		super.setAmount(40);
		this.setImage("assets/largeMoney.png");
	}

}
