package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
	CorporateCustomers fikus;
	PeopleCustomers perkus;
	Location standort;
	Product produkt;
	Maintenance maintenance;
	License lizenz;
	leasing leasing;
	ObservableList<CorporateCustomers> data = FXCollections.observableArrayList();
	ObservableList<PeopleCustomers> data2 = FXCollections.observableArrayList();
	ObservableList<Location> data3 = FXCollections.observableArrayList();
	ObservableList<Product> data4 = FXCollections.observableArrayList();
	ObservableList<Maintenance> data5 = FXCollections.observableArrayList();
	ObservableList<License> data6 = FXCollections.observableArrayList();
	ObservableList<leasing> data7 = FXCollections.observableArrayList();
	

	@SuppressWarnings("unchecked")
	@FXML
	public void getChoice(){
		
		data.removeAll(data);
		data2.removeAll(data2);
		data3.removeAll(data3);
		data5.removeAll(data5);
		data4.removeAll(data4);
		data6.removeAll(data6);
		data7.removeAll(data7);
		String option = choicebox.getValue();
		if(option == "CorporateCustomer"){
			try {
				java.sql.Connection conn = Connection.connecten();
				String query = "SELECT * FROM Fikus";
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet set = stmt.executeQuery();	// SQL Befehl f�r Inhalt
				
				while(set.next()){
					zähler++;
					fikus = new CorporateCustomers(set.getInt(i), set.getString(j), zähler);
					data.add(fikus);
				}
				listview.setItems(data.filtered(fikus -> fikus.getName().startsWith(text.getText())));
				zähler = 0;
				set.close();
				conn.close();
				data2.removeAll(data2);
				data3.removeAll(data3);
				data5.removeAll(data5);
				data4.removeAll(data4);
				data6.removeAll(data6);
				
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
		else if(option == "PeopleCustomer"){
			try {
				java.sql.Connection conn = Connection.connecten();
				String query = "SELECT * FROM Perkus";
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet set = stmt.executeQuery();	// SQL Befehl f�r Inhalt
				
				while(set.next()){
					zähler++;
					perkus = new PeopleCustomers(set.getInt(i), set.getString(j),set.getString(k),
							set.getString(l),set.getString(m),set.getString(n),set.getString(a),
							set.getString(b),set.getString(c),set.getString(d),set.getString(e),
							set.getString(f),set.getInt(g),zähler);
					data2.add(perkus);
				}
				listview.setItems(data2.filtered(perkus -> perkus.getname().startsWith(text.getText())));
				zähler = 0;
				set.close();
				conn.close();
				data.removeAll(data);
				data3.removeAll(data3);
				data4.removeAll(data4);
				data5.removeAll(data5);
				data6.removeAll(data6);

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
		else if(option == "Location"){
			try {
				java.sql.Connection conn = Connection.connecten();
				String query = "SELECT * FROM Standort";
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet set = stmt.executeQuery();	// SQL Befehl f�r Inhalt
				
				while(set.next()){
					zähler++;
					standort = new Location(set.getInt(i), set.getString(j),set.getString(k),
							set.getInt(l),set.getInt(m),set.getInt(n),set.getInt(a),
							set.getInt(b),set.getInt(c),set.getInt(d),zähler);
					data3.add(standort);
				}
				listview.setItems(data3.filtered(standort -> standort.getname().startsWith(text.getText())));
				zähler = 0;
				set.close();
				conn.close();
				data.removeAll(data);
				data2.removeAll(data2);
				data4.removeAll(data4);
				data5.removeAll(data5);
				data6.removeAll(data6);

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
		else if(option == "Product"){
			try {
				java.sql.Connection conn = Connection.connecten();
				String query = "SELECT * FROM Produkt";
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet set = stmt.executeQuery();	// SQL Befehl f�r Inhalt
				
				while(set.next()){
					zähler++;
					produkt = new Product(set.getInt(i), set.getString(j),set.getInt(k),
							set.getInt(l),set.getString(m),set.getString(n),zähler);
					data4.add(produkt);
				}
				listview.setItems(data4.filtered(produkt -> produkt.getname().startsWith(text.getText())));
				zähler = 0;
				set.close();
				conn.close();
				data.removeAll(data);
				data2.removeAll(data2);
				data3.removeAll(data3);
				data5.removeAll(data5);
				data6.removeAll(data6);

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
		else if(option == "Maintenance"){
			try {
				java.sql.Connection conn = Connection.connecten();
				String query = "SELECT * FROM Maintenance";
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet set = stmt.executeQuery();	// SQL Befehl f�r Inhalt
				
				while(set.next()){
					zähler++;
					maintenance = new Maintenance(set.getInt(i),set.getDate(j),set.getFloat(k),zähler);
					data5.add(maintenance);
				}
				listview.setItems(data5);
				zähler = 0;
				set.close();
				conn.close();
				data.removeAll(data);
				data2.removeAll(data2);
				data3.removeAll(data3);
				data4.removeAll(data4);
				data6.removeAll(data6);

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
		else if(option == "License"){
			try {
				java.sql.Connection conn = Connection.connecten();
				String query = "SELECT * FROM Lizenz";
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet set = stmt.executeQuery();	// SQL Befehl f�r Inhalt
				
				while(set.next()){
					zähler++;
					lizenz = new License(set.getInt(i),set.getString(j),set.getString(k),set.getInt(l),
							set.getInt(m),set.getInt(n),set.getDate(a),set.getDate(b),
							set.getString(c),set.getInt(d),set.getInt(e),set.getInt(f),zähler);
					data6.add(lizenz);
				}
				listview.setItems(data6.filtered(lizenz -> lizenz.gettyp().startsWith(text.getText())));
				zähler = 0;
				set.close();
				conn.close();
				data.removeAll(data);
				data2.removeAll(data2);
				data3.removeAll(data3);
				data4.removeAll(data4);
				data5.removeAll(data5);

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
		else if(option == "Leasing"){
			try {
				java.sql.Connection conn = Connection.connecten();
				String query = "SELECT * FROM Leasing";
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet set = stmt.executeQuery();	// SQL Befehl f�r Inhalt
				
				while(set.next()){
					zähler++;
					leasing = new leasing(set.getDate(i),set.getDate(j),set.getFloat(k),set.getInt(l),
							set.getDate(m),set.getDate(n),set.getInt(a),set.getInt(b),
							set.getInt(c),set.getInt(d),set.getInt(e),zähler);
					data7.add(leasing);
				}
				listview.setItems(data7);
				zähler = 0;
				set.close();
				conn.close();
				data.removeAll(data);
				data2.removeAll(data2);
				data3.removeAll(data3);
				data4.removeAll(data4);
				data5.removeAll(data5);
				data6.removeAll(data6);

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
		choicebox.getItems().addAll("CorporateCustomer","PeopleCustomer","Location","License",
				"Maintenance","Leasing","Product");
	}
	

}
