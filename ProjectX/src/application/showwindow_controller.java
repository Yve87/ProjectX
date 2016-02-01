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

public class showwindow_controller implements Initializable{
	
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
	Fikus fikus;
	Perkus perkus;
	Standort standort;
	ObservableList<Fikus> data = FXCollections.observableArrayList();
	ObservableList<Perkus> data2 = FXCollections.observableArrayList();
	ObservableList<Standort> data3 = FXCollections.observableArrayList();
	


	@SuppressWarnings("unchecked")
	@FXML
	public void getChoice(){
		String option = choicebox.getValue();
		if(option == "Fikus"){
			try {
				java.sql.Connection conn = Connection.connecten();
				String query = "SELECT * FROM Fikus";
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet set = stmt.executeQuery();	// SQL Befehl f�r Inhalt
				
				while(set.next()){
					zähler++;
					fikus = new Fikus(set.getInt(i), set.getString(j), zähler);
					data.add(fikus);
				}
				listview.setItems(data);
				zähler = 0;
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
		else if(option == "Perkus"){
			try {
				java.sql.Connection conn = Connection.connecten();
				String query = "SELECT * FROM Perkus";
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet set = stmt.executeQuery();	// SQL Befehl f�r Inhalt
				
				while(set.next()){
					zähler++;
					perkus = new Perkus(set.getInt(i), set.getString(j),set.getString(k),
							set.getString(l),set.getString(m),set.getString(n),set.getString(a),
							set.getString(b),set.getString(c),set.getString(d),set.getString(e),
							set.getString(f),set.getInt(g),zähler);
					data2.add(perkus);
				}
				listview.setItems(data2);
				zähler = 0;
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
		else if(option == "Standort"){
			try {
				java.sql.Connection conn = Connection.connecten();
				String query = "SELECT * FROM Standort";
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet set = stmt.executeQuery();	// SQL Befehl f�r Inhalt
				
				while(set.next()){
					zähler++;
					standort = new Standort(set.getInt(i), set.getString(j),set.getString(k),
							set.getInt(l),set.getInt(m),set.getInt(n),set.getInt(a),
							set.getInt(b),set.getInt(c),set.getInt(d),zähler);
					data3.add(standort);
				}
				listview.setItems(data3);
				zähler = 0;
				set.close();
				conn.close();
				data.removeAll(data);
				data2.removeAll(data2);

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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choicebox.getItems().addAll("Fikus","Perkus","Standort");
		//load.setOnAction(e -> getChoice(choicebox));
	}
	

}