package model;

import java.util.Calendar;

public class UserRegular extends User{

    private BibliographicProducts[] listOfBiblioProducts = new BibliographicProducts[7];
    private Bill[] listAllBills = new Bill[7];

    public UserRegular(String name, String cc, Calendar date) {
        super(name, cc, date);
    }

    @Override
    public boolean buyBook(Buyable productToBuyB){
        if (productToBuyB instanceof Book && verifyBookAmount()) {
            for (int i = 0; i < listOfBiblioProducts.length; i++) {
                if(listOfBiblioProducts[i] == null){
                    Book boughtBook = new Book((Book) productToBuyB);
                    listOfBiblioProducts[i] = boughtBook;
                    (boughtBook).buy();
                    return true;
                }
            }
        } 
        return false;
    }

    @Override
    public boolean subscribeMagazine(Buyable productToSubscribeM){
        if (productToSubscribeM instanceof Magazine && verifyMagazineAmount()){
            for (int i = 0; i < listOfBiblioProducts.length; i++) {
                if(listOfBiblioProducts[i] == null){
                    Magazine boughtMagazine = new Magazine((Magazine) productToSubscribeM);
                    listOfBiblioProducts[i] = boughtMagazine;
                    (boughtMagazine).buy();
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
