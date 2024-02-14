package com.example.midivideomapper;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VideoPlayerController {
	@FXML
	private Label welcomeText;

	@FXML
	protected void onHelloButtonClick() {
		welcomeText.setText("Welcome to JavaFX Application!");
	}
}
