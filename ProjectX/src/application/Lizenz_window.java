package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Lizenz_window {

	Scene scene;

	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("Lizenzwindow.fxml"));
			scene = new Scene(root, 1200,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Lizenz");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
