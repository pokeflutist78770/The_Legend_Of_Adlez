package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import java.awt.Point;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.GameMap;

public class MainView extends StackPane {
	int MAPHEIGHT = 14, MAPWIDTH = 18;
	int BLOCKHEIGHT = 48, BLOCKWIDTH = 48;
	private Pane pane;
	private Player player;
	private GameMap map;

	private MapScreen currMap;
	private Map<GameObject, ImageView> creatureMap;

	private VBox pMenu;
	private VBox kMenu;
	private VBox wMenu;
	private BorderPane window;

	private GameController controller;
	private boolean keyListener = true;
	private boolean transaction = false;
	private int price = 0;
	private ImageView textBox = new ImageView();
	StackPane healthStack;
	Label health;
	StackPane coinStack;
	Label coins; 

	public void loadMap() {
		currMap = controller.getCurrMap();
		LegendOfAdlezView.playBackground(currMap.getMusic());
		
		map = controller.getMapLayout();
		pane.getChildren().clear();
		pane.setBackground(new Background(
				new BackgroundImage(new Image(controller.getMapLayout().getMapString()), null, null, null, null)));
		creatureMap = new HashMap<GameObject, ImageView>();
		creatureMap.put(player, new ImageView(new Image(player.getImage())));
		addObject(player);
		switch (player.getDirection()) {
		case NORTH:
			creatureMap.get(player).setViewport(new Rectangle2D(0, 62, 60, 62));
			break;
		case SOUTH:
			creatureMap.get(player).setViewport(new Rectangle2D(0, 0, 60, 62));
			break;
		case EAST:
			creatureMap.get(player).setViewport(new Rectangle2D(420, 186, 60, 62));
			break;
		case WEST:
			creatureMap.get(player).setViewport(new Rectangle2D(0, 124, 60, 62));
			break;
		}
		for (GameObject obstacle : controller.getObstacles()) {
			addObject(obstacle);
		}
		for (Transition obstacle : controller.getTransitions()) {
			addObject(obstacle);
		}
		for (Enemy enemy : controller.getEnemies()) {
			if (enemy instanceof Slime) {
				ImageView sprite = new ImageView(new Image(enemy.getImage()));
				sprite.setViewport(new Rectangle2D(0, 0, 48, 48));
				creatureMap.put(enemy, sprite);
			} else if (enemy instanceof Scorpion) {
				ImageView sprite = new ImageView(new Image(enemy.getImage()));
				sprite.setViewport(new Rectangle2D(0, 0, 48, 48));
				creatureMap.put(enemy, sprite);
			} else if (enemy instanceof Poe) {
				ImageView sprite = new ImageView(new Image(enemy.getImage()));
				sprite.setViewport(new Rectangle2D(0, 0, 48, 48));
				creatureMap.put(enemy, sprite);
			} else {
				ImageView sprite = new ImageView(new Image(enemy.getImage()));
				sprite.setViewport(new Rectangle2D(0, 0, 48, 48));
				creatureMap.put(enemy, sprite);
			}
			addObject(enemy);
		}
		if(controller.getCurrMap() == MapScreen.SHOP){
			Sword displaySword = new Sword(new Point(5,8));
			BigPotion displayPotion = new BigPotion(new Point(7,8));
			ShopKeeper displayShopKeeper = new ShopKeeper(new Point(11,7));
			addObject(displaySword);
			addObject(displayPotion);
			addObject(displayShopKeeper);
			
		}
		pane.getChildren().add(healthStack);
		pane.getChildren().add(coinStack);
	}

