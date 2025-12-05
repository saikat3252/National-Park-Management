package com.example.nationalparkmanagement.saikat;

public class PatrolRoute {
    private String routeId;
    private String region;
    private String schedule;

    public PatrolRoute(String routeId, String region, String schedule) {
        this.routeId = routeId;
        this.region = region;
        this.schedule = schedule;
    }

    public String getRouteId() { return routeId; }
    public String getRegion() { return region; }
    public String getSchedule() { return schedule; }

    public void setRouteId(String routeId) { this.routeId = routeId; }
    public void setRegion(String region) { this.region = region; }
    public void setSchedule(String schedule) { this.schedule = schedule; }
}
