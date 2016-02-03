package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	int i = 1;
	int j = 2;
	int k = 3;
	int l = 4;
	int m = 5;
	int n = 6;
	int a = 7;
	int b = 8;
	int c = 9;
	int d = 10;
	int e = 11;
	int f = 12;
	int g = 13;
	DeliveryNote deliverynote;
	Invoice invoice;
	Offer offer;
	ObservableList<DeliveryNote> data = FXCollections.observableArrayList();
	ObservableList<Invoice> data2 = FXCollections.observableArrayList();
	ObservableList<Offer> data3 = FXCollections.observableArrayList();
	
	@FXML
	public void getChoice(){
		
		data.removeAll(data);
		data2.removeAll(data2);
		data3.removeAll(data3);
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
