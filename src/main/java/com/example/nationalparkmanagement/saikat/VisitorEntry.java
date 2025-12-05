package com.example.nationalparkmanagement.saikat;

import java.io.Serializable;
import java.time.LocalDateTime;

public class VisitorEntry implements Serializable {
    private String visitorName;
    private LocalDateTime entryTime;
    private double ticketPrice;

    public VisitorEntry(String visitorName, LocalDateTime entryTime, double ticketPrice) {
        this.visitorName = visitorName;
        this.entryTime = entryTime;
        this.ticketPrice = ticketPrice;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
