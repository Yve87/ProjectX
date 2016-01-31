package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class standort_show_window extends Application {
	
	Scene scene;

	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("standort_show_window.fxml"));
			scene = new Scene(root, 1200,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Standort");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
