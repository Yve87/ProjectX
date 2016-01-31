package application;

import java.lang.reflect.AccessibleObject;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Connection;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class perkus_show_controller{
	
	@FXML ListView<Perkus> listview;
	Perkus perkus;
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
	ObservableList<Perkus> data = FXCollections.observableArrayList();

	
	@FXML
	public void back()  {	
		Stage primarystage = new Stage();
		Insert_perkus_window window = new Insert_perkus_window();
		window.start(primarystage);
	}
	
	@SuppressWarnings("unchecked")
	
	// SELECT * FROM Perkus WHERE Vorname LIKE ? OR Name LIKE ? 
	public void show(){
		
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
				data.add(perkus);
			}
			listview.setItems(data);	

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