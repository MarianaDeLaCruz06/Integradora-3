package model;

import java.util.Calendar;

public class UserRegular extends User{


    private BibliographicProducts[] listOfBiblioProducts = new BibliographicProducts[7];
    private Bill[] listAllBills = new Bill[7];
    

    public UserRegular(String name, String cc, Calendar date) {
        super(name, cc, date);

    }
    
    /**
     * This method calculates the total number of pages read in books by the user.
     *
     * @return The total number of pages read in books.
     */
    public int sumNumPagesBook(){
        int acumReadB = 0;

        for (int i = 0; i < listOfBiblioProducts.length; i++) {
            if (listOfBiblioProducts[i] instanceof Book) {
                acumReadB += listOfBiblioProducts[i].getAcumReadPages();
            }
        }
     
        return acumReadB;
    }


            
    /**
     * Calculates the total number of pages read in magazines by the user.
     *
     * @return The total number of pages read in magazines.
     */
    public int sumNumPagesMagazine(){
        int acumReadM = 0;

        for (int i = 0; i < listOfBiblioProducts.length; i++) {
            if (listOfBiblioProducts[i] instanceof Magazine) {
                acumReadM += listOfBiblioProducts[i].getAcumReadPages();
            }
        }
     
        return acumReadM;
        
    }


    
    /**
     * Returns the total number of pages read in books by the user.
     *
     * @return The total number of pages read in books.
     */
    public int mumPagesBookRead(){
        int acumReadB = 0;

        for (int i = 0; i < listOfBiblioProducts.length; i++) {
            if (listOfBiblioProducts[i] instanceof Book) {
                acumReadB += listOfBiblioProducts[i].getAcumReadPages();
            }
        }
     
        return acumReadB;
    }

    /**
     * This method allows you to buy a book for one user
     *
     * @param productToBuyB The book product to buy.
     * @return True if the purchase is successful, false otherwise.
     */
    @Override
    public boolean buyBook(Buyable productToBuyB){
        if (productToBuyB instanceof Book && verifyBookAmount()) {
            for (int i = 0; i < listOfBiblioProducts.length; i++) {
                if(listOfBiblioProducts[i] == null){
                    Book boughtBook = new Book((Book) productToBuyB);
                    listOfBiblioProducts[i] = boughtBook;
                    (boughtBook).buy();
                    initMatrix();
                    return true;
                }
            }
        } 
        return false;
    }

     /**
     * Adds a bill to the user's list of bills.
     *
     * @param newBill The bill to add.
     * @return True if the bill is successfully added, false otherwise.
     */
    public boolean addBill(Bill newBill){
        for (int i = 0; i < listAllBills.length; i++) {
            if(listAllBills[i] == null){
                listAllBills[i] = newBill;
                return true;
            }
        }
        
        return false;
    }

    
    /**
     * This method allows you to subscribe a magazine for one user
     *
     * @param productToSubscribeM The magazine product to subscribe to.
     * @return True if the subscription is successful, false otherwise.
     */
    @Override
    public boolean subscribeMagazine(Buyable productToSubscribeM){
        if (productToSubscribeM instanceof Magazine && verifyMagazineAmount()){
            for (int i = 0; i < listOfBiblioProducts.length; i++) {
                if(listOfBiblioProducts[i] == null){
                    Magazine boughtMagazine = new Magazine((Magazine) productToSubscribeM);
                    listOfBiblioProducts[i] = boughtMagazine;
                    (boughtMagazine).buy();
                    initMatrix();
                    return true;
                }
            }
        } 
        return false;
    }

    /**
     * Verifies if the user can buy more book products.
     *
     * @return True if the user can buy more book products, false otherwise.
     */
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

    
    /**
     * Verifies if the user can subscribe to more magazine products.
     *
     * @return True if the user can subscribe to more magazine products, false otherwise.
     */
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

