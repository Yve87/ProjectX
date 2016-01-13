package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Fikus_Window {

	Scene scene;

	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("fikuswindowupdate.fxml"));
			scene = new Scene(root, 1200,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Update");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
