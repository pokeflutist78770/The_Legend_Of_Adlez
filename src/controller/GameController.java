package controller;

import java.util.List;

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
	List<GameObject> objects;
	MapScreen currMap = MapScreen.HOME_OUTSIDE;
	
	public GameController(){
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
			for(GameObject object : map.getObjects()) {
				if(collision(character, object)) {
					character.setPosition(currPos);
					return false;
				}
			}
			for(GameObject object : map.getEnemies()) {
				if(collision(character, object)) {
					character.setPosition(currPos);
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public Turn enemyTurn(Enemy enemy) {
		if(canAttack(enemy)) {
			System.out.println("I attacked!");
			return Turn.ATTACK;
		}
		else {
			if(move(enemy, enemy.getNextMove()))
				return Turn.MOVE;
			else
				return Turn.NONE;
		}
	}
	
	public boolean canAttack(Enemy enemy) {
		Point2D enemyPos = enemy.getPosition();
		Point2D playerPos = player.getPosition();
		return (playerPos.equals(enemyPos.add(new Point2D(0,-1))) ||
				playerPos.equals(enemyPos.add(new Point2D(1,0))) ||
				playerPos.equals(enemyPos.add(new Point2D(0,1))) ||
				playerPos.equals(enemyPos.add(new Point2D(-1,0))));
	}
	
	public boolean collision(GameObject object1, GameObject object2) {
		return (!object1.equals(object2) &&
				object1.getPosition().equals(object2.getPosition()));
	}
	
	public GameMap getMapLayout(){
		switch(currMap) {
		case HOME_OUTSIDE:
			map = new HomeOutside();
			objects = map.getObjects();
			return map;
		case MOUNTAIN:
			map = new Mountain();
			objects = map.getObjects();
			return map;
		default:
			return null;
		}
	}

	public Player getPlayer() {
		player = new Player(new Point2D(2,3));
		return player;
	}
}
