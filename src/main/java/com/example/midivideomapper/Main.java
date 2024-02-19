package com.example.midivideomapper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.javafx.videosurface.ImageViewVideoSurface;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public class Main extends Application {

	private final MediaPlayerFactory mediaPlayerFactory;

	private final EmbeddedMediaPlayer embeddedMediaPlayer;

	private ImageView videoImageView;

	public Main() {
		this.mediaPlayerFactory = new MediaPlayerFactory();
		this.embeddedMediaPlayer = mediaPlayerFactory.mediaPlayers().newEmbeddedMediaPlayer();
		this.embeddedMediaPlayer.events().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
			@Override
			public void playing(MediaPlayer mediaPlayer) {
			}

			@Override
			public void paused(MediaPlayer mediaPlayer) {
			}

			@Override
			public void stopped(MediaPlayer mediaPlayer) {
			}

			@Override
			public void timeChanged(MediaPlayer mediaPlayer, long newTime) {
			}
		});
	}

	@Override
	public void init() {
		this.videoImageView = new ImageView();
		this.videoImageView.setPreserveRatio(true);

		embeddedMediaPlayer.videoSurface().set(new ImageViewVideoSurface(this.videoImageView));
	}

	@Override
	public final void start(Stage primaryStage) throws Exception {
		List<String> params = getParameters().getRaw();
		if (params.size() != 1) {
			System.out.println("Specify a single MRL");
			System.exit(-1);
		}

		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color: black;");

		videoImageView.fitWidthProperty().bind(root.widthProperty());
		videoImageView.fitHeightProperty().bind(root.heightProperty());

		root.widthProperty().addListener((observableValue, oldValue, newValue) -> {
			// If you need to know about resizes
		});

		root.heightProperty().addListener((observableValue, oldValue, newValue) -> {
			// If you need to know about resizes
		});

		root.setCenter(videoImageView);

		Scene scene = new Scene(root, 1200, 675, Color.BLACK);
		primaryStage.setTitle("vlcj JavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();

		embeddedMediaPlayer.media().play(params.get(0));

		embeddedMediaPlayer.controls().setPosition(0.4f);
	}

	@Override
	public final void stop() {
		embeddedMediaPlayer.controls().stop();
		embeddedMediaPlayer.release();
		mediaPlayerFactory.release();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

/// OLD MAIN
//package com.example.midivideomapper;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.stage.Stage;
//import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
//import javafx.scene.control.Button;
//import javafx.stage.FileChooser;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.scene.media.MediaView;
//import java.io.File;
//import java.io.IOException;
//
//public class Main extends Application {
//	@Override
//	public void start(Stage stage) throws IOException {
//		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("video-player.fxml"));
//		Scene scene = new Scene(fxmlLoader.load());
//		stage.setTitle("乐器数字接口映射器");
//		stage.setScene(scene);
//		stage.show();
//	}
//
//	public static void main(String[] args) { launch(); }
//}