	public MainView(boolean loadFile) {
		GameController.isPaused = false;
		/*-----   Pause Menu Buttons   --------- */

		EventHandler<MouseEvent> mouseEnter = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Button button = (Button) event.getTarget();
				button.setStyle("-fx-background-color: rgba(50,50,50,.5)");
				LegendOfAdlezView.play("menu_change");
			}
		};

		EventHandler<MouseEvent> mouseExit = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Button button = (Button) event.getTarget();

				button.setStyle("-fx-background-color: transparent;");
			}
		};

		// vbox for all of the buttons
		pMenu = new VBox();
		pMenu.setPrefWidth(300);
		pMenu.setStyle("-fx-background-color: rgba(50,50,50,.5);");

		ImageView pause = new ImageView(new Image("assets/paused.png", false));
		VBox.setMargin(pause, new Insets(25, 0, 25, 0));
		
		//MenuMap
		ImageView mapImg = new ImageView(new Image("assets/MenuMapT.png", false));

		Button saveButton = new Button();
		saveButton.setId("save");
		saveButton.setGraphic(new ImageView(new Image("assets/save.png", false)));
		saveButton.setMinWidth(pMenu.getPrefWidth());
		saveButton.setStyle("-fx-background-color: transparent;" + "-fx-transition: color 0.2s ease-in;");

		saveButton.setOnMouseEntered(mouseEnter);
		saveButton.setOnMouseExited(mouseExit);
		saveButton.setOnAction(new ButtonHandler());

		Button loadButton = new Button();
		loadButton.setId("load");
		loadButton.setGraphic(new ImageView(new Image("assets/load.png", false)));
		loadButton.setMinWidth(pMenu.getPrefWidth());
		loadButton.setStyle("-fx-background-color: transparent;" + "-fx-transition: color 0.2s ease-in;");

		loadButton.setOnMouseEntered(mouseEnter);
		loadButton.setOnMouseExited(mouseExit);
		loadButton.setOnAction(new ButtonHandler());

		Button quitButton = new Button();
		quitButton.setId("quit");
		quitButton.setGraphic(new ImageView(new Image("assets/quit.png", false)));
		quitButton.setMinWidth(pMenu.getPrefWidth());
		quitButton.setStyle("-fx-background-color: transparent;" + "-fx-transition: color 0.2s ease-in;");

		quitButton.setOnMouseEntered(mouseEnter);
		quitButton.setOnMouseExited(mouseExit);
		quitButton.setOnAction(new ButtonHandler());

		pMenu.getChildren().addAll(pause, mapImg, saveButton, loadButton, quitButton);

		pMenu.setVisible(false);
		
		// vbox for kill screen
		kMenu = new VBox();
		kMenu.setPrefWidth(300);
		kMenu.setStyle("-fx-background-color: rgba(50,50,50,.5);");
		Button killQuitButton = new Button();
		killQuitButton.setId("quit");
		killQuitButton.setGraphic(new ImageView(new Image("assets/quit.png", false)));
		killQuitButton.setMinWidth(pMenu.getPrefWidth());
		killQuitButton.setStyle("-fx-background-color: transparent;" + "-fx-transition: color 0.2s ease-in;");

		killQuitButton.setOnMouseEntered(mouseEnter);
		killQuitButton.setOnMouseExited(mouseExit);
		killQuitButton.setOnAction(new ButtonHandler());
		ImageView youDied = new ImageView(new Image("assets/dead.png", false));
		VBox.setMargin(youDied, new Insets(25, 0, 25, 0));
		kMenu.getChildren().addAll(youDied, killQuitButton);
		kMenu.setVisible(false);

		// vbox for win screen
		wMenu = new VBox();
		wMenu.setPrefWidth(300);
		wMenu.setStyle("-fx-background-color: rgba(50,50,50,.5);");
		Button winQuitButton = new Button();
		winQuitButton.setId("quit");
		winQuitButton.setGraphic(new ImageView(new Image("assets/quit.png", false)));
		winQuitButton.setMinWidth(pMenu.getPrefWidth());
		winQuitButton.setStyle("-fx-background-color: transparent;" + "-fx-transition: color 0.2s ease-in;");

		winQuitButton.setOnMouseEntered(mouseEnter);
		winQuitButton.setOnMouseExited(mouseExit);
		winQuitButton.setOnAction(new ButtonHandler());
		ImageView youWin = new ImageView(new Image("assets/youWin.png", false));
		VBox.setMargin(youDied, new Insets(25, 0, 25, 0));
		wMenu.getChildren().addAll(youWin, winQuitButton);
		wMenu.setVisible(false);
		
		// we want to load a save file
		if (loadFile) {
			File file = new File(GameController.SAVE_FILE);
			try {
				ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file));
				controller = (GameController) stream.readObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			controller = new GameController();
		}

		map = controller.getMapLayout();
		currMap = controller.getCurrMap();
		creatureMap = new HashMap<GameObject, ImageView>();
		window = new BorderPane();
		this.getChildren().add(window);

		StackPane.setAlignment(pMenu, Pos.TOP_CENTER);
		StackPane.setAlignment(kMenu, Pos.CENTER);
		StackPane.setAlignment(wMenu, Pos.CENTER);
		pMenu.setAlignment(Pos.TOP_CENTER);
		kMenu.setAlignment(Pos.CENTER);
		wMenu.setAlignment(Pos.CENTER);
		this.getChildren().addAll(pMenu,kMenu,wMenu);

		pane = new Pane();
		pane.setPrefSize(MAPWIDTH * BLOCKWIDTH, MAPHEIGHT * BLOCKHEIGHT);
		window.setCenter(pane);

		TilePane tilePane = new TilePane();
		window.setBottom(tilePane);

		player = controller.getPlayer();
		health = new Label();
		coins = new Label();
		healthStack = new StackPane();
		coinStack = new StackPane();
		coinStack.setTranslateX(50);
		healthStack.getChildren().addAll(new ImageView(new Image("assets/heart.png")), health);
		coinStack.getChildren().addAll(new ImageView(new Image("assets/goldCoin.png")), coins);
		loadMap();
		/*
		 * Continous loop functioning as the games internal "clock". Screen updates on
		 * each tick.
		 */
		AnimationTimer timer = new AnimationTimer() {
			private long lastUpdate = 0;

			@Override
			public void handle(long now) {
				if (currMap != controller.getCurrMap()) {
					loadMap();
				}
				if (now - lastUpdate >= 850_000_000) {
					onUpdate();
					lastUpdate = now;
				}
			}
		};
		timer.start();

		/*
		 * Controlls: Move player using either WASD or Arrows If Player is not facing
		 * the direction, the player will "turn" otherwise the player will move in the
		 * specified direction Space drops the weapon and leaves player vulnerable
		 */
		LegendOfAdlezView.mainScene.setOnKeyPressed(e -> {
			/*
			 * Controlls: Move player using either WASD or Arrows If Player is not facing
			 * the direction, the player will "turn" otherwise the player will move in the
			 * specified direction Space drops the weapon and leaves player vulnerable
			 */
			if (!keyListener)
				return;
			keyListener = false;
			boolean moved = false;
			boolean interact = false;
			GameObject interacted = null;
			Point startPos = player.getPosition();
			switch (e.getCode()) {
			default:
				break;

			case P:{
				if(transaction) {
					textBox.setImage(null);
					transaction = false;
				}
				player.usePotion();
				}
			case B:{
				if(transaction) {
					textBox.setImage(null);
					if (player.getCurrentMoney() < price) {
						textBox.setImage(new Image("assets/NotEnough.png"));
					} else {
						textBox.setImage(new Image("assets/ItemAdded.png"));
						buyItem(price, player);

					}

					break;
				}
				break;
			}
				
			case SPACE: {
				controller.playerAttack();
				if (transaction) {
					textBox.setImage(null);
					transaction = false;
				}
				//this is a special case where both sounds need to be played at the same 
				//time
				new AudioClip("file:src/assets/attack.wav").play();
				new AudioClip("file:src/assets/sword_swoosh.wav").play();;
				
				switch (player.getDirection()) {
				case NORTH: {
					Point potentialInteractable = new Point((int) player.getPosition().getX(),
							(int) player.getPosition().getY() - 1);
					for (GameObject object : controller.getObstacles()) {
						if (object.getPosition().equals(potentialInteractable) && (object instanceof ShopItem)) {
							interact = true;
							interacted = object;
							break;
						}
					} 
					if (interact) {
						transaction = true;
						ShopItem shopI = (ShopItem) interacted;
						if (shopI.getItemNum() == 1) {
							textBox = new ImageView(new Image("assets/SwordBuy.png"));
							pane.getChildren().add(textBox);
							price = 25;
						} else if (shopI.getItemNum() == 2){
							textBox = new ImageView(new Image("assets/PotionBuy.png"));
							pane.getChildren().add(textBox);
							price = 10;
						}
						else {
							if (player.hasKey() ) {
								pane.setBackground(new Background(new BackgroundImage(new Image("assets/bossRoomOpen.png"), null, null, null, null)));
								ShopItem door = null;
								for (GameObject object: controller.getObstacles()) {
									if (object instanceof ShopItem) {
										door = (ShopItem) object;
										break;
									}
								}
								controller.getObstacles().remove(door);
							}
						}
						break;
					} else {
						if (player.getEquippedItem() instanceof Dagger) {
							Animation animation = new SpriteAnimation(creatureMap.get(player), Duration.millis(250), 2,
									2, 60, 434, 60, 62);
							animation.setCycleCount(1);
							animation.play();
							interact = true;
							break;
						}
						Animation animation = new SpriteAnimation(creatureMap.get(player), Duration.millis(250), 5, 5,
								0, 434, 60, 62);
						animation.setCycleCount(1);
						animation.setOnFinished(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								keyListener = true;
							}
						});
						animation.play();
						interact = true;
						creatureMap.get(player).setViewport(new Rectangle2D(0, 62, 60, 62));
						break;
					}
				}
				case SOUTH: {
					if (player.getEquippedItem() instanceof Dagger) {
						Animation animation = new SpriteAnimation(creatureMap.get(player), Duration.millis(250), 2, 2,
								120, 248, 60, 62);
						animation.setCycleCount(1);
						animation.play();
						interact = true;
						break;
					}
					Animation animation = new SpriteAnimation(creatureMap.get(player), Duration.millis(250), 6, 6, 0,
							248, 60, 62);
					animation.setCycleCount(1);
					animation.setOnFinished(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							keyListener = true;
						}
					});
					animation.play();
					interact = true;
					creatureMap.get(player).setViewport(new Rectangle2D(0, 0, 60, 62));
					break;
				}
				case EAST: {
					if (player.getEquippedItem() instanceof Dagger) {
						Animation animation = new SpriteAnimation(creatureMap.get(player), Duration.millis(250), 2, 2,
								60, 372, 60, 62);
						animation.setCycleCount(1);
						animation.play();
						interact = true;
						break;
					}
					Animation animation = new SpriteAnimation(creatureMap.get(player), Duration.millis(250), 5, 5, 0,
							372, 60, 62);
					animation.setCycleCount(1);
					animation.setOnFinished(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							keyListener = true;
						}
					});
					animation.play();
					interact = true;
					creatureMap.get(player).setViewport(new Rectangle2D(420, 186, 60, 62));
					break;
				}
				case WEST: {
					if (player.getEquippedItem() instanceof Dagger) {
						Animation animation = new SpriteAnimation(creatureMap.get(player), Duration.millis(250), 2, 2,
								60, 310, 60, 62);
						animation.setCycleCount(1);
						animation.play();
						interact = true;
						break;
					}
					Animation animation = new SpriteAnimation(creatureMap.get(player), Duration.millis(250), 5, 5, 0,
							310, 60, 62);
					animation.setCycleCount(1);
					animation.setOnFinished(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							keyListener = true;
						}
					});
					animation.play();
					interact = true;
					creatureMap.get(player).setViewport(new Rectangle2D(0, 124, 60, 62));
					break;
				}
				}
			}
				if (interact)
					break;
				
			case W:
			case UP:
				if(GameController.isPaused || controller.won || controller.died) return;
				
				if (transaction) {
					textBox.setImage(null);
					transaction = false;
				}
				moved = controller.move(player, Direction.NORTH);
				if (!moved) {
					creatureMap.get(player).setViewport(new Rectangle2D(0, 62, 60, 62));
				} else {
					Animation animation = new SpriteAnimation(creatureMap.get(player), Duration.millis(250), 8, 8, 0,
							62, 60, 62);
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
				if(GameController.isPaused || controller.won || controller.died) return;
				if (transaction) {
					textBox.setImage(null);
					transaction = false;
				}
				moved = controller.move(player, Direction.SOUTH);
				if (!moved) {
					creatureMap.get(player).setViewport(new Rectangle2D(0, 0, 60, 62));
				} else {
					Animation animation = new SpriteAnimation(creatureMap.get(player), Duration.millis(250), 8, 8, 0, 0,
							60, 62);
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
				if(GameController.isPaused || controller.won || controller.died) return;
				if (transaction) {
					textBox.setImage(null);
					transaction = false;
				}
				moved = controller.move(player, Direction.EAST);
				if (!moved) {
					creatureMap.get(player).setViewport(new Rectangle2D(420, 186, 60, 62));
				} else {
					Animation animation = new SpriteAnimation(creatureMap.get(player), Duration.millis(250), 8, 8, 0,
							186, 60, 62);
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
				if(GameController.isPaused || controller.won || controller.died) return;
				if (transaction) {
					textBox.setImage(null);
					transaction = false;
				}
				moved = controller.move(player, Direction.WEST);
				if (!moved) {
					creatureMap.get(player).setViewport(new Rectangle2D(0, 124, 60, 62));
				} else {
					Animation animation = new SpriteAnimation(creatureMap.get(player), Duration.millis(500), 8, 8, 0,
							124, 60, 62);
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

			case ESCAPE:
				GameController.isPaused = !GameController.isPaused;
			}
			if (moved) {
				Point pos = player.getPosition();
				Path path = new Path();
				path.getElements().add(new MoveTo(startPos.getX() * 48 + 24, startPos.getY() * 48 + 24));
				path.getElements().add(new LineTo(pos.getX() * 48 + 24, pos.getY() * 48 + 24));
				PathTransition pathTransition = new PathTransition();
				pathTransition.setDuration(Duration.millis(250));
				pathTransition.setNode(creatureMap.get(player)); // Circle is built above
				pathTransition.setPath(path);
				pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						keyListener = true;
					}
				});
				pathTransition.play();
			} else
				keyListener = true;
		});
		
	
	}
	

	/**
	 * Adds object to view at specified x/y coordinate on grid.
	 */
	public void addObject(GameObject object) {
		double x = object.getPosition().getX() * BLOCKWIDTH;
		double y = object.getPosition().getY() * BLOCKHEIGHT;
		ImageView image;
		if (creatureMap.containsKey(object)) {
			image = creatureMap.get(object);
		}
		else if(object instanceof Item || object instanceof Money) {
			image = new ImageView(new Image(object.getImage()));
		}
		else {
			image = new ImageView();
		}
		image.setTranslateX(x);
		image.setTranslateY(y);
		pane.getChildren().add(image);
	}

	/*
	 * Checks for collision between the player and any weapons or enemies. If player
	 * is colliding with a weapon, player picks it up. Having weapon allows enemies
	 * to be defeated.
	 */
	public void onUpdate() {
		health.setText(String.valueOf(player.getCurrentHP()));
		coins.setText(String.valueOf(player.getCurrentMoney()));
		kMenu.setVisible(controller.died);
		
		if (controller.died) {
			window.setEffect(new GaussianBlur());
			for(Enemy enemy : controller.getEnemies()) {
				enemy.setActive(false);
				pane.getChildren().remove(creatureMap.get(enemy));
			}
			return;
        }
		
		wMenu.setVisible(controller.won);
		
		if (controller.won) {
			window.setEffect(new GaussianBlur());
			return;
        }
		
		
		pMenu.setVisible(GameController.isPaused);
		kMenu.setVisible(false);
		
		
		if (GameController.isPaused) {
			keyListener = true;
			window.setEffect(new GaussianBlur());
			return;
		}
		window.setEffect(null);

		if (currMap != controller.getCurrMap()) {
			loadMap();
		}
		for (Enemy enemy : map.getEnemies()) {
			if (enemy.getActive()) {
				Point startPos = enemy.getPosition();
				switch (controller.enemyTurn(enemy)) {
				default:
					break;
				case ATTACK:
					LegendOfAdlezView.play(enemy.getAttackSound());
					Timeline timeline = new Timeline(
							new KeyFrame(Duration.seconds(0.05), evt -> creatureMap.get(player).setVisible(false)),
							new KeyFrame(Duration.seconds(0.1), evt -> creatureMap.get(player).setVisible(true)));
					timeline.setCycleCount(4);
					timeline.play();
					break;
				case MOVE:
					Point pos = enemy.getPosition();
					Path path = new Path();
					path.getElements().add(new MoveTo(startPos.getX() * 48 + 24, startPos.getY() * 48 + 24));
					path.getElements().add(new LineTo(pos.getX() * 48 + 24, pos.getY() * 48 + 24));
					PathTransition pathTransition = new PathTransition();
					pathTransition.setDuration(Duration.millis(750));
					pathTransition.setNode(creatureMap.get(enemy));
					pathTransition.setPath(path);
					pathTransition.play();
					if (enemy instanceof Slime || enemy instanceof Scorpion) {
						switch (enemy.getDirection()) {
						case NORTH: {
							Animation animation = new SpriteAnimation(creatureMap.get(enemy), Duration.millis(750), 3,
									3, 0, 144, 48, 48);
							animation.setCycleCount(1);
							animation.play();
							break;
						}
						case SOUTH: {
							Animation animation = new SpriteAnimation(creatureMap.get(enemy), Duration.millis(750), 3,
									3, 0, 0, 48, 48);
							animation.setCycleCount(1);
							animation.play();
							break;
						}
						case EAST: {
							Animation animation = new SpriteAnimation(creatureMap.get(enemy), Duration.millis(750), 3,
									3, 0, 96, 48, 48);
							animation.setCycleCount(1);
							animation.play();
							break;
						}
						case WEST: {
							Animation animation = new SpriteAnimation(creatureMap.get(enemy), Duration.millis(750), 3,
									3, 0, 48, 48, 48);
							animation.setCycleCount(1);
							animation.play();
							break;
						}
						default:
							break;
						}
					} else if (enemy instanceof Poe) {
						Animation animation = new SpriteAnimation(creatureMap.get(enemy), Duration.millis(1), 10, 10, 0,
								0, 48, 48);
						animation.setCycleCount(1);
						animation.play();
					} else {
						switch (enemy.getDirection()) {
						case NORTH: {
							Animation animation = new SpriteAnimation(creatureMap.get(enemy), Duration.millis(750), 3,
									3, 288, 0, 48, 48);
							animation.setCycleCount(1);
							animation.play();
							break;
						}
						case SOUTH: {
							Animation animation = new SpriteAnimation(creatureMap.get(enemy), Duration.millis(750), 3,
									3, 0, 0, 48, 48);
							animation.setCycleCount(1);
							animation.play();
							break;
						}
						case EAST: {
							Animation animation = new SpriteAnimation(creatureMap.get(enemy), Duration.millis(750), 3,
									3, 144, 0, 48, 48);
							animation.setCycleCount(1);
							animation.play();
							break;
						}
						case WEST: {
							Animation animation = new SpriteAnimation(creatureMap.get(enemy), Duration.millis(750), 3,
									3, 432, 0, 48, 48);
							animation.setCycleCount(1);
							animation.play();
							break;
						}
						default:
							break;
						}
					}
				}
			}
			//this is where the change should be
			else {
				if(enemy instanceof Slime|| enemy instanceof Scorpion || enemy instanceof Poe) {
					Money drop = null;
					if(enemy instanceof Slime) {
						drop = new SmallMoney(enemy.getPosition());
					}
					else if(enemy instanceof Scorpion) {
						drop = new MediumMoney(enemy.getPosition());
					}
					else if(enemy instanceof Poe) {
						drop = new LargeMoney(enemy.getPosition());
					}
					pane.getChildren().remove(creatureMap.get(enemy));
					if(!enemy.hasDropped()) {
						creatureMap.put(drop,new ImageView( new Image(drop.getImage())));
						addObject(drop);
						drop.setIndex(controller.getObstacles().size() -1);
						enemy.setDropped(true);
					}
					controller.addObject(drop);
				}
				//key drop
				else {
					Key drop = new Key(enemy.getPosition());
					pane.getChildren().remove(creatureMap.get(enemy));
					if(!enemy.hasDropped()) {
						creatureMap.put(drop,new ImageView( new Image(drop.getImage())));
						addObject(drop);
						drop.setIndex(controller.getObstacles().size()-1);
						enemy.setDropped(true);
					}
					controller.addObject(drop);
					
				}
			}
			
		}
		ArrayList<GameObject> indexs = new ArrayList<GameObject>();
		for (GameObject object : controller.getObstacles()) {
			if (!object.getActive()) {
				pane.getChildren().remove(creatureMap.get(object));
				if(object instanceof Money) {
					indexs.add(object);
				}
				if(object instanceof Key) {
					indexs.add(object);
				}
			}
		}
		for(GameObject in: indexs) {
			controller.getObstacles().remove(in);
		}
	}

	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			Button button = (Button) arg0.getSource();

			// continue and save file exists
			if (button.getId().equals("load") && !button.isDisabled()) {
				LegendOfAdlezView.changeView(new MainView(true));
			}

			// boot up a new game
			else if (button.getId().equals("save")) {
				File file = new File(GameController.SAVE_FILE);
				ObjectOutputStream stream;
				try {
					stream = new ObjectOutputStream(new FileOutputStream(file));
					stream.writeObject(controller);
					stream.close();
					LegendOfAdlezView.play("save");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			// quit the game
			else if (button.getId().equals("quit")) {
				for(MapScreen screen : MapScreen.values()){
					if(controller.getMaps().containsKey(screen)) {
						ArrayList<Enemy> enemies = controller.getMaps().get(screen).getEnemies();
						enemies.removeAll(enemies);
					}
				}
				controller = new GameController();
				LegendOfAdlezView.changeView(new StartMenuView());
				// Platform.exit();
			}
		}
    }
	
    public void buyItem(int price, Player player ) {
    	if(price == 25) {
    		player.setCurrentMoney(player.getCurrentMoney() - 25);
    		player.setEquippedItem(new Sword(null));
    		player.addInventory(new Sword(null));
    	}
    	else {
    		player.setCurrentMoney(player.getCurrentMoney() - 10);
    		player.upPotionCount();
    	}
    }
 }   
