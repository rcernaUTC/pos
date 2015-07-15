package models;

import javax.persistence.Entity;

@Entity
public class CashPayment extends Payment {
    private float change;

}
