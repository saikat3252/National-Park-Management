package com.example.nationalparkmanagement.saikat;

import java.io.Serializable;
import java.time.LocalDate;

public class IllegalActivityReport implements Serializable {

    private String rangerName;
    private String activityType;
    private String location;
    private LocalDate date;
    private String description;

    public IllegalActivityReport(String rangerName, String activityType, String location,
                                 LocalDate date, String description) {

        this.rangerName = rangerName;
        this.activityType = activityType;
        this.location = location;
        this.date = date;
        this.description = description;
    }

    public String getRangerName() { return rangerName; }
    public String getActivityType() { return activityType; }
    public String getLocation() { return location; }
    public LocalDate getDate() { return date; }
    public String getDescription() { return description; }
}