package model;

import java.util.ArrayList;
import java.util.Calendar;

public class UserRegular extends User{

    private BibliographicProducts[] listOfBiblioProducts = new BibliographicProducts[7];
    private Bill[] listAllBills = new Bill[7];

    public UserRegular(String name, String cc, Calendar date) {
        super(name, cc, date);
    }

    public int sumNumPagesBook(){
        int acumReadB = 0;

        for (int i = 0; i < listOfBiblioProducts.length; i++) {
            if (listOfBiblioProducts[i] instanceof Book) {
                acumReadB += listOfBiblioProducts[i].getAcumReadPages();
            }
        }
     
        return acumReadB;
    }
            
    public int sumNumPagesMagazine(){
        int acumReadM = 0;

        for (int i = 0; i < listOfBiblioProducts.length; i++) {
            if (listOfBiblioProducts[i] instanceof Book) {
                acumReadM += listOfBiblioProducts[i].getAcumReadPages();
            }
        }
     
        return acumReadM;
        
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

    public String showMagazine(){
        String msg = "";

        for (int i = 0; i < listOfBiblioProducts.length; i++) {
            if(listOfBiblioProducts[i] instanceof Magazine){
                msg += "\n"+(i + 1) + ". "+ listOfBiblioProducts[i].getId() + listOfBiblioProducts[i].getNameBP()+"\n";
            }
        }
        return msg;
    }

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
        for (int rojo = 1; rojo < listOfBiblioProducts.length; rojo++){
            for (int verde = 0; verde < rojo; verde++) {
                if (listOfBiblioProducts[rojo].getPublicateDate().compareTo(listOfBiblioProducts[verde].getPublicateDate()) < 0) {
                    BibliographicProducts temp = listOfBiblioProducts[rojo];
                    listOfBiblioProducts[rojo] = listOfBiblioProducts[verde];
                    listOfBiblioProducts[verde] = temp;
                    break;
                }
            }
        }
    }

    public void initMatrix(){
        insertionSort();
        //Arrays.toString(listOfBiblioProducts);
        ArrayList<BibliographicProducts[][]> temp = new ArrayList<>((int)Math.ceil(listOfBiblioProducts.length/25));
        int cont = 0;
        for (int h = 0; h < temp.size(); h++) {
            BibliographicProducts[][] matrix = new BibliographicProducts[5][5];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j <= matrix.length; j++) {
                    if(cont<listOfBiblioProducts.length){
                        matrix[i][j] = listOfBiblioProducts[cont];
                        cont++;
                    }
                }
            }
            temp.add(matrix);
        }

        setListAllBiblio(temp);
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
