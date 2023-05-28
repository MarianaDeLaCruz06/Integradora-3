package model;

import java.util.Calendar;

public class Magazine extends BibliographicProducts implements Buyable{

    private TypeMagazine category;
    private double valueSubscription;
    private String emissionPeriod;
    private int numSubscription;



    public Magazine(String id, String nameBP, int numPages, Calendar publicateDate, String URL, int acumReadPages, TypeMagazine category, double valueSubscription, String emissionPeriod, int numSubscription) {
        super(id, nameBP, numPages, publicateDate, URL, acumReadPages);

        this.category = category;
        this.valueSubscription = valueSubscription;
        this.emissionPeriod = emissionPeriod;
        this.numSubscription = numSubscription;
    }

    /**
     * This method is the copy of the constructor 
     * @param magazineToCopy
     */

    public Magazine(Magazine magazineToCopy){ 
        super(magazineToCopy.getId(), magazineToCopy.getNameBP(), magazineToCopy.getNumPages(), magazineToCopy.getPublicateDate(), magazineToCopy.getURL(), magazineToCopy.getAcumReadPages());

        this.category = magazineToCopy.getCategory();
        this.valueSubscription = magazineToCopy.getValueSubscription();
        this.emissionPeriod = magazineToCopy.getEmissionPeriod();

        this. numSubscription = magazineToCopy.getNumSubscription();
        
    }

    public TypeMagazine getCategory() {
        return category;
    }

    public void setCategory(TypeMagazine category) {
        this.category = category;
    }

    public double getValueSubscription() {
        return valueSubscription;
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

    public int getNumSubscription() {
        return numSubscription;
    }

    public void setNumSubscription(int numSubscription) {
        this.numSubscription = numSubscription;
    }

    /**
     * intefase
     */
    @Override
    public void buy() {
        setNumSubscription(getNumSubscription()+1);
    }
    
}
