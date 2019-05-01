package model;

import java.util.ArrayList;


import enums.MapScreen;
import gameObjects.GameObject;
import gameObjects.ShopItem;

import java.awt.Point;
import gameObjects.Enemy;
import gameObjects.Transition;

/**
 * Shop map class
 * @author Tito Vasquez
 *
 */

public class Shop extends GameMap {

	private static ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private static ArrayList<Transition> transitions = new ArrayList<Transition>();
	private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	
	/**
	 * Constructor for Shop mapscreen.
	 */
	public Shop() {
		super(objects, transitions, enemies, MapScreen.SHOP, "assets/itemShop.png");
		objects.add(new GameObject(new Point(3, 3)));
		objects.add(new GameObject(new Point(3, 4)));
		objects.add(new GameObject(new Point(3, 5)));
		objects.add(new GameObject(new Point(3, 6)));
		objects.add(new GameObject(new Point(3, 7)));
		objects.add(new GameObject(new Point(3, 8)));
		objects.add(new GameObject(new Point(3, 9)));
		objects.add(new GameObject(new Point(3, 10)));
		objects.add(new GameObject(new Point(3, 11)));
		objects.add(new GameObject(new Point(3, 12)));
		objects.add(new GameObject(new Point(3, 13)));
		objects.add(new GameObject(new Point(4, 3)));
		objects.add(new GameObject(new Point(4, 4)));
		objects.add(new GameObject(new Point(4, 5)));
		objects.add(new GameObject(new Point(4, 6)));
		objects.add(new GameObject(new Point(4, 8)));
		objects.add(new GameObject(new Point(4, 11)));
		objects.add(new GameObject(new Point(4, 12)));
		objects.add(new GameObject(new Point(4, 13)));
		objects.add(new GameObject(new Point(5, 3)));
		objects.add(new GameObject(new Point(5, 4)));
		objects.add(new GameObject(new Point(5, 5)));
		objects.add(new GameObject(new Point(5, 6)));
		objects.add(new ShopItem(new Point(5, 8),1));
		objects.add(new GameObject(new Point(5, 11)));
		objects.add(new GameObject(new Point(5, 12)));
		objects.add(new GameObject(new Point(5, 13)));
		objects.add(new GameObject(new Point(6, 3)));
		objects.add(new GameObject(new Point(6, 4)));
		objects.add(new GameObject(new Point(6, 5)));
		objects.add(new GameObject(new Point(6, 6)));
		objects.add(new GameObject(new Point(6, 11)));
		objects.add(new GameObject(new Point(6, 12)));
		objects.add(new GameObject(new Point(6, 13)));
		objects.add(new GameObject(new Point(7, 3)));
		objects.add(new GameObject(new Point(7, 4)));
		objects.add(new GameObject(new Point(7, 5)));
		objects.add(new GameObject(new Point(7, 6)));
		objects.add(new ShopItem(new Point(7, 8),2));
		objects.add(new GameObject(new Point(7, 11)));
		objects.add(new GameObject(new Point(7, 12)));
		objects.add(new GameObject(new Point(7, 13)));
		objects.add(new GameObject(new Point(8, 3)));
		objects.add(new GameObject(new Point(8, 4)));
		objects.add(new GameObject(new Point(8, 5)));
		objects.add(new GameObject(new Point(8, 6)));
		objects.add(new GameObject(new Point(8, 11)));
		objects.add(new GameObject(new Point(8, 12)));
		objects.add(new GameObject(new Point(8, 13)));
		objects.add(new GameObject(new Point(9, 3)));
		objects.add(new GameObject(new Point(9, 4)));
		objects.add(new GameObject(new Point(9, 5)));
		objects.add(new GameObject(new Point(9, 6)));
		objects.add(new GameObject(new Point(9, 7)));
		objects.add(new GameObject(new Point(9, 8)));
		objects.add(new GameObject(new Point(9, 11)));
		objects.add(new GameObject(new Point(9, 12)));
		objects.add(new GameObject(new Point(9, 13)));
		objects.add(new GameObject(new Point(10, 3)));
		objects.add(new GameObject(new Point(10, 4)));
		objects.add(new GameObject(new Point(10, 5)));
		objects.add(new GameObject(new Point(10, 6)));
		objects.add(new GameObject(new Point(10, 7)));
		objects.add(new GameObject(new Point(10, 8)));
		objects.add(new GameObject(new Point(10, 11)));
		objects.add(new GameObject(new Point(10, 12)));
		objects.add(new GameObject(new Point(10, 13)));
		objects.add(new GameObject(new Point(11, 3)));
		objects.add(new GameObject(new Point(11, 4)));
		objects.add(new GameObject(new Point(11, 5)));
		objects.add(new GameObject(new Point(11, 6)));
		objects.add(new GameObject(new Point(11, 8)));
		objects.add(new GameObject(new Point(12, 3)));
		objects.add(new GameObject(new Point(12, 4)));
		objects.add(new GameObject(new Point(12, 5)));
		objects.add(new GameObject(new Point(12, 6)));
		objects.add(new GameObject(new Point(12, 7)));
		objects.add(new GameObject(new Point(12, 8)));
		objects.add(new GameObject(new Point(12, 11)));
		objects.add(new GameObject(new Point(12, 12)));
		objects.add(new GameObject(new Point(12, 13)));
		objects.add(new GameObject(new Point(13, 3)));
		objects.add(new GameObject(new Point(13, 4)));
		objects.add(new GameObject(new Point(13, 5)));
		objects.add(new GameObject(new Point(13, 6)));
		objects.add(new GameObject(new Point(13, 7)));
		objects.add(new GameObject(new Point(13, 8)));
		objects.add(new GameObject(new Point(13, 9)));
		objects.add(new GameObject(new Point(13, 10)));
		objects.add(new GameObject(new Point(13, 11)));
		objects.add(new GameObject(new Point(13, 12)));
		objects.add(new GameObject(new Point(13, 13)));
		transitions.add(new Transition(new Point(11, 13), MapScreen.RIVER, new Point(5, 5)));
		setCloneObjects((ArrayList<GameObject>) objects.clone());
	}
	public void refresh() {
		objects = getCloneObjects();
	}

}
