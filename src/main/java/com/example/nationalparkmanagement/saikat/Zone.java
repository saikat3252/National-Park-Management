package com.example.nationalparkmanagement.saikat;

import java.io.Serializable;

public class Zone implements Serializable {

    private String zoneName;

    public Zone(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getZoneName() {
        return zoneName;
    }

    @Override
    public String toString() {
        return zoneName;
    }
}
