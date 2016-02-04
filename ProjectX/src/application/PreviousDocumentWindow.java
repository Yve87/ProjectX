package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PreviousDocumentWindow {
	static Stage stage13;
	Scene scene;

	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("PreviousDocumentsWindow.fxml"));
			scene = new Scene(root, 1200,700);
			scene.getStylesheets().add(getClass().getResource("DarkTheme.css").toExternalForm());
			stage13 = primaryStage;
			stage13.setScene(scene);
			stage13.setTitle("Previous Documents");
			stage13.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}	
