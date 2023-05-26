package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public abstract class User {
    private String name;
    private String cc;
    private Calendar date;
    private ArrayList<BibliographicProducts[][]> listAllBiblio;

    private SimpleDateFormat simpleDateFormat;
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
        
    public ArrayList<BibliographicProducts[][]> getListAllBiblio() {
        return listAllBiblio;
    }

    public void setListAllBiblio(ArrayList<BibliographicProducts[][]> listAllBiblio) {
        this.listAllBiblio = listAllBiblio;
    }

    public abstract boolean buyBook(Buyable productToBuyB);

    public abstract boolean subscribeMagazine(Buyable productToSubscribeM);

    public abstract String getProducts();
    
    public abstract int sumNumPagesBook();
    public abstract int sumNumPagesMagazine();

    public abstract String showMagazine();

    public abstract boolean cancelSubscription(String idBP);

    public String toString() {
        String msg = "";
        
        msg = "\n Name User:" + name + "\n CC:" + cc + "\n Date:" + date;
        
        return msg;
    }

    

    public String changeFormat(Calendar date){
        String formatDate = simpleDateFormat.format(date.getTime());
        return formatDate;
    }

    
}


