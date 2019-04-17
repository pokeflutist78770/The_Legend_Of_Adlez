package view;

import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainView extends Application {
	
	Circle circle;
	
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Object[][] layout = new Object[9][9];
        int pX = 0;
        int pY = 0;
        int eX = 4;
        int eY = 4;
        int radius = 15;

        circle = new Circle(pX * 40 + 20, pY * 40 + 20, radius);
        Rectangle square = new Rectangle(eX * 40 +5, eY * 40 + 5, radius*2, radius*2);
        layout[pY][pX] = circle;
        layout[eY][eX] = square;
        circle.setFill(Color.GREEN);
        square.setFill(Color.BLUE);
        Scene scene = new Scene(pane, 360, 360);
        pane.getChildren().addAll(square, circle);

        scene.setOnKeyPressed(e -> {
        	double newY, newX;
            switch (e.getCode()) {
            case W:
            case UP:
            	newY = circle.getCenterY() - 40;
            	if (newY < 0) newY += 360;
                circle.setCenterY(newY);
                break;
            case S:
            case DOWN:
            	newY = circle.getCenterY() + 40;
            	if (newY > 360) newY -= 360;
                circle.setCenterY(newY);
                break;
            case A:
            case LEFT:
            	newX = circle.getCenterX() - 40;
            	if (newX < 0) newX += 360;
                circle.setCenterX(newX);
                break;
            case D:
            case RIGHT:
            	newX = circle.getCenterX() + 40;
            	if (newX > 360) newX -= 360;
                circle.setCenterX(newX);
                break;
			default:
				break;
            }
        });
        primaryStage.setTitle("Arrow Keys");
        primaryStage.setScene(scene);
        primaryStage.show();    	
    }

    public static void main(String[] args) { launch(args); }
}  