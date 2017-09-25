package ru.petshopedia.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Medicine implements Serializable {

    private static final long serialVersionID = 1L;

    /**
     * Уникальный идентификатор лекарства
     */
    Integer id;

    /**
     * Наименование лекарсвта
     */
    String name;

    /**
     * Наименование производителя
     */
    String customer;

    /**
     * Цена
     */
    String price;

    /**
     * Склад хранения
     */
    String stock;

    /**
     * В наличии или нет
     */
    Boolean available;

    /**
     * Дата создания
     */
    Date createDate;

    /**
     * Дата последнего обновления
     */
    Date updateDate;

    /** */
    public Medicine(){}

    /**
     * see {@link #id}
     */
    public Integer getId() {
        return id;
    }

    /**
     * see {@link #id}
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * see {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * see {@link #name}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * see {@link #customer}
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * see {@link #customer}
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     * see {@link #price}
     */
    public String getPrice() {
        return price;
    }

    /**
     * see {@link #price}
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * see {@link #stock}
     */
    public String getStock() {
        return stock;
    }

    /**
     * see {@link #stock}
     */
    public void setStock(String stock) {
        this.stock = stock;
    }

    /**
     * see {@link #available}
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     * see {@link #available}
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    /**
     * see {@link #createDate}
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * see {@link #createDate}
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * see {@link #updateDate}
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * see {@link #updateDate}
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }




}
