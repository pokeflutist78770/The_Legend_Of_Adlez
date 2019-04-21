package view;

import javafx.geometry.Point2D;
import javafx.scene.*;

public class GameObject {
	private Node node;
	private Point2D position;
	private boolean active;
	
	public GameObject(Node node) {
		this.node = node;
		this.position = new Point2D(0,0);
		active = true;
	}
	
	public void move(int x, int y) {
		position = position.add(x,y);
		node.setTranslateX(node.getTranslateX() + x * 40);
		node.setTranslateY(node.getTranslateY() + y * 40);
	}
	
	public Point2D getPosition() {
		return position;
	}
	
	public void setPosition(int x, int y) {
		position = new Point2D(x, y);
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
