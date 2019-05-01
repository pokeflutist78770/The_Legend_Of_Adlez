
package controller;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.*;
import gameObjects.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

import java.awt.Point;
import model.*;

/**
 * Controller for the GameBoard including interactions with the character and
 * enemies, etc.
 * 
 * @author Tito Vasquez & Timothy Lyons
 *
 */

public class GameController implements Serializable {
	public static boolean isPaused = false;
	public static final String SAVE_FILE = "save_file.dat";
	GameMap map;
	Player player;
	MapScreen currMap = MapScreen.HOME_OUTSIDE;
	Map<MapScreen, GameMap> maps;

	public GameController() {
		player = new Player(new Point(2, 3));
		maps = new HashMap<MapScreen, GameMap>();
		maps.put(currMap, new HomeOutside());
		
	}


	public boolean move(Creature character, Direction dir) {
		Direction currDir = character.getDirection();
		Point currPos = character.getPosition();
		int x = 0, y = 0;
		boolean moved = false;
		if (!currDir.equals(dir)) {
			character.setDirection(dir);
			return false;
		}
		switch (dir) {
		case NORTH:
			if (character.getPosition().getY() > 0) {
				x = 0;
				y = -1;
				moved = true;
			}
			break;
		case SOUTH:
			if (character.getPosition().getY() < 13) {
				x = 0;
				y = 1;
				moved = true;
			}
			break;
		case EAST:
			if (character.getPosition().getX() < 17) {
				x = 1;
				y = 0;
				moved = true;
			}
			break;
		case WEST:
			if (character.getPosition().getX() > 0) {
				x = -1;
				y = 0;
				moved = true;
			}
			break;
		default:
			break;
		}
		if (moved) {
			character.setPosition(new Point(currPos.x + x, currPos.y + y));
			for (GameObject object : maps.get(currMap).getObjects()) {
				if (collision(character, object)) {
					character.setPosition(currPos);
					return false;
				}
			}

			for (Enemy object : maps.get(currMap).getEnemies()) {
				if (collision(character, object)) {
					character.setPosition(currPos);
					return false;
				}
			}

			for (Transition transition : maps.get(currMap).getTransitions()) {
				if (collision(character, transition)) {
					loadMap(transition.getMap(), transition.getSpawn());
					return false;
				}
			}
			return true;

		}
		return false;
	}

	public Turn enemyTurn(Enemy enemy) {
		if (canAttack(enemy)) {
			System.out.println("I attacked!");
			return Turn.ATTACK;
		} else {
			if (move(enemy, enemy.getNextMove()))
				return Turn.MOVE;
			else
				return Turn.NONE;
		}
	}

	public boolean canAttack(Enemy enemy) {
		Point enemyPos = enemy.getPosition();
		Point playerPos = player.getPosition();
		return (playerPos.equals(new Point(enemyPos.x, enemyPos.y - 1))
				|| playerPos.equals(new Point(enemyPos.x + 1, enemyPos.y))
				|| playerPos.equals(new Point(enemyPos.x, enemyPos.y + 1))
				|| playerPos.equals(new Point(enemyPos.x - 1, enemyPos.y)));
	}

	public boolean collision(GameObject object1, GameObject object2) {
		return (!object1.equals(object2) &&
				object1.getPosition().equals(object2.getPosition()));
	}
	
	
	private void loadMap(MapScreen map, Point spawn) {
		currMap = map;
		if(!maps.containsKey(currMap)) {
			GameMap newMap = null;
			switch(currMap) {
			default:
				break;
			case HOME_OUTSIDE:
				newMap = new HomeOutside();
				break;
			case HOME_UP:
				newMap = new HomeUp();
				break;
			case RIVER:
				newMap = new River();
				break;
			case MOUNTAIN:
				newMap = new Mountain();
				break;
			case DUNGEON1:
				newMap = new Dungeon1();
				break;
			case DESERT:
				newMap = new Desert();
				break;
			case DUNGEON2:
				newMap = new Dungeon2();
				break;
			case DUNGEON3:
				newMap = new Dungeon3();
				break;
			case SHOP:
				newMap = new Shop();
				break;
			case HOME:
				newMap = new Home();
				break;
			}
			maps.put(currMap, newMap);
		}
		player.setPosition(spawn);
		
	}

	
	public GameMap getMapLayout(){
		return maps.get(currMap);
	}

	public Player getPlayer() {
		return player;
	}
	
	public MapScreen getCurrMap() {
		return currMap;
	}

	public List<Enemy> getEnemies(){
		return maps.get(currMap).getEnemies();
	}
	
	public List<GameObject> getObstacles(){
		return maps.get(currMap).getObjects();
	}
	
	public List<Transition> getTransitions(){
		return maps.get(currMap).getTransitions();
	}
}