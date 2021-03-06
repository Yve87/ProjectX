package application;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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

import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DeliveryNoteWindow_Controller implements Initializable{
	

    
    LocalDate today = LocalDate.now();
    LocalDate todayplus30 = today.plusDays(30);
    
	@FXML private TextField fikusname;
	@FXML private TextField perkusid;
	@FXML private TextField standortname;
	@FXML private TextField rabatt;
	@FXML private DatePicker lieferdatum;
	@FXML private TextField menge;
	@FXML private ChoiceBox<String> choicebox;
	String fikusnametext;
	int perkusidtext;
	String produktnametext;
	String standortnametext;
	int preistext;
	int rabatttext;
	int mengetext;
	int listsize;
	float erstesprodukt;
	float zweitesprodukt;
	int idlieferschein;
	Date lieferungsdatum;
	int zahl = 0;
	Product produkt = null;
	PeopleCustomers customer = null;
	ArrayList<Integer> mengen = new ArrayList<Integer>();
	ObservableList<Product> list = FXCollections.observableArrayList();
	DecimalFormat f = new DecimalFormat("#0.00"); 
	int size;
	
	float left = 30;
    float right = 30;
    float top = 100;
    float bottom = 30;
    Document document = new Document(PageSize.A4, left, right, top, bottom);
	
	public void lieferschein_erstellen() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, FileNotFoundException, DocumentException{
		idlieferschein++;
		fikusnametext = fikusname.getText();
		rabatttext = Integer.parseInt(rabatt.getText());
		perkusidtext = Integer.parseInt(perkusid.getText());
		standortnametext = standortname.getText();
		lieferungsdatum = Date.valueOf(lieferdatum.getValue());
		
		java.sql.Connection conn = Connection.connecten();
		String query3 = "SELECT * FROM Perkus WHERE idPerkus = '"+ perkusidtext+"'";
		PreparedStatement stmt3 = conn.prepareStatement(query3);
		ResultSet set = stmt3.executeQuery();
		
		while(set.next()){
			customer = new PeopleCustomers(idlieferschein, set.getString(2), query3, query3, query3, query3, query3, query3, query3, query3, query3, query3, idlieferschein, idlieferschein);
		}
		String perkusnametext = customer.getname();
		
		int idPerkus = perkusidtext;
        // step 2
        
        /** Path to the resulting PDF file. */
        final String RESULT = "./DeliveryNote_"+perkusnametext+".pdf";
        
        PdfWriter.getInstance(document, new FileOutputStream(RESULT));

        // step 3
        document.open();
        document.addTitle("Delivery Note ");
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
        Paragraph paragraph1 = new Paragraph("Delivery Note "+idlieferschein,new Font(Font.FontFamily.HELVETICA, 20, Font.BOLDITALIC, BaseColor.BLUE));              
        document.add(paragraph1);
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Dear Sir or Madam, \n"
        		+ "attached you receive:\n", new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
        document.add(new Paragraph(" "));
	    document.add(new Paragraph(" "));
        postion_hinzufuegen();
        float preistextRabatt = erstesprodukt + zweitesprodukt;
        document.add(new Paragraph("Total price with discount: " + f.format(preistextRabatt) + "EUR", new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD, BaseColor.BLUE))); 
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
       }
        document.add(new Paragraph("Accounting takes places separately. The product stays in our ownership until the product is completely paid.", 
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
        alert.setContentText("The Delivery Note PDF has been created!");
        alert.showAndWait();
        
        String query7 = "INSERT INTO Lieferschein(idLieferschein,Lieferdatum,Fikusname,Produktname,Gesamtpreis,Rabatt,Perkus_idPerkus)" 
				+ "values('"+idlieferschein+"','"+lieferungsdatum+"','"+fikusnametext+"','"+produktnametext+"'"
						+ ",'"+preistextRabatt+"','"+rabatttext+"','"+idPerkus+"')";
        PreparedStatement stmt7 = conn.prepareStatement(query7);
        stmt7.executeUpdate();
	}
	
	public void show(){
		Stage primarystage = new Stage();
		PreviousDocumentWindow window = new PreviousDocumentWindow();
		window.start(primarystage);
	}
	
	public void back(){
		
		Stage primaryStage = new Stage();
		MainWindow window = new MainWindow();
		window.start(primaryStage);
		DeliveryNoteWindow.stage11.close();
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
			String query7 = "SELECT * FROM Lieferschein";
			PreparedStatement stmt7 = conn.prepareStatement(query7);			
			DeliveryNote lieferschein = null;
			ResultSet set = stmt7.executeQuery();
			idlieferschein = 0;
			
			while(set.next()){
				lieferschein = new DeliveryNote(set.getInt(1),set.getDate(2),set.getString(3),
				set.getString(4),set.getDouble(5),set.getFloat(6),set.getInt(7));
				idlieferschein = lieferschein.getlieferscheinid();
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
