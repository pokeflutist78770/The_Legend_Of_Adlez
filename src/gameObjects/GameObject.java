package gameObjects;

import javafx.geometry.Point2D;

public class GameObject {
	private Point2D position;
	private String image;
	private boolean active = true;
		
	public GameObject(Point2D position) {
		this.position = position;
		image = null;
	}
	public GameObject(Point2D position, String image) {
		this.position = position;
		this.image = image;
	}

	public void setPosition(Point2D point) {
		position = point;
	}	
	public Point2D getPosition() {
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
