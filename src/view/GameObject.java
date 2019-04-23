package view;

import javafx.geometry.Point2D;
import javafx.scene.*;


public class GameObject {
	private Node node;
	private Point2D position;
	private boolean active;
	private Direction dir;
	
	enum Direction {
		NORTH, SOUTH, EAST, WEST;
	}
	
	public GameObject(Node node) {
		this.node = node;
		this.position = new Point2D(0,0);
		active = true;
		dir = Direction.SOUTH;
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
		position = position.add(x, y);
		node.setTranslateX(node.getTranslateX() + x * 48);
		node.setTranslateY(node.getTranslateY() + y * 48);
	}
	
	public Point2D getPosition() {
		return position;
	}
	
	public void setPosition(int x, int y) {
		position = new Point2D(x, y);
	}
	
	public void setPosition(Point2D point) {
		position = point;
	}
	
	public boolean isActive() {
		return active;
	}
	
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Direction getDirection() {
		return dir;
	}
	
	public void setDirection(Direction dir) {
		this.dir = dir;
	}
	
	public Node getNode() {
		return node;
	}
	
	public boolean collision(GameObject other) {
		return position.equals(other.getPosition());
	}
}
