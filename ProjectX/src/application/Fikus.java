package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Fikus {
	
	public final SimpleIntegerProperty id;
	public final SimpleStringProperty name;
	
	
	public Fikus(int id,String name){
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
	}

	public Integer getid(){
		return id.get();
	}
	
	public String getName(){
		return name.get();
	}
}
