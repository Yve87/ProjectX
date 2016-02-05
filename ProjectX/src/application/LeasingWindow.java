package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LeasingWindow {

	static Stage stage8;
	Scene scene;

	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("LeasingWindow.fxml"));
			scene = new Scene(root, 1200,700);
			scene.getStylesheets().add(getClass().getResource("DarkTheme.css").toExternalForm());
			stage8 = primaryStage;
			stage8.setScene(scene);
			stage8.setTitle("Leasing");
			stage8.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
