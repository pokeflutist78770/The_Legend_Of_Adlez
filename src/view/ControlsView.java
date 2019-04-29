package view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ControlsView extends StackPane{

	
	public ControlsView() {
		Image image=new Image("assets/new_background.png", false);
		ImageView imageView=new ImageView(image);
		
		this.getChildren().add(imageView);
		
		setup();
	}
	
	
	private void setup() {
		
		Image continueImg=new Image("assets/back.png", false);
		Button backButton=new Button();
		backButton.setId("Back");
		backButton.setGraphic(new ImageView(continueImg));
		backButton.setStyle("-fx-background-color: transparent;"+
						"-fx-transition: color 0.2s ease-in;");
						
		backButton.setOnAction(e -> {
			LegendOfAdlezView.changeView(new StartMenuView());
		});
		
		backButton.setOnMouseEntered(e -> {
			Button button=(Button) e.getTarget();
			button.setStyle("-fx-background-color: rgba(50,50,50,.5)");
		});
		
		backButton.setOnMouseExited(e -> {
			Button button=(Button) e.getTarget();
			
			button.setStyle("-fx-background-color: transparent;");
		});
		
		Image image=new Image("assets/controls.png", false);
		ImageView logoView=new ImageView(image);
		
		StackPane.setAlignment(backButton, Pos.TOP_LEFT);
		StackPane.setMargin(backButton, new Insets(10,0,0,10));
		
		// Set instruction text
		Label instructions = new Label("↑   : Move up\n"+
									 "↓   : Move down\n"+
									 "→ : Move right\n"+
									 "← : Move Left\n\n"+
									 "SPACE : Use/Attack\n"+
									 "ESC/P : Pause\n");
		instructions.setMinWidth(400);
		instructions.setMinHeight(400);
		instructions.setAlignment(Pos.CENTER);
		
		instructions.setStyle("-fx-font: 30 serif;\n" + "-fx-background-color: rgba(50,50,50,.5);");
		instructions.setTextFill(Color.WHITE);
		
		VBox center=new VBox();
		center.getChildren().addAll(logoView, instructions);
		
		StackPane.setAlignment(center, Pos.TOP_CENTER);
		
		center.setAlignment(Pos.CENTER);
		
		this.getChildren().add(center);
		this.getChildren().add(backButton);
	}
}




