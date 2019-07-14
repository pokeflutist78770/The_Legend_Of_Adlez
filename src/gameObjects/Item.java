package gameObjects;
import java.awt.Point;


/**
 * Item abstract class. Serves as the base item class, where every item
 * has a cost and name attached to them.
 * @author Angel Aguayo
 *
 */
public abstract class Item extends GameObject {
	
	protected static int COST;
	
	protected static String name;
	
	
	/**
	 * Constructor for Item to be a GameObject
	 * @param position Point2D The position on the map.
	 */
	public Item(Point position) {
		super(position);
	}
	
	
	/**
	 * Gets the cost of the current item
	 * @return int representing how much the item costs
	 */
	public int getCost() {
		return COST;
	}
	
	
	/**
	 * Gets the name of the item. This is used to access the image 
	 * that correlates to the item
	 * @return String representing the name of the item
	 */
	public String getName() {
		return name;
	}
	
}
