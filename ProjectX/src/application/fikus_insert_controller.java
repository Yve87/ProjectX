package application;

import java.lang.reflect.AccessibleObject;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mysql.jdbc.Statement;

import application.Connection;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class fikus_insert_controller{
	
	@FXML private TextField namef; 
	@FXML private TextField idf;
	@FXML private Button button;
	private String idtext;
	private String nametext;
	private int ids;

	@FXML TableView<Fikus> table;
	@FXML TableColumn<Fikus, Integer> id;
	@FXML TableColumn<Fikus, String> name;

	@FXML TableView<Fikus> tableview;
	@FXML TableColumn<Fikus, String> first;
	@FXML TableColumn<Fikus, String> second;
	Fikus[] list;
	ArrayList<Integer> listInt;
	Fikus fikus;
	int i = 1;
	int j = 2;
	
	@FXML
	public void insert() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		idtext = idf.getText();
		nametext = namef.getText();
		ids = Integer.parseInt(idtext);
		java.sql.Connection conn = Connection.connecten();
		String query = "INSERT INTO Fikus(idFikus,Name)" + "values('"+ ids +"','"+ nametext +"')";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("New Insert into Table Fikus is completed.");
	}
	
	@FXML
	public void updaten() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		idtext = idf.getText();
		nametext = namef.getText();
		ids = Integer.parseInt(idtext);
		java.sql.Connection conn = Connection.connecten();
		String query = "UPDATE Fikus SET Name = '"+ nametext +"' WHERE idFikus IN ("+ids+")";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("Update at Table Fikus is completed.");
	}
	
	@FXML
	public void delete() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		idtext = idf.getText();
		nametext = namef.getText();
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
		id = new TableColumn<Fikus, Integer>("id");
		id.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("id"));
		name = new TableColumn<Fikus, String>("name");
		name.setCellValueFactory(new PropertyValueFactory<Fikus, String>("name"));
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
				//fikus = new Fikus(idFikus, nameFikus);
				//System.out.println(fikus.getName());
				//System.out.println(fikus.getid());
				list.add(fikus);
				//System.out.println(fikus);
				System.out.println("list: " +list);
			}
			//data.addAll(list);
				
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
	public void initialize(URL location, ResourceBundle resources) {
	
		//id.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("id"));
		//name.setCellValueFactory(new PropertyValueFactory<Fikus, String>("name"));
		//table.setItems(data);
	//	first.setCellValueFactory(new PropertyValueFactory<Fikus, String>("ID"));
	 //   second.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Name"));
	  //  tableview.setItems(data);
	}

	public void show1 () {
		Stage primarystage = new Stage();
		fikus_show_window window = new fikus_show_window();
		window.start(primarystage);
	}
	
	public void search () throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		idtext = idf.getText();
		nametext = namef.getText();
		ids = Integer.parseInt(idtext);
		java.sql.Connection conn = Connection.connecten();
		String query = "SELECT * from Fikus WHERE idFikus LIKE ? OR Name LIKE ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, idtext);
		stmt.setString(2, nametext);
		ResultSet set = stmt.executeQuery(query);
		stmt.executeUpdate();
		System.out.println("New Delete at Table Fikus is completed.");


		   while(set.next()){
			   set.getString("idtext");
			   set.getString("nametext");
			   System.out.println(set.getString(0));

               }
	}
}