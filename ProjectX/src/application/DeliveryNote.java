package application;

public class DeliveryNote {

	private int lieferscheinid;
	private String fikusname;
	private String perkusname;
	private int produktid;
	private String name;
	private double price;
	private double newprice;
	private float rabatt;
	
	
	public DeliveryNote(int lieferscheinid, String fikusname,String perkusname,
			int produktid,String name,double price,double newprice,float rabatt){
		
		this.lieferscheinid = lieferscheinid;
		this.fikusname = fikusname;
		this.perkusname = perkusname;
		this.produktid = produktid;
		this.name = name;
		this.price = price;
		this.newprice = newprice;
		this.rabatt = rabatt;
	}
}
