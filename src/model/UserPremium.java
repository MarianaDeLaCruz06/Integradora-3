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

    public int sumNumPagesBook(){
        int acumReadB = 0;

        for (int i = 0; i < listAllBibliographicProducts.size(); i++) {
            if (listAllBibliographicProducts.get(i) instanceof Book) {
                acumReadB += listAllBibliographicProducts.get(i).getAcumReadPages();
            }
        }
     
        return acumReadB;
    }

    public int sumNumPagesMagazine(){
        int acumReadM = 0;

        for (int i = 0; i < listAllBibliographicProducts.size(); i++) {
            if (listAllBibliographicProducts.get(i) instanceof Magazine) {
                acumReadM += listAllBibliographicProducts.get(i).getAcumReadPages();
            }
        }
     
        return acumReadM;
    }

    public String showMagazine(){
        String msg = "";

        for (int i = 0; i < listAllBibliographicProducts.size(); i++) {
            if(listAllBibliographicProducts.get(i) instanceof Magazine){
                msg += "\n"+(i + 1) + ". "+ listAllBibliographicProducts.get(i).getId() + listAllBibliographicProducts.get(i).getNameBP()+"\n";
            }
        }
        return msg;
    }

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
        String msg = "[ _ ][  0  ][  1  ][  2  ][  3  ][  4  ]\n";
        for (int i = 0; i < getListAllBiblio().size(); i++) {
            for (int j = 0; j < getListAllBiblio().get(i).length; j++) {
                for (int j2 = 0; j2 < getListAllBiblio().get(i).length; j2++) {
                    if (getListAllBiblio().get(i)[j][j2] != null) {
                        msg += "[ " + getListAllBiblio().get(i)[j][j2].getId() + " ]";
                    } else {
                        msg += "[ _ ]";
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

    

    
    @Override
    public boolean cancelSubscription(String idBP) {

        for (int i = 0; i < listAllBibliographicProducts.size(); i++) {
            if (listAllBibliographicProducts.get(i).getId().equals(idBP)) {
                listAllBibliographicProducts.remove(i);
                return true; // Se canceló la suscripción
            }
        }
        return false; // No se encontró la suscripción con ese idBP
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
