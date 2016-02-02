package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class bisherige_dokumente_controller implements Initializable{

	@FXML ChoiceBox<String> choicebox;
	@FXML ListView listview;
	@FXML TextField text;
	@FXML Button load;
	int zähler = 0;
	
	@FXML
	public void getChoice(){
		
		
		String option = choicebox.getValue();
		
		if(option == "Angebote"){
			
		}
		
		else if(option == "Lieferscheine"){
			
		}
		
		else if(option == "Rechnungen"){
			
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choicebox.getItems().addAll("Angebote","Lieferscheine","Rechnungen");
		
	}
}
