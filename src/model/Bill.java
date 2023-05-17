package model;

import java.text.DateFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Bill {
    private BibliographicProducts product;
    private Calendar dateTransaction;
    private String namebuyer;

    private SimpleDateFormat simpleDateFormat;
    private DateFormat format;

    public Bill(Calendar dateTransaction, BibliographicProducts product,String namebuyer){
        this.product = product;
        this.dateTransaction = dateTransaction;
        this.namebuyer=namebuyer;
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }

   
    public Calendar getDateTransaction() {
        return dateTransaction;
    }


    public void setDateTransaction(Calendar dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public DateFormat getFormat() {
        return format;
    }


    public void setFormat(DateFormat format) {
        this.format = format;
    }
    
    public String getNamebuyer() {
        return namebuyer;
    }


    public void setNamebuyer(String namebuyer) {
        this.namebuyer = namebuyer;
    }




    @Override
    public String toString() {
        return "Bill:\n"
                + "Product: " + product.getNameBP() + "\n"
                + "Transaction Date: " + changeFormat(dateTransaction) + "\n"
                + "Buyer's Name: " + namebuyer + "\n";
    }
    

    public String changeFormat(Calendar date){
        String formatDate= simpleDateFormat.format(date.getTime());
        return formatDate;
    }

}
