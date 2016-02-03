package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class showwindow {

	static Stage stage2;
	Scene scene;

	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("showindow.fxml"));
			scene = new Scene(root, 1200,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage2 = primaryStage;
			stage2.setScene(scene);
			stage2.setTitle("Show the Entries");
			stage2.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
