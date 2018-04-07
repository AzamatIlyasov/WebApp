package net.azma.webapp.model;

import java.util.Date;

public class OrganizationPeriod {
    private Date startDate;
    private Date endDate;
    private String position;
    private String content;

    public OrganizationPeriod(Date startDate, Date endDate, String position, String content) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.content = content;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
