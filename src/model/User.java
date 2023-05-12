package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class User {
    private String name;
    private String cc;
    private Calendar date;

    private DateFormat formatteDate;

    public User(String name, String cc, Calendar date){

        this.name = name;
        this.cc = cc; 
        this.date = Calendar.getInstance();

        this.formatteDate = new SimpleDateFormat("dd/mm/yy");
    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public DateFormat getFormatteDate() {
        return formatteDate;
    }

    public void setFormatteDate(DateFormat formatteDate) {
        this.formatteDate = formatteDate;
    }

    public abstract boolean buyBook(Buyable productToBuyB);

    public abstract boolean subscribeMagazine(Buyable productToSubscribeM);
    

    public String toString() {
        String msg = "";
        
        msg = "\n Name User:" + name + "\n CC:" + cc + "\n Date:" + date;
        
        return msg;
    }
    
}


