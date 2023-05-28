package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public abstract class User {
    private String name;
    private String cc;
    private Calendar date;
    private ArrayList<BibliographicProducts[][]> listAllBiblio;
    private BibliographicProducts[][] listOfBiblio = new BibliographicProducts[5][5];


    private SimpleDateFormat simpleDateFormat;
    private DateFormat formatteDate;

    public User(String name, String cc, Calendar date){

        this.name = name;
        this.cc = cc; 
        this.date = Calendar.getInstance();

        this.formatteDate = new SimpleDateFormat("dd/mm/yy");
    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public DateFormat getFormatteDate() {
        return formatteDate;
    }

    public void setFormatteDate(DateFormat formatteDate) {
        this.formatteDate = formatteDate;
    }
        
    public ArrayList<BibliographicProducts[][]> getListAllBiblio() {
        return listAllBiblio;
    }

    public void setListAllBiblio(ArrayList<BibliographicProducts[][]> listAllBiblio) {
        this.listAllBiblio = listAllBiblio;
    }

    public BibliographicProducts[][] getListOfBiblio() {
        return listOfBiblio;
    }

    public void setListOfBiblio(BibliographicProducts[][] listOfBiblio) {
        this.listOfBiblio = listOfBiblio;
    }

    /**
     * Buys a book product.
     *
     * @param productToBuyB The book product to buy.
     * @return True if the purchase is successful, false otherwise.
     */
    public abstract boolean buyBook(Buyable productToBuyB);

    /**
     * Subscribes to a magazine product.
     *
     * @param productToSubscribeM The magazine product to subscribe to.
     * @return True if the subscription is successful, false otherwise.
     */
    public abstract boolean subscribeMagazine(Buyable productToSubscribeM);

    /**
     * This method returns a string representation of the user's products.
     *
     * @return A string representation of the user's products.
     */
    public abstract String getProducts();
    
     /**
     * This method calculates the total number of pages read in books by the user.
     *
     * @return The total number of pages read in books.
     */
    public abstract int sumNumPagesBook();

    /**
     * This method calculates the total number of pages read in magazines by the user.
     *
     * @return The total number of pages read in magazines.
     */
    public abstract int sumNumPagesMagazine();

    /**
     * Displays information about the user's subscribed magazines.
     *
     * @return A string representation of the user's subscribed magazines.
     */
    public abstract String showMagazine();

    /**
     * Cancels the subscription to a magazine.
     *
     * @param idBP The ID of the bibliographic product to cancel the subscription.
     * @return True if the cancellation is successful, false otherwise.
     */
    public abstract boolean cancelSubscription(String idBP);

    /**
     * This method returns the most read book genre by the user.
     *
     * @return The most read book genre.
     */
    public abstract TypeBook getMostReadBookGenre();

    /**
     * This method the most read magazine category by the user.
     *
     * @return The most read magazine category.
     */
    public abstract TypeMagazine getMostReadMagazineCategory();
        

    public String toString() {
        String msg = "";
        
        msg = "\n Name User:" + name + "\n CC:" + cc + "\n Date:" + date;
        
        return msg;
    }

    

    public String changeFormat(Calendar date){
        String formatDate = simpleDateFormat.format(date.getTime());
        return formatDate;
    }



    
}


