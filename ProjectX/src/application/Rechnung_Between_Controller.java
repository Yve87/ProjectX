package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Rechnung_Between_Controller {
	
	Rechnung_Between_Window window;
	Stage primaryStage = new Stage();
	
	public void Rechnung_Eingabe(){
		window = new Rechnung_Between_Window();
		window.start(primaryStage);
	}
}
