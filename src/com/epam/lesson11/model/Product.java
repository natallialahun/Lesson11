package com.epam.lesson11.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Natallia_Lahun on 03/28/2017.
 */
public class Product implements Serializable {
    private int productID;
    private String productName;
    private String productCategory;
    private String producerCode;
    private Date productionDate;
    private String productDescription;

    private static final Long serialVersionUID = 1L;


    public Product(int productID, String productName, String productCategory, String producerCode,
                   Date productionDate, String productDescription){
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.producerCode = producerCode;
        this.productionDate = productionDate;
        this.productDescription = productDescription;
    }

    public Product(){}

    public void setProductID(int productID){
        this.productID = productID;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductCategory(String productCategory){
        this.productCategory= productCategory;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
    }

    public int getProductID() {
        return productID;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public String getProducerCode() {
        return producerCode;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public String toString() {
        return "id = "+ productID + ", name = "+ productName + ", category = " + productCategory +
                ", prodution date = " + productionDate + ", producer = " + producerCode + ", Description: "+ productDescription;
    }


}
