
package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import animation.SpriteAnimation;
import controller.GameController;
import gameObjects.*;
import enums.*;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.GameMap;

public class MainView extends StackPane {
	int MAPHEIGHT = 14, MAPWIDTH = 18;
	int BLOCKHEIGHT = 48, BLOCKWIDTH = 48;
	private Pane pane;
	private Player player;
	private GameMap map;
	private List<GameObject> objects;
	private Map<Creature, ImageView> creatureMap;
	private GameController controller;
	private BorderPane bPane;
	private VBox pMenu;
	
	
    public MainView() {
    	bPane=new BorderPane();
    	this.getChildren().add(bPane);
    	
    	GameController.isPaused=false;
    	
    	/*------ Inventory Box  -----*/
    	VBox inventory=new VBox();
    	
    	
    	
    	/*-----   Pause Menu Buttons   --------- */
    	
		EventHandler<MouseEvent> mouseEnter=new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Button button=(Button) event.getTarget();
				button.setStyle("-fx-background-color: rgba(50,50,50,.5)");
			}			
		};
		
		
		EventHandler<MouseEvent> mouseExit=new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Button button=(Button) event.getTarget();
				
				button.setStyle("-fx-background-color: transparent;");
			}			
		};
		
		//vbox for all of the buttons
    	pMenu=new VBox();
    	pMenu.setPrefWidth(300);
    	pMenu.setStyle("-fx-background-color: rgba(50,50,50,.5);");
    	
    	ImageView pause=new ImageView(new Image("assets/paused.png", false));
    	VBox.setMargin(pause, new Insets(25,0,25,0));
    	
    	ImageView mapImg=new ImageView(new Image("assets/test.jpg", false));
    	
    	
    	Button inventButton=new Button();
    	inventButton.setId("invent");
    	inventButton.setGraphic(new ImageView(new Image("assets/inventory.png", false)));
		inventButton.setMinWidth(pMenu.getPrefWidth());
		inventButton.setStyle("-fx-background-color: transparent;"+
						"-fx-transition: color 0.2s ease-in;");
		
		inventButton.setOnMouseEntered(mouseEnter);
		inventButton.setOnMouseExited(mouseExit);
		inventButton.setOnAction(new ButtonHandler());
    	
		
    	Button saveButton=new Button();
    	saveButton.setId("save");
    	saveButton.setGraphic(new ImageView(new Image("assets/save.png", false)));
		saveButton.setMinWidth(pMenu.getPrefWidth());
		saveButton.setStyle("-fx-background-color: transparent;"+
						"-fx-transition: color 0.2s ease-in;");
		
		saveButton.setOnMouseEntered(mouseEnter);
		saveButton.setOnMouseExited(mouseExit);
		saveButton.setOnAction(new ButtonHandler());
		
		
    	Button loadButton=new Button();
    	loadButton.setId("load");
    	loadButton.setGraphic(new ImageView(new Image("assets/load.png", false)));
		loadButton.setMinWidth(pMenu.getPrefWidth());
		loadButton.setStyle("-fx-background-color: transparent;"+
						"-fx-transition: color 0.2s ease-in;");
		
		loadButton.setOnMouseEntered(mouseEnter);
		loadButton.setOnMouseExited(mouseExit);
		loadButton.setOnAction(new ButtonHandler());
		
		
    	Button quitButton=new Button();
    	quitButton.setId("quit");
    	quitButton.setGraphic(new ImageView(new Image("assets/quit.png", false)));
		quitButton.setMinWidth(pMenu.getPrefWidth());
		quitButton.setStyle("-fx-background-color: transparent;"+
						"-fx-transition: color 0.2s ease-in;");
		
		quitButton.setOnMouseEntered(mouseEnter);
		quitButton.setOnMouseExited(mouseExit);
		quitButton.setOnAction(new ButtonHandler());
    	
		
    	pMenu.getChildren().addAll(pause, mapImg, inventButton, saveButton, loadButton, quitButton);
    	
    	pMenu.setVisible(false);
    	
    	StackPane.setAlignment(pMenu, Pos.TOP_CENTER);
    	pMenu.setAlignment(Pos.TOP_CENTER);
    	this.getChildren().add(pMenu);
    	
    	controller = new GameController();
    	map = controller.getMapLayout();
    	creatureMap = new HashMap<Creature, ImageView>();
    	BorderPane window = new BorderPane();
    	pane = new Pane();
    	pane.setPrefSize(MAPWIDTH * BLOCKWIDTH, MAPHEIGHT * BLOCKHEIGHT);
    	pane.setBackground(new Background(new BackgroundImage(new Image(map.getMapString()), null, null, null, null)));
    	window.setCenter(pane);

    	TilePane tilePane = new TilePane();
    	window.setBottom(tilePane);

    	for(GameObject obstacle : map.getObjects()) {
    		addObject(obstacle);
    	}
    	for(Enemy enemy : map.getEnemies()) {
    		creatureMap.put(enemy, new ImageView(new Image(enemy.getImage())));
    		addObject(enemy);
    	}
