package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class bisherige_dokumente_window {
	static Stage stage13;
	Scene scene;

	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("bisherige_dokumente_window.fxml"));
			scene = new Scene(root, 700,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage13 = primaryStage;
			stage13.setScene(scene);
			stage13.setTitle("Bisherige Dokumente");
			stage13.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}	
