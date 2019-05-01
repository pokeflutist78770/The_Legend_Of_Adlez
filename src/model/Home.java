package model;

import java.util.ArrayList;

import enums.MapScreen;
import gameObjects.GameObject;
import javafx.geometry.Point2D;
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
	  
	  /**
	   * Constructor for Home map.
	   */
	  public Home() {
		  super(objects, transitions, enemies, MapScreen.HOME, "assets/home.png");
		  objects.add(new GameObject(new Point2D(5, 6)));
		  objects.add(new GameObject(new Point2D(5, 7)));
		  objects.add(new GameObject(new Point2D(5, 8)));
		  objects.add(new GameObject(new Point2D(5, 9)));
		  objects.add(new GameObject(new Point2D(5, 10)));
		  objects.add(new GameObject(new Point2D(5, 11)));
		  objects.add(new GameObject(new Point2D(5, 12)));
		  objects.add(new GameObject(new Point2D(5, 13)));
		  objects.add(new GameObject(new Point2D(6, 6)));
		  objects.add(new GameObject(new Point2D(6, 7)));
		  objects.add(new GameObject(new Point2D(6, 10)));
		  objects.add(new GameObject(new Point2D(6, 12)));
		  objects.add(new GameObject(new Point2D(6, 13)));
		  objects.add(new GameObject(new Point2D(7, 6)));
		  objects.add(new GameObject(new Point2D(7, 7)));
		  objects.add(new GameObject(new Point2D(8, 6)));
		  objects.add(new GameObject(new Point2D(8, 7)));
		  objects.add(new GameObject(new Point2D(8, 8)));
		  objects.add(new GameObject(new Point2D(8, 12)));
		  objects.add(new GameObject(new Point2D(8, 13)));
		  objects.add(new GameObject(new Point2D(9, 6)));
		  objects.add(new GameObject(new Point2D(9, 7)));
		  objects.add(new GameObject(new Point2D(9, 6)));
		  objects.add(new GameObject(new Point2D(9, 12)));
		  objects.add(new GameObject(new Point2D(9, 13)));
		  objects.add(new GameObject(new Point2D(10, 6)));
		  objects.add(new GameObject(new Point2D(10, 7)));
		  objects.add(new GameObject(new Point2D(10, 8)));
		  objects.add(new GameObject(new Point2D(10, 11)));
		  objects.add(new GameObject(new Point2D(10, 12)));
		  objects.add(new GameObject(new Point2D(10, 13)));
		  objects.add(new GameObject(new Point2D(11, 6)));
		  objects.add(new GameObject(new Point2D(11, 7)));
		  objects.add(new GameObject(new Point2D(11, 8)));
		  objects.add(new GameObject(new Point2D(11, 9)));
		  objects.add(new GameObject(new Point2D(11, 10)));
		  objects.add(new GameObject(new Point2D(11, 11)));
		  objects.add(new GameObject(new Point2D(11, 12)));
		  objects.add(new GameObject(new Point2D(11, 13))); 
		  transitions.add(new Transition(new Point2D(7, 13), MapScreen.HOME_OUTSIDE, new Point2D(2, 3)));
	  }
}
