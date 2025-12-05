package com.example.nationalparkmanagement.saikat;

public class Ranger {
    private int id;
    private String name;

    public Ranger(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Ranger(String rangerKarim) {
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name;
    }
}

