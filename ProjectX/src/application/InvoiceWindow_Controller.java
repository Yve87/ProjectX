package application;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


 
/**
 * Hello World: document constructor.
 */
public class InvoiceWindow_Controller implements Initializable{
	
    
 
    LocalDate today = LocalDate.now();
    LocalDate todayplus30 = today.plusDays(30);
    
	@FXML private TextField fikusname;
	@FXML private TextField produktname;
	@FXML private TextField perkusname;
	@FXML private TextField standortname;
	@FXML private TextField preis;
	@FXML private TextField rabatt;
	@FXML private DatePicker rechnungdatum;
	@FXML private TextField menge;
	@FXML private ChoiceBox<String> choicebox;
	String fikusnametext;
	String perkusnametext;
	String produktnametext;
	String standortnametext;
	Product produkt = null;
	ArrayList<Integer> mengen = new ArrayList<Integer>();
	int zahl = 0;
	int preistext;
	int rabatttext;
	int rechnungsid;
	Date rechnungsdatum;
	int bestellnummer;
	int lieferscheinid;
	int vorgaengerrechnung;
	int bezahlt;
	int mengetext;
	int listsize;
	int size;
	float erstesprodukt;
	float zweitesprodukt;
	
	float left = 30;
    float right = 30;
    float top = 100;
    float bottom = 30;
    Document document = new Document(PageSize.A4, left, right, top, bottom);
    ObservableList<Product> list = FXCollections.observableArrayList();
	

	DecimalFormat f = new DecimalFormat("#0.00"); 
	
	
	public void rechnung_erstellen() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, FileNotFoundException, DocumentException{
		
		rechnungsid++;
		rechnungsdatum = Date.valueOf(rechnungdatum.getValue());
		fikusnametext = fikusname.getText();
		perkusnametext = perkusname.getText();
		standortnametext = standortname.getText();
		mengetext = Integer.parseInt(menge.getText());
		rabatttext = Integer.parseInt(rabatt.getText());
		
		int lieferantennummer = 192384 + rechnungsid;
		
		java.sql.Connection conn = Connection.connecten();
		String query1 = "SELECT Name FROM Fikus WHERE Name='"+fikusnametext+"'";
		String query2 = "SELECT * FROM Produkt WHERE Name='"+produktnametext+"'";
		String query3 = "SELECT * FROM Perkus WHERE Name='"+perkusnametext+"'";
		String query4 = "SELECT * FROM Standort WHERE Name='"+standortnametext+"'";
		String query5 = "SELECT * FROM Produkt WHERE Listenpreis='"+preistext+"'";
		String query6 = "SELECT * FROM Lizenz WHERE Rabatt='"+rabatttext+"'";
		String idquery = "SELECT idRechnung FROM Rechnung WHERE Name='"+fikusnametext+"'";
		
		String query8 = "SELECT * FROM Rechnung WHERE idRechnung";

		PreparedStatement stmt1 = conn.prepareStatement(query1);
		PreparedStatement stmt2 = conn.prepareStatement(query2);
		PreparedStatement stmt3 = conn.prepareStatement(query3);
		PreparedStatement stmt4 = conn.prepareStatement(query4);
		PreparedStatement stmt5 = conn.prepareStatement(query5);
		PreparedStatement stmt6 = conn.prepareStatement(query6);
		
		PreparedStatement stmt8 = conn.prepareStatement(query8);
		PreparedStatement stmt9 = conn.prepareStatement(idquery);
		stmt1.executeQuery();
		stmt2.executeQuery();
		stmt3.executeQuery();
		stmt4.executeQuery();
		stmt5.executeQuery();
		stmt6.executeQuery();
		
		stmt8.executeQuery();
		//stmt9.executeQuery();
		
		ResultSet set = stmt1.executeQuery();
		String strasse1 = set.toString();
		System.out.println(set);
		
		//ResultSet set1 = stmt9.executeQuery();
		//rechnungsid = set.getInt(0);
		
		
      //  document.setMargins(left, right, bottom, top);
        // step 2
        
        /** Path to the resulting PDF file. */
        final String RESULT
            = "./Invoice_"+perkusnametext+".pdf";
        
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
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        Paragraph paragraph1 = new Paragraph("Invoice "+rechnungsid,new Font(Font.FontFamily.HELVETICA, 20, Font.BOLDITALIC, BaseColor.BLUE));              
        document.add(paragraph1);
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Dear Sir or Madam, \n"
        		+ "attached you receive the following invoice: Invoice ID " +rechnungsid +"\n", new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
        document.add(new Paragraph(" "));
	    document.add(new Paragraph(" "));
        postion_hinzufuegen();
        float preistextRabatt = erstesprodukt + zweitesprodukt;
        if(size >= 2){
         	 document.add(new Paragraph(" "));
  			 document.add(new Paragraph(" "));
  		     document.add(new Paragraph(" "));
  		     document.add(new Paragraph(" "));
  		     document.add(new Paragraph(" "));
  		     document.add(new Paragraph(" "));
  		     document.add(new Paragraph(" "));
  			 document.add(new Paragraph(" "));
  		     document.add(new Paragraph(" "));
  			 document.add(new Paragraph(" "));
  		     document.add(new Paragraph(" "));
  			 document.add(new Paragraph(" "));
          }
        document.add(new Paragraph("We please you to transfer the total amount of EUR "+f.format(preistextRabatt)+"\n"
        		+ "on the Sample Company on the bank account 123456789, OurBank OurCity, \n"
        		+ "Bank Rounting Number 12300000. Term of payment: 30 days net", 
        		new Font(Font.FontFamily.HELVETICA, 11, Font.ITALIC)));
        document.add(new Paragraph(" "));        
        document.add(new Paragraph("With kind regards,", new Font(Font.FontFamily.HELVETICA, 13)));
        document.add(new Paragraph("Sample Company", new Font(Font.FontFamily.HELVETICA, 13)));
        document.add(new Paragraph("Sample Company employee", new Font(Font.FontFamily.HELVETICA, 13)));       
     
        // step 5
        document.close();
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("The Invoice PDF has been created!");
        alert.showAndWait();
        
        lieferscheinid = 2;
        String query7 = "INSERT INTO Rechnung(idRechnung,Rechnungsdatum,Betrag,"
    			+ "Lieferantennummer,Perkusname,Fikusname,Produktname,Lieferschein_idLieferschein)"
    		+ "values('"+rechnungsid+"','"+rechnungsdatum+"','"+preistextRabatt+"','"+lieferantennummer
    			+ "','"+perkusnametext+"','"+fikusnametext+"','"
    			+ ""+produktnametext+"','"+lieferscheinid+"')";
    		PreparedStatement stmt7 = conn.prepareStatement(query7);
    		stmt7.executeUpdate();
        }
	
