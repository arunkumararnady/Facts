package com.assignment.facts.data;

import java.util.List;

/**
 * An object representing the response.
 */
public class CountryData {
    private String title;
    private List<RowData> rows;

    public CountryData(String title, List<RowData> rows) {
        this.title = title;
        this.rows = rows;
    }

    /**
     * Get the title.
     *
     * @return The title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the list of rows.
     *
     * @return The rows.
     */
    public List<RowData> getRowsData() {
        return rows;
    }
}
