package model;

import java.util.ArrayList;

import enums.MapScreen;
import gameObjects.*;
import javafx.geometry.Point2D;


/**
 * Mountain map class.
 * @author Tito Vasquez
 *
 */
public class Mountain extends GameMap {

	private static ArrayList<GameObject> objects = new ArrayList<GameObject>();
//	private static ArrayList<Transition> transitions = new ArrayList<Transition>();
	private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	/**
	 * Constructor for Mountain map screen.
	 */
	public Mountain() {
		super(objects, enemies, MapScreen.MOUNTAIN, "assets/mountain.png");
		objects.add(new GameObject(new Point2D(0, 0)));
		objects.add(new GameObject(new Point2D(0, 1)));
		objects.add(new GameObject(new Point2D(0, 2)));
		objects.add(new GameObject(new Point2D(0, 3)));
		objects.add(new GameObject(new Point2D(0, 4)));
		objects.add(new GameObject(new Point2D(0, 5)));
		objects.add(new GameObject(new Point2D(0, 6)));
		objects.add(new GameObject(new Point2D(0, 7)));
		objects.add(new GameObject(new Point2D(0, 10)));
		objects.add(new GameObject(new Point2D(0, 11)));
		objects.add(new GameObject(new Point2D(0, 12)));
		objects.add(new GameObject(new Point2D(0, 13)));
		objects.add(new GameObject(new Point2D(1, 13)));
		objects.add(new GameObject(new Point2D(2, 13)));
		objects.add(new GameObject(new Point2D(3, 13)));
		objects.add(new GameObject(new Point2D(4, 13)));
		objects.add(new GameObject(new Point2D(5, 13)));
		objects.add(new GameObject(new Point2D(6, 13)));
		objects.add(new GameObject(new Point2D(7, 13)));
		objects.add(new GameObject(new Point2D(8, 13)));
		objects.add(new GameObject(new Point2D(9, 13)));
		objects.add(new GameObject(new Point2D(10, 13)));
		objects.add(new GameObject(new Point2D(11, 13)));
		objects.add(new GameObject(new Point2D(12, 13)));
		objects.add(new GameObject(new Point2D(13, 13)));
		objects.add(new GameObject(new Point2D(14, 13)));
		objects.add(new GameObject(new Point2D(15, 13)));
		objects.add(new GameObject(new Point2D(16, 13)));
		objects.add(new GameObject(new Point2D(1, 0)));
		objects.add(new GameObject(new Point2D(2, 0)));
		objects.add(new GameObject(new Point2D(3, 0)));
		objects.add(new GameObject(new Point2D(4, 0)));
		objects.add(new GameObject(new Point2D(5, 0)));
		objects.add(new GameObject(new Point2D(6, 0)));
		objects.add(new GameObject(new Point2D(7, 0)));
		objects.add(new GameObject(new Point2D(8, 0)));
		objects.add(new GameObject(new Point2D(9, 0)));
		objects.add(new GameObject(new Point2D(10, 0)));
		objects.add(new GameObject(new Point2D(11, 0)));
		objects.add(new GameObject(new Point2D(12, 0)));
		objects.add(new GameObject(new Point2D(13, 0)));
		objects.add(new GameObject(new Point2D(14, 0)));
		objects.add(new GameObject(new Point2D(15, 0)));
		objects.add(new GameObject(new Point2D(16, 0)));
		objects.add(new GameObject(new Point2D(17, 0)));
		objects.add(new GameObject(new Point2D(1, 1)));
		objects.add(new GameObject(new Point2D(2, 1)));
		objects.add(new GameObject(new Point2D(3, 1)));
		objects.add(new GameObject(new Point2D(4, 1)));
		objects.add(new GameObject(new Point2D(5, 1)));
		objects.add(new GameObject(new Point2D(6, 1)));
		objects.add(new GameObject(new Point2D(7, 1)));
		objects.add(new GameObject(new Point2D(8, 1)));
		objects.add(new GameObject(new Point2D(10, 1)));
		objects.add(new GameObject(new Point2D(11, 1)));
		objects.add(new GameObject(new Point2D(12, 1)));
		objects.add(new GameObject(new Point2D(13, 1)));
		objects.add(new GameObject(new Point2D(14, 1)));
		objects.add(new GameObject(new Point2D(15, 1)));
		objects.add(new GameObject(new Point2D(16, 1)));
		objects.add(new GameObject(new Point2D(17, 1)));
		objects.add(new GameObject(new Point2D(2, 3)));
		objects.add(new GameObject(new Point2D(1, 10)));
		objects.add(new GameObject(new Point2D(1, 11)));
		objects.add(new GameObject(new Point2D(5, 13)));
		objects.add(new GameObject(new Point2D(10, 6)));
		objects.add(new GameObject(new Point2D(10, 7)));
		objects.add(new GameObject(new Point2D(11, 2)));
		objects.add(new GameObject(new Point2D(13, 2)));
		objects.add(new GameObject(new Point2D(14, 2)));
		objects.add(new GameObject(new Point2D(14, 13)));
		objects.add(new GameObject(new Point2D(15, 3)));
		objects.add(new GameObject(new Point2D(15, 8)));
		objects.add(new GameObject(new Point2D(15, 9)));
		objects.add(new GameObject(new Point2D(15, 10)));
		objects.add(new GameObject(new Point2D(16, 2)));
		objects.add(new GameObject(new Point2D(16, 6)));
		objects.add(new GameObject(new Point2D(17, 2)));
		objects.add(new GameObject(new Point2D(17, 3)));
		objects.add(new GameObject(new Point2D(17, 4)));
		objects.add(new GameObject(new Point2D(17, 5)));
		objects.add(new GameObject(new Point2D(17, 6)));
		objects.add(new GameObject(new Point2D(17, 7)));
		objects.add(new GameObject(new Point2D(17, 8)));
		objects.add(new GameObject(new Point2D(17, 9)));
		objects.add(new GameObject(new Point2D(17, 10)));
		objects.add(new GameObject(new Point2D(17, 11)));
		objects.add(new GameObject(new Point2D(17, 12)));
		objects.add(new GameObject(new Point2D(17, 13)));
    	enemies.add(new Scorpion(new Point2D(1, 2), 3));
//		enemies.add(new Poe(new Point2D(6, 3), 1));
		enemies.add(new Scorpion(new Point2D(12, 5), 2));
//		enemies.add(new Slime(new Point2D(6, 11), 1));
//		transitions.add(new Transition(new Point2D(0, 8), new River(), new Point2D(16, 8)));
//		transitions.add(new Transition(new Point2D(0, 9), new River(), new Point2D(16, 9)));
//		transitions.add(new Transition(new Point2D(9, 1), new Dungeon1(), new Point2D(9, 12)));
	}

}