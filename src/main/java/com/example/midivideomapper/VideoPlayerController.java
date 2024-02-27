package com.example.midivideomapper;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.javafx.videosurface.ImageViewVideoSurface;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

public class VideoPlayerController {


	private MediaPlayerFactory mediaPlayerFactory;

	private EmbeddedMediaPlayer embeddedMediaPlayer;

	public String videoLocation = "/home/zachary/Desktop/tokyo-walk.mp4";


	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnPlay;

	@FXML
	private ImageView imageView;

	@FXML
	private Label labelDuration;

	@FXML
	private Slider timeSlider;

	@FXML
	private BorderPane root;

	@FXML
	private Pane imageContainer;

	@FXML
	void btnPlay(MouseEvent event) {

	}

	@FXML
	void selectVideo(ActionEvent event) {
	}

	@FXML
	void sliderPressed(MouseEvent event) {

	}

	private MediaPlayerEventAdapter setupMediaPlayerEventListeners() {
		return new MediaPlayerEventAdapter() {
			@Override
			public void playing(MediaPlayer mediaPlayer) {

			}

			@Override
			public void paused(MediaPlayer mediaPlayer) {
			}

			@Override
			public void stopped(MediaPlayer mediaPlayer) {
			}

			String humanReadableDurationString(double current, double total) {
				double totalSeconds = (total / 1000);
				double currentSeconds = (current / 1000);

				int totalMinutesAndSeconds = (int) totalSeconds / 60;
				int currentMinutesAndSeconds = (int) currentSeconds / 60;

				int totalLeftoverSeconds = (int) totalSeconds % 60;
				int currentLeftoverSeconds = (int) currentSeconds % 60;

				return String.format("%s:%s/%s:%s",
					currentMinutesAndSeconds,
					currentLeftoverSeconds,
					totalMinutesAndSeconds,
					totalLeftoverSeconds);
			}

			@Override
			public void timeChanged(MediaPlayer mediaPlayer, long newTime) {
				Platform.runLater(() -> {
					double total = mediaPlayer.status().length();
					double ratio = newTime / total;
					double m = timeSlider.getMax();
					timeSlider.setValue(ratio * m);
					labelDuration.setText(humanReadableDurationString(newTime, total));
				});
			}
		};
	}


	@FXML
	void initialize() {
		// Initialize the media player factory and player
		this.mediaPlayerFactory = new MediaPlayerFactory();
		this.embeddedMediaPlayer = mediaPlayerFactory.mediaPlayers().newEmbeddedMediaPlayer();

		// Now imageView is initialized, so we can set the video surface
		this.embeddedMediaPlayer.videoSurface().set(new ImageViewVideoSurface(this.imageView));
		this.embeddedMediaPlayer.events().addMediaPlayerEventListener(setupMediaPlayerEventListeners());
		imageView.fitWidthProperty().bind(imageContainer.widthProperty());
		imageView.fitHeightProperty().bind(imageContainer.heightProperty());
		// Play video
		embeddedMediaPlayer.media().play(videoLocation);

	}
}
