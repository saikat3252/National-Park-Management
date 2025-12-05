package com.example.nationalparkmanagement.saikat;

public class RangerPerformanceReport {

    private Ranger ranger;
    private int patrolHours;
    private int tasksCompleted;
    private int incidentsHandled;
    private double rating;
    private String remarks;

    public RangerPerformanceReport(Ranger ranger, int patrolHours, int tasksCompleted,
                                   int incidentsHandled, double rating, String remarks) {
        this.ranger = ranger;
        this.patrolHours = patrolHours;
        this.tasksCompleted = tasksCompleted;
        this.incidentsHandled = incidentsHandled;
        this.rating = rating;
        this.remarks = remarks;
    }

    public Ranger getRanger() { return ranger; }
    public int getPatrolHours() { return patrolHours; }
    public int getTasksCompleted() { return tasksCompleted; }
    public int getIncidentsHandled() { return incidentsHandled; }
    public double getRating() { return rating; }
    public String getRemarks() { return remarks; }

    public void setRemarks(String remarks) { this.remarks = remarks; }
}