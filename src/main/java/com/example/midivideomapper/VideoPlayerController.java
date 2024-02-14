package com.example.midivideomapper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;


import java.io.File;

public class VideoPlayerController {

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnStop;

	@FXML
	private Label labelDuration;

	@FXML
	private MediaView mediaView;

	@FXML
	private Slider timeSlider;

	private Media media;
	private MediaPlayer mediaPlayer;
	private boolean isPlayed = false;

	@FXML
	void btnPlay(MouseEvent event) {
		if (!isPlayed) {
			btnPlay.setText("Pause");
			mediaPlayer.play();
			isPlayed = true;
		} else {
			mediaPlayer.stop();
			btnPlay.setText("Play");
			isPlayed = false;
		}
	}

	@FXML
	void btnStop(MouseEvent event) {

	}

	@FXML
	void selectVideo(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select Video");
		File selectedFile = fileChooser.showOpenDialog(null);
		if (selectedFile != null) {
			String url = selectedFile.toURI().toString();
			media = new Media(url);
			mediaPlayer = new MediaPlayer(media);

			mediaView.setMediaPlayer(mediaPlayer);

			// Set an observer on an observable property, in this case the "time"
			mediaPlayer.currentTimeProperty().addListener((((observable, oldValue, newValue) -> {
				timeSlider.setValue(newValue.toSeconds());
				labelDuration.setText(String.format("%.2f", newValue.toSeconds()));
			})));

			mediaPlayer.setOnReady(() -> {
				Duration totalDuration = media.getDuration();
				timeSlider.setValue(totalDuration.toSeconds());
			});

			Scene scene = mediaView.getScene();
			mediaView.fitWidthProperty().bind(scene.widthProperty());
			mediaView.fitHeightProperty().bind(scene.heightProperty());

			mediaPlayer.setAutoPlay(true);
		}
	}

	@FXML
	private void sliderPressed(MouseEvent event) {
		mediaPlayer.seek(Duration.seconds(timeSlider.getValue()));
	}

}
