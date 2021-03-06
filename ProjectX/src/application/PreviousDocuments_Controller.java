package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PreviousDocuments_Controller implements Initializable{

	@FXML ChoiceBox<String> choicebox;
	@FXML ListView listview;
	@FXML TextField text;
	@FXML Button load;
	int counter = 0;
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
	ObservableList<Offer> data = FXCollections.observableArrayList();
	ObservableList<Invoice> data3 = FXCollections.observableArrayList();
	ObservableList<DeliveryNote> data2 = FXCollections.observableArrayList();
	
	@SuppressWarnings("unchecked")
	@FXML
	public void getChoice(){
		
		data.removeAll(data);
		data2.removeAll(data2);
		data3.removeAll(data3);
		String option = choicebox.getValue();
		
		if(option == "Offer"){
			try {
				java.sql.Connection conn = Connection.connecten();
				String query = "SELECT * FROM Angebot";
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet set = stmt.executeQuery();	// SQL Befehl f�r Inhalt
				
				while(set.next()){
					counter++;
					offer = new Offer(set.getInt(i),set.getString(j), set.getFloat(k),set.getInt(l),
							set.getDate(m),set.getInt(n));
					data.add(offer);
				}
				listview.setItems(data);
				counter = 0;
				set.close();
				conn.close();
				data2.removeAll(data2);
				data3.removeAll(data3);
				
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(option == "DeliveryNotes"){
			try{
			java.sql.Connection conn = Connection.connecten();
			String query = "SELECT * FROM Lieferschein";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet set = stmt.executeQuery();	// SQL Befehl f�r Inhalt
			
			while(set.next()){
				counter++;
				deliverynote = new DeliveryNote(set.getInt(i), set.getDate(j),set.getString(k),
						set.getString(l),set.getDouble(m),set.getFloat(n),set.getInt(a));
				data2.add(deliverynote);
			}
			listview.setItems(data2.filtered(Lieferschein -> Lieferschein.getfikusname().startsWith(text.getText())));
			counter = 0;
			set.close();
			conn.close();
			data.removeAll(data);
			data3.removeAll(data3);
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		else if(option == "Invoices"){
			try{
			java.sql.Connection conn = Connection.connecten();
			String query = "SELECT * FROM Rechnung";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet set = stmt.executeQuery();	// SQL Befehl f�r Inhalt
			
			while(set.next()){
				counter++;
				invoice = new Invoice(set.getInt(i), set.getDate(j),set.getFloat(k),
						set.getInt(l),set.getString(m),set.getString(n),set.getString(a),set.getInt(b));
				data3.add(invoice);
			}
			listview.setItems(data3.filtered(Rechnung -> Rechnung.getperkusname().startsWith(text.getText())));
			counter = 0;
			set.close();
			conn.close();
			data2.removeAll(data2);
			data.removeAll(data);
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public void back(){
		Stage primaryStage = new Stage();
		MainWindow window = new MainWindow();
		window.start(primaryStage);
		PreviousDocumentWindow.stage13.close();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choicebox.getItems().addAll("Offer","DeliveryNotes","Invoices");
		
	}
}
