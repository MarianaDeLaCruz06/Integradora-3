package model;

import java.text.DateFormat;
import java.util.Calendar;

public abstract class BibliographicProducts implements Comparable<BibliographicProducts> {
    
    private String id;
    private String nameBP;
    private int numPages;
    private Calendar publicateDate;
    private String URL;
    private int acumReadPages;

    private DateFormat format;

    public BibliographicProducts(String id, String nameBP, int numPages, Calendar publicateDate, String URL, int acumReadPages){

        this.id = id;
        this.nameBP = nameBP; 
        this.numPages = numPages;
        this.publicateDate = publicateDate;
        this.URL = URL;
        this.acumReadPages = 0;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameBP() {
        return nameBP;
    }

    public void setNameBP(String nameBP) {
        this.nameBP = nameBP;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public Calendar getPublicateDate() {
        return publicateDate;
    }

    public void setPublicateDate(Calendar publicateDate) {
        this.publicateDate = publicateDate;
    }

    public DateFormat getFormat() {
        return format;
    }

    public void setFormat(DateFormat format) {
        this.format = format;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String uRL) {
        URL = uRL;
    }

    public int getAcumReadPages() {
        return acumReadPages;
    }

    public void setAcumReadPages(int acumReadPages) {
        this.acumReadPages = acumReadPages;
    }

    public String toString() {
        return "BibliographicProducts id=" + id 
                + ", nameBP=" + nameBP 
                + ", numPages=" + numPages 
                + ", publicateDate=" + publicateDate
                + ", URL" + URL
                + ", Acumulate Read Pages" + acumReadPages;
    }

    @Override
    public int compareTo(BibliographicProducts o) {
        
        return this.getPublicateDate().compareTo(o.getPublicateDate());
    }

    

    
}
