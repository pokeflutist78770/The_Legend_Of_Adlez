package Items;


public abstract class Item {
	protected static int COST;

	protected static String name;
	
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
