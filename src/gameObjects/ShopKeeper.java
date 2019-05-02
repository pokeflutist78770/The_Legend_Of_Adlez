/**
 * 
 */
package gameObjects;

import java.awt.Point;

/**
 * @author Ben Bauer
 *
 */
public class ShopKeeper extends Item {

	/**
	 * @param position
	 */
	public ShopKeeper(Point position) {
		super(position);
		this.setImage("assets/shopKeeper.png");
	}

}
