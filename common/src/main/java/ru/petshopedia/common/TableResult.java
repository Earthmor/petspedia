package ru.petshopedia.common;

import java.util.List;

public class TableResult extends Result {

    /** */
    private List data;

    /** */
    public TableResult(String message, boolean success, List data) {
        super(message, success);
        this.data = data;
    }

    /**
     * see {@link #data}
     */
    public List getData() {
        return data;
    }

    /**
     * see {@link #data}
     */
    public void setData(List data) {
        this.data = data;
    }
}

