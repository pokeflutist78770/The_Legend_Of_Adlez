package model;

import java.util.ArrayList;

import enums.MapScreen;
import gameObjects.*;
import java.awt.Point;


/**
 * Mountain map class.
 * @author Tito Vasquez
 *
 */
public class Mountain extends GameMap {

	private static ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private static ArrayList<Transition> transitions = new ArrayList<Transition>();
	private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	/**
	 * Constructor for Mountain map screen.
	 */
	public Mountain() {
		super(objects, transitions, enemies, MapScreen.MOUNTAIN, "assets/mountain.png");
		objects.add(new GameObject(new Point(0, 0)));
		objects.add(new GameObject(new Point(0, 1)));
		objects.add(new GameObject(new Point(0, 2)));
		objects.add(new GameObject(new Point(0, 3)));
		objects.add(new GameObject(new Point(0, 4)));
		objects.add(new GameObject(new Point(0, 5)));
		objects.add(new GameObject(new Point(0, 6)));
		objects.add(new GameObject(new Point(0, 7)));
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
		objects.add(new GameObject(new Point(11, 13)));
		objects.add(new GameObject(new Point(12, 13)));
		objects.add(new GameObject(new Point(13, 13)));
		objects.add(new GameObject(new Point(14, 13)));
		objects.add(new GameObject(new Point(15, 13)));
		objects.add(new GameObject(new Point(16, 13)));
		objects.add(new GameObject(new Point(1, 0)));
		objects.add(new GameObject(new Point(2, 0)));
		objects.add(new GameObject(new Point(3, 0)));
		objects.add(new GameObject(new Point(4, 0)));
		objects.add(new GameObject(new Point(5, 0)));
		objects.add(new GameObject(new Point(6, 0)));
		objects.add(new GameObject(new Point(7, 0)));
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
		objects.add(new GameObject(new Point(1, 1)));
		objects.add(new GameObject(new Point(2, 1)));
		objects.add(new GameObject(new Point(3, 1)));
		objects.add(new GameObject(new Point(4, 1)));
		objects.add(new GameObject(new Point(5, 1)));
		objects.add(new GameObject(new Point(6, 1)));
		objects.add(new GameObject(new Point(7, 1)));
		objects.add(new GameObject(new Point(8, 1)));
		objects.add(new GameObject(new Point(10, 1)));
		objects.add(new GameObject(new Point(11, 1)));
		objects.add(new GameObject(new Point(12, 1)));
		objects.add(new GameObject(new Point(13, 1)));
		objects.add(new GameObject(new Point(14, 1)));
		objects.add(new GameObject(new Point(15, 1)));
		objects.add(new GameObject(new Point(16, 1)));
		objects.add(new GameObject(new Point(17, 1)));
		objects.add(new GameObject(new Point(2, 3)));
		objects.add(new GameObject(new Point(1, 10)));
		objects.add(new GameObject(new Point(1, 11)));
		objects.add(new GameObject(new Point(5, 13)));
		objects.add(new GameObject(new Point(10, 6)));
		objects.add(new GameObject(new Point(10, 7)));
		objects.add(new GameObject(new Point(11, 2)));
		objects.add(new GameObject(new Point(13, 2)));
		objects.add(new GameObject(new Point(14, 2)));
		objects.add(new GameObject(new Point(14, 13)));
		objects.add(new GameObject(new Point(15, 3)));
		objects.add(new GameObject(new Point(15, 8)));
		objects.add(new GameObject(new Point(15, 9)));
		objects.add(new GameObject(new Point(15, 10)));
		objects.add(new GameObject(new Point(16, 2)));
		objects.add(new GameObject(new Point(16, 6)));
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
    	enemies.add(new Scorpion(new Point(1, 2), 3));
		enemies.add(new Poe(new Point(6, 3), 1));
		enemies.add(new Scorpion(new Point(12, 5), 2));
		enemies.add(new Slime(new Point(6, 11), 1));
		transitions.add(new Transition(new Point(0, 8), MapScreen.RIVER, new Point(16, 8)));
		transitions.add(new Transition(new Point(0, 9), MapScreen.RIVER, new Point(16, 9)));
		transitions.add(new Transition(new Point(9, 1), MapScreen.DUNGEON1, new Point(9, 12)));
		setCloneObjects((ArrayList<GameObject>) objects.clone());
	}
	public void refresh() {
		objects = getCloneObjects();
	}

}