    /**
     * Returns a string representation of the magazines subscribed by the user.
     *
     * @return A string representation of the magazines subscribed by the user.
     */
    public String showMagazine(){
        String msg = "";

        for (int i = 0; i < listOfBiblioProducts.length; i++) {
            if(listOfBiblioProducts[i] instanceof Magazine){
                msg += "\n"+(i + 1) + ". "+ listOfBiblioProducts[i].getId()+ " " + listOfBiblioProducts[i].getNameBP()+"\n";
            }
        }
        return msg;
    }

    /**
     * Cancels the subscription to a product with the specified ID.
     *
     * @param idBP The ID of the product to cancel the subscription.
     * @return True if the subscription is successfully canceled, false otherwise.
     */
    @Override
    public boolean cancelSubscription(String idBP) {
        
        for (int i = 0; i < listOfBiblioProducts.length; i++) {
            if (listOfBiblioProducts[i].getId().equals(idBP)) {
                listOfBiblioProducts[i] = null;
                return true; // Se canceló la suscripción
            }
        }
        return false; // No se encontró la suscripción con ese idBP
    }   


    public void insertionSort(){
        for (int i = 1; i < listOfBiblioProducts.length; i ++){
            for (int j = 0; j < i; j++) {
                if(listOfBiblioProducts[i] != null && listOfBiblioProducts != null)
                if (listOfBiblioProducts[i].getPublicateDate().compareTo(listOfBiblioProducts[j].getPublicateDate()) < 0) {
                    BibliographicProducts temp = listOfBiblioProducts[i];
                    listOfBiblioProducts[i] = listOfBiblioProducts[j];
                    listOfBiblioProducts[j] = temp;
                    break;
                }
            }
        }
    }


    public void initMatrix(){
        insertionSort();
        //Arrays.toString(listOfBiblioProducts);
        //ArrayList<BibliographicProducts[][]> temp = new ArrayList<>((int)Math.ceil(listOfBiblioProducts.length/25));
        BibliographicProducts[][] matrix = new BibliographicProducts[5][5];
        int cont = 0;

        for (int h = 0; h < (((int)listOfBiblioProducts.length/25)+1); h++) {
            
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (cont < listOfBiblioProducts.length) {
                     matrix[i][j] = listOfBiblioProducts[cont];
                        cont++;
                    }      
                }
            }
        }
        setListOfBiblio(matrix);

    }
    
    @Override
    public String getProducts(){
        String msg = "[  _  ][  0  ][  1  ][  2  ][  3  ][  4  ]\n";
        for (int i = 0; i < getListOfBiblio().length; i++) {
            msg += "[  " + i +  "  ]";
                for (int j = 0; j < getListOfBiblio()[i].length; j++) {
                    if (getListOfBiblio()[i][j] != null) {
                        msg += "[  " + getListOfBiblio()[i][j].getId() + "  ]";
                    } else {
                        msg += "[  _  ]";
                    }
                    
                }
                msg += "\n";
        }
        
        return msg;
    }


    public TypeBook getMostReadBookGenre() {
        int maxGenrePages = 0;
        TypeBook mostReadGenre = null;

        for (BibliographicProducts product : listOfBiblioProducts) {
            if (product instanceof Book) {
                Book book = (Book) product;
                TypeBook genre = book.getGender();
                int pages = product.getAcumReadPages();
                if (pages > maxGenrePages) {
                    maxGenrePages = pages;
                    mostReadGenre = genre;
                }
            }
        }

        return mostReadGenre;
    }

    public TypeMagazine getMostReadMagazineCategory() {
        int maxCategoryPages = 0;
        TypeMagazine mostReadCategory = null;

        for (BibliographicProducts product : listOfBiblioProducts) {
            if (product instanceof Magazine) {
                Magazine magazine = (Magazine) product;
                TypeMagazine category = magazine.getCategory();
                int pages = product.getAcumReadPages();
                if (pages > maxCategoryPages) {
                    maxCategoryPages = pages;
                    mostReadCategory = category;
                }
            }
        }

        return mostReadCategory;
    }


    /** 
    public String getProducts(){
        String msg = "";

        for(int i=0; i<listOfBiblioProducts.length;i++){

            msg += "\n" + (i + 1) + ". " + listOfBiblioProducts[i];

        }
        
        return msg;
    }
    */

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



