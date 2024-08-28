package org.pmob.flowpeople_system;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlowpeopleSystemApplication extends Application  {

	public static void main(String[] args) {
		//
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		var context = SpringApplication.run(FlowpeopleSystemApplication.class);
		var fxml = new FXMLLoader(getClass().getResource("/Main.fxml"));

		var scene = new Scene(fxml.load());
		stage.setScene(scene);
		stage.show();
	}
}
