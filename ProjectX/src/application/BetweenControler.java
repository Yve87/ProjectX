package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class BetweenControler {
	
	public void fikus_button(){

			Stage primarystage = new Stage();
			Fikus_Window window = new Fikus_Window();
			window.start(primarystage);
	}
		
	public void perkus_button(){

			Stage primarystage = new Stage();
			Insert_perkus_window window = new Insert_perkus_window();
			window.start(primarystage);
	}
	
	public void standort_button(){

			Stage primarystage = new Stage();
			Standort_insert_window window = new Standort_insert_window();
			window.start(primarystage);
	}
	
	public void produkt_button(){

			Stage primarystage = new Stage();
			produkt_insert_window window = new produkt_insert_window();
			window.start(primarystage);
	}
	
	public void lizenz_button(){
		
			Stage primaryStage = new Stage();
			Lizenz_window window = new Lizenz_window();
			window.start(primaryStage);
	}
	
	public void maintenance_button(){
		
			Stage primaryStage = new Stage();
			maintenance_window window = new maintenance_window();
			window.start(primaryStage);
	}
}
