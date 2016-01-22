package application;

public class Angebot {

	private int produktid;
	private String name;
	private double price;
	private double newprice;
	private float rabatt;
	
	
	public Angebot(int produktid,String name,double price,double newprice,float rabatt){
		
		this.produktid = produktid;
		this.name = name;
		this.price = price;
		this.newprice = newprice;
		this.rabatt = rabatt;
	}
}
