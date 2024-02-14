package com.example.midivideomapper;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;

public class VideoPlayerApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Button to open video
		Button btnOpenVideo = new Button("Open Video");
		StackPane root = new StackPane();
		root.getChildren().add(btnOpenVideo);

		// Set up the scene and stage
		Scene scene = new Scene(root, 640, 480);
		primaryStage.setTitle("JavaFX Video Player");
		primaryStage.setScene(scene);
		primaryStage.show();

		// Action for button click
		btnOpenVideo.setOnAction(event -> {
			FileChooser fileChooser = new FileChooser();
			// Filter for .mp4 files
			FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("MP4 Files", "*.mp4");
			fileChooser.getExtensionFilters().add(filter);

			// Show open file dialog
			File file = fileChooser.showOpenDialog(primaryStage);
			if (file != null) {
				playVideo(file, root);
			}
		});
	}

	private void playVideo(File file, StackPane root) {
		Media media = new Media(file.toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		MediaView mediaView = new MediaView(mediaPlayer);

		// Adjust size as necessary
		mediaView.setFitWidth(640);
		mediaView.setFitHeight(480);

		// Clear previous content and add mediaView
		root.getChildren().clear();
		root.getChildren().add(mediaView);

		mediaPlayer.play();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
