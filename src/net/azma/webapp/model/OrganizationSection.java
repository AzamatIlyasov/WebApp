package net.azma.webapp.model;

import java.util.List;

public class OrganizationSection extends Section {
    private List<Organization> values;

    public OrganizationSection(SectionType type) {
        super(type);
    }

    public List<Organization> getValues() {
        return values;
    }

    public void setValues(List<Organization> values) {
        this.values = values;
    }
}
