package net.azma.webapp.model;

import java.util.List;

public class MultiTextSection extends Section {
    private List<String> values;

    public MultiTextSection(SectionType type) {
        super(type);
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
