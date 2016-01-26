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

public class fikus_insert_controller implements Initializable{
	
	@FXML private TextField name; 
	@FXML private TextField id;
	@FXML private Button button;
	private String idtext;
	private String nametext;
	private int ids;

	@FXML TableView<Fikus> table;
	@FXML TableColumn<Fikus, Integer> idColumn;
	@FXML TableColumn<Fikus, String> nameColumn;

	@FXML TableView<Fikus> tableview;
	@FXML TableColumn<Fikus, String> first;
	@FXML TableColumn<Fikus, String> second;
	Fikus[] list;
	ArrayList<Integer> listInt;
	Fikus fikus;
	int i = 1;
	int j = 2;
	
	ObservableList<Fikus> data = FXCollections.observableArrayList();
	private ObservableList<ObservableList> dataInt = FXCollections.observableArrayList();
	
	@FXML
	public void insert() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		idtext = id.getText();
		nametext = name.getText();
		ids = Integer.parseInt(idtext);
		java.sql.Connection conn = Connection.connecten();
		String query = "INSERT INTO Fikus(idFikus,Name)" + "values('"+ ids +"','"+ nametext +"')";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("New Insert into Table Fikus is completed.");
	}
	
	@FXML
	public void updaten() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		idtext = id.getText();
		nametext = name.getText();
		ids = Integer.parseInt(idtext);
		java.sql.Connection conn = Connection.connecten();
		String query = "UPDATE Fikus SET Name = '"+ nametext +"' WHERE idFikus IN ("+ids+")";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("Update at Table Fikus is completed.");
	}
	
	@FXML
	public void delete() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		idtext = id.getText();
		nametext = name.getText();
		ids = Integer.parseInt(idtext);
		java.sql.Connection conn = Connection.connecten();
		String query = "DELETE FROM Fikus WHERE idFikus = '"+ ids +"' AND Name = '"+ nametext +"'";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("New Delete at Table Fikus is completed.");
	}
	
	@SuppressWarnings("unchecked")
	public void show(){
		//list = new ArrayList<>();
		listInt = new ArrayList<>();
		idColumn = new TableColumn<Fikus, Integer>("ID");
		idColumn.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("idColumn"));
		nameColumn = new TableColumn<Fikus, String>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Name"));
		table = new TableView<Fikus>();
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
				fikus = new Fikus(idFikus, nameFikus);
				System.out.println(fikus.getName());
				System.out.println(fikus.getid());
				list.add(fikus);
				//System.out.println("list: " +list);
			}
			data.addAll(list);

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
	
		idColumn.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("ID"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Name"));
		table.setItems(data);
		
	//	first.setCellValueFactory(new PropertyValueFactory<Fikus, String>("ID"));
	 //   second.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Name"));
	  //  tableview.setItems(data);
	}
}