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

public class MainView extends Application {
	int HEIGHT = 9, WIDTH = 9, BLOCK = 40;
	private Pane pane;
	private Player player;
	private GameObject weapon;
	private int score = 0;
	Label scoreLabel;
	private List<Enemy> enemies = new ArrayList<>();
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
			circle.setFill(Color.DEEPPINK);
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
	int count = 0;
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
    	AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
        timer.start();
    	Scene scene = new Scene(window);
    	scene.setOnKeyPressed(e -> {
    		switch(e.getCode()) {
			default:
				break;
			case W:
			case UP:
				player.move(0, -1);
				if(player.getPosition().getY() < 0) {
					player.move(0, HEIGHT);
					player.dropWeapon();
				}
				break;
			case S:
			case DOWN:
				player.move(0, 1);
				if(player.getPosition().getY() >= HEIGHT) {
					player.move(0, -HEIGHT);
					player.dropWeapon();
				}
				break;
			case A:
			case LEFT:
				player.move(-1, 0);
				if(player.getPosition().getX() < 0) {
					player.move(WIDTH, 0);
					player.dropWeapon();
				}
				break;
			case D:
			case RIGHT:
				player.move(1, 0);
				if(player.getPosition().getX() >= WIDTH) {
					player.move(-WIDTH, 0);
					player.dropWeapon();
				}
				break;
    		}
    	});
        stage.setScene(scene);
        stage.show();
    }

    
    public void onUpdate() {
    	if(player.collision(weapon)) {
			player.getWeapon();
		}
    	for(Enemy enemy : enemies) {
    		if(player.collision(enemy) && player.hasWeapon()) {
    			score++;
    			enemy.setActive(false);
    			pane.getChildren().remove(enemy.getNode());
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
    public void addObject(GameObject object, double x, double y) {
    	object.getNode().setTranslateX(x);
    	object.getNode().setTranslateY(y);
    	pane.getChildren().add(object.getNode());
    }

    public static void main(String[] args) { launch(args); }
}  