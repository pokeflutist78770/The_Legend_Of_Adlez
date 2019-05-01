package model;

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

	public GameMap(ArrayList<GameObject> objects, ArrayList<Transition> transitions, ArrayList<Enemy> enemies,
			MapScreen screen, String mapString) {
		this.objects = objects;
		this.transitions = transitions;
		this.enemies = enemies;
		this.map = screen;
		this.mapString = mapString;
	}
	
	public ArrayList<GameObject> getObjects() {
		return objects;
	}

	public ArrayList<Transition> getTransitions() {
		return transitions;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public MapScreen getMap() {
		return map;
	}
	
	public String getMapString() {
		return mapString;
	}
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