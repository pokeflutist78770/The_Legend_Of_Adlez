

import java.util.HashMap;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import view.StartMenuView;

public class LegendOfAdlezView extends Application{
	private static StackPane mainPane;
	static Scene mainScene;
	private HashMap<String, Image> imageMap;
	
	
	public static void main(String args[]) {
		launch(args);
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("The Legend of Adlez");
		
		StartMenuView startView=new StartMenuView();
		mainPane=new StackPane();
		mainPane.getChildren().add(startView);
		//BorderPane.setAlignment(startView, P);
		
		mainScene=new Scene(mainPane, 864,672);
		
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
	
	
	public static void changeView(Pane view) {
		mainPane.getChildren().removeAll(mainPane.getChildren());
		mainPane.getChildren().add(view);
	}
}
