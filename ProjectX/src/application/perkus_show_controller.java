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

public class perkus_show_controller implements Initializable{
	
	@FXML private TextField namep; 
	@FXML private TextField idp;
	@FXML private TextField vornamep;
	@FXML private TextField anredep;
	@FXML private TextField titelp;
	@FXML private TextField abteilungp; 
	@FXML private TextField gebaeudenummerp;
	@FXML private TextField zimmernummerp;
	@FXML private TextField telp;
	@FXML private TextField faxp;
	@FXML private TextField emailp; 
	@FXML private TextField positionp;
	@FXML private TextField fikusidp;
	@FXML private Button button;
	private String idtext;
	private String nametext;
	private String vornametext;
	private String anredetext;
	private String titeltext;
	private String abteilungtext;
	private String gebaeudenummertext;
	private String zimmernummertext;
	private String teltext;
	private String faxtext;
	private String emailtext;
	private String positiontext;
	private String fikusidtext;
	private int ids;
	
	@FXML TableView<Fikus> table;
	@FXML TableColumn<Fikus, Integer> id;
	@FXML TableColumn<Fikus, String> name;
	@FXML TableColumn<Fikus, String> vorname;
	@FXML TableColumn<Fikus, String> anrede;
	@FXML TableColumn<Fikus, String> titel;
	@FXML TableColumn<Fikus, String> abteilung;
	@FXML TableColumn<Fikus, Integer> gebaeudenummer;
	@FXML TableColumn<Fikus, Integer> zimmernummer;
	@FXML TableColumn<Fikus, Integer> tel;
	@FXML TableColumn<Fikus, Integer> fax;
	@FXML TableColumn<Fikus, String> email;
	@FXML TableColumn<Fikus, String> position;
	@FXML TableColumn<Fikus, Integer> fikusid;

	@FXML TableView<Fikus> tableview;
	@FXML TableColumn<Fikus, String> first;
	@FXML TableColumn<Fikus, String> second;
	@FXML TableColumn<Fikus, String> third;
	Fikus[] list;
	ArrayList<Integer> listInt;
	Fikus fikus;
	int i = 1;
	int j = 2;
	int k = 3;
	int l = 4;
	int m = 5;
	int n = 6;
	
	ObservableList<Fikus> data = FXCollections.observableArrayList();
	private ObservableList<ObservableList> dataInt = FXCollections.observableArrayList();
	
	@FXML
	public void back()  {	
		Stage primarystage = new Stage();
		Insert_perkus_window window = new Insert_perkus_window();
		window.start(primarystage);
	}
	
	@SuppressWarnings("unchecked")
	
	// SELECT * FROM Perkus WHERE Vorname LIKE ? OR Name LIKE ? 
	public void show(){
		//list = new ArrayList<>();
		listInt = new ArrayList<>();
		id = new TableColumn<Fikus, Integer>("ID");
		id.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("idColumn"));
		name = new TableColumn<Fikus, String>("Name");
		name.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Name"));
		vorname = new TableColumn<Fikus, String>("Vorname");
		vorname.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Vorname"));
		anrede = new TableColumn<Fikus, String>("Anrede");
		anrede.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Anrede"));
		titel = new TableColumn<Fikus, String>("Titel");
		titel.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Titel"));
		abteilung = new TableColumn<Fikus, String>("Abteilung");
		abteilung.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Abteilung"));
		gebaeudenummer = new TableColumn<Fikus, Integer>("Geb�udenummer");
		gebaeudenummer.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("Geb�udenummer"));
		zimmernummer = new TableColumn<Fikus, Integer>("Zimmernummer");
		zimmernummer.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("Zimmernummer"));
		tel = new TableColumn<Fikus, Integer>("Tel");
		tel.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("Tel"));
		fax= new TableColumn<Fikus, Integer>("Fax");
		fax.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("Fax"));
		table = new TableView<Fikus>();
		//data = table.getItems();	// initialize 
		
		try {
			java.sql.Connection conn = Connection.connecten();
			String query = "SELECT * FROM Perkus";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet set = stmt.executeQuery();	// SQL Befehl f�r Inhalt
			ObservableList<Fikus> list = FXCollections.observableArrayList();
			
			while(set.next()){

				int idPerkus = set.getInt(i);
				String namePerkus = set.getString(j);
				String vornamePerkus = set.getNString(k);
				//perkus = new Perkus(idPerkus, namePerkus, vornamePerkus);
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
	
		id.setCellValueFactory(new PropertyValueFactory<Fikus, Integer>("ID"));
		name.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Name"));
		table.setItems(data);
	//	first.setCellValueFactory(new PropertyValueFactory<Fikus, String>("ID"));
	 //   second.setCellValueFactory(new PropertyValueFactory<Fikus, String>("Name"));
	  //  tableview.setItems(data);
	}
}