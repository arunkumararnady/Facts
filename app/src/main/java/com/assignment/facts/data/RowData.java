package com.assignment.facts.data;

/**
 * An object representing a row.
 */
public class RowData {

    private String title;
    private String description;
    private String imageHref;

    public RowData(String title, String description, String imageHref) {
        this.title = title;
        this.description = description;
        this.imageHref = imageHref;
    }

    /**
     * Get the url of the image.
     *
     * @return The url.
     */
    public String getImageURL() {
        return imageHref;
    }

    /**
     * Get the title for the row.
     *
     * @return The title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the description for the row.
     *
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

}
