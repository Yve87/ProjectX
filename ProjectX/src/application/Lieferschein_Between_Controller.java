package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Lieferschein_Between_Controller {
	
	Lieferschein_Between_Window window;
	Stage primaryStage = new Stage();
	
	public void Lieferschein_Eingabe(){
		window = new Lieferschein_Between_Window();
		window.start(primaryStage);
	}
}
