module com.example.midivideomapper {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.media;

	requires org.controlsfx.controls;
	requires com.dlsc.formsfx;
	requires net.synedra.validatorfx;
	requires org.kordamp.ikonli.javafx;
	requires org.kordamp.bootstrapfx.core;

	opens com.example.midivideomapper to javafx.fxml;
	exports com.example.midivideomapper;
}
