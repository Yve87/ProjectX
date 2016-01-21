package application;

import java.lang.reflect.AccessibleObject;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class fikus_insert_controller {
	
	@FXML private TextField name; 
	@FXML private TextField id;
	@FXML private Button button;
	private String idtext;
	private String nametext;
	private int ids;
	@FXML TableView<Fikus> tableview;
	@FXML TableColumn<Fikus, Integer> first;
	@FXML TableColumn<Fikus, String> second;
	
	
	
	public fikus_insert_controller(){
		
	}
	public void listview(){
		tableview = new TableView<Fikus>();
		first.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("ID"));
		second.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Name"));
		ObservableList<Fikus> data = FXCollections.observableArrayList();
		data.add(new Fikus(23,"Nils"));
		
		tableview.setItems(data);
	}
	
	
	
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
		Fikus fikus = new Fikus(ids,nametext);
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
		Fikus fikus = new Fikus(ids,nametext);
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
		tableview = new TableView<>();
	}
}