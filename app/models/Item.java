package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Item extends Model {
	private int quantity;
	private float tax;
	
	@OneToOne(cascade=CascadeType.ALL)
	public Product product;

	
	public Item(Product p, int qty)
	{
		this.product = p;
		this.quantity = qty;
		this.tax = TaxCalculator.getInstance().calculateTaxes(this.product.getCode(), this.product.getPrice(), qty);
	}
	
	public float calculateSubTotal() {
		float x = 3;
		return x;
	}

	public void decreaseStock() {
	}
	
	public float getTax()
	{
		return this.tax;
	}

}

