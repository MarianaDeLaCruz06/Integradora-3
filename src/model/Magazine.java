package model;

import java.util.Calendar;

public class Magazine extends BibliographicProducts{

    private TypeMagazine category;
    private double valueSuscription;
    private String emissionPeriod;
    private int numSuscription;


    public Magazine(String id, String nameBP, int numPages, Calendar publicateDate, String URL, int acumReadPages, TypeMagazine category, double valueSuscription, String emissionPeriod, int numSuscription) {
        super(id, nameBP, numPages, publicateDate, URL, acumReadPages);

        this.category = category;
        this.valueSuscription = valueSuscription;
        this.emissionPeriod = emissionPeriod;
        this.numSuscription = numSuscription;
    }


    public TypeMagazine getCategory() {
        return category;
    }

    public void setCategory(TypeMagazine category) {
        this.category = category;
    }

    public double getValueSuscription() {
        return valueSuscription;
    }

    public void setValueSuscription(double valueSuscription) {
        this.valueSuscription = valueSuscription;
    }

    public String getEmissionPeriod() {
        return emissionPeriod;
    }

    public void setEmissionPeriod(String emissionPeriod) {
        this.emissionPeriod = emissionPeriod;
    }

    public int getNumSuscription() {
        return numSuscription;
    }

    public void setNumSuscription(int numSuscription) {
        this.numSuscription = numSuscription;
    }

    
}
