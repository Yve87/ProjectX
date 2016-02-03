package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LicenseWindow {

	static Stage stage7;
	Scene scene;

	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("LicenseWindow.fxml"));
			scene = new Scene(root, 1200,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage7 = primaryStage;
			stage7.setScene(scene);
			stage7.setTitle("License");
			stage7.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
