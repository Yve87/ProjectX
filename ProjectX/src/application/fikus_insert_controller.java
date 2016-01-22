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
	@FXML TableView<ObservableList<Fikus>> table;
	@FXML TableColumn<Fikus, Integer> idColumn;
	@FXML TableColumn<Fikus, String> nameColumn;
	ArrayList<Fikus> list;
	ArrayList<Integer> listInt;
	Fikus fikus;
	int i = 1;
	int j = 2;
	
	private ObservableList<ObservableList<Fikus>> data = FXCollections.observableArrayList();
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
		list = new ArrayList<>();
		listInt = new ArrayList<>();
		idColumn = new TableColumn<Fikus, Integer>("ID");
		idColumn.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("idColumn"));
		nameColumn = new TableColumn<Fikus, String>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Name"));
		table = new TableView<ObservableList<Fikus>>();
		data = table.getItems();	// initialize 
		
		try {
			java.sql.Connection conn = Connection.connecten();
			String query = "SELECT * FROM Fikus";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet set = stmt.executeQuery();	// SQL Befehl für Inhalt
			
			int k=0;
			while(set.next()){
				ObservableList<Fikus> list = FXCollections.observableArrayList();
				int idFikus = set.getInt(i);
				String nameFikus = set.getString(j);
				fikus = new Fikus(idFikus, nameFikus);
				System.out.println(fikus.getName());
				System.out.println(fikus.getid());
				list.add(fikus);
				data.addAll(list);
				//listInt.add(set.getInt(i));
				//list.add(fikus);
				//System.out.println("List index: " + list.get(k));
				//System.out.println("List Index: " + list.get(k+1));
				//System.out.println("ID: " + fikus.getid());
				//System.out.println("Name: " + fikus.getName());
				//list.add(fikus);
				//data.add(fikus);
				k++;
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
	public void initialize(URL location, ResourceBundle resources) {
		//first.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("ID"));
		//second.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Name"));
		//first.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("ID"));
		//tableview.setItems(dataInt);
	
		idColumn.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("ID"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Name"));
		table.setItems(data);
	}
}