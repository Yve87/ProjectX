package application;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
 
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Angebot_Between_Controller implements Initializable{
	
	  /** Path to the resulting PDF file. */
    public static final String RESULT
        = "./Angebot.pdf";
 
    @FXML private TextField fikusText;
    
	@FXML private TextField fikusname;
	@FXML private TextField produktname;
	@FXML private TextField perkusname;
	@FXML private TextField standortname;
	@FXML private TextField preis;
	@FXML private TextField rabatt;
	@FXML private TextField menge;
	String fikusString;
	
	int mengetext;
	String fikusnametext;
	String perkusnametext;
	String produktnametext;
	String standortnametext;
	float preistext;
	float rabatttext;
	ListView<Object> listview;

	DecimalFormat f = new DecimalFormat("#0.00"); 
	
	public void angebot_erstellen() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, FileNotFoundException, DocumentException{
		fikusString = fikusText.getText();
		produktnametext = produktname.getText();
		perkusnametext = perkusname.getText();
		standortnametext = standortname.getText();
		preistext = Float.parseFloat(preis.getText());
		rabatttext = Integer.parseInt(rabatt.getText());
		mengetext = Integer.parseInt(menge.getText());

		float gesamtpreistext = preistext * mengetext;
		float rabattsumme = ((float)rabatttext)/100;
		float preistextRabatt = (float) (gesamtpreistext * (1-rabattsumme));
		float rabattEuro = (float) gesamtpreistext * rabattsumme;
		
		
		/*	
		java.sql.Connection conn = Connection.connecten();
		String query1 = "SELECT Fikus WHERE Name='"+ fikusnametext+"'";
		String query2 = "SELECT Produkt WHERE Name='"+ produktnametext+"'";
		String query3 = "SELECT Perkus WHERE Name='"+ perkusnametext+"'";
		String query4 = "SELECT Standort WHERE Name='"+ standortnametext+"'";
		String query5 = "SELECT Produkt WHERE Preis='"+ preistext+"'";
		String query6 = "SELECT Produkt WHERE Rabatt='"+ rabatttext+"'";
		PreparedStatement stmt1 = conn.prepareStatement(query1);
		PreparedStatement stmt2 = conn.prepareStatement(query2);
		PreparedStatement stmt3 = conn.prepareStatement(query3);
		PreparedStatement stmt4 = conn.prepareStatement(query4);
		PreparedStatement stmt5 = conn.prepareStatement(query5);
		PreparedStatement stmt6 = conn.prepareStatement(query6);
		stmt1.executeUpdate();
		stmt2.executeUpdate();
		stmt3.executeUpdate();
		stmt4.executeUpdate();
		stmt5.executeUpdate();
		stmt6.executeUpdate();
	
		
		AngebotSchreiben datei = new AngebotSchreiben();
		datei.schreibeString("Neues Angebot\n");
		datei.schreibeString("1. Angebot: \n Produktname: " + produktnametext + "\n Firmenkunde: " 
		+fikusnametext+"\n Person:"+perkusnametext+"\n Price: "+preistext+ "\n Rabatt: "
				+rabatttext);
		
		System.out.println("New Advertisement is ready.");
		*/
		 // PDF create step 1
    	// Using a custom page size
		float left = 30;
        float right = 30;
        float top = 60;
        float bottom = 0;
        Document document = new Document(PageSize.A4, left, right, top, bottom);
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(RESULT));
;
        // step 3
        document.open();
        document.addTitle("Angebot");
        document.addCreationDate();
        // step 4
        Paragraph paragraph = new Paragraph("Angebot",new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLUE));     
        Paragraph paragraph1 = new Paragraph("Details:", new Font(Font.FontFamily.HELVETICA, 16, Font.BOLDITALIC));
        Paragraph paragraph2 = new Paragraph("", new Font(Font.FontFamily.HELVETICA, 13));         
        paragraph.add(" ");
        paragraph1.add(" ");
        document.add(paragraph);
        document.add(paragraph1);
        document.add(paragraph2);
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Firmenkunde: " + fikusString));
        document.add(new Paragraph("Personenkunde: " + perkusnametext));
        document.add(new Paragraph("Standort: " + standortnametext));
        document.add(new Paragraph("Produkt: " + produktnametext));
        document.add(new Paragraph("Menge: " + mengetext));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Einzelpreis ohne Rabatt: " + f.format(preistext) +"€"));
        document.add(new Paragraph("Gesamtpreis ohne Rabatt: " + f.format(gesamtpreistext) + "€"));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Rabatt: " + rabatttext + "%"));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Einzelpreis inklusive Rabatt: " + f.format(preistextRabatt/mengetext) +"€"));
        document.add(new Paragraph("Gesamtrabatt: " + rabattEuro + "€"));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Gesamtpreis inklusive Rabatt: " + f.format(preistextRabatt) +"€", new Font(Font.FontFamily.HELVETICA, 14, Font.UNDERLINE))); 
       
        // step 5
        document.close();
	}

	
	public void show(){
		listview = new ListView<>();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		java.sql.Connection conn;
		try {
			conn = Connection.connecten();
			String query = "SELECT * FROM Angebot";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet set = stmt.executeQuery();
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
