package application;

public class rechnung_controler {
	
	private int rechnungidtext;
	private String fikusnametext;
	private String perkusnametext;
	private int produktidtext;
	private String nametext;
	private double pricetext;
	private double newpricetext;
	private float rabatttext;
	
	public void erstellen(){
		Rechnungschreiben datei1 = new Rechnungschreiben();
		datei1.schreibeString("Neue Rechnung");
		
		AngebotSchreiben datei = new AngebotSchreiben();
		datei.schreibeString("Neues Angebot\n");
		datei.schreibeString("1. Angebot: \n ID: " + produktidtext + "\n Name: " 
		+nametext+"\n Price:"+pricetext+"\n New Price: "+newpricetext+ "\n Rabatt: "
				+rabatttext);
		
	}
}
