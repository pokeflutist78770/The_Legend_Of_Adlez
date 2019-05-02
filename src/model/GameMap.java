package model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

import enums.MapScreen;
import gameObjects.*;

/**
 * Constructs all the maps of the game using GameObjects, Enemies, and Player.
 */
public abstract class GameMap implements Serializable{

	private ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private ArrayList<GameObject> cloneObjects;
	private ArrayList<Transition> transitions = new ArrayList<Transition>();
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private MapScreen map;
	private String mapString;
	private Point spawn;

	
	/**
	 * Constructor for GameMap
	 * @param objects ArrayList<GameObject> List of all the objects on the map.
	 * @param transitions ArrayList<Transition> List of all the Transitions on the map.
	 * @param enemies ArrayList<Enemy> List of all the Enemys on the map.
	 * @param screen MapScreen What the current map is.
	 * @param mapString String The name of the current map.
	 * @param spawn Point The default spawn point on the map.
	 */
	public GameMap(ArrayList<GameObject> objects, ArrayList<Transition> transitions, ArrayList<Enemy> enemies,
			MapScreen screen, String mapString, Point spawn) {
		this.objects = objects;
		this.transitions = transitions;
		this.enemies = enemies;
		this.map = screen;
		this.mapString = mapString;
		this.spawn = spawn;
	}
	
	
	/**
	 * Getter for the objects on the map.
	 * @return objects ArrayList<GameObject> List of the objects on the map.
	 */
	public ArrayList<GameObject> getObjects() {
		return objects;
	}

	
	/**
	 * Getter for the Transitions objects on the map
	 * @return transitions ArrayList<Transition> List of the Transition objects on the map.
	 */
	public ArrayList<Transition> getTransitions() {
		return transitions;
	}

	
	/**
	 * Getter for the Enemys on the map.
	 * @return enemies ArrayList<Enemy> List of all the Enemys on the map.
	 */
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	
	/**
	 * Getter for the map currently displayed.
	 * @return map MapScreen The current map.
	 */
	public MapScreen getMap() {
		return map;
	}
	
	
	/**
	 * Getter for the current map as a string.
	 * @return mapString String The current map as a string.
	 */
	public String getMapString() {
		return mapString;
	}
	
	
	/**
	 * Adds a GameObject to the list of objects on a specific map.
	 * @param object GameObject The object that needs to be added.
	 */
	public void addObject(GameObject object) {
		objects.add(object);
	}

	/**
	 * @return the cloneObjects
	 */
	public ArrayList<GameObject> getCloneObjects() {
		return cloneObjects;
	}

	/**
	 * @param cloneObjects the cloneObjects to set
	 */
	public void setCloneObjects(ArrayList<GameObject> cloneObjects) {
		this.cloneObjects = cloneObjects;
	}
}