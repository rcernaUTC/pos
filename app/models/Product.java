package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Product extends Model {
	public long code;
	private String description;
	private float price;
	private boolean stock;
	private String nombreImagen;
	private int numStock;

	public Product(long code, String description, float price, boolean stock,
			String nombreImagen, int numStock) {
		this.code = code;
		this.description = description;
		this.price = price;
		this.nombreImagen = nombreImagen;
		this.stock = stock;
		this.numStock = numStock;
	}

	public long getCode() {
		return this.code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getNombreImagen() {
		return this.nombreImagen;
	}

	public void setNombreImagen(String NombreImagen) {
		this.nombreImagen = NombreImagen;
	}

	public boolean getStock() {
		return this.stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

	public String toString() {
		return "nombre: (" + description + ")";
	}
}
