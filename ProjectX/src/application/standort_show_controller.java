package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class standort_show_controller {
	
	@FXML ListView<Standort> listview;
	Standort standort;
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
	ObservableList<Standort> data = FXCollections.observableArrayList();
	
	public void show(){
		
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
				data.add(standort);
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
