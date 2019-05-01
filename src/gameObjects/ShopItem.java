package gameObjects;



import java.awt.Point;

import gameObjects.BigPotion;
import gameObjects.GameObject;
import gameObjects.Item;
import gameObjects.Sword;
import javafx.geometry.Point2D;

/**
 * @author Ben Bauer
 *
 */
public class ShopItem extends GameObject {

	private int item_num;
	private int price;
	private Item item;

	public ShopItem(Point pos, int itemNumber){
		super(pos);
		this.item_num = itemNumber;
		if(itemNumber == 1) {
			item = new Sword(null);
			price = item.getCost();
		}
		else if(itemNumber == 2) {
			item = new BigPotion(null);
			price = item.getCost();
		}
		else if (itemNumber == 3) {
			item = new Door(null);
		}
		
	}

	public int getItemNum() {
		return item_num;
	}

}