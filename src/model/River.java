package model;

import java.util.ArrayList;

import enums.MapScreen;

import gameObjects.GameObject;
import java.awt.Point;
import gameObjects.Enemy;
import gameObjects.Transition;


/**
 * River map class.
 * @author Tito Vasquez
 *
 */
public class River extends GameMap {

	private static ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private static ArrayList<Transition> transitions = new ArrayList<Transition>();
	private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private static Point spawn = new Point(3, 6);

	
	/**
	 * Constructor for River map
	 */
	public River() {
		super(objects, transitions, enemies, MapScreen.RIVER, "assets/river.png", spawn);
		objects.add(new GameObject(new Point(0, 0)));
		objects.add(new GameObject(new Point(0, 1)));
		objects.add(new GameObject(new Point(0, 2)));
		objects.add(new GameObject(new Point(0, 3)));
		objects.add(new GameObject(new Point(1, 0)));
		objects.add(new GameObject(new Point(1, 1)));
		objects.add(new GameObject(new Point(1, 2)));
		objects.add(new GameObject(new Point(1, 3)));
		objects.add(new GameObject(new Point(1, 4)));
		objects.add(new GameObject(new Point(2, 0)));
		objects.add(new GameObject(new Point(2, 1)));
		objects.add(new GameObject(new Point(2, 2)));
		objects.add(new GameObject(new Point(2, 3)));
		objects.add(new GameObject(new Point(2, 4)));
		objects.add(new GameObject(new Point(2, 6)));
		objects.add(new GameObject(new Point(3, 0)));
		objects.add(new GameObject(new Point(3, 1)));
		objects.add(new GameObject(new Point(3, 2)));
		objects.add(new GameObject(new Point(3, 3)));
		objects.add(new GameObject(new Point(3, 4)));
		objects.add(new GameObject(new Point(3, 13)));
		objects.add(new GameObject(new Point(4, 0)));
		objects.add(new GameObject(new Point(4, 1)));
		objects.add(new GameObject(new Point(4, 2)));
		objects.add(new GameObject(new Point(4, 3)));
		objects.add(new GameObject(new Point(4, 4)));
		objects.add(new GameObject(new Point(4, 12)));
		objects.add(new GameObject(new Point(4, 13)));
		objects.add(new GameObject(new Point(5, 0)));
		objects.add(new GameObject(new Point(5, 1)));
		objects.add(new GameObject(new Point(5, 2)));
		objects.add(new GameObject(new Point(5, 11)));
		objects.add(new GameObject(new Point(5, 12)));
		objects.add(new GameObject(new Point(5, 13)));
		objects.add(new GameObject(new Point(6, 0)));
		objects.add(new GameObject(new Point(6, 1)));
		objects.add(new GameObject(new Point(6, 2)));
		objects.add(new GameObject(new Point(6, 3)));
		objects.add(new GameObject(new Point(6, 4)));
		objects.add(new GameObject(new Point(6, 10)));
		objects.add(new GameObject(new Point(6, 11)));
		objects.add(new GameObject(new Point(6, 12)));
		objects.add(new GameObject(new Point(6, 13)));
		objects.add(new GameObject(new Point(7, 0)));
		objects.add(new GameObject(new Point(7, 1)));
		objects.add(new GameObject(new Point(7, 2)));
		objects.add(new GameObject(new Point(7, 3)));
		objects.add(new GameObject(new Point(7, 4)));
		objects.add(new GameObject(new Point(7, 7)));
		objects.add(new GameObject(new Point(7, 10)));
		objects.add(new GameObject(new Point(7, 11)));
		objects.add(new GameObject(new Point(7, 12)));
		objects.add(new GameObject(new Point(7, 13)));
		objects.add(new GameObject(new Point(8, 0)));
		objects.add(new GameObject(new Point(8, 1)));
		objects.add(new GameObject(new Point(8, 2)));
		objects.add(new GameObject(new Point(8, 3)));
		objects.add(new GameObject(new Point(8, 4)));
		objects.add(new GameObject(new Point(8, 5)));
		objects.add(new GameObject(new Point(8, 6)));
		objects.add(new GameObject(new Point(8, 7)));
		objects.add(new GameObject(new Point(8, 10)));
		objects.add(new GameObject(new Point(8, 11)));
		objects.add(new GameObject(new Point(8, 12)));
		objects.add(new GameObject(new Point(8, 13)));
		objects.add(new GameObject(new Point(9, 0)));
		objects.add(new GameObject(new Point(9, 1)));
		objects.add(new GameObject(new Point(9, 2)));
		objects.add(new GameObject(new Point(9, 3)));
		objects.add(new GameObject(new Point(9, 4)));
		objects.add(new GameObject(new Point(9, 5)));
		objects.add(new GameObject(new Point(9, 6)));
		objects.add(new GameObject(new Point(9, 7)));
		objects.add(new GameObject(new Point(9, 10)));
		objects.add(new GameObject(new Point(9, 11)));
		objects.add(new GameObject(new Point(9, 12)));
		objects.add(new GameObject(new Point(9, 13)));
		objects.add(new GameObject(new Point(10, 0)));
		objects.add(new GameObject(new Point(10, 1)));
		objects.add(new GameObject(new Point(10, 2)));
		objects.add(new GameObject(new Point(10, 3)));
		objects.add(new GameObject(new Point(10, 4)));
		objects.add(new GameObject(new Point(10, 5)));
		objects.add(new GameObject(new Point(10, 6)));
		objects.add(new GameObject(new Point(10, 7)));
		objects.add(new GameObject(new Point(10, 10)));
		objects.add(new GameObject(new Point(10, 11)));
		objects.add(new GameObject(new Point(10, 12)));
		objects.add(new GameObject(new Point(11, 0)));
		objects.add(new GameObject(new Point(11, 1)));
		objects.add(new GameObject(new Point(11, 2)));
		objects.add(new GameObject(new Point(11, 3)));
		objects.add(new GameObject(new Point(11, 4)));
		objects.add(new GameObject(new Point(11, 5)));
		objects.add(new GameObject(new Point(11, 6)));
		objects.add(new GameObject(new Point(11, 7)));
		objects.add(new GameObject(new Point(11, 10)));
		objects.add(new GameObject(new Point(12, 0)));
		objects.add(new GameObject(new Point(12, 1)));
		objects.add(new GameObject(new Point(12, 2)));
		objects.add(new GameObject(new Point(12, 3)));
		objects.add(new GameObject(new Point(12, 4)));
		objects.add(new GameObject(new Point(12, 5)));
		objects.add(new GameObject(new Point(12, 6)));
		objects.add(new GameObject(new Point(12, 7)));
		objects.add(new GameObject(new Point(12, 11)));
		objects.add(new GameObject(new Point(13, 0)));
		objects.add(new GameObject(new Point(13, 1)));
		objects.add(new GameObject(new Point(13, 2)));
		objects.add(new GameObject(new Point(13, 3)));
		objects.add(new GameObject(new Point(13, 4)));
		objects.add(new GameObject(new Point(13, 5)));
		objects.add(new GameObject(new Point(13, 6)));
		objects.add(new GameObject(new Point(13, 13)));
		objects.add(new GameObject(new Point(14, 0)));
		objects.add(new GameObject(new Point(14, 1)));
		objects.add(new GameObject(new Point(14, 2)));
		objects.add(new GameObject(new Point(14, 3)));
		objects.add(new GameObject(new Point(14, 4)));
		objects.add(new GameObject(new Point(14, 5)));
		objects.add(new GameObject(new Point(14, 7)));
		objects.add(new GameObject(new Point(15, 0)));
		objects.add(new GameObject(new Point(15, 1)));
		objects.add(new GameObject(new Point(15, 2)));
		objects.add(new GameObject(new Point(15, 3)));
		objects.add(new GameObject(new Point(15, 13)));
		objects.add(new GameObject(new Point(16, 0)));
		objects.add(new GameObject(new Point(16, 1)));
		objects.add(new GameObject(new Point(16, 5)));
		objects.add(new GameObject(new Point(16, 11)));
		objects.add(new GameObject(new Point(17, 0)));
		objects.add(new GameObject(new Point(17, 1)));
		objects.add(new GameObject(new Point(17, 2)));
		objects.add(new GameObject(new Point(17, 3)));
		objects.add(new GameObject(new Point(17, 4)));
		objects.add(new GameObject(new Point(17, 5)));
		objects.add(new GameObject(new Point(17, 6)));
		objects.add(new GameObject(new Point(17, 7)));
		objects.add(new GameObject(new Point(17, 10)));
		objects.add(new GameObject(new Point(17, 11)));
		objects.add(new GameObject(new Point(17, 12)));
		objects.add(new GameObject(new Point(17, 13)));
		transitions.add(new Transition(new Point(-1, 8), MapScreen.HOME_OUTSIDE, new Point(17, 8)));
		transitions.add(new Transition(new Point(-1, 9), MapScreen.HOME_OUTSIDE, new Point(17, 9)));
		transitions.add(new Transition(new Point(5, 3), MapScreen.SHOP, new Point(11, 13)));
		transitions.add(new Transition(new Point(18, 8), MapScreen.MOUNTAIN, new Point(0, 8)));
		transitions.add(new Transition(new Point(18, 9), MapScreen.MOUNTAIN, new Point(0, 9)));
		setCloneObjects((ArrayList<GameObject>) objects.clone());
	}
	public void refresh() {
		objects = getCloneObjects();
	}
}
