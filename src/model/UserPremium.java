package model;

import java.util.Calendar;
import java.util.ArrayList;

public class UserPremium extends User{
    
    private ArrayList<BibliographicProducts> listAllBibliographicProducts;
    private ArrayList<Bill> listAllBill;


    public UserPremium(String name, String cc, Calendar date) {
        super(name, cc, date);
        this.listAllBibliographicProducts = new ArrayList<>();
    }

    /**
     * Calculates the total number of pages read in books by the user.
     *
     * @return The total number of pages read in books.
     */
    public int sumNumPagesBook(){
        int acumReadB = 0;

        for (int i = 0; i < listAllBibliographicProducts.size(); i++) {
            if (listAllBibliographicProducts.get(i) instanceof Book) {
                acumReadB += listAllBibliographicProducts.get(i).getAcumReadPages();
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

        for (int i = 0; i < listAllBibliographicProducts.size(); i++) {
            if (listAllBibliographicProducts.get(i) instanceof Magazine) {
                acumReadM += listAllBibliographicProducts.get(i).getAcumReadPages();
            }
        }
     
        return acumReadM;
    }

    /**
     * Returns a string representation of the magazines subscribed by the user.
     *
     * @return A string representation of the subscribed magazines.
     */
    public String showMagazine(){
        String msg = "";

        for (int i = 0; i < listAllBibliographicProducts.size(); i++) {
            if(listAllBibliographicProducts.get(i) instanceof Magazine){
                msg += "\n"+(i + 1) + ". "+ listAllBibliographicProducts.get(i).getId() + " " + listAllBibliographicProducts.get(i).getNameBP()+"\n";
            }
        }
        return msg;
    }

    /**
     * Initializes the matrix of bibliographic products.
     * The matrix is populated with the sorted list of bibliographic products.
     *
     * Initializes the matrix of bibliographic products.
     * The matrix is populated with the sorted list of bibliographic products.
     */
    public void initMatrix() {
        insertionSort();
        
        /** 
        listAllBibliographicProducts.forEach((bibliographicProduct) ->{
            System.out.println(bibliographicProduct.getPublicateDate());
        });
        */

        ArrayList<BibliographicProducts[][]> temp = new ArrayList<>();
        int cont = 0;
        for (int h = 0; h < (((int)listAllBibliographicProducts.size()/25)+1); h++) {
            BibliographicProducts[][] matrix = new BibliographicProducts[5][5];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j <= matrix.length; j++) {

                    if(cont<listAllBibliographicProducts.size()){
                        matrix[i][j] = listAllBibliographicProducts.get(cont);
                        cont++;
                    }
                }
            }
            temp.add(matrix);
        }

        setListAllBiblio(temp);
    }
    
    @Override
    public String getProducts(){
        String msg = "[  _  ][  0  ][  1  ][  2  ][  3  ][  4  ]\n";
        for (int i = 0; i < getListAllBiblio().size(); i++) {
            for (int j = 0; j < getListAllBiblio().get(i).length; j++) {
                msg += "[  " + j +  "  ]";
                for (int j2 = 0; j2 < getListAllBiblio().get(i).length; j2++) {
                    if (getListAllBiblio().get(i)[j][j2] != null) {
                        msg += "[  " + getListAllBiblio().get(i)[j][j2].getId() + "  ]";
                    } else {
                        msg += "[  _  ]";
                    }
                    
                }
                msg += "\n";
            }
            msg += "\n";
        }
        
        return msg;
    }


    @Override
    public boolean buyBook(Buyable productToBuyB) {
        if (productToBuyB instanceof Book){
            Book boughtBook = new Book((Book) productToBuyB);
            boughtBook.buy();
            listAllBibliographicProducts.add(boughtBook);
            initMatrix();
            return true;
        } 
        return false;
    }
    
    @Override
    public boolean subscribeMagazine(Buyable productToSubscribeM) {
        if (productToSubscribeM instanceof Magazine){
            Magazine boughtMagazine = new Magazine((Magazine) productToSubscribeM);
            boughtMagazine.buy();
            listAllBibliographicProducts.add(boughtMagazine);
            initMatrix();
            return true;
        } 
        return false;
    }

    /**
     * Returns the genre of the book that has been read the most by the user.
     *
     * @return The genre of the most read book.
     */
    public TypeBook getMostReadBookGenre() {
        int maxGenrePages = 0;
        TypeBook mostReadGenre = null;

        for (BibliographicProducts product : listAllBibliographicProducts) {
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

    /**
     * Returns the category of the magazine that has been read the most by the user.
     *
     * @return The category of the most read magazine.
     */
    public TypeMagazine getMostReadMagazineCategory() {
        int maxCategoryPages = 0;
        TypeMagazine mostReadCategory = null;

        for (BibliographicProducts product : listAllBibliographicProducts) {
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
    

    @Override
    public boolean cancelSubscription(String idBP) {

        for (int i = 0; i < listAllBibliographicProducts.size(); i++) {
            if (listAllBibliographicProducts.get(i).getId().equals(idBP)) {
                listAllBibliographicProducts.remove(i);
                initMatrix();
                return true; // Se canceló la suscripción
            }
        }
        return false; // No se encontró la suscripción con ese idBP
    }    
    
    public void insertionSort() { 
        
        for (int i = 1; i < listAllBibliographicProducts.size(); i++){
            for (int j = 0; j < i; j++) {
                if (listAllBibliographicProducts.get(i).getPublicateDate().compareTo(listAllBibliographicProducts.get(j).getPublicateDate()) < 0) {
                    listAllBibliographicProducts.add(j, listAllBibliographicProducts.remove(i));
                    break;
                }
            }
        }
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
    

}
