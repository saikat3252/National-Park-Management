package com.example.nationalparkmanagement.saikat;

import java.io.Serializable;

public class Visitor implements Serializable {

    private String name;
    private int age;
    private String contact;
    private String uid;

    public Visitor(String name, int age, String contact, String uid) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public String getName() { return name; }

    public int getAge() { return age; }

    public String getContact() { return contact; }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
