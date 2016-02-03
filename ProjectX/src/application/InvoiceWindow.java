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


public class InvoiceWindow extends Application {
	static Stage stage9;
	Scene scene;

	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("InvoiceWindow.fxml"));
			scene = new Scene(root, 1200,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage9 = primaryStage;
			stage9.setScene(scene);
			stage9.setTitle("New Invoice");
			stage9.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}