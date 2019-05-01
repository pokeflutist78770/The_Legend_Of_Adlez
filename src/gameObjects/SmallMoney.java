package gameObjects;

import java.awt.Point;

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
	public SmallMoney(Point position) {
		super(position);
		super.setAmount(5);
		this.setImage("assets/smallMoney.png");
	}

}
