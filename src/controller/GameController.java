
package controller;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import enums.*;
import gameObjects.*;
import java.awt.Point;
import model.*;
import view.LegendOfAdlezView;


/**
 * Controller for the GameBoard including interactions with the character and
 * enemies, etc.
 * 
 * @author Tito Vasquez & Timothy Lyons
 *
 */


public class GameController implements Serializable{
	public static boolean isPaused=false;
	public boolean died = false;
	public boolean won = false;
	public static final String SAVE_FILE="save_file.dat";
	private GameMap map;
	private Player player;
	private MapScreen currMap = MapScreen.HOME_OUTSIDE;

	Map<MapScreen, GameMap> maps;

	
	/**
	 * Constructor for controller that places the player at a specific point and
	 * map. Saves all the maps that have currently been explored.
	 */
	public GameController() {
		player = new Player(new Point(2, 3));
		maps = new HashMap<MapScreen, GameMap>();
		maps.put(currMap, new HomeOutside());
		
	}

	
	/**
	 * Moves a given Creature object in a given direction. Checks to see if they can
	 * actually move and sets new position.
	 * 
	 * @param character Creature The object on the map that needs to be moved.
	 * @param dir       Direction The direction that the Creature is moving.
	 * @return boolean Whether or not a move was made.
	 */
	public boolean move(Creature character, Direction dir) {
		Direction currDir = character.getDirection();
		Point currPos = character.getPosition();
		int x = 0, y = 0;
		boolean moved = false;
		if(!currDir.equals(dir)) {
			character.setDirection(dir);
			return false;
		}
		switch(dir) {
			case NORTH:				
				if(character.getPosition().getY() > -1){
					x = 0;
					y = -1;
					moved = true;
				}
				break;
			case SOUTH:
				if(character.getPosition().getY() < 14){
					x = 0;
					y = 1;
					moved = true;
				}
				break;
			case EAST:
				if(character.getPosition().getX() < 18){
					x = 1;
					y = 0;
					moved = true;
				}
				break;
			case WEST:
				if(character.getPosition().getX() > -1){
					x = -1;
					y = 0;
					moved = true;
				}
				break;
			default:
				break;
		}
		if(moved) {
			character.setPosition(new Point(currPos.x+x, currPos.y+y));
			if(currMap == MapScreen.DUNGEON3 && player.getPosition().equals(new Point(9, 3))) {
				won = true;
				return true;
			}
			for(GameObject object : getObstacles()) {
				if(collision(character, object)) {
					if(object instanceof Money) {
						if(!object.getActive()) {
							
						}
						else {
							LegendOfAdlezView.play("coin");
							Money drop = (Money)object;
							player.incrementMoney(drop.getAmount());
							object.setActive(false);
						}
						return true;
					}
					if(object instanceof Key) {
						if(!object.getActive()) {
							
						}
						else {
							LegendOfAdlezView.play("key");
							player.giveKey();
							object.setActive(false);
						}
						return true;
					}
					else {
						character.setPosition(currPos);
						return false;
					}
				}
			}
			
			for(Enemy enemy : maps.get(currMap).getEnemies()) {
				if(enemy.getActive())
					if(collision(character, enemy)) {
						character.setPosition(currPos);
						return false;
					}
			}
			
			for(Transition transition : maps.get(currMap).getTransitions()) {
				if(collision(character, transition)) {
					loadMap(transition.getMap(), transition.getSpawn());
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	
	/**
	 * Getter for the maps.
	 * @return maps Map<MapScreen, GameMap> The maps
	 */
	public Map<MapScreen, GameMap> getMaps(){
		return maps;
	}

	/**
	 * Checks the surrounding tiles of a given Enemy to see if the player is around
	 * them to determine if the enemy should attack.
	 * 
	 * @param enemy Enemy The current enemy.
	 * @return boolean If the player is in a tile adjacent to the given enemy.
	 */
	public boolean canAttack(Enemy enemy) {
		Point enemyPos = enemy.getPosition();
		Point playerPos = player.getPosition();
		return (playerPos.equals(new Point(enemyPos.x, enemyPos.y-1)) ||
				playerPos.equals(new Point(enemyPos.x+1,enemyPos.y)) ||
				playerPos.equals(new Point(enemyPos.x, enemyPos.y+1)) ||
				playerPos.equals(new Point(enemyPos.x-1, enemyPos.y)));
	}
		
	
	/**
	 * Loads in the map that the player is currently in.
	 * 
	 * @param map   MapScreen The current map the player is on.
	 * @param spawn Point The player's spawn point in the current map.
	 */
	public void loadMap(MapScreen map, Point spawn) {
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
		else {
			for(Enemy enemy : getEnemies()) {
				enemy.setActive(true);
				enemy.setDropped(false);
				enemy.setCurrentHP(enemy.getTotalHP());
			}
			ArrayList<GameObject> indexs = new ArrayList<GameObject>();
			for(GameObject object: getObstacles()) {
				if(object instanceof Money|| object instanceof Key) {
					if(object instanceof Money) {
						indexs.add(object);
					}
					if(object instanceof Key) {
						indexs.add(object);
					}
				}
			}
			for(GameObject in: indexs) {
				getObstacles().remove(in);
			}
		}
		player.setPosition(spawn);
	}

	
	/**
	 * The Enemy's turn. Can either be a move or an attack.
	 * 
	 * @param enemy Enemy The current enemy being looked at.
	 * @return Turn The type of turn that the Enemy took.
	 */
	public Turn enemyTurn(Enemy enemy) {
		Direction tempDir = enemy.getDirection();
		boolean didAttack = false;
		for(Direction dir : Direction.values()) {
			enemy.setDirection(dir);
			if(attemptAttack(enemy, player)) {
				didAttack = true;
			}
		}
		enemy.setDirection(tempDir);
		if(didAttack) {
			return Turn.ATTACK;
		}
		else {
			enemy.setDirection(tempDir);
			if(move(enemy, enemy.getNextMove()))
				return Turn.MOVE;
			else
				return Turn.NONE;
		}
	}
	
	
	/**
	 * An attack from the predator to the prey.
	 * 
	 * @param predator Creature The object doing the attacking.
	 * @param prey     Creature The object being attacked.
	 */
	public void attack(Creature predator, Creature prey) {
		prey.decrementHP(predator.getAttack());
		if(prey.getCurrentHP() == 0) {
			if(prey instanceof FinalBoss) {
				LegendOfAdlezView.playBackground("victory");
			}
			prey.setActive(false);
			if(prey instanceof Player)
				died = true;
		}
	}
	
	
	/**
	 * Knockback on the object being attacked. If something was attacked.
	 * 
	 * @param predator Creature The object doing the attacking.
	 * @param prey     Creature The object being attacked.
	 * @return boolean Whether an attack was made.
	 */
	public boolean attemptAttack(Creature predator, Creature prey) {
		Point predatorPos = predator.getPosition();
		Point preyPos = prey.getPosition();
		Point newPoint = new Point(predatorPos.x, predatorPos.y);
		boolean didAttack = false;
		switch(predator.getDirection()) {
		case NORTH:
			newPoint.translate(0,-1);
			didAttack = preyPos.equals(newPoint);
			break;
		case SOUTH:
			newPoint.translate(0,1);
			didAttack = preyPos.equals(newPoint);
			break;
		case EAST:
			newPoint.translate(1,0);
			didAttack = preyPos.equals(newPoint);
			break;
		case WEST:
			newPoint.translate(-1,0);
			didAttack = preyPos.equals(newPoint);
			break;
		}
		if(didAttack) {
			attack(predator, prey);
		}
		return didAttack;
	}
	
	
	/**
	 * Checks if one object collides with another object. Prevents movement if this
	 * is the case.
	 * 
	 * @param object1 GameObject The object that moved.
	 * @param object2 GameObject The object being moved into.
	 * @return boolean If a collision happened.
	 */
	public boolean collision(GameObject object1, GameObject object2) {
		return (!object1.equals(object2) &&
				object1.getPosition().equals(object2.getPosition()));
	}
	
	
	/**
	 * Getter for the current GameMap.
	 * 
	 * @return GameMap The current map.
	 */
	public GameMap getMapLayout(){
		return maps.get(currMap);
	}

	
	/**
	 * Getter for the player character.
	 * 
	 * @return player Player The player.
	 */
	public Player getPlayer() {
		return player;
	}
	
	
	/**
	 * Getter for the current map.
	 * 
	 * @return currMap MapScreen The map the player is on.
	 */
	public MapScreen getCurrMap() {
		return currMap;
	}

	
	/**
	 * Getter for the list of enemies on the current map.
	 * 
	 * @return List<Enemy> The list of enemies on the map.
	 */
	public List<Enemy> getEnemies(){
		return maps.get(currMap).getEnemies();
	}
	
	
	/**
	 * Getter for all the obstacles on the current map.
	 * 
	 * @return List<GameObject> The list of objects on the map.
	 */
	public List<GameObject> getObstacles(){
		return maps.get(currMap).getObjects();
	}
	
	
	/**
	 * Getter for the list of transitions on the current map.
	 * 
	 * @return List<Transition> The list of transitions on the map.
	 */
	public List<Transition> getTransitions(){
		return maps.get(currMap).getTransitions();

	}

	
	/**
	 * Attack for the player. Checks if the player actually attacked an enemy.
	 */
	public void playerAttack() {
		for(Enemy enemy : getEnemies()) {
			if(enemy.getActive())
				attemptAttack(player, enemy);
		}
	}


	/**
	 * @param drop
	 */
	public void addObject(GameObject object) {
		maps.get(currMap).addObject(object);
		
	}
}
