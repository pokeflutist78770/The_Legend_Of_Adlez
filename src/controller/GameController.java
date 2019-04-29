package controller;

import java.util.List;

import enums.*;
import gameObjects.*;
import javafx.geometry.Point2D;
import model.GameMap;

/**
 * Controller for the GameBoard including interactions with the character and enemies, etc.
 * @author Tito Vasquez
 *
 */

public class GameController {
	GameMap maps;
	Player player;
	List<GameObject> objects;
	int currMap = 1;
	
	public GameController(){
		maps = new GameMap();
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
			for(GameObject object : objects) {
				if(collision(character, object)) {
					character.setPosition(currPos);
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public boolean collision(GameObject object1, GameObject object2) {
		return !object1.equals(object2) &&
				object1.getPosition().equals(object2.getPosition());
	}
	
	public List<GameObject> getMapLayout(){
		switch(currMap) {
		case 1:
			objects = maps.getHomeOutside();
			return objects;
		default:
			return null;
		}
	}
}
