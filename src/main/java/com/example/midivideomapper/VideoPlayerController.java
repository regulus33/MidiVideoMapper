//package com.example.midivideomapper;
//
//import javafx.application.Platform;
//import javafx.fxml.FXML;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.image.PixelBuffer;
//import javafx.scene.image.PixelFormat;
//import javafx.scene.image.WritableImage;
//import javafx.scene.layout.StackPane;
//import javafx.stage.FileChooser;
//import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
//import uk.co.caprica.vlcj.player.base.MediaPlayer;
//import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
//import uk.co.caprica.vlcj.player.embedded.videosurface.CallbackVideoSurface;
//
//import java.io.File;
//import java.nio.ByteBuffer;
//
//public class VideoPlayerController {
//
//	@FXML
//	private StackPane videoPane;
//
//	private Canvas canvas;
//	private WritableImage writableImage;
//	private PixelBuffer<ByteBuffer> pixelBuffer;
//
//	//
//	private EmbeddedMediaPlayer mediaPlayer;
//	private MediaPlayerFactory mediaPlayerFactory;
//
//	public void initialize() {
//		// factories are a cool oop pattern that makes instantiation from the caller super simple.
//		// we don't need to worry about what args an EmbeddedMediaPlayer would need.
//		mediaPlayerFactory = new MediaPlayerFactory();
//		mediaPlayer = mediaPlayerFactory.mediaPlayers().newEmbeddedMediaPlayer();
//
//		int width = 640; // Set to your video's width
//		int height = 360; // Set to your video's height
//		canvas = new Canvas(width, height);
//		videoPane.getChildren().add(canvas);
//
//		// Initialize PixelBuffer
//		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(width * height * 4);
//		pixelBuffer = new PixelBuffer<>(width, height, byteBuffer, PixelFormat.getByteBgraPreInstance());
//
//		writableImage = new WritableImage(pixelBuffer);
//		GraphicsContext gc = canvas.getGraphicsContext2D();
//
//		// Set the video surface for the media player
//		CallbackVideoSurface videoSurface = mediaPlayerFactory.videoSurfaces().newVideoSurface(new JavaFxVideoSurfaceAdapter(pixelBuffer, gc, writableImage));
//		mediaPlayer.videoSurface().set(videoSurface);
//
//		// Load and play video after selection
//		selectAndPlayVideo();
//	}
//
//	private void selectAndPlayVideo() {
//		FileChooser fileChooser = new FileChooser();
//		File file = fileChooser.showOpenDialog(videoPane.getScene().getWindow());
//		if (file != null) {
//			mediaPlayer.media().play(file.getAbsolutePath());
//		}
//	}
//}
