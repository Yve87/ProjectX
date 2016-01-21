package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Fikus {
	
	public final SimpleIntegerProperty id;
	public final SimpleStringProperty name;
	
	
	public Fikus(int id,String name){
		this.name = new SimpleStringProperty (name);
		this.id = new SimpleIntegerProperty(id);
	}

	public Integer getid(){
		return id.get();
	}
	
	public String getName(){
		return name.get();
	}
}
