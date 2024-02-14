package com.example.midivideomapper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;
import java.io.IOException;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("video-player.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle("乐器数字接口映射器");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) { launch(); }
}
