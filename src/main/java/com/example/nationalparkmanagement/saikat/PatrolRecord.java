package com.example.nationalparkmanagement.saikat;

import java.time.LocalDate;

public class PatrolRecord {

    private LocalDate date;
    private String patrolArea;
    private int patrolHours;
    private String activitiesPerformed;
    private String incidentReport;

    public PatrolRecord(LocalDate date, String patrolArea, int patrolHours,
                        String activitiesPerformed, String incidentReport) {
        this.date = date;
        this.patrolArea = patrolArea;
        this.patrolHours = patrolHours;
        this.activitiesPerformed = activitiesPerformed;
        this.incidentReport = incidentReport;
    }

    public LocalDate getDate() { return date; }
    public String getPatrolArea() { return patrolArea; }
    public int getPatrolHours() { return patrolHours; }
    public String getActivitiesPerformed() { return activitiesPerformed; }
    public String getIncidentReport() { return incidentReport; }
}