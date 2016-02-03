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


public class PeopleCustomersWindow extends Application {
	public Stage stage15;
	Scene scene;

	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("PeopleCustomersWindow.fxml"));
			scene = new Scene(root, 1200,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage15 = primaryStage;
			stage15.setScene(scene);
			stage15.setTitle("People Customers");
			stage15.show();		
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}