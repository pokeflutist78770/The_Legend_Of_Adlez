package gameObjects;

import enums.Direction;
import javafx.geometry.Point2D;
import javafx.scene.*;


public class GameObject {
	private Node node;
	private Point2D position;
	private boolean active;
	private String image;
	
	public GameObject(Node node) {
		this.node = node;
		this.position = new Point2D(0,0);
		active = true;
	}
	
	public GameObject(Point2D position) {
		this.position = position;
		image = null;
	}
	
	public Point2D getPosition() {
		return position;
	}
	
	public void setImage(String image) {
		this.image = image;
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
	
	public Node getNode() {
		return node;
	}
	
	public boolean collision(GameObject other) {
		return position.equals(other.getPosition());
	}
}
