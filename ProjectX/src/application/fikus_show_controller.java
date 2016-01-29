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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class fikus_show_controller implements Initializable{
	
	@FXML private TextField namef; 
	@FXML private TextField idf;
	@FXML private Button button;
	private String idtext;
	private String nametext;
	private int ids;

	@FXML TableView<Fikus> table;
	@FXML TableColumn<Fikus, Integer> test;
	@FXML TableColumn<Fikus, String> name;
	
	@FXML ListView<Fikus> listview;

	@FXML TableView<Fikus> tableview;
	@FXML TableColumn<Fikus, String> first;
	@FXML TableColumn<Fikus, String> second;
	Fikus[] list;
	ArrayList<Integer> listInt;
	Fikus fikus;
	int i = 1;
	int j = 2;
	
	
	
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

				fikus = new Fikus(set.getInt(i), set.getString(j));
				//data.add(fikus);

			}
			
				
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
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		ObservableList<Fikus> data = FXCollections.observableArrayList(
				new Fikus(27,"Etst"));
		ObservableList<String> data2 = FXCollections.observableArrayList();
		
		
		try {
			java.sql.Connection conn = Connection.connecten();
			String query = "SELECT * FROM Fikus";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet set = stmt.executeQuery();	// SQL Befehl f�r Inhalt
			
			while(set.next()){

				fikus = new Fikus(set.getInt(i), set.getString(j));
				data.add(fikus);
				//data2.add(fikus.toString());

			}
			
				
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
		
		test.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("test"));
		name.setCellValueFactory(new PropertyValueFactory<Fikus, String>("name"));
		table.setItems(data);
		listview.setItems(data);

	}
}