package gameObjects;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Player extends Character{
	private Boolean weapon = false;
	private int health;
	public Player(){
		super(new Circle(0,0,15, Color.GREEN));
		health = 100;
	}
	
	public void damange (int dmg) {
		health = Math.max(0, health - dmg);
	}
	
	public void heal (int amt) {
		health = Math.min(100, health + amt);
	}
	
	public int getHealth() {
		return health;
	}
	
	public Boolean hasWeapon() {
		return weapon;
	}
	
	public void getWeapon() {
		Circle circle = (Circle) this.getNode();
		circle.setFill(Color.BLUE);
		weapon = true;
	}
	
	public void dropWeapon() {
		Circle circle = (Circle) this.getNode();
		circle.setFill(Color.GREEN);
		weapon = false;
	}
}
