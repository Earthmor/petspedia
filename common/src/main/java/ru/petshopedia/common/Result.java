package ru.petshopedia.common;

import java.io.Serializable;

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
    public Result() {}

    /** */
    public Result(String message, boolean success) {
        this.message = message;
        this.success = success;
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
}