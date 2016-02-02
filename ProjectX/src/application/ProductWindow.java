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


public class ProductWindow extends Application {
	
	Scene scene;

	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("ProductWindow.fxml"));
			scene = new Scene(root, 1200,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Product");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}