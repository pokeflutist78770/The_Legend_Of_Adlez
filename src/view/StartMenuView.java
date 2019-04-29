package view;

import java.io.File;
import java.io.InputStream;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class StartMenuView extends StackPane{
	private Image background;
	
	
	public StartMenuView() {
		Image image=new Image("assets/new_background.png", false);
		ImageView imageView=new ImageView(image);
		
		this.getChildren().add(imageView);
		
		setup();
	}
	
	
	/**
	 * Performs setup for the start menu. This sets up all UI elements, from buttons, to
	 * titles, as well as background images and implementation
	 */
	private void setup() {
		BorderPane pane=new BorderPane();
		
		Image image=new Image("assets/Logo.png", false);
		ImageView logoView=new ImageView(image);
		pane.setTop(logoView);
		BorderPane.setAlignment(logoView, Pos.TOP_CENTER);
		BorderPane.setMargin(logoView, new Insets(50,0,0,0));
		this.getChildren().add(pane);
		
		
		// Black Background Canvas
		Canvas canvas = new Canvas(400,400);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.setGlobalAlpha(.5);
		gc.setFill(Color.BLACK);
		gc.setStroke(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		pane.setCenter(canvas); 
		
		
		VBox menuBox=new VBox();
		menuBox.setMaxHeight(350);
		menuBox.setMaxWidth(350);
		menuBox.setPrefWidth(350);
		menuBox.setPrefHeight(350);
		menuBox.setPickOnBounds(false);
		BorderPane.setAlignment(menuBox, Pos.TOP_CENTER);
		
		
		/*---------------  Set Up Buttons  ----------------------*/
		
		File file=new File("save_file.dat");
		Image continueImg=new Image("assets/continue.png", false);
		
		
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
		
		//CONTINUE BUTTON
		
		Button contButton=new Button();
		contButton.setId("Continue");
		
		//save file doesnt exist, disbale button
		if(!file.exists()) {
			contButton.setDisable(true);
		}
		
		contButton.setGraphic(new ImageView(continueImg));
		contButton.setMinWidth(menuBox.getPrefWidth());
		contButton.setStyle("-fx-background-color: transparent;"+
						"-fx-transition: color 0.2s ease-in;");

		
		
		//NEW GAME BUTTON
		
		Image newImg=new Image("assets/newGame.png", false);
		Button newGameButton=new Button();
		newGameButton.setId("New Game");
		newGameButton.setGraphic(new ImageView(newImg));
		newGameButton.setMinWidth(menuBox.getPrefWidth());
		newGameButton.setStyle("-fx-background-color: transparent;"+
				"-fx-transition: color 0.2s ease-in;");
		
		
		
		//CONTROLS BUTTON
		
		Image controlImg=new Image("assets/controls.png", false);
		Button controlButton=new Button();
		controlButton.setId("Controls");
		controlButton.setGraphic(new ImageView(controlImg));
		controlButton.setMinWidth(menuBox.getPrefWidth());
		controlButton.setStyle("-fx-background-color: transparent;"+
				"-fx-transition: color 0.2s ease-in;");
		
		
		//QUIT BUTTON
		
		Image quitImg=new Image("assets/quit.png", false);
		Button quitButton=new Button();
		quitButton.setId("Quit");
		quitButton.setGraphic(new ImageView(quitImg));
		quitButton.setMinWidth(menuBox.getPrefWidth());
		quitButton.setStyle("-fx-background-color: transparent;"+
				"-fx-transition: color 0.2s ease-in;");
		
		menuBox.getChildren().addAll(contButton, newGameButton, controlButton, quitButton);
		
		
		/*--- Set up button handlers ---*/
		
		contButton.setOnAction(new ButtonHandler());
		contButton.setOnMouseEntered(mouseEnter);
		contButton.setOnMouseExited(mouseExit);
		
		newGameButton.setOnAction(new ButtonHandler());
		newGameButton.setOnMouseEntered(mouseEnter);
		newGameButton.setOnMouseExited(mouseExit);
		
		controlButton.setOnAction(new ButtonHandler());
		controlButton.setOnMouseEntered(mouseEnter);
		controlButton.setOnMouseExited(mouseExit);
		
		
		quitButton.setOnAction(new ButtonHandler());
		quitButton.setOnMouseEntered(mouseEnter);
		quitButton.setOnMouseExited(mouseExit);
		
		
		BorderPane.setAlignment(menuBox, Pos.CENTER);
		pane.setCenter(menuBox);
	}
	
	
	/**
	 * Handles any button clicks
	 * @author aagua
	 *
	 */
	private class ButtonHandler implements EventHandler<ActionEvent> {

		/**
		 * handle the potential event of a button click
		 */
		@Override
		public void handle(ActionEvent arg0) {
			Button button=(Button) arg0.getSource();
			System.out.println(button.getId());
			
			//continue and save file exists
			if(button.getId().equals("Continue") && !button.isDisabled()) {
				
			}
			
			//boot up a new game
			else if(button.getId().equals("New Game")) {
				
			}
			
			//display controls
			else if(button.getId().equals("Controls")) {
				LegendOfAdlezView.changeView(new ControlsView());
			}
			
			//quit the game
			else if(button.getId().equals("Quit")) {
				Platform.exit();
			}
		}
	}
}





