package com.example.nationalparkmanagement.saikat;

import java.io.Serializable;
import java.time.LocalDate;

public class WildlifeSighting implements Serializable {

    private String species;
    private String location;
    private LocalDate date;
    private String time;
    private int count;
    private String notes;

    public WildlifeSighting(String species, String location, LocalDate date,
                            String time, int count, String notes) {

        this.species = species;
        this.location = location;
        this.date = date;
        this.time = time;
        this.count = count;
        this.notes = notes;
    }

    public String getSpecies() { return species; }
    public String getLocation() { return location; }
    public LocalDate getDate() { return date; }
    public String getTime() { return time; }
    public int getCount() { return count; }
    public String getNotes() { return notes; }
}