package net.azma.webapp.model;

public class TextSection extends Section {
    private String title;
    private String comment;

    public TextSection(SectionType type) {
        super(type);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
