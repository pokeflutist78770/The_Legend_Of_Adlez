package model;

import java.util.ArrayList;

import enums.MapScreen;
import gameObjects.GameObject;
import java.awt.Point;
import gameObjects.Enemy;
import gameObjects.Transition;


/**
 * Dungeon3 map class.
 * @author Tito Vasquez
 *
 */
public class Dungeon3 extends GameMap {

	private static ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private static ArrayList<Transition> transitions = new ArrayList<Transition>();
	private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private static Point spawn = new Point(10, 7);

	
	/**
	 * Constructor for Dungeon3 map.
	 */
	public Dungeon3() {
		super(objects, transitions, enemies, MapScreen.DUNGEON3, "assets/endRoom.png", spawn);
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
		objects.add(new GameObject(new Point(1, 13)));
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
		objects.add(new GameObject(new Point(1, 12)));
		objects.add(new GameObject(new Point(3, 12)));
		objects.add(new GameObject(new Point(4, 12)));
		objects.add(new GameObject(new Point(5, 12)));
		objects.add(new GameObject(new Point(6, 12)));
		objects.add(new GameObject(new Point(7, 12)));
		objects.add(new GameObject(new Point(8, 12)));
		objects.add(new GameObject(new Point(9, 12)));
		objects.add(new GameObject(new Point(10, 12)));
		objects.add(new GameObject(new Point(11, 12)));
		objects.add(new GameObject(new Point(12, 12)));
		objects.add(new GameObject(new Point(13, 12)));
		//objects.add(new GameObject(new Point(14, 12)));
		objects.add(new GameObject(new Point(15, 12)));
		objects.add(new GameObject(new Point(16, 12)));
		objects.add(new GameObject(new Point(1, 2)));
		objects.add(new GameObject(new Point(1, 3)));
		objects.add(new GameObject(new Point(1, 4)));
		objects.add(new GameObject(new Point(1, 5)));
		objects.add(new GameObject(new Point(1, 6)));
		objects.add(new GameObject(new Point(1, 7)));
		objects.add(new GameObject(new Point(1, 8)));
		objects.add(new GameObject(new Point(1, 9)));
		objects.add(new GameObject(new Point(2, 2)));
		objects.add(new GameObject(new Point(2, 3)));
		objects.add(new GameObject(new Point(2, 4)));
		objects.add(new GameObject(new Point(2, 5)));
		objects.add(new GameObject(new Point(2, 6)));
		objects.add(new GameObject(new Point(2, 7)));
		objects.add(new GameObject(new Point(2, 8)));
		objects.add(new GameObject(new Point(2, 9)));
		objects.add(new GameObject(new Point(3, 2)));
		objects.add(new GameObject(new Point(3, 3)));
		objects.add(new GameObject(new Point(3, 4)));
		objects.add(new GameObject(new Point(3, 5)));
		objects.add(new GameObject(new Point(3, 6)));
		objects.add(new GameObject(new Point(3, 7)));
		objects.add(new GameObject(new Point(3, 8)));
		objects.add(new GameObject(new Point(3, 9)));
		objects.add(new GameObject(new Point(4, 2)));
		objects.add(new GameObject(new Point(4, 3)));
		objects.add(new GameObject(new Point(4, 4)));
		objects.add(new GameObject(new Point(4, 5)));
		objects.add(new GameObject(new Point(4, 6)));
		objects.add(new GameObject(new Point(4, 7)));
		objects.add(new GameObject(new Point(4, 8)));
		objects.add(new GameObject(new Point(4, 9)));
		objects.add(new GameObject(new Point(5, 2)));
		objects.add(new GameObject(new Point(5, 3)));
		objects.add(new GameObject(new Point(5, 4)));
		objects.add(new GameObject(new Point(5, 5)));
		objects.add(new GameObject(new Point(5, 6)));
		objects.add(new GameObject(new Point(5, 7)));
		objects.add(new GameObject(new Point(5, 8)));
		objects.add(new GameObject(new Point(5, 9)));
		objects.add(new GameObject(new Point(6, 4)));
		objects.add(new GameObject(new Point(6, 5)));
		objects.add(new GameObject(new Point(6, 6)));
		objects.add(new GameObject(new Point(6, 7)));
		objects.add(new GameObject(new Point(6, 8)));
		objects.add(new GameObject(new Point(6, 9)));
		objects.add(new GameObject(new Point(8, 2)));
		objects.add(new GameObject(new Point(8, 3)));
		objects.add(new GameObject(new Point(9, 2)));
		objects.add(new GameObject(new Point(10, 2)));
		objects.add(new GameObject(new Point(10, 3)));
		objects.add(new GameObject(new Point(12, 4)));
		objects.add(new GameObject(new Point(12, 5)));
		objects.add(new GameObject(new Point(13, 2)));
		objects.add(new GameObject(new Point(13, 3)));
		objects.add(new GameObject(new Point(13, 4)));
		objects.add(new GameObject(new Point(13, 5)));
		objects.add(new GameObject(new Point(13, 6)));
		objects.add(new GameObject(new Point(13, 7)));
		objects.add(new GameObject(new Point(13, 8)));
		objects.add(new GameObject(new Point(13, 9)));
		objects.add(new GameObject(new Point(14, 2)));
		objects.add(new GameObject(new Point(14, 3)));
		objects.add(new GameObject(new Point(14, 4)));
		objects.add(new GameObject(new Point(14, 5)));
		objects.add(new GameObject(new Point(14, 6)));
		objects.add(new GameObject(new Point(14, 7)));
		objects.add(new GameObject(new Point(14, 8)));
		objects.add(new GameObject(new Point(14, 9)));
		objects.add(new GameObject(new Point(15, 2)));
		objects.add(new GameObject(new Point(15, 3)));
		objects.add(new GameObject(new Point(15, 4)));
		objects.add(new GameObject(new Point(15, 5)));
		objects.add(new GameObject(new Point(15, 6)));
		objects.add(new GameObject(new Point(15, 7)));
		objects.add(new GameObject(new Point(15, 8)));
		objects.add(new GameObject(new Point(15, 9)));
		objects.add(new GameObject(new Point(16, 2)));
		objects.add(new GameObject(new Point(16, 3)));
		objects.add(new GameObject(new Point(16, 4)));
		objects.add(new GameObject(new Point(16, 5)));
		objects.add(new GameObject(new Point(16, 6)));
		objects.add(new GameObject(new Point(16, 7)));
		objects.add(new GameObject(new Point(16, 8)));
		objects.add(new GameObject(new Point(16, 9)));
		transitions.add(new Transition(new Point(2, 14), MapScreen.DUNGEON2, new Point(2, 2)));
		setCloneObjects((ArrayList<GameObject>) objects.clone());
	}
	public void refresh() {
		objects = getCloneObjects();
	}
	

}
