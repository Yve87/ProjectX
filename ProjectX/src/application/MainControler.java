package application;

import javafx.stage.Stage;

public class MainControler {
	
	Between_Window window;
	Stage primaryStage = new Stage();
	
	public void Datenbank_modifizieren(){
		BetweenControler.counter = 1;
		window = new Between_Window();
		window.start(primaryStage);
	}
}
