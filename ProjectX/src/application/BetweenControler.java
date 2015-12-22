package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class BetweenControler {
	
	static int counter = 0;
	static int inside_counter = 0;
	
	public void fikus_button(){
		if(counter == 6){
			Stage primarystage = new Stage();
			Fikus_Window window = new Fikus_Window();
			window.start(primarystage);
		}

		else if(counter == 2){
			Stage primarystage = new Stage();
			Insert_fikus_window window = new Insert_fikus_window();
			window.start(primarystage);
		}
	}
		
	public void perkus_button(){
		if(counter == 6){
			Stage primarystage = new Stage();
			Update_perkus_window window = new Update_perkus_window();
			window.start(primarystage);
		}
		
		else if(counter == 2){
			Stage primarystage = new Stage();
			Insert_perkus_window window = new Insert_perkus_window();
			window.start(primarystage);
		}
	}
	
	public void standort_button(){
		if(counter == 6){
			Stage primarystage = new Stage();
			standort_update_window window = new standort_update_window();
			window.start(primarystage);
		}
		
		else if(counter == 2){
			Stage primarystage = new Stage();
			Standort_insert_window window = new Standort_insert_window();
			window.start(primarystage);
		}
	}
	
	public void produkt_button(){
		if(counter == 6){
			Stage primarystage = new Stage();
			produkt_update_window window = new produkt_update_window();
			window.start(primarystage);
		}
		
		else if(counter == 2){
			Stage primarystage = new Stage();
			produkt_insert_window window = new produkt_insert_window();
			window.start(primarystage);
		}
	}
}
