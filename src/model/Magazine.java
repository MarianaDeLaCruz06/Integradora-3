package model;

import java.util.Calendar;

public class Magazine extends BibliographicProducts implements Buyable{

    private TypeMagazine category;
    private double valueSuscription;
    private String emissionPeriod;
    private int numSubscription;


    public Magazine(String id, String nameBP, int numPages, Calendar publicateDate, String URL, int acumReadPages, TypeMagazine category, double valueSubscription, String emissionPeriod, int numSuscription) {
        super(id, nameBP, numPages, publicateDate, URL, acumReadPages);

        this.category = category;
        this.valueSuscription = valueSuscription;
        this.emissionPeriod = emissionPeriod;
        this.numSubscription = numSuscription;
    }

    public Magazine(Magazine magazineToCopy){ 
        super(magazineToCopy.getId(), magazineToCopy.getNameBP(), magazineToCopy.getNumPages(), magazineToCopy.getPublicateDate(), magazineToCopy.getURL(), magazineToCopy.getAcumReadPages());

        this.category = magazineToCopy.getCategory();
        this.valueSuscription = magazineToCopy.getValueSubscription();
        this.emissionPeriod = magazineToCopy.getEmissionPeriod();
        this. numSubscription = magazineToCopy.getNumSuscription();
        
    }


    public TypeMagazine getCategory() {
        return category;
    }

    public void setCategory(TypeMagazine category) {
        this.category = category;
    }

    public double getValueSubscription() {
        return valueSuscription;
    }

    public void setValueSubscription(double valueSubscription) {
        this.valueSubscription = valueSubscription;
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


    @Override
    public void buy() {
        setNumSuscription(getNumSuscription()+1);
    }
    
}
