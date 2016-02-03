package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MaintenanceWindow {

	static Stage stage5;
	Scene scene;

	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("MaintenanceWindow.fxml"));
			scene = new Scene(root, 1200,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage5 = primaryStage;
			stage5.setScene(scene);
			stage5.setTitle("Maintenance");
			stage5.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
