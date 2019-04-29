package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gameObjects.*;
import enums.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainView extends BorderPane {
	int HEIGHT = 14, WIDTH = 18, BLOCK = 48, BLOCKHEIGHT = 40, BLOCKWIDTH = 30;
	private Pane pane;
	private Player player;
	private Weapon weapon;
	private Potion potion;
	private int score = 0;
	Label scoreLabel;
	Label healthLabel;
	Label dirLabel;
	private List<GameObject> objects;
	private List<Enemy> enemies = new ArrayList<>();
	
	/*
	 * TODO Remove temporary classes on merge with master
	 */
	public class Weapon extends GameObject{
		Weapon(){
			super(new Rectangle(20,20, Color.BLUE));
		}
	}
	public class Potion extends GameObject{
		private int health;
		Potion(int amt) {
			super(new Rectangle(20,20, Color.DEEPPINK));
			health = amt;
		}
		public int getHealth() {
			return health;
		}
	}
	
    public MainView() {
    	pane = new Pane();
    	pane.setBackground(new Background(new BackgroundImage(new Image("assets/homeOutside.png"), null, null, null, null)));
    	this.setCenter(pane);
    	
    	TilePane tilePane = new TilePane();
    	scoreLabel = new Label();
    	healthLabel = new Label();
    	dirLabel = new Label();
    	tilePane.getChildren().addAll(scoreLabel, healthLabel, dirLabel);
    	this.setBottom(tilePane);
    	pane.setPrefSize(WIDTH * BLOCK, HEIGHT * BLOCK);
    	
    	player = new Player();
    	player.setPosition(0,0);
    	addObject(player, player.getPosition().getX() * BLOCK + BLOCK / 2, player.getPosition().getY() * BLOCK + BLOCK / 2);
    	weapon = new Weapon();
    	weapon.setPosition(5,0);
    	addObject(weapon, weapon.getPosition().getX() * BLOCK + 10, weapon.getPosition().getY() * BLOCK + 10);
    	potion = new Potion(10);
    	potion.setPosition(0, 5);
    	addObject(potion, potion.getPosition().getX() * BLOCK + 10, potion.getPosition().getY() * BLOCK + 10);
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
        

    	/*
    	 * Controlls: Move player using either WASD or Arrows
    	 * 			  If Player is not facing the direction, the player will "turn"
    	 * 			  otherwise the player will move in the specified direction
    	 *            Space drops the weapon and leaves player vulnerable
    	 */
    	LegendOfAdlezView.mainScene.setOnKeyPressed(e -> {
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
			case D:
			case RIGHT:
				if(dir != Direction.EAST)
					player.setDirection(Direction.EAST);
				else if(player.getPosition().getX() < WIDTH - 1){
					player.move(Direction.EAST);
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
			case SPACE:
				player.dropWeapon();
				weapon.setActive(true);
				pane.getChildren().add(weapon.getNode());
    		}
    	});
    }

    /*
     * Checks for collision between the player and any weapons or enemies.
     * If player is colliding with a weapon, player picks it up. Having weapon
     * allows enemies to be defeated.
     */
    public void onUpdate() {
    	if(player.collision(potion)) {
    		player.heal(potion.getHealth());
    		potion.setActive(false);
    		pane.getChildren().remove(potion.getNode());
    		newPotion();
    	}
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
    			player.damange(10);
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
    	healthLabel.setText("Health: " + player.getHealth());
    	dirLabel.setText("Direction: " + player.getDirection());
    	
    }
    
    private void newPotion() {
		potion = new Potion(10);
		Random coord = new Random();
    	Point2D loc = new Point2D(coord.nextInt(WIDTH),coord.nextInt(HEIGHT));
    	while(loc.equals(player.getPosition()) || loc.equals(weapon.getPosition()) || loc.equals(potion.getPosition())) {
    		loc = new Point2D(coord.nextInt(WIDTH),coord.nextInt(HEIGHT));
    	}
    	potion.setPosition(loc);
    	addObject(potion, potion.getPosition().getX() * BLOCK + 10, potion.getPosition().getY() * BLOCK + 10);
	}

	/*
     * Generates new enemy randomly on board. Prevents initial collision with player and weapon
     */
    public void newEnemy() {
    	Enemy enemy = new Enemy();
    	Random coord = new Random();
    	Point2D loc = new Point2D(coord.nextInt(WIDTH),coord.nextInt(HEIGHT));
    	while(loc.equals(player.getPosition()) || loc.equals(weapon.getPosition()) || loc.equals(potion.getPosition())) {
    		loc = new Point2D(coord.nextInt(WIDTH),coord.nextInt(HEIGHT));
    	}
    	enemy.setPosition(loc);
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

}  