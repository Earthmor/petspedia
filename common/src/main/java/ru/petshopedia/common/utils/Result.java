package ru.petshopedia.common.utils;

import java.io.Serializable;
import java.util.List;

/**
 * Результат выполсения операций
 */
public class Result implements Serializable {

    /** */
    private static final long serialVersionID = 2L;

    /**
     * Сообщение
     */
    private String message;

    /**
     * Результат
     */
    private boolean success;

    /** */
    private List data;

    /** */
    public Result(){}

    /** */
    public Result(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    /** */
    public Result(String message, boolean success, List data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }

    /**
     * see {@link #message}
     */
    public String getMessage() {
        return message;
    }

    /**
     * see {@link #message}
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * see {@link #success}
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * see {@link #success}
     */
    public void setSuccess(boolean success) {
        this.success = success;
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
