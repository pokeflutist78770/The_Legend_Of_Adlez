package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import animation.SpriteAnimation;
import controller.GameController;
import gameObjects.*;
import gameObjects.Creature;
import enums.*;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import model.GameMap;
import javafx.util.Duration;

public class MainView extends Application {
	int MAPHEIGHT = 14, MAPWIDTH = 18;
	int BLOCKHEIGHT = 48, BLOCKWIDTH = 48;
	private Pane pane;
	private Player player;
	private GameMap map;
	private MapScreen currMap;
	private Map<Creature, ImageView> creatureMap;
	private GameController controller;
	private boolean keyListener = true;
	private long time;

	public void loadMap() {
		currMap = controller.getCurrMap();
		map = controller.getMapLayout();
		pane.getChildren().clear();
		pane.setBackground(new Background(new BackgroundImage(new Image(map.getMapString()), null, null, null, null)));
		creatureMap = new HashMap<Creature, ImageView>();
		creatureMap.put(player, new ImageView(new Image(player.getImage())));
    	addObject(player);
		switch(player.getDirection()) {
		case NORTH:
			creatureMap.get(player).setViewport(new Rectangle2D(0,62,60,62));
			break;
		case SOUTH:
			creatureMap.get(player).setViewport(new Rectangle2D(0,0,60,62));
			break;
		case EAST:
			creatureMap.get(player).setViewport(new Rectangle2D(420,186,60,62));
			break;
		case WEST:
			creatureMap.get(player).setViewport(new Rectangle2D(0,124,60,62));
			break;
		}
		for(GameObject obstacle : controller.getObstacles()) {
    		addObject(obstacle);
    	}
		for(Transition obstacle : controller.getTransitions()) {
    		addObject(obstacle);
    	}
    	for(Enemy enemy : controller.getEnemies()) {
    		creatureMap.put(enemy, new ImageView(new Image(enemy.getImage())));
    		addObject(enemy);
    	}
	}
	
