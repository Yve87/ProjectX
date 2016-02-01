package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class showwindow {

	Scene scene;

	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("showindow.fxml"));
			scene = new Scene(root, 700,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Choose the Table");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
