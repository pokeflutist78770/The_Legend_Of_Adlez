package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.GameObject.Direction;

public class MainView extends Application {
	int HEIGHT = 9, WIDTH = 9, BLOCK = 40;
	private Pane pane;
	private Player player;
	private GameObject weapon;
	private int score = 0;
	Label scoreLabel;
	private List<Enemy> enemies = new ArrayList<>();
	
	/*
	 * TODO Remove temporary classes on merge with master
	 */
	private class Player extends GameObject{
		private Boolean weapon = false;
		Player(){
			super(new Circle(0,0,15, Color.GREEN));
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
	private class Enemy extends GameObject {
		Enemy(){
			super(new Rectangle(30, 30 , Color.RED));
		}
	}
	private class Weapon extends GameObject{
		Weapon(){
			super(new Rectangle(20,20, Color.BLUE));
		}
	}

    public void start(Stage stage) {
    	BorderPane window = new BorderPane();
    	pane = new Pane();
    	window.setCenter(pane);
    	scoreLabel = new Label();
    	window.setBottom(scoreLabel);
    	pane.setPrefSize(360,360);
    	
    	player = new Player();
    	player.setPosition(0,0);
    	addObject(player, player.getPosition().getX() * BLOCK + BLOCK / 2, player.getPosition().getY() * BLOCK + BLOCK / 2);
    	weapon = new Weapon();
    	weapon.setPosition(5,0);
    	addObject(weapon, weapon.getPosition().getX() * BLOCK + 10, weapon.getPosition().getY() * BLOCK + 10);
 
    	/*
    	 * Continous loop functioning as the games internal "clock". Screen updates on each tick.
    	 */
    	AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
        timer.start();
        
    	Scene scene = new Scene(window);

    	/*
    	 * Controlls: Move player using either WASD or Arrows
    	 * 			  If Player is not facing the direction, the player will "turn"
    	 * 			  otherwise the player will move in the specified direction
    	 *            Space drops the weapon and leaves player vulnerable
    	 */
    	scene.setOnKeyPressed(e -> {
    		Direction dir = player.getDirection();
    		switch(e.getCode()) {
			default:
				break;
			case W:
			case UP:
				if(dir != Direction.NORTH)
					player.setDirection(Direction.NORTH);
				else if(player.getPosition().getY() > 0){
					player.move(Direction.NORTH);
				}
				break;
			case S:
			case DOWN:
				if(dir != Direction.SOUTH)
					player.setDirection(Direction.SOUTH);
				else if(player.getPosition().getY() < HEIGHT - 1){
					player.move(Direction.SOUTH);
				}
				break;
			case A:
			case LEFT:
				if(dir != Direction.WEST)
					player.setDirection(Direction.WEST);
				else if(player.getPosition().getX() > 0){
					player.move(Direction.WEST);
				}
				break;
			case D:
			case RIGHT:
				if(dir != Direction.EAST)
					player.setDirection(Direction.EAST);
				else if(player.getPosition().getX() < WIDTH - 1){
					player.move(Direction.EAST);
				}
				break;
			case SPACE:
				player.dropWeapon();
				weapon.setActive(true);
				pane.getChildren().add(weapon.getNode());
    		}
    	});
        stage.setScene(scene);
        stage.show();
    }

    /*
     * Checks for collision between the player and any weapons or enemies.
     * If player is colliding with a weapon, player picks it up. Having weapon
     * allows enemies to be defeated.
     */
    public void onUpdate() {
    	if(player.collision(weapon)) {
			player.getWeapon();
			weapon.setActive(false);
			pane.getChildren().remove(weapon.getNode());
		}
    	for(Enemy enemy : enemies) {
    		if(player.collision(enemy) && player.hasWeapon()) {
    			score++;
    			enemy.setActive(false);
    			pane.getChildren().remove(enemy.getNode());
    		}
    		else if(player.collision(enemy) && !player.hasWeapon()) {
    			switch(player.getDirection()) {
    			case NORTH:
    				player.move(Direction.SOUTH);
    				break;
    			case SOUTH:
    				player.move(Direction.NORTH);
    				break;
    			case EAST:
    				player.move(Direction.WEST);
    				break;
    			case WEST:
    				player.move(Direction.EAST);
    				break;
    			}
    		}
    			
    	}
    	enemies.removeIf(e-> !e.isActive());
    	if(enemies.size() == 0) {
    		newEnemy();
    		newEnemy();
    		newEnemy();
    		newEnemy();
    	}
    	scoreLabel.setText("Enemies defeated: " + Integer.toString(score));
    	
    }
    
    /*
     * Generates new enemy randomly on board. Prevents initial collision with player and weapon
     */
    public void newEnemy() {
    	Enemy enemy = new Enemy();
    	Random coord = new Random();
    	int eX = coord.nextInt(WIDTH);
    	int eY = coord.nextInt(HEIGHT);
    	while((eX == player.getPosition().getX() &&
    		  eY == player.getPosition().getY()) ||
    		  (eX == weapon.getPosition().getX() &&
    		  eY == weapon.getPosition().getY())) {
    		eX = coord.nextInt(WIDTH);
        	eY = coord.nextInt(HEIGHT);
    	}
    	enemy.setPosition(eX, eY);
    	enemies.add(enemy);
    	addObject(enemy, enemy.getPosition().getX() * BLOCK + 5, enemy.getPosition().getY() * BLOCK + 5);
    	
    }
    
    /*
     * Adds object to view at specified x/y coordinate on grid.
     */
    public void addObject(GameObject object, double x, double y) {
    	object.getNode().setTranslateX(x);
    	object.getNode().setTranslateY(y);
    	pane.getChildren().add(object.getNode());
    }

    public static void main(String[] args) {
    	launch(args);
    }
}  