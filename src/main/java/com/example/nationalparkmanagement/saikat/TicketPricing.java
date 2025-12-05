package com.example.nationalparkmanagement.saikat;



import java.io.Serializable;

public class TicketPricing implements Serializable {

    private double ticketPrice;
    private double discount;

    public TicketPricing(double ticketPrice, double discount) {
        this.ticketPrice = ticketPrice;
        this.discount = discount;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}