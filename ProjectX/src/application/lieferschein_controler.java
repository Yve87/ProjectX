package application;

public class lieferschein_controler {
	
	private int lieferscheinidtext;
	private String fikusnametext;
	private String perkusnametext;
	private int produktidtext;
	private String nametext;
	private double pricetext;
	private double newpricetext;
	private float rabatttext;
	
	public void erstellen(){
		
		AngebotSchreiben datei = new AngebotSchreiben();
		datei.schreibeString("Neues Angebot\n");
		datei.schreibeString("1. Angebot: \n ID: " + produktidtext + "\n Name: " 
		+nametext+"\n Price:"+pricetext+"\n New Price: "+newpricetext+ "\n Rabatt: "
				+rabatttext);
		
	}
}
