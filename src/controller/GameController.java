package controller;

import enums.Direction;
import gameObjects.Creature;
import player_enemies.GameObject;

/**
 * Controller for the GameBoard including interactions with the character and enemies, etc.
 * @author Tito Vasquez
 *
 */

public class GameController {
	
	//collisions
	
	//movement
	public void move(Creature character, Direction dir) {
		Direction curr = character.getDirection();
		switch(dir) {
		default:
			break;
		case NORTH:
			if(curr != Direction.NORTH)
				character.setDirection(Direction.NORTH);
			else if(character.getPosition().getY() > 0){
				character.move(Direction.NORTH);
			}
			break;
		case SOUTH:
			if(curr != Direction.SOUTH)
				character.setDirection(Direction.SOUTH);
			else if(character.getPosition().getY() < 13){
				character.move(Direction.SOUTH);
			}
			break;
		case EAST:
			if(curr != Direction.EAST)
				character.setDirection(Direction.EAST);
			else if(character.getPosition().getX() < 17){
				character.move(Direction.EAST);
			}
			break;
		case WEST:
			if(curr != Direction.WEST)
				character.setDirection(Direction.WEST);
			else if(character.getPosition().getX() > 0){
				character.move(Direction.WEST);
			}
			break;
		}
	}
	//

	//drop chances
	
	//attack
	
	//speak
	
}
