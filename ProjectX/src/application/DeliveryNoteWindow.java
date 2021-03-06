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


public class DeliveryNoteWindow extends Application {
	static Stage stage11;
	Scene scene;

	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("DeliveryNoteWindow.fxml"));
			scene = new Scene(root, 1200,700);
			scene.getStylesheets().add(getClass().getResource("DarkTheme.css").toExternalForm());
			stage11 = primaryStage;
			stage11.setScene(scene);
			stage11.setTitle("New Delivery Note");
			stage11.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}