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


public class Insert_fikus_window extends Application {
	static Stage stage10;
	Scene scene;

	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("fikuswindowinsert.fxml"));
			scene = new Scene(root, 1200,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage10 = primaryStage;
			stage10.setScene(scene);
			stage10.setTitle("People Customers");
			stage10.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}