package gameObjects;

import java.awt.Point;

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
	public LargeMoney(Point position) {
		super(position);
		super.setAmount(40);
		this.setImage("assets/largeMoney.png");
	}

}
