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
    
}