    public void start(Stage stage) {
    	controller = new GameController();
    	BorderPane window = new BorderPane();
    	pane = new Pane();
    	pane.setPrefSize(MAPWIDTH * BLOCKWIDTH, MAPHEIGHT * BLOCKHEIGHT);
    	window.setCenter(pane);

    	TilePane tilePane = new TilePane();
    	window.setBottom(tilePane);

    	player = controller.getPlayer();
    	loadMap();
    	/*
    	 * Continous loop functioning as the games internal "clock". Screen updates on each tick.
    	 */
    	AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
//            	if(!keyListener) {
//            		if((now - time) > 600000000) {
//            			keyListener = true;
////            			System.out.println(time);
//            		}
//            	}
//        		else {
//        			time = now;
//        		}
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
    		if(!keyListener)
    			return;
    		keyListener = false;
    		boolean moved = false;
    		boolean interact = false;
    		Point2D startPos = player.getPosition();
    		switch(e.getCode()) {
				default:
					break;
				case SPACE:{
					switch(player.getDirection()) {
						case NORTH:{
							Animation animation = new SpriteAnimation(
					                creatureMap.get(player),
					                Duration.millis(500),
					                5, 5,
					                0, 434,
					                60, 62
					        );
					        animation.setCycleCount(1);
					        animation.setOnFinished(new EventHandler<ActionEvent>() {
				    	        @Override
				    	        public void handle(ActionEvent event) {
				    	            keyListener = true;
				    	        }
				    	    });
					        animation.play();
					       interact = true;
					        creatureMap.get(player).setViewport(new Rectangle2D(0,62,60,62));
					        break;
						}
						case SOUTH:{
							
							Animation animation = new SpriteAnimation(
					                creatureMap.get(player),
					                Duration.millis(250),
					                6, 6,
					                0, 248,
					                60, 62
					        );
					        animation.setCycleCount(1);
					        animation.setOnFinished(new EventHandler<ActionEvent>() {
				    	        @Override
				    	        public void handle(ActionEvent event) {
				    	            keyListener = true;
				    	        }
				    	    });
					        animation.play();
					        interact = true;
					        creatureMap.get(player).setViewport(new Rectangle2D(0,0,60,62));
					        break;
						}
						case EAST:{
							Animation animation = new SpriteAnimation(
					                creatureMap.get(player),
					                Duration.millis(250),
					                5, 5,
					                0, 372,
					                60, 62
					        );
					        animation.setCycleCount(1);
					        animation.setOnFinished(new EventHandler<ActionEvent>() {
				    	        @Override
				    	        public void handle(ActionEvent event) {
				    	            keyListener = true;
				    	        }
				    	    });
					        animation.play();
					        interact = true;
					        creatureMap.get(player).setViewport(new Rectangle2D(420,186,60,62));
					        break;
						}
						case WEST:{
							Animation animation = new SpriteAnimation(
					                creatureMap.get(player),
					                Duration.millis(250),
					                5, 5,
					                0, 310,
					                60, 62
					        );
					        animation.setCycleCount(1);
					        animation.setOnFinished(new EventHandler<ActionEvent>() {
				    	        @Override
				    	        public void handle(ActionEvent event) {
				    	            keyListener = true;
				    	        }
				    	    });
					        animation.play();
					        interact = true;
					        creatureMap.get(player).setViewport(new Rectangle2D(0,124,60,62));
							break;
						}
					}
				}
				if(interact)
					break;
				case W:
				case UP:
					moved = controller.move(player, Direction.NORTH);
					if(!moved) {
						creatureMap.get(player).setViewport(new Rectangle2D(0,62,60,62));
					}
					else {
						Animation animation = new SpriteAnimation(
				                creatureMap.get(player),
				                Duration.millis(500),
				                8, 8,
				                0, 62,
				                60, 62
				        );
				        animation.setCycleCount(1);
				        animation.setOnFinished(new EventHandler<ActionEvent>() {
			    	        @Override
			    	        public void handle(ActionEvent event) {
			    	            keyListener = true;
			    	        }
			    	    });
				        animation.play();
					}
					break;
				case S:
				case DOWN:
					moved = controller.move(player, Direction.SOUTH);
					if(!moved) {
						creatureMap.get(player).setViewport(new Rectangle2D(0,0,60,62));
					}
					else {
						Animation animation = new SpriteAnimation(
				                creatureMap.get(player),
				                Duration.millis(500),
				                8, 8,
				                0, 0,
				                60, 62
				        );
				        animation.setCycleCount(1);
				        animation.setOnFinished(new EventHandler<ActionEvent>() {
			    	        @Override
			    	        public void handle(ActionEvent event) {
			    	            keyListener = true;
			    	        }
			    	    });
				        animation.play();
					}
					break;
				case D:
				case RIGHT:
					moved = controller.move(player, Direction.EAST);
					if(!moved) {
						creatureMap.get(player).setViewport(new Rectangle2D(420,186,60,62));
					}
					else {
						Animation animation = new SpriteAnimation(
				                creatureMap.get(player),
				                Duration.millis(500),
				                1, 8,
				                0, 186,
				                60, 62
				        );
				        animation.setCycleCount(1);
				        animation.setOnFinished(new EventHandler<ActionEvent>() {
			    	        @Override
			    	        public void handle(ActionEvent event) {
			    	            keyListener = true;
			    	        }
			    	    });
				        animation.play();
					}
					break;
				case A:
				case LEFT:
					moved = controller.move(player, Direction.WEST);
					if(!moved) {
						creatureMap.get(player).setViewport(new Rectangle2D(0,124,60,62));
					}
					else {
						Animation animation = new SpriteAnimation(
				                creatureMap.get(player),
				                Duration.millis(500),
				                8, 8,
				                0, 124,
				                60, 62
				        );
				        animation.setCycleCount(1);
				        animation.setOnFinished(new EventHandler<ActionEvent>() {
			    	        @Override
			    	        public void handle(ActionEvent event) {
			    	            keyListener = true;
			    	        }
			    	    });
				        animation.play();
					}
					break;
    			}
    		if(moved) {
	    		Point2D pos = player.getPosition();
	    		Path path = new Path();
	    	    path.getElements().add(new MoveTo(startPos.getX() * 48 + 24, startPos.getY() * 48 + 24));
	    	    path.getElements().add(new LineTo(pos.getX() * 48 + 24, pos.getY() * 48 + 24));
	    	    PathTransition pathTransition = new PathTransition();
	    	    pathTransition.setDuration(Duration.millis(500));
	    	    pathTransition.setNode(creatureMap.get(player)); // Circle is built above
	    	    pathTransition.setPath(path);
	    	    pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
	    	        @Override
	    	        public void handle(ActionEvent event) {
	    	            keyListener = true;
	    	        }
	    	    });
	    	    pathTransition.play();	
    		}
    		else
    			keyListener = true;
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
    	if(currMap != controller.getCurrMap()) {
    		loadMap();
    	}
//    	for(Enemy enemy : controller.getEnemies()) {
//    		if(controller.enemyTurn(enemy) == Turn.MOVE) {
//    			Point2D pos = enemy.getPosition();
//				creatureMap.get(enemy).setTranslateX(pos.getX() * BLOCKWIDTH);
//				creatureMap.get(enemy).setTranslateY(pos.getY() * BLOCKHEIGHT);
//    		}
//    	}
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