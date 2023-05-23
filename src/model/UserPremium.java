package model;

import java.util.Calendar;
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

    public String getProducts(){
        String msg = "";

        for(int i=0; i<listAllBibliographicProducts.size();i++){
            
            msg += "\n" + (i+1) +". "+ listAllBibliographicProducts.get(i).getId()+" - "+listAllBibliographicProducts.get(i).getNameBP();
            
        }
        
        return msg;
    }

}
