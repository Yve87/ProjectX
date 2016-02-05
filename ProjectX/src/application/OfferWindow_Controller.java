package application;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
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
import com.sun.glass.ui.Pixels.Format;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OfferWindow_Controller implements Initializable{
 
    LocalDate today = LocalDate.now();
    LocalDate todayplus30 = today.plusDays(30);
    
    @FXML private TextField fikusText;  
	@FXML private TextField fikusname;
	@FXML private TextField produktname;
	@FXML private TextField perkusname;
	@FXML private TextField standortname;
	@FXML private TextField preis;
	@FXML private TextField rabatt;
	@FXML private TextField menge;
	@FXML private ChoiceBox<String> choicebox;
	String fikusString;
	
	int zahl = 0;
	int mengetext;
	int produktmenge = 0;
	String fikusnametext;
	String perkusnametext;
	String produktnametext;
	String standortnametext;
	float preistext;
	float rabatttext;
	int idangebot;
	Date gueltigkeit;
	Product produkt = null;
	int size;
	
	float left = 30;
    float right = 30;
    float top = 60;
    float bottom = 0;
    Document document = new Document(PageSize.A4, left, right, top, bottom);
	ObservableList<Product> list = FXCollections.observableArrayList();
	ArrayList<Integer> mengen = new ArrayList<Integer>();
	int index = 1;
	int listsize;
	float erstesprodukt;
	float zweitesprodukt;
	PeopleCustomers perkus;

	DecimalFormat f = new DecimalFormat("#0.00"); 
	
	@SuppressWarnings("deprecation")
	public void angebot_erstellen() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, FileNotFoundException, DocumentException{
		idangebot++;
		fikusString = fikusText.getText();
		//produktnametext = produktname.getText();
		perkusnametext = perkusname.getText();
		standortnametext = standortname.getText();
		//preistext = Float.parseFloat(preis.getText());
		//rabatttext = Integer.parseInt(rabatt.getText());
		mengetext = Integer.parseInt(menge.getText());
		gueltigkeit = Date.valueOf(todayplus30);
		
		
			
		java.sql.Connection conn = Connection.connecten();
		String strasse = "SELECT Fikus WHERE Name='"+ fikusString+"'";
		//String query2 = "SELECT Produkt WHERE Name='"+ produktnametext+"'";
		String query3 = "SELECT Name FROM Perkus WHERE idPerkus='"+ perkusnametext+"'";
		//String query4 = "SELECT Standort WHERE Name='"+ standortnametext+"'";
		//String query5 = "SELECT Produkt WHERE Preis='"+ preistext+"'";
		//String query6 = "SELECT Produkt WHERE Rabatt='"+ rabatttext+"'";
		
		//PreparedStatement stmt1 = conn.prepareStatement(strasse);
		//PreparedStatement stmt2 = conn.prepareStatement(query2);
		PreparedStatement stmt3 = conn.prepareStatement(query3);
		//PreparedStatement stmt4 = conn.prepareStatement(query4);
		//PreparedStatement stmt5 = conn.prepareStatement(query5);
		//PreparedStatement stmt6 = conn.prepareStatement(query6);
		
		
		//stmt2.executeQuery();
		ResultSet set = stmt3.executeQuery();

		int idPerkus = 8;
		
	
		 // PDF create step 1
    	// Using a custom page size
		
        /** Path to the resulting PDF file. */
        final String RESULT
            = "./Angebot_"+perkusnametext+".pdf";
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(RESULT));
;
        // step 3
        document.open();
        document.addTitle("Offer");
        document.addCreationDate();
        document.add(new Paragraph("Created: " + today.getDayOfMonth() + "." + today.getMonthValue() 
        + "." + today.getYear(), new Font(Font.FontFamily.HELVETICA, 9, Font.ITALIC)));
        document.add(new Paragraph(" "));
        // step 4
        
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
        document.add(new Paragraph("Street: " +strasse, new Font(Font.FontFamily.HELVETICA, 9)));
        document.add(new Paragraph(" "));
        Paragraph paragraph1 = new Paragraph("Offer "+idangebot,new Font(Font.FontFamily.HELVETICA, 20, Font.BOLDITALIC, BaseColor.BLUE));              
        document.add(paragraph1);
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Dear Sir or Madam, \n"
        		+ "attached you receive the following offer:  \n", new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
        document.add(new Paragraph(" "));
        
        postion_hinzufuegen();
        float preistextRabatt = erstesprodukt + zweitesprodukt;
        document.add(new Paragraph("Total price with discount: " + f.format(preistextRabatt) + "EUR", new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD, BaseColor.BLUE))); 
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        if(size >= 2){
          	 document.add(new Paragraph(" "));
   			 document.add(new Paragraph(" "));
   		     document.add(new Paragraph(" "));
   		     document.add(new Paragraph(" "));
   		     document.add(new Paragraph(" "));
   		     document.add(new Paragraph(" "));
   		     document.add(new Paragraph(" "));
   			 document.add(new Paragraph(" "));
          }
        document.add(new Paragraph("Terms and Conditions:, \n"
        		+ "- The Sample Company license terms are valid. \n"
        		+ "- All prices are quoted in addition of sales tax.\n"
        		+ "- Payment follows 30 days net. This offer is non-binding and is valid until " 
        		+ + todayplus30.getDayOfMonth() +"." + todayplus30.getMonthValue() + "." + today.getYear(), 
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
        alert.setContentText("The Offer PDF has been created!");
        alert.showAndWait();
        String query7 = "INSERT INTO Angebot(idAngebot,Produktname,Gesamtpreis,Rabatt,gueltig_bis,Perkus_idPerkus)" 
				+ "values('"+idangebot+"','"+produktnametext+"','"+preistextRabatt+"','"+rabatttext+"','"+gueltigkeit+"','"+idPerkus+"')";
        PreparedStatement stmt7 = conn.prepareStatement(query7);
        stmt7.executeUpdate();
	}

	public void show(){
		Stage primarystage = new Stage();
		PreviousDocumentWindow window = new PreviousDocumentWindow();
		window.start(primarystage);
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
		System.out.println(list.size());
		
	}
	
	public void postion_hinzufuegen() throws DocumentException{
		
		listsize = list.size();
		size = listsize;
		while(listsize > 0){
			
			System.out.println("Die: "+listsize);
			produkt = list.get(listsize-1);
				float gesamtpreistext = produkt.getlistenspreis() * mengen.get(listsize-1);
				float rabattsumme = ((float)rabatttext)/100;
				float preistextRabatt = (float) (gesamtpreistext * (1-rabattsumme));
				float rabattEuro = (float) gesamtpreistext * rabattsumme;
			
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
			}	
			listsize--;
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		java.sql.Connection conn;
		try {
			conn = Connection.connecten();
			String query = "SELECT * FROM Angebot";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet set = stmt.executeQuery();
			Offer angebot = null;
			idangebot = 0;
			while(set.next()){
				
				angebot = new Offer(set.getInt(1),set.getString(2),set.getDouble(3),set.getFloat(4),set.getDate(5)
						,set.getInt(6));
				idangebot = angebot.getangebotsid();
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