        // step 4
		
	public void show(){
		Stage primarystage = new Stage();
		PreviousDocumentWindow window = new PreviousDocumentWindow();
		window.start(primarystage);
	}
	
	public void back(){
		Stage primaryStage = new Stage();
		MainWindow window = new MainWindow();
		window.start(primaryStage);
		InvoiceWindow.stage9.close();
	}
	public void postion_hinzufuegen() throws DocumentException{
		
		listsize = list.size();
		size = listsize;
		while(listsize > 0){
			produkt = list.get(listsize-1);
				float gesamtpreistext = produkt.getlistenspreis() * mengen.get(listsize-1);
				float rabattsumme = ((float)rabatttext)/100;
				float preistextRabatt = (float) (gesamtpreistext * (1-rabattsumme));
				float rabattEuro = (float) gesamtpreistext * rabattsumme;
				
				if(listsize == 2){
					erstesprodukt = preistextRabatt;
				}
				zweitesprodukt = preistextRabatt;	
				
			document.add(new Paragraph("Product: " + produkt.getname(),  new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD)));
	        document.add(new Paragraph("Amount: " + mengen.get(listsize-1),  new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD)));
	        document.add(new Paragraph(" "));
	        document.add(new Paragraph("Price of a single item without discount: " + f.format(produkt.getlistenspreis()) +"EUR",  new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD)));
	        document.add(new Paragraph("Total price for all items without discount: " + f.format(gesamtpreistext) + "EUR",  new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD)));
	        document.add(new Paragraph(" "));
	        document.add(new Paragraph("Discount: " + rabatttext + "%",  new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD)));
	        document.add(new Paragraph(" "));
	        document.add(new Paragraph("Price of a single item with discount: " + f.format(preistextRabatt/mengen.get(listsize-1)) +"EUR",  new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD)));
	        document.add(new Paragraph("Total discount: " + f.format(rabattEuro) + "EUR",  new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD)));
	        document.add(new Paragraph(" ")); 
	        document.add(new Paragraph(" "));
	        document.add(new Paragraph(" "));
	        if(listsize > 1){
				 document.add(new Paragraph(" "));
			     document.add(new Paragraph(" "));
			     document.add(new Paragraph(" "));
			     document.add(new Paragraph(" "));
			     document.add(new Paragraph(" "));
			     document.add(new Paragraph(" "));
				 document.add(new Paragraph(" "));
			     document.add(new Paragraph(" "));
			     document.add(new Paragraph(" "));
			     document.add(new Paragraph(" "));
	   		     document.add(new Paragraph(" "));
	   			 document.add(new Paragraph(" "));
	   			document.add(new Paragraph(" "));
	   			 document.add(new Paragraph(" "));
			}	
			listsize--;
		}
	}

	@FXML
	public void getchoice() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		String option = choicebox.getValue();
		java.sql.Connection conn;
		conn = Connection.connecten();
		String query8 = "SELECT * FROM Produkt";
		PreparedStatement stmt8 = conn.prepareStatement(query8);			
		ResultSet set2 = stmt8.executeQuery();
		
		while(set2.next()){
			produkt = new Product(set2.getInt(1), set2.getString(2),set2.getInt(3),
					set2.getInt(4),set2.getString(5),set2.getString(6),zahl);
			if(option.equals(produkt.getname())){
				list.add(produkt);
				mengetext = Integer.parseInt(menge.getText());
				mengen.add(mengetext);
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		java.sql.Connection conn;
		try {
			conn = Connection.connecten();
			String query = "SELECT * FROM Rechnung";
			PreparedStatement stmt = conn.prepareStatement(query);
			Invoice rechnung = null;
			ResultSet set = stmt.executeQuery();
			rechnungsid = 0;
			while(set.next()){
				rechnung = new Invoice(set.getInt(1),set.getDate(2),set.getFloat(3),
				set.getInt(4),set.getString(5),set.getString(6),set.getString(7),set.getInt(8));
				rechnungsid = rechnung.getrechnungsid();
			}


			
			String query1 = "SELECT Name FROM Produkt";
			PreparedStatement stmt1 = conn.prepareStatement(query1);
			ResultSet set1 = stmt1.executeQuery();
			int counter = 1;
			ArrayList<String> list = new ArrayList<String>();
			while(set1.next()) {
				list.add(set1.getString(counter));
			}
			
			choicebox.getItems().addAll(list);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
