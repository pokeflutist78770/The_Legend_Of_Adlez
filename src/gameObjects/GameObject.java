package gameObjects;

import javafx.geometry.Point2D;

public class GameObject {
	private Point2D prevPosition;
	private Point2D position;
	private String image;
	private boolean active;
		
	public GameObject(Point2D position) {
		prevPosition = position;
		this.position = position;
		image = null;
	}

	public void setPosition(Point2D point) {
		prevPosition = position;
		position = point;
	}	
	public Point2D getPosition() {
		return position;
	}
	public Point2D getPrevPositon() {
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
