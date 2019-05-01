package gameObjects;

import java.awt.Point;
import java.io.Serializable;

import javafx.geometry.Point2D;

public class GameObject implements Serializable{
	private Point prevPosition;
	private Point position;
	private String image;
	private boolean active;
		
	public GameObject(Point position2) {
		prevPosition = position2;
		this.position = position2;
		image = null;
	}

	public void setPosition(Point point) {
		prevPosition = position;
		position = point;
	}	
	public Point getPosition() {
		return position;
	}
	public Point getPrevPositon() {
		return prevPosition;
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
