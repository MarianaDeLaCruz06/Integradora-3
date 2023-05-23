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

    public boolean addBill(Bill newBill){
        for (int i = 0; i < listAllBills.length; i++) {
            if(listAllBills[i] == null){
                listAllBills[i] = newBill;
                return true;
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

    boolean verifyBookAmount(){
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

    boolean verifyMagazineAmount(){
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

    public String getProducts(){
        String msg = "";

        for(int i=0; i<listOfBiblioProducts.length;i++){

            msg += "\n" + (i + 1) + ". " + listOfBiblioProducts[i];

        }
        
        return msg;
    }

    
    public BibliographicProducts[] getListOfBiblioProducts() {
        return listOfBiblioProducts;
    }

    public void setListOfBiblioProducts(BibliographicProducts[] listOfBiblioProducts) {
        this.listOfBiblioProducts = listOfBiblioProducts;
    }

    public Bill[] getListAllBills() {
        return listAllBills;
    }

    public void setListAllBills(Bill[] listAllBills) {
        this.listAllBills = listAllBills;
    }
}
