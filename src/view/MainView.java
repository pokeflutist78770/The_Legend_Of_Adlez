package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.GameController;
import gameObjects.*;
import gameObjects.Creature;
import enums.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class MainView extends Application {
	int MAPHEIGHT = 14, MAPWIDTH = 18;
	int BLOCKHEIGHT = 48, BLOCKWIDTH = 48;
	private Pane pane;
	private Player player;
	private List<GameObject> objects;
	private Map<Creature, ImageView> creatureMap;
	private GameController controller;

    public void start(Stage stage) {
    	controller = new GameController();
    	creatureMap = new HashMap<Creature, ImageView>();
    	BorderPane window = new BorderPane();
    	pane = new Pane();
    	pane.setPrefSize(MAPWIDTH * BLOCKWIDTH, MAPHEIGHT * BLOCKHEIGHT);
    	pane.setBackground(new Background(new BackgroundImage(new Image("assets/homeOutside.png"), null, null, null, null)));
    	window.setCenter(pane);

    	TilePane tilePane = new TilePane();
    	window.setBottom(tilePane);

    	objects = controller.getMapLayout();
    	player = new Player(new Point2D(2,3));
    	creatureMap.put(player, new ImageView(new Image("assets/idleDark.png")));
    	addObject(player);
    	for(GameObject object : objects) {
    		addObject(object);
    	}
    	
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
    		boolean moved = false;
    		switch(e.getCode()) {
				default:
					break;
				case W:
				case UP:
					moved = controller.move(player, Direction.NORTH);						
					break;
				case S:
				case DOWN:
					moved = controller.move(player, Direction.SOUTH);
					break;
				case D:
				case RIGHT:
					moved = controller.move(player, Direction.EAST);
					break;
				case A:
				case LEFT:
					moved = controller.move(player, Direction.WEST);
					break;
    		}
    		if(moved) {
	    		Point2D pos = player.getPosition();
				creatureMap.get(player).setTranslateX(pos.getX() * BLOCKWIDTH);
				creatureMap.get(player).setTranslateY(pos.getY() * BLOCKHEIGHT);
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
    	
    }
        
    /**
     * Adds object to view at specified x/y coordinate on grid.
     */
    public void addObject(GameObject object) {
		double x = object.getPosition().getX() * BLOCKWIDTH;
		double y = object.getPosition().getY() * BLOCKHEIGHT;
		ImageView image;
		if(creatureMap.containsKey(object)) {
			image = creatureMap.get(object);
		}else {
		image = new ImageView();
		}
		image.setTranslateX(x);
		image.setTranslateY(y);
	    pane.getChildren().add(image);
    }

}  