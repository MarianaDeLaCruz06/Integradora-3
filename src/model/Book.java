package model;

import java.util.Calendar;

public class Book extends BibliographicProducts{
   
    private String reviewShort;
    private TypeBook gender;
    private Double sellingValue;
    private int numCopies;

    public Book(String id, String nameBP, int numPages, Calendar publicateDate, String URL, int acumReadPages, String reviewShort, TypeBook gender, double sellingValue, int numCopies) {
        super(id, nameBP, numPages, publicateDate, URL, acumReadPages);

        this.reviewShort = reviewShort;
        this.gender = gender;
        this.sellingValue = sellingValue;
        this. numCopies = numCopies;
        
        
    }
    
    public String getReviewShort() {
        return reviewShort;
    }

    public void setReviewShort(String reviewShort) {
        this.reviewShort = reviewShort;
    }

    public TypeBook getGender() {
        return gender;
    }

    public void setGender(TypeBook gender) {
        this.gender = gender;
    }

    public Double getSellingValue() {
        return sellingValue;
    }

    public void setSellingValue(Double sellingValue) {
        this.sellingValue = sellingValue;
    }

    public int getNumCopies() {
        return numCopies;
    }

    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }

}

