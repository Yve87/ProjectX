package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;


public class BetweenWindow extends Application {
	static Stage stage14;
	Scene scene;

	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("BetweenWindow.fxml"));
			scene = new Scene(root, 1200,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage14 = primaryStage;
			stage14.setScene(scene);
			stage14.setTitle("Choose the Table to modify");
			stage14.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}