package ru.petshopedia.common.utils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Результат выполсения операций
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Result implements Serializable {

    /** */
    private static final long serialVersionID = 1L;

    /**
     * Сообщение
     */
    private String message;

    /**
     * Результат
     */
    private boolean success;

    /** */
    public Result(){}

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
