package model;

import java.util.Calendar;

public class UserRegular extends User{

    private BibliographicProducts[] listOfBiblioProducts = new BibliographicProducts[7];

    public UserRegular(String name, String cc, Calendar date) {
        super(name, cc, date);
    }

    @Override
    public boolean buyBook(BibliographicProducts productToBuyB){
        if (productToBuyB instanceof Book && verifyBookAmount()) {
            for (int i = 0; i < listOfBiblioProducts.length; i++) {
                if(listOfBiblioProducts[i] == null){
                    listOfBiblioProducts[i] = productToBuyB;
                    return true;
                }
            }
        } 
        return false;
    }

    @Override
    public boolean suscribeMagazine(BibliographicProducts productToSuscribeM){
        if (productToSuscribeM instanceof Magazine && verifyMagazineAmount()){
            for (int i = 0; i < listOfBiblioProducts.length; i++) {
                if(listOfBiblioProducts[i] == null){
                    listOfBiblioProducts[i] = productToSuscribeM;
                    return true;
                }
            }
        } 
        return false;
    }

    private boolean verifyBookAmount(){
        int counter = 0;
        for (int i = 0; i < listOfBiblioProducts.length; i++) {
            if (listOfBiblioProducts[i] instanceof Book) {
                counter++;
            }
        }
        if (counter < 5) {
            return true;
        }
        return false;
    }

    private boolean verifyMagazineAmount(){
        int counter2 = 0;
        for (int i = 0; i < listOfBiblioProducts.length; i++) {
            if (listOfBiblioProducts[i] instanceof Magazine) {
                counter2++;
            }
        }
        if (counter2 < 2) {
            return true;
        }
        return false;
    }

    
    
}
