package gameObjects;

import enums.Direction;
import javafx.geometry.Point2D;
import javafx.scene.Node;

public class Character extends GameObject{
	private int currentHP;
	private int totalHP;
	private int attack;
	private Direction direction;
	
	public Character(Node node) {
		super(node);
		direction = Direction.SOUTH;
		// TODO Auto-generated constructor stub
	}
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction dir) {
		direction = dir;
	}
	public void move(Direction dir) {
		int x = 0, y = 0;
		switch(dir) {
		case NORTH:
			x = 0;
			y= -1;
			break;
		case SOUTH:
			x = 0;
			y = 1;
			break;
		case EAST:
			x = 1;
			y = 0;
			break;
		case WEST:
			x = -1;
			y = 0;
			break;	
		}
		setPosition(getPosition().add(x, y));
		Node node = getNode();
		node.setTranslateX(node.getTranslateX() + x * 48);
		node.setTranslateY(node.getTranslateY() + y * 48);
	}

}
