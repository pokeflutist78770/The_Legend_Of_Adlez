package gameObjects;

import java.awt.Point;
import java.io.Serializable;

import javafx.geometry.Point2D;


public class GameObject implements Serializable{
	private Point position;
	private String image;
	private boolean active = true;
		
	public GameObject(Point position2) {
		this.position = position2;
		image = null;
	}
	public GameObject(Point position, String image) {
		this.position = position;
		this.image = image;
	}

	public void setPosition(Point point) {
		position = point;
	}	
	public Point getPosition() {
		return position;
	}
	
	public void setImage(String imageString) {
		this.image = imageString;
	}	
	public String getImage() {
		return image;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean getActive() {
		return active;
	}
}
