module com.example.midivideomapper {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.media;
	requires javafx.graphics;

	requires org.controlsfx.controls;
	requires com.dlsc.formsfx;
	requires net.synedra.validatorfx;
	requires org.kordamp.ikonli.javafx;
	requires org.kordamp.bootstrapfx.core;
	requires java.sql;
	requires uk.co.caprica.vlcj;
	requires uk.co.caprica.vlcj.natives;
	requires uk.co.caprica.vlcj.javafx;


	opens com.example.midivideomapper to javafx.fxml;
	exports com.example.midivideomapper;
}
