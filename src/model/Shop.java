package model;

import java.util.ArrayList;


import enums.MapScreen;
import gameObjects.GameObject;
import javafx.geometry.Point2D;
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
		objects.add(new GameObject(new Point2D(3, 3)));
		objects.add(new GameObject(new Point2D(3, 4)));
		objects.add(new GameObject(new Point2D(3, 5)));
		objects.add(new GameObject(new Point2D(3, 6)));
		objects.add(new GameObject(new Point2D(3, 7)));
		objects.add(new GameObject(new Point2D(3, 8)));
		objects.add(new GameObject(new Point2D(3, 9)));
		objects.add(new GameObject(new Point2D(3, 10)));
		objects.add(new GameObject(new Point2D(3, 11)));
		objects.add(new GameObject(new Point2D(3, 12)));
		objects.add(new GameObject(new Point2D(3, 13)));
		objects.add(new GameObject(new Point2D(4, 3)));
		objects.add(new GameObject(new Point2D(4, 4)));
		objects.add(new GameObject(new Point2D(4, 5)));
		objects.add(new GameObject(new Point2D(4, 6)));
		objects.add(new GameObject(new Point2D(4, 8)));
		objects.add(new GameObject(new Point2D(4, 11)));
		objects.add(new GameObject(new Point2D(4, 12)));
		objects.add(new GameObject(new Point2D(4, 13)));
		objects.add(new GameObject(new Point2D(5, 3)));
		objects.add(new GameObject(new Point2D(5, 4)));
		objects.add(new GameObject(new Point2D(5, 5)));
		objects.add(new GameObject(new Point2D(5, 6)));
		objects.add(new GameObject(new Point2D(5, 8)));
		objects.add(new GameObject(new Point2D(5, 11)));
		objects.add(new GameObject(new Point2D(5, 12)));
		objects.add(new GameObject(new Point2D(5, 13)));
		objects.add(new GameObject(new Point2D(6, 3)));
		objects.add(new GameObject(new Point2D(6, 4)));
		objects.add(new GameObject(new Point2D(6, 5)));
		objects.add(new GameObject(new Point2D(6, 6)));
		objects.add(new GameObject(new Point2D(6, 11)));
		objects.add(new GameObject(new Point2D(6, 12)));
		objects.add(new GameObject(new Point2D(6, 13)));
		objects.add(new GameObject(new Point2D(7, 3)));
		objects.add(new GameObject(new Point2D(7, 4)));
		objects.add(new GameObject(new Point2D(7, 5)));
		objects.add(new GameObject(new Point2D(7, 6)));
		objects.add(new GameObject(new Point2D(7, 8)));
		objects.add(new GameObject(new Point2D(7, 11)));
		objects.add(new GameObject(new Point2D(7, 12)));
		objects.add(new GameObject(new Point2D(7, 13)));
		objects.add(new GameObject(new Point2D(8, 3)));
		objects.add(new GameObject(new Point2D(8, 4)));
		objects.add(new GameObject(new Point2D(8, 5)));
		objects.add(new GameObject(new Point2D(8, 6)));
		objects.add(new GameObject(new Point2D(8, 11)));
		objects.add(new GameObject(new Point2D(8, 12)));
		objects.add(new GameObject(new Point2D(8, 13)));
		objects.add(new GameObject(new Point2D(9, 3)));
		objects.add(new GameObject(new Point2D(9, 4)));
		objects.add(new GameObject(new Point2D(9, 5)));
		objects.add(new GameObject(new Point2D(9, 6)));
		objects.add(new GameObject(new Point2D(9, 7)));
		objects.add(new GameObject(new Point2D(9, 8)));
		objects.add(new GameObject(new Point2D(9, 11)));
		objects.add(new GameObject(new Point2D(9, 12)));
		objects.add(new GameObject(new Point2D(9, 13)));
		objects.add(new GameObject(new Point2D(10, 3)));
		objects.add(new GameObject(new Point2D(10, 4)));
		objects.add(new GameObject(new Point2D(10, 5)));
		objects.add(new GameObject(new Point2D(10, 6)));
		objects.add(new GameObject(new Point2D(10, 7)));
		objects.add(new GameObject(new Point2D(10, 8)));
		objects.add(new GameObject(new Point2D(10, 11)));
		objects.add(new GameObject(new Point2D(10, 12)));
		objects.add(new GameObject(new Point2D(10, 13)));
		objects.add(new GameObject(new Point2D(11, 3)));
		objects.add(new GameObject(new Point2D(11, 4)));
		objects.add(new GameObject(new Point2D(11, 5)));
		objects.add(new GameObject(new Point2D(11, 6)));
		objects.add(new GameObject(new Point2D(11, 8)));
		objects.add(new GameObject(new Point2D(12, 3)));
		objects.add(new GameObject(new Point2D(12, 4)));
		objects.add(new GameObject(new Point2D(12, 5)));
		objects.add(new GameObject(new Point2D(12, 6)));
		objects.add(new GameObject(new Point2D(12, 7)));
		objects.add(new GameObject(new Point2D(12, 8)));
		objects.add(new GameObject(new Point2D(12, 11)));
		objects.add(new GameObject(new Point2D(12, 12)));
		objects.add(new GameObject(new Point2D(12, 13)));
		objects.add(new GameObject(new Point2D(13, 3)));
		objects.add(new GameObject(new Point2D(13, 4)));
		objects.add(new GameObject(new Point2D(13, 5)));
		objects.add(new GameObject(new Point2D(13, 6)));
		objects.add(new GameObject(new Point2D(13, 7)));
		objects.add(new GameObject(new Point2D(13, 8)));
		objects.add(new GameObject(new Point2D(13, 9)));
		objects.add(new GameObject(new Point2D(13, 10)));
		objects.add(new GameObject(new Point2D(13, 11)));
		objects.add(new GameObject(new Point2D(13, 12)));
		objects.add(new GameObject(new Point2D(13, 13)));
		transitions.add(new Transition(new Point2D(11, 13), MapScreen.RIVER, new Point2D(5, 5)));
	}

}
