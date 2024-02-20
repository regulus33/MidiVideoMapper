package com.example.midivideomapper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
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
