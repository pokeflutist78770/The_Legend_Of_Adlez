package model;

import java.util.ArrayList;

import enums.MapScreen;
import gameObjects.GameObject;
import javafx.geometry.Point2D;
import gameObjects.Enemy;
import gameObjects.FinalBoss;
import gameObjects.Transition;

/**
 * Dungeon2Open map.
 * @author Tito Vasquez
 *
 */
public class Dungeon2Open extends GameMap {

	private static ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private static ArrayList<Transition> transitions = new ArrayList<Transition>();
	private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	/**
	 * Constructor for Dungeon2Open map.
	 */
	public Dungeon2Open() {
		super(objects, transitions, enemies, MapScreen.DUNGEON2, "assets/bossRoomOpen.png");
		objects.add(new GameObject(new Point2D(0, 0)));
		objects.add(new GameObject(new Point2D(0, 1)));
		objects.add(new GameObject(new Point2D(0, 2)));
		objects.add(new GameObject(new Point2D(0, 3)));
		objects.add(new GameObject(new Point2D(0, 4)));
		objects.add(new GameObject(new Point2D(0, 5)));
		objects.add(new GameObject(new Point2D(0, 6)));
		objects.add(new GameObject(new Point2D(0, 7)));
		objects.add(new GameObject(new Point2D(0, 8)));
		objects.add(new GameObject(new Point2D(0, 9)));
		objects.add(new GameObject(new Point2D(0, 10)));
		objects.add(new GameObject(new Point2D(0, 11)));
		objects.add(new GameObject(new Point2D(0, 12)));
		objects.add(new GameObject(new Point2D(0, 13)));
		objects.add(new GameObject(new Point2D(17, 0)));
		objects.add(new GameObject(new Point2D(17, 1)));
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
		objects.add(new GameObject(new Point2D(1, 1)));
		objects.add(new GameObject(new Point2D(3, 1)));
		objects.add(new GameObject(new Point2D(4, 1)));
		objects.add(new GameObject(new Point2D(5, 1)));
		objects.add(new GameObject(new Point2D(6, 1)));
		objects.add(new GameObject(new Point2D(7, 1)));
		objects.add(new GameObject(new Point2D(8, 1)));
		objects.add(new GameObject(new Point2D(9, 1)));
		objects.add(new GameObject(new Point2D(10, 1)));
		objects.add(new GameObject(new Point2D(11, 1)));
		objects.add(new GameObject(new Point2D(12, 1)));
		objects.add(new GameObject(new Point2D(13, 1)));
		objects.add(new GameObject(new Point2D(14, 1)));
		objects.add(new GameObject(new Point2D(15, 1)));
		objects.add(new GameObject(new Point2D(16, 1)));
		objects.add(new GameObject(new Point2D(1, 2)));
		objects.add(new GameObject(new Point2D(3, 2)));
		objects.add(new GameObject(new Point2D(4, 2)));
		objects.add(new GameObject(new Point2D(5, 2)));
		objects.add(new GameObject(new Point2D(6, 2)));
		objects.add(new GameObject(new Point2D(7, 2)));
		objects.add(new GameObject(new Point2D(8, 2)));
		objects.add(new GameObject(new Point2D(9, 2)));
		objects.add(new GameObject(new Point2D(10, 2)));
		objects.add(new GameObject(new Point2D(11, 2)));
		objects.add(new GameObject(new Point2D(12, 2)));
		objects.add(new GameObject(new Point2D(13, 2)));
		objects.add(new GameObject(new Point2D(14, 2)));
		objects.add(new GameObject(new Point2D(15, 2)));
		objects.add(new GameObject(new Point2D(16, 2)));
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
		objects.add(new GameObject(new Point2D(15, 13)));
		objects.add(new GameObject(new Point2D(16, 13)));
		objects.add(new GameObject(new Point2D(1, 12)));
		objects.add(new GameObject(new Point2D(2, 12)));
		objects.add(new GameObject(new Point2D(3, 12)));
		objects.add(new GameObject(new Point2D(4, 12)));
		objects.add(new GameObject(new Point2D(5, 12)));
		objects.add(new GameObject(new Point2D(6, 12)));
		objects.add(new GameObject(new Point2D(7, 12)));
		objects.add(new GameObject(new Point2D(8, 12)));
		objects.add(new GameObject(new Point2D(9, 12)));
		objects.add(new GameObject(new Point2D(10, 12)));
		objects.add(new GameObject(new Point2D(11, 12)));
		objects.add(new GameObject(new Point2D(12, 12)));
		objects.add(new GameObject(new Point2D(13, 12)));
		objects.add(new GameObject(new Point2D(14, 12)));
		objects.add(new GameObject(new Point2D(16, 12)));
		objects.add(new GameObject(new Point2D(4, 3)));
		objects.add(new GameObject(new Point2D(6, 3)));
		objects.add(new GameObject(new Point2D(6, 4)));
		objects.add(new GameObject(new Point2D(10, 3)));
		objects.add(new GameObject(new Point2D(10, 4)));
		objects.add(new GameObject(new Point2D(12, 4)));
		objects.add(new GameObject(new Point2D(14, 4)));
		objects.add(new GameObject(new Point2D(15, 4)));
		objects.add(new GameObject(new Point2D(14, 5)));
		objects.add(new GameObject(new Point2D(15, 5)));
		objects.add(new GameObject(new Point2D(13, 6)));
		objects.add(new GameObject(new Point2D(15, 7)));
		objects.add(new GameObject(new Point2D(14, 9)));
		objects.add(new GameObject(new Point2D(12, 9)));
		objects.add(new GameObject(new Point2D(1, 7)));
		objects.add(new GameObject(new Point2D(1, 9)));
		objects.add(new GameObject(new Point2D(1, 10)));
		objects.add(new GameObject(new Point2D(2, 9)));
		objects.add(new GameObject(new Point2D(2, 10)));
		objects.add(new GameObject(new Point2D(3, 8)));
		objects.add(new GameObject(new Point2D(4, 11)));
		objects.add(new GameObject(new Point2D(6, 6)));
		objects.add(new GameObject(new Point2D(6, 7)));
		objects.add(new GameObject(new Point2D(6, 9)));
		objects.add(new GameObject(new Point2D(6, 10)));
		objects.add(new GameObject(new Point2D(10, 6)));
		objects.add(new GameObject(new Point2D(10, 7)));
		objects.add(new GameObject(new Point2D(10, 9)));
		objects.add(new GameObject(new Point2D(10, 10)));
		enemies.add(new FinalBoss(new Point2D(8, 4), 4));
		enemies.add(new FinalBoss(new Point2D(8, 4), 2));
		transitions.add(new Transition(new Point2D(14, 13), MapScreen.DUNGEON1, new Point2D(14, 2)));
		transitions.add(new Transition(new Point2D(2, 1), MapScreen.DUNGEON3, new Point2D(2, 12)));
	}

}
