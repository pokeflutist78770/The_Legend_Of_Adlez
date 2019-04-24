package view;

import java.io.InputStream;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class StartMenuView extends StackPane{
	private Image background;
	
	
	public StartMenuView() {
		Image image=new Image("assets/background.jpg", false);
		ImageView imageView=new ImageView(image);
		
		this.getChildren().add(imageView);
		
		setup();
	}
	
	
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
		menuBox.setStyle("-fx-border-color: grey;\r\n" + 
				"    -fx-border-insets: 5;\r\n" + 
				"    -fx-border-width: 3;\r\n" + 
				"    ;");
		
		
		Image continueImg=new Image("assets/continue.png", false);
		Button cont=new Button();
		cont.setGraphic(new ImageView(continueImg));
		cont.setMinWidth(menuBox.getPrefWidth());
		
		cont.setStyle("-fx-color: white;"+
		"-fx-border: none;"+
		"-fx-outline: none;"+
		"-fx-display: block;"+
		"-fx-position: relative;"+
		"-fx-font-family: Medula One;"+
		"-fx-text-decoration: none;"+
		"-fx-background-color: transparent;"+
		"-fx-transition: color 0.2s ease-in;");

		
		Image newImg=new Image("assets/newGame.png", false);
		Button newGame=new Button();
		newGame.setGraphic(new ImageView(newImg));
		newGame.setMinWidth(menuBox.getPrefWidth());
		
		Image controlImg=new Image("assets/controls.png", false);
		Button control=new Button();
		control.setGraphic(new ImageView(controlImg));
		control.setMinWidth(menuBox.getPrefWidth());
		
		Image quitImg=new Image("assets/quit.png", false);
		Button quit=new Button();
		quit.setGraphic(new ImageView(quitImg));
		quit.setMinWidth(menuBox.getPrefWidth());
		
		
		menuBox.getChildren().addAll(cont, newGame, control, quit);
		
		BorderPane.setAlignment(menuBox, Pos.CENTER);
		pane.setCenter(menuBox);
	
	}
}
