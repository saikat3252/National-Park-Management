package com.example.nationalparkmanagement.saikat;

import java.time.LocalDate;

public class DailyReport {
    private String rangerId;
    private LocalDate date;
    private String reportDetails;

    public DailyReport(String rangerId, LocalDate date, String reportDetails) {
        this.rangerId = rangerId;
        this.date = date;
        this.reportDetails = reportDetails;
    }

    public String getRangerId() { return rangerId; }
    public LocalDate getDate() { return date; }
    public String getReportDetails() { return reportDetails; }

    public void setRangerId(String rangerId) { this.rangerId = rangerId; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setReportDetails(String reportDetails) { this.reportDetails = reportDetails; }
}