package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller{

    private ArrayList<User> listAllUsers;
    private ArrayList<BibliographicProducts> listAllBibliographicProducts;
    private ArrayList<Bill> listAllBill;

    public Controller(){
        listAllUsers = new ArrayList<>();
        listAllBibliographicProducts = new ArrayList<>();
        testCase();
    }

    public void testCase(){
        Calendar date = Calendar.getInstance();
        User usertest = new UserRegular("Jose Ramirez", "1234567", date);
        User usertest2 = new UserPremium("Ana Perez", "7654321", date);

        listAllUsers.add(usertest);
        listAllUsers.add(usertest2);

        Book book = new Book("12345678", "Caperucita Roja", 128, date, "caperucita.com", 20,"Es un libro infantil con una buena moraleja", TypeBook.HISTORICAL_NOVEL, 10.000, 2);
        Magazine magazine = new Magazine("34567890", "Amimales en Extincion", 30, date, "animal.com", 10, TypeMagazine.VARIETIES, 8.000, "media",  1);
    
        listAllBibliographicProducts.add(book);
        listAllBibliographicProducts.add(magazine);
    }

    public boolean createUser(int userType, String name, String cc, Calendar date){
        
        switch(userType){
            case 1:
                listAllUsers.add(new UserRegular(name, cc, date));
            return true;
            case 2:
                listAllUsers.add(new UserPremium(name, cc, date ));
            return true;
        }
        
        return false;
    }

    public boolean registerBook(String id, String nameBP, int numPages, int dayB, int monthB, int yearB, String URL, int acumReadPages, String reviewShort, int genderIndex, double sellingValue, int numCopies){

       TypeBook gender = TypeBook.values()[genderIndex-1];

       Book newBook = new Book(id, nameBP, numPages, new GregorianCalendar(yearB, monthB, dayB), URL, numPages, reviewShort, gender, sellingValue, numCopies);

       return listAllBibliographicProducts.add(newBook);
        
    }

    public boolean registerMagazine(String id, String nameBP, int numPages, int dayM, int monthM, int yearM, String URL, int acumReadPages, int categoryIndex, double valueSuscription, String emissionPeriod, int numSuscription){

        TypeMagazine category = TypeMagazine.values()[categoryIndex-1];

        Magazine newMagazine = new Magazine(id, nameBP, numPages, new GregorianCalendar(yearM, monthM, dayM), URL, acumReadPages, category, valueSuscription, emissionPeriod, numSuscription);

        return listAllBibliographicProducts.add(newMagazine);

    }

    
    public boolean modifyBook(int optionModify, String idBModify, String nameBPModify, int numPagesModify, int dayBModify, int monthBModify, int yearBModify, String URLModify, int acumReadPagesModify, String reviewShortModify, int genderIndexModify, double sellingValueModify, int numCopiesModify){
        
        TypeBook gender = TypeBook.values()[genderIndexModify-1];

        Calendar postDateBModify = new GregorianCalendar(yearBModify, monthBModify, yearBModify);
        
        for(int i = 0; i<listAllBibliographicProducts.size();i++){
            if (optionModify >= 0 && optionModify < listAllBibliographicProducts.size()) {
                BibliographicProducts book = listAllBibliographicProducts.get(optionModify);
                if (book instanceof Book) {

                    book.setId(idBModify);
                    book.setNameBP(nameBPModify);
                    book.setNumPages(numPagesModify);
                    book.setURL(URLModify);
                    book.setAcumReadPages(acumReadPagesModify);
                    ((Book) book).setReviewShort(reviewShortModify);
                    ((Book) book).setGender(gender);
                    ((Book) book).setSellingValue(sellingValueModify);
                    ((Book) book).setNumCopies(numCopiesModify);
                    book.setPublicateDate(postDateBModify);
                    
                }
            }
        }
        return true; 
    }

    public boolean modifyMagazine(int optionMModify, String idMModify, String namePBModify, int numPagesModify, int dayMModify, int monthMModify, int yearMModify, String URLModify, int acumReadPagesModify, int categoryIndexModify, double valueSubscriptionModify, String emissionPeriodModify, int numSubscriptionModify){

        TypeMagazine category = TypeMagazine.values()[categoryIndexModify-1];

        Calendar postDateMModify = new GregorianCalendar(yearMModify, monthMModify, yearMModify);
        
        for(int i = 0; i<listAllBibliographicProducts.size();i++){
            if (optionMModify >= 0 && optionMModify < listAllBibliographicProducts.size()) {
                BibliographicProducts magazine = listAllBibliographicProducts.get(optionMModify);
                if (magazine instanceof Magazine) {

                    magazine.setId(idMModify);
                    magazine.setNameBP(namePBModify);
                    magazine.setNumPages(numPagesModify);
                    magazine.setURL(URLModify);
                    magazine.setAcumReadPages(acumReadPagesModify);
                    ((Magazine) magazine).setCategory(category);
                    ((Magazine) magazine).setValueSubscription(valueSubscriptionModify);
                    ((Magazine) magazine).setEmissionPeriod(emissionPeriodModify);
                    ((Magazine) magazine).setNumSubscription(numSubscriptionModify);
                    magazine.setPublicateDate(postDateMModify);
                    
                }
            }
        }
        

        return true;
    }

    public boolean deleteBook(String idB) {
        // Recorrer la lista de libros
        for (BibliographicProducts book : listAllBibliographicProducts) {
            // Verificar si es un libro y si tiene el ID correspondiente
            if (book instanceof Book && book.getId().equals(idB)) {
                // Eliminar el libro
                listAllBibliographicProducts.remove(book);
                return true;
            }
        }
        // Si no se encontró un libro con el ID especificado, devolver false
        return false;
    }

    public boolean deleteMagazine(String idM) {

        for (BibliographicProducts magazine : listAllBibliographicProducts) {
    
            if (magazine instanceof Magazine && magazine.getId().equals(idM)) {
                
                listAllBibliographicProducts.remove(magazine);
                return true;
            }
        }
        return false;
    }

    public void buyOrSubscribe(String ccUser, String idBP){

        boolean wasBuy = false;
        int posUserx = searchUser(ccUser);
        
        int posBooky = searchBP(idBP);

        if (posUserx != -1 && posBooky != -1){
            User user = listAllUsers.get(posUserx);
            String namebuyer= user.getName() ;
            BibliographicProducts product = listAllBibliographicProducts.get(posBooky);

            if(user instanceof UserRegular){

                if(product instanceof Magazine && ((UserRegular) user).verifyMagazineAmount()){
                    user.subscribeMagazine((Buyable) product);
                    ((Buyable) product).buy();
                    Bill newBill = new Bill(Calendar.getInstance(), product,namebuyer);
                    System.out.println(newBill.toString());
                    
                    // user.addBill(newBill);
                    wasBuy = true;
                }else if ( product instanceof Book && ((UserRegular) user).verifyBookAmount()){
                    user.buyBook((Buyable) product);
                    ((Buyable) product).buy();
                    wasBuy = true;
                    Bill newBill = new Bill(Calendar.getInstance(), product,namebuyer);
                    System.out.println(newBill.toString());
                    //Guardar bill
                }else{
                    System.out.println("No tienes espacio para comprar");
                }

            }else{

                if(product instanceof Magazine){
                    user.subscribeMagazine((Buyable) product);
                    ((Buyable) product).buy();
                    Bill newBill = new Bill(Calendar.getInstance(), product,namebuyer);   
                    System.out.println(newBill.toString());                 
                }else{
                    user.buyBook((Buyable) product);
                    ((Buyable) product).buy();
                    Bill newBill = new Bill(Calendar.getInstance(), product,namebuyer);
                    System.out.println(newBill.toString());
                }
                wasBuy = true;
            }
            if (wasBuy){
                System.out.println(user.getName());
                System.out.println(product.getNameBP());
                
            }


        }
    }


    public String getProducts(){
        String msg = "";

        for(int i=0; i<listAllBibliographicProducts.size();i++){

             msg += "\n" + (i+1) +". "+ listAllBibliographicProducts.get(i).getId()+" - "+listAllBibliographicProducts.get(i).getNameBP();

        }
        
        return msg;
    }


    public String getBPBook(){

        String msg = "";

        for(int i=0; i<listAllBibliographicProducts.size();i++){

            if(listAllBibliographicProducts.get(i) instanceof Book){

             msg += "\n" + (i+1) +". "+  listAllBibliographicProducts.get(i).getId()+" - "+listAllBibliographicProducts.get(i).getNameBP();

            }
        }
        
        return msg;
    }

    public String getBPMagazine(){

        String msg = "";

        for(int i=0; i<listAllBibliographicProducts.size();i++){

            if(listAllBibliographicProducts.get(i) instanceof Magazine){

             msg += "\n" + (i+1) +". "+ listAllBibliographicProducts.get(i).getId()+" - "+listAllBibliographicProducts.get(i).getNameBP();

            }
        }
        
        return msg;
    }

    public String getUsers(){
        String msg = "";

        for(int i=0; i<listAllUsers.size();i++){

            msg += "\n" + (i+1) +". "+ listAllUsers.get(i).getCc()+" - "+listAllUsers.get(i).getName();

        }
        
        return msg;
    }

    public String getUsersRegular(){
        String msg = "";

        for(int i=0; i<listAllUsers.size();i++){
            if(listAllUsers.get(i) instanceof UserRegular){
             msg += "\n" + (i+1) +". "+ listAllUsers.get(i).getCc()+" - "+listAllUsers.get(i).getName();
            }
        }
        
        return msg;
    }

    public String getUsersPremium(){
        String msg = "";

        for(int i=0; i<listAllUsers.size();i++){
            if(listAllUsers.get(i) instanceof UserPremium){
             msg += "\n" + (i+1) +". "+ listAllUsers.get(i).getCc()+" - "+listAllUsers.get(i).getName();
            }
        }
        
        return msg;
    }


    public Calendar createDate(int day, int month, int year){
		Calendar date = new GregorianCalendar(year,month-1,day);
        return date;
	}


    public boolean verifyBook(String idBP){
        boolean isABook = false;
        BibliographicProducts product =getBibliographicProduct(idBP);
        if(product!= null){
            if(product instanceof Book){
                isABook=true;
            }
        }
        return isABook;
    }



    public BibliographicProducts getBibliographicProduct(String idBP){
        BibliographicProducts product = null;
        boolean found =false;
        for(int i=0; i<listAllBibliographicProducts.size()&&!found;i++){
            if(listAllBibliographicProducts.get(i).getId().equalsIgnoreCase(idBP)){

                found =true;
                product= listAllBibliographicProducts.get(i);
            }
        }
        return product;
    }
    

    public int searchUser(String ccUser) {
       int pos = -1;
       for (int i = 0; i < listAllUsers.size(); i++) {
        if(ccUser.equals(listAllUsers.get(i).getCc())){
            pos = i;
        }
       } 
       return pos;
    }

    public int searchBP(String idProduct) {
        int pos = -1;
        for (int i = 0; i < listAllBibliographicProducts.size(); i++) {
         if(idProduct.equals(listAllBibliographicProducts.get(i).getId())){
             pos = i;
         }
        } 
        return pos;
    }
}

