package application;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class produkt_insert_controler {
	
	@FXML private TextField produktid;
	@FXML private TextField name;
	@FXML private TextField versionsnummer;
	@FXML private TextField listenpreis;
	@FXML private TextField systemvoraussetzung;
	@FXML private TextField produktcol;
	private int ids;
	private String nametext;
	private int versionsnummertext;
	private int listenpreistext;
	private String systemvoraussetzungtext;
	private String produktcoltext;
	
	public void insert() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		ids = Integer.parseInt(produktid.getText());
		nametext = name.getText();
		versionsnummertext = Integer.parseInt(versionsnummer.getText());
		listenpreistext = Integer.parseInt(listenpreis.getText());
		systemvoraussetzungtext = systemvoraussetzung.getText();
		produktcoltext = produktcol.getText();

		java.sql.Connection conn = Connection.connecten();
		String query = "INSERT INTO Produkt(idProdukt,Name,Versionsnummer,Listenpreis,"
				+ "Systemvoraussetzungen,Produktcol)"
				+ "values('"+ids+"','"+nametext+"','"+versionsnummertext+"','"+listenpreistext+"','"+systemvoraussetzungtext+"','"
				+produktcoltext+"')";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("New Insert into Table Produkt is completed.");
	}

}
