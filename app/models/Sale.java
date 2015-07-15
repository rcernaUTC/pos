package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Sale extends Model {
	private int number;
	private Date date;
	public Boolean complete;
	private float subtotal;
	private float taxes;
	@OneToMany(cascade = CascadeType.ALL)
	public List<Item> items;
	@OneToOne(cascade = CascadeType.ALL)
	private Payment payment;

	public Sale() {
		this.complete = false;
		this.items = new ArrayList<Item>();
		this.payment = null;
	}

	public void makeItem(Product p, int qty) {
		Item i = new Item(p, qty);
		this.items.add(i);
		// this.save();
	}

	public void becomeComplete() {
		this.complete = true;
	}

	public float calculateTotal() {
		this.subtotal = 0;
		this.taxes = 0;

		for (Item i : this.items) {
			this.subtotal += i.calculateSubTotal();
			this.taxes += i.getTax();
		}

		return this.subtotal + this.taxes;
	}

	public float makeCashPayment(float amount) {
		float x = 3;
		return x;
	}

	public void makeCheckPayment(String number) {
	}

	public void record(String cashier, String register) {
	}

	public void decreaseStock() {
	}

	public boolean verificarItemExistente(Product p) {
		for (int i = 0; i < this.items.size(); i++) {
			Item item = this.items.get(i);
			if (item.product.code == p.code)
				return true;
			else
				return false;
		}

		return false;
	}

}
