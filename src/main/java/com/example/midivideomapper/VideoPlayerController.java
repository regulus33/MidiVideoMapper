package com.example.midivideomapper;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

			@Override
			public void timeChanged(MediaPlayer mediaPlayer, long newTime) {
			}
		};
	}



	@FXML
	void initialize() {
		assert btnPlay != null : "fx:id=\"btnPlay\" was not injected: check your FXML file 'video-player.fxml'.";
		assert imageView != null : "fx:id=\"imageView\" was not injected: check your FXML file 'video-player.fxml'.";
		assert labelDuration != null : "fx:id=\"labelDuration\" was not injected: check your FXML file 'video-player.fxml'.";
		assert timeSlider != null : "fx:id=\"timeSlider\" was not injected: check your FXML file 'video-player.fxml'.";
		// Initialize the media player factory and player
		this.mediaPlayerFactory = new MediaPlayerFactory();
		this.embeddedMediaPlayer = mediaPlayerFactory.mediaPlayers().newEmbeddedMediaPlayer();

		// Now imageView is initialized, so we can set the video surface
		this.embeddedMediaPlayer.videoSurface().set(new ImageViewVideoSurface(this.imageView));
		this.embeddedMediaPlayer.events().addMediaPlayerEventListener(setupMediaPlayerEventListeners());

		// Play video
		embeddedMediaPlayer.media().play(videoLocation);
		embeddedMediaPlayer.controls().setPosition(0.4f);
	}
}
