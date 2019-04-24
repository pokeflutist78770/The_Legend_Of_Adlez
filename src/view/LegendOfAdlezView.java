package view;

import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LegendOfAdlezView extends Application{
	
	private HashMap<String, Image> imageMap;
	
	
	public static void main(String args[]) {
		launch(args);
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("The  Legend of Adlez");
		
		StartMenuView startView=new StartMenuView();
		
		Scene scene=new Scene(startView, 864,672);
		
		setupImages();
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
	
	private static void setupImages() {
		
	}
}
