package model;

import java.util.Calendar;
import java.util.Collections;
import java.util.ArrayList;

public class UserPremium extends User{
    
    private ArrayList<BibliographicProducts> listAllBibliographicProducts;
    private ArrayList<Bill> listAllBill;


    public UserPremium(String name, String cc, Calendar date) {
        super(name, cc, date);
    }

    @Override
    public boolean buyBook(Buyable productToBuyB) {
        if (productToBuyB instanceof Book){
            Book boughtBook = new Book((Book) productToBuyB);
            boughtBook.buy();
            return listAllBibliographicProducts.add(boughtBook);
        } 
        return false;
    }
    
    @Override
    public boolean subscribeMagazine(Buyable productToSubscribeM) {
        if (productToSubscribeM instanceof Magazine){
            Magazine boughtMagazine = new Magazine((Magazine) productToSubscribeM);
            boughtMagazine.buy();
            return listAllBibliographicProducts.add(boughtMagazine);
        } 
        return false;
    }

    public ArrayList<BibliographicProducts> getListAllBibliographicProducts() {
        return listAllBibliographicProducts;
    }

    public void setListAllBibliographicProducts(ArrayList<BibliographicProducts> listAllBibliographicProducts) {
        this.listAllBibliographicProducts = listAllBibliographicProducts;
    }

    public ArrayList<Bill> getListAllBill() {
        return listAllBill;
    }

    public void setListAllBill(ArrayList<Bill> listAllBill) {
        this.listAllBill = listAllBill;
    }
    public void insertionSort() { 
        
        for (int rojo = 1; rojo < listAllBibliographicProducts.size(); rojo++){
            for (int verde = 0; verde < rojo; verde++) {
                if (listAllBibliographicProducts.get(rojo).getPublicateDate().compareTo(listAllBibliographicProducts.get(verde).getPublicateDate()) < 0) {
                    listAllBibliographicProducts.add(verde, listAllBibliographicProducts.remove(rojo));
                    break;
                }
            }
        }
    }
    
    @Override
    public String getProducts(){
        String msg = "   |   0   |   1   |   2   |   3   |   4   |\n";

        insertionSort();
        

        for(int i=0; i<listAllBibliographicProducts.size();i++){

            
            msg +=   "   |  " +  listAllBibliographicProducts.get(i).getId() + "  |"  + (((i-1)%4 == 0)?"\n":"");


            
        
            
        }
        
        return msg;
    }

}
