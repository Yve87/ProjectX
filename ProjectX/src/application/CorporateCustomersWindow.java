package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class CorporateCustomersWindow {
	static Stage stage12;
	Scene scene;
	
	public void start(Stage primaryStage) {
		try {		
			Parent root = FXMLLoader.load(getClass().getResource("CorporateCustomersWindow.fxml"));
			scene = new Scene(root, 1200,700);
			scene.getStylesheets().add(getClass().getResource("DarkTheme.css").toExternalForm());
			stage12 = primaryStage;
			stage12.setScene(scene);
			stage12.setTitle("Corporate Customers");
			stage12.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

