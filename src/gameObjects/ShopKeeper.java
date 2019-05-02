/**
 * 
 */
package gameObjects;

import java.awt.Point;

/**
 * @author Ben Bauer
 *ShopKeeper class used to display shopKeeper in
 *shop
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
