package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Temporal extends Model {
	private long code;
	private String description;
	private float price;
	private int cantidad;
	

	public Temporal(long codeL, String descrip, float priceF,int qty) {
		this.code = codeL;
		this.description = descrip;
		this.price = priceF;
		this.cantidad = qty;

	}
	

}
