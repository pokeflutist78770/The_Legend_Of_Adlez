package model;

import java.util.ArrayList;

import enums.MapScreen;
import gameObjects.*;
import model.*;
import javafx.geometry.Point2D;

/**
 * River map class.
 * @author Tito Vasquez
 *
 */
public class River extends GameMap {

	private static ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private static ArrayList<Transition> transitions = new ArrayList<Transition>();
	private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	
	/**
	 * Constructor for River map
	 */
	public River() {
		super(objects, transitions, enemies, MapScreen.RIVER, "assets/river.png");
		objects.add(new GameObject(new Point2D(0, 0)));
		objects.add(new GameObject(new Point2D(0, 1)));
		objects.add(new GameObject(new Point2D(0, 2)));
		objects.add(new GameObject(new Point2D(0, 3)));
		objects.add(new GameObject(new Point2D(1, 0)));
		objects.add(new GameObject(new Point2D(1, 1)));
		objects.add(new GameObject(new Point2D(1, 2)));
		objects.add(new GameObject(new Point2D(1, 3)));
		objects.add(new GameObject(new Point2D(1, 4)));
		objects.add(new GameObject(new Point2D(2, 0)));
		objects.add(new GameObject(new Point2D(2, 1)));
		objects.add(new GameObject(new Point2D(2, 2)));
		objects.add(new GameObject(new Point2D(2, 3)));
		objects.add(new GameObject(new Point2D(2, 4)));
		objects.add(new GameObject(new Point2D(2, 6)));
		objects.add(new GameObject(new Point2D(3, 0)));
		objects.add(new GameObject(new Point2D(3, 1)));
		objects.add(new GameObject(new Point2D(3, 2)));
		objects.add(new GameObject(new Point2D(3, 3)));
		objects.add(new GameObject(new Point2D(3, 4)));
		objects.add(new GameObject(new Point2D(3, 13)));
		objects.add(new GameObject(new Point2D(4, 0)));
		objects.add(new GameObject(new Point2D(4, 1)));
		objects.add(new GameObject(new Point2D(4, 2)));
		objects.add(new GameObject(new Point2D(4, 3)));
		objects.add(new GameObject(new Point2D(4, 4)));
		objects.add(new GameObject(new Point2D(4, 12)));
		objects.add(new GameObject(new Point2D(4, 13)));
		objects.add(new GameObject(new Point2D(5, 0)));
		objects.add(new GameObject(new Point2D(5, 1)));
		objects.add(new GameObject(new Point2D(5, 2)));
		objects.add(new GameObject(new Point2D(5, 11)));
		objects.add(new GameObject(new Point2D(5, 12)));
		objects.add(new GameObject(new Point2D(5, 13)));
		objects.add(new GameObject(new Point2D(6, 0)));
		objects.add(new GameObject(new Point2D(6, 1)));
		objects.add(new GameObject(new Point2D(6, 2)));
		objects.add(new GameObject(new Point2D(6, 3)));
		objects.add(new GameObject(new Point2D(6, 4)));
		objects.add(new GameObject(new Point2D(6, 10)));
		objects.add(new GameObject(new Point2D(6, 11)));
		objects.add(new GameObject(new Point2D(6, 12)));
		objects.add(new GameObject(new Point2D(6, 13)));
		objects.add(new GameObject(new Point2D(7, 0)));
		objects.add(new GameObject(new Point2D(7, 1)));
		objects.add(new GameObject(new Point2D(7, 2)));
		objects.add(new GameObject(new Point2D(7, 3)));
		objects.add(new GameObject(new Point2D(7, 4)));
		objects.add(new GameObject(new Point2D(7, 7)));
		objects.add(new GameObject(new Point2D(7, 10)));
		objects.add(new GameObject(new Point2D(7, 11)));
		objects.add(new GameObject(new Point2D(7, 12)));
		objects.add(new GameObject(new Point2D(7, 13)));
		objects.add(new GameObject(new Point2D(8, 0)));
		objects.add(new GameObject(new Point2D(8, 1)));
		objects.add(new GameObject(new Point2D(8, 2)));
		objects.add(new GameObject(new Point2D(8, 3)));
		objects.add(new GameObject(new Point2D(8, 4)));
		objects.add(new GameObject(new Point2D(8, 5)));
		objects.add(new GameObject(new Point2D(8, 6)));
		objects.add(new GameObject(new Point2D(8, 7)));
		objects.add(new GameObject(new Point2D(8, 10)));
		objects.add(new GameObject(new Point2D(8, 11)));
		objects.add(new GameObject(new Point2D(8, 12)));
		objects.add(new GameObject(new Point2D(8, 13)));
		objects.add(new GameObject(new Point2D(9, 0)));
		objects.add(new GameObject(new Point2D(9, 1)));
		objects.add(new GameObject(new Point2D(9, 2)));
		objects.add(new GameObject(new Point2D(9, 3)));
		objects.add(new GameObject(new Point2D(9, 4)));
		objects.add(new GameObject(new Point2D(9, 5)));
		objects.add(new GameObject(new Point2D(9, 6)));
		objects.add(new GameObject(new Point2D(9, 7)));
		objects.add(new GameObject(new Point2D(9, 10)));
		objects.add(new GameObject(new Point2D(9, 11)));
		objects.add(new GameObject(new Point2D(9, 12)));
		objects.add(new GameObject(new Point2D(9, 13)));
		objects.add(new GameObject(new Point2D(10, 0)));
		objects.add(new GameObject(new Point2D(10, 1)));
		objects.add(new GameObject(new Point2D(10, 2)));
		objects.add(new GameObject(new Point2D(10, 3)));
		objects.add(new GameObject(new Point2D(10, 4)));
		objects.add(new GameObject(new Point2D(10, 5)));
		objects.add(new GameObject(new Point2D(10, 6)));
		objects.add(new GameObject(new Point2D(10, 7)));
		objects.add(new GameObject(new Point2D(10, 10)));
		objects.add(new GameObject(new Point2D(10, 11)));
		objects.add(new GameObject(new Point2D(10, 12)));
		objects.add(new GameObject(new Point2D(11, 0)));
		objects.add(new GameObject(new Point2D(11, 1)));
		objects.add(new GameObject(new Point2D(11, 2)));
		objects.add(new GameObject(new Point2D(11, 3)));
		objects.add(new GameObject(new Point2D(11, 4)));
		objects.add(new GameObject(new Point2D(11, 5)));
		objects.add(new GameObject(new Point2D(11, 6)));
		objects.add(new GameObject(new Point2D(11, 7)));
		objects.add(new GameObject(new Point2D(11, 10)));
		objects.add(new GameObject(new Point2D(12, 0)));
		objects.add(new GameObject(new Point2D(12, 1)));
		objects.add(new GameObject(new Point2D(12, 2)));
		objects.add(new GameObject(new Point2D(12, 3)));
		objects.add(new GameObject(new Point2D(12, 4)));
		objects.add(new GameObject(new Point2D(12, 5)));
		objects.add(new GameObject(new Point2D(12, 6)));
		objects.add(new GameObject(new Point2D(12, 7)));
		objects.add(new GameObject(new Point2D(12, 11)));
		objects.add(new GameObject(new Point2D(13, 0)));
		objects.add(new GameObject(new Point2D(13, 1)));
		objects.add(new GameObject(new Point2D(13, 2)));
		objects.add(new GameObject(new Point2D(13, 3)));
		objects.add(new GameObject(new Point2D(13, 4)));
		objects.add(new GameObject(new Point2D(13, 5)));
		objects.add(new GameObject(new Point2D(13, 6)));
		objects.add(new GameObject(new Point2D(13, 13)));
		objects.add(new GameObject(new Point2D(14, 0)));
		objects.add(new GameObject(new Point2D(14, 1)));
		objects.add(new GameObject(new Point2D(14, 2)));
		objects.add(new GameObject(new Point2D(14, 3)));
		objects.add(new GameObject(new Point2D(14, 4)));
		objects.add(new GameObject(new Point2D(14, 5)));
		objects.add(new GameObject(new Point2D(14, 7)));
		objects.add(new GameObject(new Point2D(15, 0)));
		objects.add(new GameObject(new Point2D(15, 1)));
		objects.add(new GameObject(new Point2D(15, 2)));
		objects.add(new GameObject(new Point2D(15, 3)));
		objects.add(new GameObject(new Point2D(15, 13)));
		objects.add(new GameObject(new Point2D(16, 0)));
		objects.add(new GameObject(new Point2D(16, 1)));
		objects.add(new GameObject(new Point2D(16, 5)));
		objects.add(new GameObject(new Point2D(16, 11)));
		objects.add(new GameObject(new Point2D(17, 0)));
		objects.add(new GameObject(new Point2D(17, 1)));
		objects.add(new GameObject(new Point2D(17, 2)));
		objects.add(new GameObject(new Point2D(17, 3)));
		objects.add(new GameObject(new Point2D(17, 4)));
		objects.add(new GameObject(new Point2D(17, 5)));
		objects.add(new GameObject(new Point2D(17, 6)));
		objects.add(new GameObject(new Point2D(17, 7)));
		objects.add(new GameObject(new Point2D(17, 10)));
		objects.add(new GameObject(new Point2D(17, 11)));
		objects.add(new GameObject(new Point2D(17, 12)));
		objects.add(new GameObject(new Point2D(17, 13)));
		transitions.add(new Transition(new Point2D(0, 8), MapScreen.HOME_OUTSIDE, new Point2D(16, 8)));
		transitions.add(new Transition(new Point2D(0, 9), MapScreen.HOME_OUTSIDE, new Point2D(16, 9)));
//		transitions.add(new Transition(new Point2D(5, 4), new Shop(), new Point2D(11, 12)));
		transitions.add(new Transition(new Point2D(17, 8), MapScreen.MOUNTAIN, new Point2D(1, 8)));
		transitions.add(new Transition(new Point2D(17, 9), MapScreen.MOUNTAIN, new Point2D(1, 9)));
	}

}