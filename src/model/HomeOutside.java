package model;

import java.util.ArrayList;

import enums.MapScreen;
import gameObjects.GameObject;
import java.awt.Point;
import gameObjects.*;

/**
 * HomeOutside map class.
 * @author Tito Vasquez
 *
 */

public class HomeOutside extends GameMap {

	private static ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private static ArrayList<Transition> transitions = new ArrayList<Transition>();
	private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	
	/**
	 * Constructor for HomeOutside Map.
	 */
	public HomeOutside() {
		super(objects, transitions, enemies, MapScreen.HOME_OUTSIDE, "assets/homeOutside.png");
		objects.add(new GameObject(new Point(0, 0)));
		objects.add(new GameObject(new Point(0, 1)));
		objects.add(new GameObject(new Point(0, 2)));
		objects.add(new GameObject(new Point(0, 3)));
		objects.add(new GameObject(new Point(0, 4)));
		objects.add(new GameObject(new Point(0, 5)));
		objects.add(new GameObject(new Point(0, 6)));
		objects.add(new GameObject(new Point(0, 7)));
		objects.add(new GameObject(new Point(0, 8)));
		objects.add(new GameObject(new Point(0, 9)));
		objects.add(new GameObject(new Point(0, 10)));
		objects.add(new GameObject(new Point(0, 11)));
		objects.add(new GameObject(new Point(0, 12)));
		objects.add(new GameObject(new Point(0, 13)));
		objects.add(new GameObject(new Point(1, 0)));
		objects.add(new GameObject(new Point(1, 1)));
		objects.add(new GameObject(new Point(1, 2)));
		objects.add(new GameObject(new Point(1, 4)));
		objects.add(new GameObject(new Point(1, 5)));
		objects.add(new GameObject(new Point(1, 6)));
		objects.add(new GameObject(new Point(1, 7)));
		objects.add(new GameObject(new Point(1, 8)));
		objects.add(new GameObject(new Point(1, 9)));
		objects.add(new GameObject(new Point(1, 10)));
		objects.add(new GameObject(new Point(1, 11)));
		objects.add(new GameObject(new Point(1, 12)));
		objects.add(new GameObject(new Point(1, 13)));
		objects.add(new GameObject(new Point(2, 0)));
		objects.add(new GameObject(new Point(2, 1)));
		objects.add(new GameObject(new Point(2, 5)));
		objects.add(new GameObject(new Point(2, 6)));
		objects.add(new GameObject(new Point(3, 0)));
		objects.add(new GameObject(new Point(3, 1)));
		objects.add(new GameObject(new Point(3, 2)));
		objects.add(new GameObject(new Point(4, 0)));
		objects.add(new GameObject(new Point(4, 1)));
		objects.add(new GameObject(new Point(4, 2)));
		objects.add(new GameObject(new Point(5, 0)));
		objects.add(new GameObject(new Point(5, 1)));
		objects.add(new GameObject(new Point(5, 2)));
		objects.add(new GameObject(new Point(5, 9)));
		objects.add(new GameObject(new Point(12, 5)));
		objects.add(new GameObject(new Point(13, 4)));
		objects.add(new GameObject(new Point(14, 3)));
		objects.add(new GameObject(new Point(8, 0)));
		objects.add(new GameObject(new Point(9, 0)));
		objects.add(new GameObject(new Point(10, 0)));
		objects.add(new GameObject(new Point(11, 0)));
		objects.add(new GameObject(new Point(12, 0)));
		objects.add(new GameObject(new Point(13, 0)));
		objects.add(new GameObject(new Point(14, 0)));
		objects.add(new GameObject(new Point(15, 0)));
		objects.add(new GameObject(new Point(16, 0)));
		objects.add(new GameObject(new Point(17, 0)));
		objects.add(new GameObject(new Point(8, 1)));
		objects.add(new GameObject(new Point(9, 1)));
		objects.add(new GameObject(new Point(10, 1)));
		objects.add(new GameObject(new Point(11, 1)));
		objects.add(new GameObject(new Point(12, 1)));
		objects.add(new GameObject(new Point(13, 1)));
		objects.add(new GameObject(new Point(14, 1)));
		objects.add(new GameObject(new Point(15, 1)));
		objects.add(new GameObject(new Point(16, 1)));
		objects.add(new GameObject(new Point(17, 1)));
		objects.add(new GameObject(new Point(17, 2)));
		objects.add(new GameObject(new Point(17, 3)));
		objects.add(new GameObject(new Point(17, 4)));
		objects.add(new GameObject(new Point(17, 5)));
		objects.add(new GameObject(new Point(17, 6)));
		objects.add(new GameObject(new Point(17, 7)));
		objects.add(new GameObject(new Point(2, 13)));
		objects.add(new GameObject(new Point(3, 13)));
		objects.add(new GameObject(new Point(4, 13)));
		objects.add(new GameObject(new Point(5, 13)));
		objects.add(new GameObject(new Point(6, 13)));
		objects.add(new GameObject(new Point(7, 13)));
		objects.add(new GameObject(new Point(8, 13)));
		objects.add(new GameObject(new Point(9, 13)));
		objects.add(new GameObject(new Point(10, 13)));
		objects.add(new GameObject(new Point(11, 13)));
		objects.add(new GameObject(new Point(12, 13)));
		objects.add(new GameObject(new Point(13, 13)));
		objects.add(new GameObject(new Point(14, 13)));
		objects.add(new GameObject(new Point(15, 13)));
		objects.add(new GameObject(new Point(16, 13)));
		objects.add(new GameObject(new Point(17, 13)));
		transitions.add(new Transition(new Point(2, 2), MapScreen.HOME, new Point(7, 12)));
		transitions.add(new Transition(new Point(6, 0), MapScreen.HOME_UP, new Point(6, 12)));
		transitions.add(new Transition(new Point(7, 0), MapScreen.HOME_UP, new Point(7, 12)));
		transitions.add(new Transition(new Point(17, 8), MapScreen.RIVER, new Point(1, 8)));
		transitions.add(new Transition(new Point(17, 9), MapScreen.RIVER, new Point(1, 9)));
	}
}
