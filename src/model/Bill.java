package model;

import java.text.DateFormat;
import java.util.Calendar;

public class Bill {
    private double amountPaid;
    private Calendar dateTransaction;
    private String nameUser;
    private String nameProduct;


    private DateFormat format;

    public Bill(double amountPaid, Calendar dateTransaction, String nameUser, String nameProduct){
        this.amountPaid = amountPaid;
        this.dateTransaction = dateTransaction;
        this.nameUser = nameUser;
        this.nameProduct = nameProduct;
    }

    public double getAmountPaid() {
        return amountPaid;
    }


    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }


    public Calendar getDateTransaction() {
        return dateTransaction;
    }


    public void setDateTransaction(Calendar dateTransaction) {
        this.dateTransaction = dateTransaction;
    }


    public String getNameUser() {
        return nameUser;
    }


    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }


    public String getNameProduct() {
        return nameProduct;
    }


    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }


    public DateFormat getFormat() {
        return format;
    }


    public void setFormat(DateFormat format) {
        this.format = format;
    }
    


}
