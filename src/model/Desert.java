package model;

import java.util.ArrayList;

import enums.MapScreen;
import gameObjects.GameObject;
import java.awt.Point;
import gameObjects.Enemy;
import gameObjects.Scorpion;
import gameObjects.Transition;


/**
 * Desert map.
 * @author Tito Vasquez
 *
 */
public class Desert extends GameMap {

	private static ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private static ArrayList<Transition> transitions = new ArrayList<Transition>();
	private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	/**
	 * Constructor for Desert map.
	 */
	public Desert() {
		super(objects, transitions, enemies, MapScreen.DESERT, "assets/desert.png");

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
		objects.add(new GameObject(new Point(1, 13)));
		objects.add(new GameObject(new Point(2, 13)));
		objects.add(new GameObject(new Point(3, 13)));
		objects.add(new GameObject(new Point(4, 13)));
		objects.add(new GameObject(new Point(5, 13)));
		objects.add(new GameObject(new Point(6, 13)));
		objects.add(new GameObject(new Point(7, 13)));
		objects.add(new GameObject(new Point(8, 13)));
		objects.add(new GameObject(new Point(9, 13)));
		objects.add(new GameObject(new Point(10, 13)));
		objects.add(new GameObject(new Point(13, 13)));
		objects.add(new GameObject(new Point(14, 13)));
		objects.add(new GameObject(new Point(15, 13)));
		objects.add(new GameObject(new Point(16, 13)));
		objects.add(new GameObject(new Point(17, 0)));
		objects.add(new GameObject(new Point(17, 1)));
		objects.add(new GameObject(new Point(17, 2)));
		objects.add(new GameObject(new Point(17, 3)));
		objects.add(new GameObject(new Point(17, 4)));
		objects.add(new GameObject(new Point(17, 5)));
		objects.add(new GameObject(new Point(17, 6)));
		objects.add(new GameObject(new Point(17, 7)));
		objects.add(new GameObject(new Point(17, 8)));
		objects.add(new GameObject(new Point(17, 9)));
		objects.add(new GameObject(new Point(17, 10)));
		objects.add(new GameObject(new Point(17, 11)));
		objects.add(new GameObject(new Point(17, 12)));
		objects.add(new GameObject(new Point(17, 13)));
		objects.add(new GameObject(new Point(1, 0)));
		objects.add(new GameObject(new Point(1, 1)));
		objects.add(new GameObject(new Point(1, 2)));
		objects.add(new GameObject(new Point(1, 3)));
		objects.add(new GameObject(new Point(1, 6)));
		objects.add(new GameObject(new Point(2, 0)));
		objects.add(new GameObject(new Point(2, 1)));
		objects.add(new GameObject(new Point(3, 0)));
		objects.add(new GameObject(new Point(3, 1)));
		objects.add(new GameObject(new Point(3, 7)));
		objects.add(new GameObject(new Point(4, 0)));
		objects.add(new GameObject(new Point(4, 1)));
		objects.add(new GameObject(new Point(4, 4)));
		objects.add(new GameObject(new Point(5, 0)));
		objects.add(new GameObject(new Point(5, 1)));
		objects.add(new GameObject(new Point(5, 9)));
		objects.add(new GameObject(new Point(5, 10)));
		objects.add(new GameObject(new Point(6, 0)));
		objects.add(new GameObject(new Point(6, 1)));
		objects.add(new GameObject(new Point(6, 2)));
		objects.add(new GameObject(new Point(6, 3)));
		objects.add(new GameObject(new Point(6, 4)));
		objects.add(new GameObject(new Point(7, 0)));
		objects.add(new GameObject(new Point(7, 1)));
		objects.add(new GameObject(new Point(7, 2)));
		objects.add(new GameObject(new Point(7, 3)));
		objects.add(new GameObject(new Point(7, 4)));
		objects.add(new GameObject(new Point(8, 0)));
		objects.add(new GameObject(new Point(8, 1)));
		objects.add(new GameObject(new Point(8, 2)));
		objects.add(new GameObject(new Point(9, 0)));
		objects.add(new GameObject(new Point(9, 1)));
		objects.add(new GameObject(new Point(9, 2)));
		objects.add(new GameObject(new Point(10, 0)));
		objects.add(new GameObject(new Point(10, 1)));
		objects.add(new GameObject(new Point(10, 2)));
		objects.add(new GameObject(new Point(10, 3)));
		objects.add(new GameObject(new Point(11, 0)));
		objects.add(new GameObject(new Point(11, 1)));
		objects.add(new GameObject(new Point(11, 2)));
		objects.add(new GameObject(new Point(11, 3)));
		objects.add(new GameObject(new Point(12, 0)));
		objects.add(new GameObject(new Point(12, 1)));
		objects.add(new GameObject(new Point(13, 0)));
		objects.add(new GameObject(new Point(13, 1)));
		objects.add(new GameObject(new Point(14, 0)));
		objects.add(new GameObject(new Point(15, 0)));
		objects.add(new GameObject(new Point(15, 1)));
		objects.add(new GameObject(new Point(15, 2)));
		objects.add(new GameObject(new Point(15, 4)));
		objects.add(new GameObject(new Point(15, 5)));
		objects.add(new GameObject(new Point(16, 0)));
		objects.add(new GameObject(new Point(16, 11)));
		enemies.add(new Scorpion(new Point(3, 3), 3));
		enemies.add(new Scorpion(new Point(9, 4), 0));
		enemies.add(new Scorpion(new Point(2, 6), 3));
		enemies.add(new Scorpion(new Point(14, 7), 1));
		transitions.add(new Transition(new Point(11, 13), MapScreen.HOME_UP, new Point(11, 0)));
		transitions.add(new Transition(new Point(12, 13), MapScreen.HOME_UP, new Point(12, 0)));
	}

}