//    	player = new Player(new Point2D(2,3));
//    	creatureMap.put(player, new ImageView(new Image("assets/adlez1.png")));
//    	creatureMap.get(player).setViewport(new Rectangle2D(0,0,60,62));
//    	addObject(player);
//    	}
    	player = controller.getPlayer();
    	creatureMap.put(player, new ImageView(new Image(player.getImage())));
    	creatureMap.get(player).setViewport(new Rectangle2D(0,0,60,62));
    	addObject(player);
    	
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
    	LegendOfAdlezView.mainScene.setOnKeyReleased(e -> {
    		/*
        	 * Controlls: Move player using either WASD or Arrows
        	 * 			  If Player is not facing the direction, the player will "turn"
        	 * 			  otherwise the player will move in the specified direction
        	 *            Space drops the weapon and leaves player vulnerable
        	 */
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
    					                Duration.millis(250),
    					                5, 5,
    					                0, 434,
    					                60, 62
    					        );
    					        animation.setCycleCount(1);
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
    				                Duration.millis(250),
    				                8, 8,
    				                0, 62,
    				                60, 62
    				        );
    				        animation.setCycleCount(1);
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
    				                Duration.millis(250),
    				                8, 8,
    				                0, 0,
    				                60, 62
    				        );
    				        animation.setCycleCount(1);
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
    				                Duration.millis(250),
    				                8, 8,
    				                0, 186,
    				                60, 62
    				        );
    				        animation.setCycleCount(1);
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
    	    	    pathTransition.setDuration(Duration.millis(250));
    	    	    pathTransition.setNode(creatureMap.get(player)); // Circle is built above
    	    	    pathTransition.setPath(path);
    	    	    pathTransition.play();	
        		}
        	});
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
    
    
    /*
     * Checks for collision between the player and any weapons or enemies.
     * If player is colliding with a weapon, player picks it up. Having weapon
     * allows enemies to be defeated.
     */
    public void onUpdate() {
    
    	pMenu.setVisible(GameController.isPaused);
    	if(GameController.isPaused) {
    		bPane.setEffect(new GaussianBlur());
    		return;
    	}
    	
    	bPane.setEffect(null);
    	for(Enemy enemy : map.getEnemies())
    		if(controller.enemyTurn(enemy) == Turn.MOVE) {
    			Point2D pos = enemy.getPosition();
				creatureMap.get(enemy).setTranslateX(pos.getX() * BLOCKWIDTH);
				creatureMap.get(enemy).setTranslateY(pos.getY() * BLOCKHEIGHT);
    		}
    }
    
    
    private class ButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent arg0) {
			Button button=(Button) arg0.getSource();
			
			//continue and save file exists
			if(button.getId().equals("load") && !button.isDisabled()) {
				
			}
			
			//boot up a new game
			else if(button.getId().equals("save")) {
			}
			
			//quit the game
			else if(button.getId().equals("quit")) {
				LegendOfAdlezView.changeView(new StartMenuView());
				//Platform.exit();
			}
			
		}
    	
    }

}  





