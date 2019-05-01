package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.*;
import gameObjects.*;
import javafx.geometry.Point2D;
import model.*;

/**
 * Controller for the GameBoard including interactions with the character and enemies, etc.
 * @author Tito Vasquez & Timothy Lyons
 *
 */

public class GameController {
	public static boolean isPaused=false;
	GameMap map;
	Player player;
	MapScreen currMap = MapScreen.DUNGEON1;
	Map<MapScreen, GameMap> maps;
	
	public GameController(){
		maps = new HashMap<MapScreen, GameMap>();
		maps.put(currMap, new Dungeon1());
	}
	
	public boolean move(Creature character, Direction dir) {
		Direction currDir = character.getDirection();
		Point2D currPos = character.getPosition();
		int x = 0, y = 0;
		boolean moved = false;
		if(!currDir.equals(dir)) {
			character.setDirection(dir);
			return false;
		}
		switch(dir) {
			case NORTH:				
				if(character.getPosition().getY() > 0){
					x = 0;
					y = -1;
					moved = true;
				}
				break;
			case SOUTH:
				if(character.getPosition().getY() < 13){
					x = 0;
					y = 1;
					moved = true;
				}
				break;
			case EAST:
				if(character.getPosition().getX() < 17){
					x = 1;
					y = 0;
					moved = true;
				}
				break;
			case WEST:
				if(character.getPosition().getX() > 0){
					x = -1;
					y = 0;
					moved = true;
				}
				break;
			default:
				break;
		}
		if(moved) {
			character.setPosition(currPos.add(x, y));
			for(GameObject object : maps.get(currMap).getObjects()) {
				if(collision(character, object)) {
					character.setPosition(currPos);
					return false;
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

	private void loadMap(MapScreen map, Point2D spawn) {
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
				enemy.setCurrentHP(enemy.getTotalHP());
			}
		}
		player.setPosition(spawn);
		
	}

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
	
	public void attack(Creature predator, Creature prey) {
		prey.decrementHP(predator.getAttack());
		if(prey.getCurrentHP() == 0) {
			prey.setActive(false);
		}
	}
	
	public boolean attemptAttack(Creature predator, Creature prey) {
		Point2D predatorPos = predator.getPosition();
		Point2D preyPos = prey.getPosition();
		boolean didAttack = false;
		switch(predator.getDirection()) {
		case NORTH:
			didAttack = preyPos.equals(predatorPos.add(new Point2D(0,-1)));
			break;
		case SOUTH:
			didAttack = preyPos.equals(predatorPos.add(new Point2D(0,1)));
			break;
		case EAST:
			didAttack = preyPos.equals(predatorPos.add(new Point2D(1,0)));
			break;
		case WEST:
			didAttack = preyPos.equals(predatorPos.add(new Point2D(-1,0)));
			break;
		}
		if(didAttack) {
			attack(predator, prey);
		}
		return didAttack;
	}
	
	public boolean collision(GameObject object1, GameObject object2) {
		return (!object1.equals(object2) &&
				object1.getPosition().equals(object2.getPosition()));
	}
	
	public GameMap getMapLayout(){
		return maps.get(currMap);
	}

	public Player getPlayer() {
		player = new Player(new Point2D(2,3));
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

	public void playerAttack() {
		for(Enemy enemy : getEnemies()) {
			if(enemy.getActive())
				attemptAttack(player, enemy);
		}
	}
}
