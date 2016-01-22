package application;

import java.lang.reflect.AccessibleObject;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Connection;
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
	@FXML TableView<Fikus> tableview;
	@FXML TableColumn<Fikus, Integer> first;
	@FXML TableColumn<Fikus, String> second;
	ArrayList<Fikus> list;
	
	ObservableList<Fikus> data = FXCollections.observableArrayList();
	
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
	
	public void show(){
		
		try {
			java.sql.Connection conn = Connection.connecten();
			String query = "SELECT * FROM Fikus";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet set = stmt.executeQuery();
			while(set.next()){
				list.add((Fikus) set.getObject(1));
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
		list = new ArrayList<>();
		
		first.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("id"));
		second.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Name"));
		tableview.setItems(data);
	}
}