package gameObjects;

import javafx.geometry.Point2D;
import model.GameMap;

public class Transition extends GameObject {
	
	private GameMap currentMap;
	private Point2D spawn;
	
	/**
	 * Constructor for Transition tiles that would be used to change to the other screens.
	 * @param position Point2D The position on the map.
	 */
	public Transition(Point2D position, GameMap map, Point2D spawn) {
		super(position);
		currentMap = map;
		this.spawn = spawn;
	}
	
	/**
	 * Gets the map after a transition tile is stepped on.
	 * @return currentMap GameMap The map that is being transitioned to.
	 */
	public GameMap getMap() {
		return currentMap;
	}
	
	/**
	 * Gets the spawn point of the player after a transition
	 * @return spawn Point2D The spawn point of the player.
	 */
	public Point2D getSpawn() {
		return spawn;
	}

}
