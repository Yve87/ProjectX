package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class BetweenControler {
	
	static int counter = 0;
	
	public void irgendwas(){
		
		if(counter == 2){
			fikus_button_insert();
		}
		
		else if(counter == 6){
			fikus_button_update();
		}
	}
	
	public void fikus_button_update(){
		
		Stage primarystage = new Stage();
		Fikus_Window window = new Fikus_Window();
		window.start(primarystage);
	}
	
	public void fikus_button_insert(){
		Stage primarystage = new Stage();
		Insert_fikus_window window = new Insert_fikus_window();
		window.start(primarystage);
	}
}
