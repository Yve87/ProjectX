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
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class fikus_show_controller{
	
	@FXML private TextField namef; 
	@FXML private TextField idf;
	@FXML private Button button;
	private String idtext;
	private String nametext;
	private int ids;
	Fikus fikus;
	@FXML ListView<Fikus> listview;
	int zähler = 0;
	int i = 1;
	int j = 2;
	final ObservableList<Fikus> data = FXCollections.observableArrayList();

	
	@FXML
	public void back()  {
		
		Stage primarystage = new Stage();
		Fikus_Window window = new Fikus_Window();
		window.start(primarystage);
	}
	
	@SuppressWarnings("unchecked")
	public void show(){
			
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