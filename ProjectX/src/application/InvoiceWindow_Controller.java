package application;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.Date;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


 
/**
 * Hello World: document constructor.
 */
public class InvoiceWindow_Controller implements Initializable{
	
    /** Path to the resulting PDF file. */
    public static final String RESULT
        = "./Rechnung.pdf";
 
    LocalDate today = LocalDate.now();
    LocalDate todayplus90 = today.plusDays(90);
    
	@FXML private TextField fikusname;
	@FXML private TextField produktname;
	@FXML private TextField perkusname;
	@FXML private TextField standortname;
	@FXML private TextField preis;
	@FXML private TextField rabatt;
	@FXML private DatePicker rechnungdatum;
	String fikusnametext;
	String perkusnametext;
	String produktnametext;
	String standortnametext;
	int preistext;
	int rabatttext;
	int rechnungsid;
	Date rechnungsdatum;
	int bestellnummer;
	int lieferscheinid;
	int vorgaengerrechnung;
	int bezahlt;
	
	ListView<Object> listview;
	
	public void rechnung_erstellen() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, FileNotFoundException, DocumentException{
		
		rechnungsdatum = Date.valueOf(rechnungdatum.getValue());
		fikusnametext = fikusname.getText();
		produktnametext = produktname.getText();
		perkusnametext = perkusname.getText();
		standortnametext = standortname.getText();
		preistext = Integer.parseInt(preis.getText());
		rabatttext = Integer.parseInt(rabatt.getText());
		java.sql.Connection conn = Connection.connecten();
		String query1 = "SELECT Name FROM Fikus WHERE Name='"+fikusnametext+"'";
		String query2 = "SELECT * FROM Produkt WHERE Name='"+produktnametext+"'";
		String query3 = "SELECT * FROM Perkus WHERE Name='"+perkusnametext+"'";
		String query4 = "SELECT * FROM Standort WHERE Name='"+standortnametext+"'";
		String query5 = "SELECT * FROM Produkt WHERE Listenpreis='"+preistext+"'";
		String query6 = "SELECT * FROM Lizenz WHERE Rabatt='"+rabatttext+"'";
		String idquery = "SELECT idRechnung FROM Rechnung WHERE Name='"+fikusnametext+"'";
		// query7 = "INSERT INTO Rechnung(idRechnung,Rechnungsdatum,Vorgängerrechnung,"
	//			+ "Bezahlt,Betrag,Lieferantennummer,Bestellnummer,Lieferschein_idLieferschein)"
		//		+ "values('"+rechnungsid+"','"+rechnungsdatum+"','"+vorgaengerrechnung+"',"
			//	+ "'"+bezahlt+"','"+preistext+"','"
			//	+ ""+bestellnummer+"','"+lieferscheinid+"')";
		String query8 = "SELECT * FROM Rechnung WHERE idRechnung";

		PreparedStatement stmt1 = conn.prepareStatement(query1);
		PreparedStatement stmt2 = conn.prepareStatement(query2);
		PreparedStatement stmt3 = conn.prepareStatement(query3);
		PreparedStatement stmt4 = conn.prepareStatement(query4);
		PreparedStatement stmt5 = conn.prepareStatement(query5);
		PreparedStatement stmt6 = conn.prepareStatement(query6);
		//PreparedStatement stmt7 = conn.prepareStatement(query7);
		PreparedStatement stmt8 = conn.prepareStatement(query8);
		PreparedStatement stmt9 = conn.prepareStatement(idquery);
		stmt1.executeQuery();
		stmt2.executeQuery();
		stmt3.executeQuery();
		stmt4.executeQuery();
		stmt5.executeQuery();
		stmt6.executeQuery();
		//stmt7.executeQuery();
		stmt8.executeQuery();
		stmt9.executeQuery();
		
		ResultSet set = stmt1.executeQuery();
		String strasse1 = set.toString();
		System.out.println(set);
		
		ResultSet set1 = stmt9.executeQuery();
		rechnungsid = set.getInt(0);
		
		float left = 30;
        float right = 30;
        float top = 100;
        float bottom = 0;
        Document document = new Document(PageSize.A4, left, right, top, bottom);
      //  document.setMargins(left, right, bottom, top);
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(RESULT));

        // step 3
        document.open();
        document.addTitle("Invoice");
        document.addCreationDate();
        document.add(new Paragraph("Created: " + today.getDayOfMonth() + "." + today.getMonthValue() 
        + "." + today.getYear(), new Font(Font.FontFamily.HELVETICA, 11, Font.ITALIC)));
        document.add(new Paragraph(" "));
        
        document.add(new Paragraph("Sample Company",  new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
        document.add(new Paragraph("Street House No.",  new Font(Font.FontFamily.HELVETICA, 9)));
        document.add(new Paragraph("D-12345 City",  new Font(Font.FontFamily.HELVETICA, 9)));
        document.add(new Paragraph("Telephone: 069-12345678, Fax: 069-23456789",  new Font(Font.FontFamily.HELVETICA, 9)));
        document.add(new Paragraph("E-Mail: sampleCompany@email.de",  new Font(Font.FontFamily.HELVETICA, 9)));
        document.add(new Paragraph("http://www.sampleCompany.de",  new Font(Font.FontFamily.HELVETICA, 9)));
        document.add(new Paragraph(" "));
       
        Paragraph paragraph = new Paragraph("To Customer:", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD));
        document.add(paragraph);
        document.add(new Paragraph("People Customer: " + fikusnametext,  new Font(Font.FontFamily.HELVETICA, 9)));
        document.add(new Paragraph("Corporate Customer: " + perkusnametext,  new Font(Font.FontFamily.HELVETICA, 9)));
        document.add(new Paragraph("Location: " + standortnametext,  new Font(Font.FontFamily.HELVETICA, 9)));
        document.add(new Paragraph("Street: ", new Font(Font.FontFamily.HELVETICA, 9)));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        Paragraph paragraph1 = new Paragraph("Invoice",new Font(Font.FontFamily.HELVETICA, 20, Font.BOLDITALIC, BaseColor.BLUE));              
        document.add(paragraph1);
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Dear Sir or Madam, \n"
        		+ "attached you receive the following invoice: Invoice ID " +rechnungsid +"\n", new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
        
        document.close();
        }
        
        // step 4
		/*Rechnungschreiben datei = new Rechnungschreiben();
		datei.schreibeString("Neue Rechnung "+ rechnungsdatum +"\n");
		datei.schreibeString(+rechnungsid+". Rechnung: \n Produktname: " + produktnametext + "\n Firmenkunde: " 
		+fikusnametext+"\n Person:"+perkusnametext+"\n Price: "+preistext+ "\n Rabatt: "
				+rabatttext);
	
		System.out.println("New Rechnung is ready.");
	}
	*/
	public void show(){
		listview = new ListView<>();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		java.sql.Connection conn;
		try {
			conn = Connection.connecten();
			String query = "SELECT * FROM Rechnung";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet set = stmt.executeQuery();
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
