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
	//@FXML TableColumn<Fikus, String> id;
	@FXML TableColumn<Fikus, String> name;
	@FXML TableColumn<Fikus, Integer> test;

	@FXML TableView<Fikus> tableview;
	@FXML TableColumn<Fikus, String> first;
	@FXML TableColumn<Fikus, String> second;
	Fikus[] list;
	ArrayList<Integer> listInt;
	Fikus fikus;
	int i = 1;
	int j = 1;
	
	ObservableList<Fikus> data = FXCollections.observableArrayList();
	private ObservableList<ObservableList> dataInt = FXCollections.observableArrayList();
	
	@FXML
	public void back()  {
		
		Stage primarystage = new Stage();
		Fikus_Window window = new Fikus_Window();
		window.start(primarystage);
	}
	
	@SuppressWarnings("unchecked")
	public void show(){
		//list = new ArrayList<>();
		listInt = new ArrayList<>();
		//id = new TableColumn<Fikus, String>("ID");
		//id.setCellValueFactory(new PropertyValueFactory<Fikus, String>("id"));
		name = new TableColumn<Fikus, String>("Name");
		test = new TableColumn<Fikus, Integer>("Test");
		//name.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Name"));
		test.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("Test"));
		//data = table.getItems();	// initialize 
		
		try {
			java.sql.Connection conn = Connection.connecten();
			String query = "SELECT * FROM Fikus";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet set = stmt.executeQuery();	// SQL Befehl f�r Inhalt
			ObservableList<Fikus> list = FXCollections.observableArrayList();
			
			while(set.next()){

				int idFikus = set.getInt(i);
				String nameFikus = set.getString(j);
				fikus = new Fikus(set.getInt(i), set.getString(j));
				System.out.println(fikus.getName());
				System.out.println(fikus.getid());
				data.add(fikus);
				//System.out.println("list: " +list);
			}
			table.setItems(data);
				
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
	public void initialize(URL location, ResourceBundle resources) {
	
		//id.setCellValueFactory(new PropertyValueFactory<Fikus, String>("ID"));
		name.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Name"));
		test.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("Test"));
		table.setItems(data);
	//	first.setCellValueFactory(new PropertyValueFactory<Fikus, String>("ID"));
	 //   second.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Name"));
	  //  tableview.setItems(data);
	}
}