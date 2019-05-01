package view;

import java.io.File;
import java.util.HashMap;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LegendOfAdlezView extends Application{
	private static StackPane mainPane;
	static Scene mainScene;
	private static HashMap<String, Media> songs;
	private static HashMap<String, AudioClip> soundEffects;
	
	private static MediaPlayer songPlayer;
	
	
	public static void main(String args[]) {
		launch(args);
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("The Legend of Adlez");
		
		initializeMusic();

		
		StartMenuView startView=new StartMenuView();
		mainPane=new StackPane();
		mainPane.getChildren().add(startView);
		//BorderPane.setAlignment(startView, P);
		
		mainScene=new Scene(mainPane, 864,672);
		
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
	
	
	private void initializeMusic() {
		songs=new HashMap<>();
		soundEffects=new HashMap<>();
		
		songs.put("theme", new Media(new File("src/assets/main_menu.mp3").toURI().toString()));
		songs.put("shop", new Media(new File("src/assets/shop.mp3").toURI().toString()));
		songs.put("home", new Media(new File("src/assets/grasslands.mp3").toURI().toString()));
		songs.put("mountain", new Media(new File("src/assets/mountain.mp3").toURI().toString()));
		songs.put("dungeon", new Media(new File("src/assets/dungeon.mp3").toURI().toString()));
		songs.put("desert", new Media(new File("src/assets/desert.mp3").toURI().toString()));
		
		soundEffects.put("shout", new AudioClip("file:src/assets/attack.wav"));
		soundEffects.put("sword", new AudioClip("file:src/assets/sword_swoosh.wav"));
		soundEffects.put("scorpion", new AudioClip("file:src/assets/scorpion.mp3"));
		soundEffects.put("poe", new AudioClip("file:src/assets/poe.wav"));
		soundEffects.put("slime", new AudioClip("file:src/assets/slime.wav"));
		soundEffects.put("boss", new AudioClip("file:src/assets/boss.wav"));
		soundEffects.put("save", new AudioClip("file:src/assets/save.wav"));
		soundEffects.put("menu_change", new AudioClip("file:src/assets/menu_change.wav"));
		soundEffects.put("coin", new AudioClip("File:src/assets/coin.wav"));
		soundEffects.put("key", new AudioClip("file:src/assets/coin.wav"));
	}

	/**
	 * initializeAssets Initializes all images and sound, allowing for a flyweight
	 * design pattern 
	 * @param AudioClip serves as a short sound byte
	*/
	public static void play(String effectName) {
		AudioClip ac=soundEffects.get(effectName);
		for (AudioClip a : soundEffects.values()) {
			if (a.isPlaying()) {
				a.stop();
			}
			ac.play();
		}
	}

	/**
	 * playBackground Serves to be able to play background music, as MediaPlayer is
	 * better suited for it
	 * 
	 * @param song:
	 *            current song to be played
	 */
	public static void playBackground(String songName) {
		Media song=songs.get(songName);
		
		if(songPlayer==null) {
			songPlayer=new MediaPlayer(song);
			songPlayer.play();
			return;
		}
		
		if(song.equals(songPlayer.getMedia())){
			return;
		}
		
		System.out.println(songPlayer.getStatus());
		
		if (songPlayer.getStatus().equals(Status.PLAYING)) {
			songPlayer.stop();
		}

		songPlayer = new MediaPlayer(song);
		songPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		songPlayer.setOnEndOfMedia(new Runnable() {
			public void run() {
				songPlayer.seek(Duration.ZERO);
			}
		});
		songPlayer.play();
	}
	
	
	public static void changeView(Pane view) {
		System.out.println("CHANGE");
		mainPane.getChildren().clear();
		mainPane.getChildren().removeAll(mainPane.getChildren());
		mainPane.getChildren().add(view);
	}
}

