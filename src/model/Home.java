package model;

import java.util.ArrayList;

import enums.MapScreen;
import gameObjects.GameObject;
import java.awt.Point;
import gameObjects.Enemy;
import gameObjects.Transition;

/**
 * Home map.
 * @author Tito Vasquez
 *
 */
public class Home extends GameMap { 
	
	  private static ArrayList<GameObject> objects = new ArrayList<GameObject>();
	  private static ArrayList<Transition> transitions = new ArrayList<Transition>();
	  private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();	 
	  private static Point spawn = new Point(6, 9);
	  
	  /**
	   * Constructor for Home map.
	   */
	  public Home() {
		  super(objects, transitions, enemies, MapScreen.HOME, "assets/home.png", spawn);
		  objects.add(new GameObject(new Point(5, 6)));
		  objects.add(new GameObject(new Point(5, 7)));
		  objects.add(new GameObject(new Point(5, 8)));
		  objects.add(new GameObject(new Point(5, 9)));
		  objects.add(new GameObject(new Point(5, 10)));
		  objects.add(new GameObject(new Point(5, 11)));
		  objects.add(new GameObject(new Point(5, 12)));
		  objects.add(new GameObject(new Point(5, 13)));
		  objects.add(new GameObject(new Point(6, 6)));
		  objects.add(new GameObject(new Point(6, 7)));
		  objects.add(new GameObject(new Point(6, 10)));
		  objects.add(new GameObject(new Point(6, 12)));
		  objects.add(new GameObject(new Point(6, 13)));
		  objects.add(new GameObject(new Point(7, 6)));
		  objects.add(new GameObject(new Point(7, 7)));
		  objects.add(new GameObject(new Point(8, 6)));
		  objects.add(new GameObject(new Point(8, 7)));
		  objects.add(new GameObject(new Point(8, 8)));
		  objects.add(new GameObject(new Point(8, 12)));
		  objects.add(new GameObject(new Point(8, 13)));
		  objects.add(new GameObject(new Point(9, 6)));
		  objects.add(new GameObject(new Point(9, 7)));
		  objects.add(new GameObject(new Point(9, 6)));
		  objects.add(new GameObject(new Point(9, 12)));
		  objects.add(new GameObject(new Point(9, 13)));
		  objects.add(new GameObject(new Point(10, 6)));
		  objects.add(new GameObject(new Point(10, 7)));
		  objects.add(new GameObject(new Point(10, 8)));
		  objects.add(new GameObject(new Point(10, 11)));
		  objects.add(new GameObject(new Point(10, 12)));
		  objects.add(new GameObject(new Point(10, 13)));
		  objects.add(new GameObject(new Point(11, 6)));
		  objects.add(new GameObject(new Point(11, 7)));
		  objects.add(new GameObject(new Point(11, 8)));
		  objects.add(new GameObject(new Point(11, 9)));
		  objects.add(new GameObject(new Point(11, 10)));
		  objects.add(new GameObject(new Point(11, 11)));
		  objects.add(new GameObject(new Point(11, 12)));
		  objects.add(new GameObject(new Point(11, 13))); 
		  transitions.add(new Transition(new Point(7, 14), MapScreen.HOME_OUTSIDE, new Point(2, 3)));
		  setCloneObjects((ArrayList<GameObject>) objects.clone());
	  }
	  public void refresh() {
			objects = getCloneObjects();
		}
}
