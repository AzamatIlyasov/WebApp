package net.azma.webapp.model;

import java.util.List;

public class Organization {
    private Link link;
    private List<OrganizationPeriod> periods;

    public Organization() {
    }

    public Organization(Link link, List<OrganizationPeriod> periods) {
        this.link = link;
        this.periods = periods;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public List<OrganizationPeriod> getPeriods() {
        return periods;
    }

    public void setPeriods(List<OrganizationPeriod> periods) {
        this.periods = periods;
    }
}
