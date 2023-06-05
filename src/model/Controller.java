package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Controller{

    private ArrayList<User> listAllUsers;
    private ArrayList<BibliographicProducts> listAllBibliographicProducts;

    private SimpleDateFormat simpleDateFormat;

    public Controller(){
        listAllUsers = new ArrayList<>();
        listAllBibliographicProducts = new ArrayList<>();
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        testCase();
    }

    /**
     * This method is to help me to buy something and it would not be necessary to register a product or a user.
     */
    public void testCase(){
        Calendar date = Calendar.getInstance();
        User usertest = new UserRegular("Jose Ramirez", "1234567", date);
        User usertest2 = new UserPremium("Ana Perez", "7654321", date);

        listAllUsers.add(usertest);
        listAllUsers.add(usertest2);

        Book book = new Book("12A", "Caperucita Roja", 128, date, "caperucita.com", 20,"Es un libro infantil con una buena moraleja", TypeBook.HISTORICAL_NOVEL, 10.000, 2);
        Magazine magazine = new Magazine("34B", "Amimales en Extincion", 30, date, "animal.com", 10, TypeMagazine.VARIETIES, 8.000, "media",  1);
    
        listAllBibliographicProducts.add(book);
        listAllBibliographicProducts.add(magazine);
    }

    /**
     * This method is used to create a user.
     *
     * @param userType  The type of the user (regular or premium).
     * @param name      The name of the user.
     * @param cc        The credit card number of the user.
     * @param date      The date of user creation (Calendar or Instant).
     * @return          Returns false if the user could not be created.
     */
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

    /**
     * This method is used to create a new book.
     *
     * @param id            The ID of the book.
     * @param nameBP        The name of the book.
     * @param numPages      The number of pages in the book.
     * @param dayB          The day of publication.
     * @param monthB        The month of publication.
     * @param yearB         The year of publication.
     * @param URL           The URL of the book.
     * @param acumReadPages The accumulated number of pages read.
     * @param reviewShort   The short review of the book.
     * @param genderIndex   The index of the book's gender (SCIENCE_FICTION, FANTASY, HISTORICAL_NOVEL).
     * @param sellingValue  The selling value of the book.
     * @param numCopies     The number of copies of the book.
     * @return              Returns true if the book was successfully registered, false otherwise.
     */
    public boolean registerBook(String id, String nameBP, int numPages, int dayB, int monthB, int yearB, String URL, int acumReadPages, String reviewShort, int genderIndex, double sellingValue, int numCopies){

       TypeBook gender = TypeBook.values()[genderIndex-1];

       Book newBook = new Book(id, nameBP, numPages, new GregorianCalendar(yearB, monthB, dayB), URL, numPages, reviewShort, gender, sellingValue, numCopies);

       return listAllBibliographicProducts.add(newBook);
        
    }

    /**
     * This method is used to create a new magazine.
     *
     * @param id                The ID of the magazine.
     * @param nameBP            The name of the magazine.
     * @param numPages          The number of pages in the magazine.
     * @param dayM              The day of publication.
     * @param monthM            The month of publication.
     * @param yearM             The year of publication.
     * @param URL               The URL of the magazine.
     * @param acumReadPages     The accumulated number of pages read.
     * @param categoryIndex     The index of the magazine category.
     * @param valueSuscription  The value of the magazine subscription.
     * @param emissionPeriod    The emission period of the magazine.
     * @param numSuscription    The number of subscriptions for the magazine.
     * @return                  Returns true if the magazine was successfully registered, false otherwise.
     */
    public boolean registerMagazine(String id, String nameBP, int numPages, int dayM, int monthM, int yearM, String URL, int acumReadPages, int categoryIndex, double valueSuscription, String emissionPeriod, int numSuscription){

        TypeMagazine category = TypeMagazine.values()[categoryIndex-1];

        Magazine newMagazine = new Magazine(id, nameBP, numPages, new GregorianCalendar(yearM, monthM, dayM), URL, acumReadPages, category, valueSuscription, emissionPeriod, numSuscription);

        return listAllBibliographicProducts.add(newMagazine);

    }

    /**
     * This method modifies the book completely
     *
     * @param optionModify         The option to modify.
     * @param idBModify            The ID of the book to modify.
     * @param nameBPModify         The modified name of the book.
     * @param numPagesModify       The modified number of pages in the book.
     * @param dayBModify           The modified day of publication.
     * @param monthBModify         The modified month of publication.
     * @param yearBModify          The modified year of publication.
     * @param URLModify            The modified URL of the book.
     * @param acumReadPagesModify  The modified accumulated number of pages read.
     * @param reviewShortModify    The modified short review of the book.
     * @param genderIndexModify    The modified index of the book's gender (SCIENCE_FICTION, FANTASY, HISTORICAL_NOVEL).
     * @param sellingValueModify   The modified selling value of the book.
     * @param numCopiesModify      The modified number of copies of the book.
     * @return                     Returns true if the book was successfully modified.
     */
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

    /**
     * This method modifies the magazine completely
     *
     * @param optionMModify           The option to modify.
     * @param idMModify               The ID of the magazine to modify.
     * @param namePBModify            The modified name of the magazine.
     * @param numPagesModify          The modified number of pages in the magazine.
     * @param dayMModify              The modified day of publication.
     * @param monthMModify            The modified month of publication.
     * @param yearMModify             The modified year of publication.
     * @param URLModify               The modified URL of the magazine.
     * @param acumReadPagesModify     The modified accumulated number of pages read.
     * @param categoryIndexModify     The modified index of the magazine category.
     * @param valueSubscriptionModify The modified value of the magazine subscription.
     * @param emissionPeriodModify    The modified emission period of the magazine.
     * @param numSubscriptionModify   The modified number of subscriptions for the magazine.
     * @return                        Returns true if the magazine was successfully modified.
     */
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

    /**
     * This method delete a book with the specified ID.
     *
     * @param idB  The ID of the book to delete.
     * @return     Returns true if the book was successfully deleted, false otherwise.
     */
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

    /**
     * This method delete a magazine with the specified ID.
     *
     * @param idM  The ID of the magazine to delete.
     * @return     Returns true if the magazine was successfully deleted, false otherwise.
     */
    public boolean deleteMagazine(String idM) {

        for (BibliographicProducts magazine : listAllBibliographicProducts) {
    
            if (magazine instanceof Magazine && magazine.getId().equals(idM)) {
                
                listAllBibliographicProducts.remove(magazine);
                return true;
            }
        }
        return false;
    }

    /**
     * This method allows the user with his ID to buy a book or subscribe to a magazine.
     *
     * @param ccUser  The ID number of the user.
     * @param idBP    The ID of the bibliographic product to buy or subscribe to.
     */
    public void buyOrSubscribe(String ccUser, String idBP){

       // boolean wasBuy = false;
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
                    
                    // wasBuy = true;

                }else if ( product instanceof Book && ((UserRegular) user).verifyBookAmount()){
                    user.buyBook((Buyable) product);
                    ((Buyable) product).buy();
                    // wasBuy = true;
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
                
            }

          
        }
    }

    /**
     * This method retrieves the list of products in the user's library.
     *
     * @param ccUser  The ID number of the user.
     * @return        Returns a string representation of the user's library.
     */
    public String viewLibrary(String ccUser) {
        String msg = "";
        User user = null;
        
        for (User currentUser : listAllUsers) {
            if (currentUser.getCc().equals(ccUser)) {
                user = currentUser;
            }
         
        }

        if (user != null) {
            msg = user.getProducts();
        }
    
        return msg;
    }
    
    /**
     * This method retrieves the list of subscribed magazines for a user.
     *
     * @param ccUser The ID number of the user.
     * @return Returns a string representation of the user's subscribed magazines.
     */
    public String viewMagazineSubscribe(String ccUser) {
        String msg = "";
        User user = null;
    
        for (User currentUser : listAllUsers) {
            if (currentUser.getCc().equals(ccUser)) {
                user = currentUser;
            }
        }
    
        if (user != null) {
            msg = user.showMagazine();
        }
    
        return msg;
    }

    /**
     * This method allows the user to cancel the subscription to a magazine
     *
     * @param ccUser The ID number of the user.
     * @param idBP   The ID of the bibliographic product to cancel the subscription for.
     * @return Returns true if the subscription was successfully canceled, false otherwise.
     */
    public boolean cancelSubs(String ccUser, String idBP) {
        boolean indication = false;
        User user = null;
    
        for (User currentUser : listAllUsers) {
            if (currentUser.getCc().equals(ccUser)) {
                user = currentUser;
            }

            if (user != null) {
                indication = user.cancelSubscription(idBP);
            }
        }
    
        return indication;
    }

    /**
     * Retrieves the list of all bibliographic products.
     *
     * @return Returns a string representation of all bibliographic products.
     */
    public String getProducts(){
        String msg = "";

        for(int i=0; i<listAllBibliographicProducts.size();i++){

             msg += "\n" + (i+1) +". "+ listAllBibliographicProducts.get(i).getId()+" - "+listAllBibliographicProducts.get(i).getNameBP();

        }
        
        return msg;
    }

    /**
     * Retrieves the list of books among all bibliographic products.
     *
     * @return Returns a string representation of all books.
     */
    public String getBPBook(){

        String msg = "";

        for(int i=0; i<listAllBibliographicProducts.size();i++){

            if(listAllBibliographicProducts.get(i) instanceof Book){

             msg += "\n" + (i+1) +". "+  listAllBibliographicProducts.get(i).getId()+" - "+listAllBibliographicProducts.get(i).getNameBP();

            }
        }
        
        return msg;
    }

    /**
     * Retrieves the list of magazines among all bibliographic products.
     *
     * @return Returns a string representation of all magazines.
     */
    public String getBPMagazine(){

        String msg = "";

        for(int i=0; i<listAllBibliographicProducts.size();i++){

            if(listAllBibliographicProducts.get(i) instanceof Magazine){

             msg += "\n" + (i+1) +". "+ listAllBibliographicProducts.get(i).getId()+" - "+listAllBibliographicProducts.get(i).getNameBP();

            }
        }
        
        return msg;
    }

    /**
     * Retrieves the list of all users.
     *
     * @return Returns a string representation of all users.
     */
    public String getUsers(){
        String msg = "";

        for(int i=0; i<listAllUsers.size();i++){

            msg += "\n" + (i+1) +". "+ listAllUsers.get(i).getCc()+ " - " +listAllUsers.get(i).getName();

        }
        
        return msg;
    }

    /**
     * Retrieves the list of regular users among all users.
     *
     * @return Returns a string representation of all regular users.
     */
    public String getUsersRegular(){
        String msg = "";

        for(int i=0; i<listAllUsers.size();i++){
            if(listAllUsers.get(i) instanceof UserRegular){
             msg += "\n" + (i+1) +". "+ listAllUsers.get(i).getCc()+" - "+listAllUsers.get(i).getName();
            }
        }
        
        return msg;
    }

    /**
     * Retrieves the list of premium users among all users.
     *
     * @return Returns a string representation of all premium users.
     */
    public String getUsersPremium(){
        String msg = "";

        for(int i=0; i<listAllUsers.size();i++){
            if(listAllUsers.get(i) instanceof UserPremium){
             msg += "\n" + (i+1) +". "+ listAllUsers.get(i).getName() +" - "+ listAllUsers.get(i).getCc();
            }
        }
        
        return msg;
    }

    /**
     * Creates a calendar object with the specified day, month, and year.
     *
     * @param day   The day.
     * @param month The month.
     * @param year  The year.
     * @return Returns a Calendar object representing the specified date.
     */
    public Calendar createDate(int day, int month, int year){
		Calendar date = new GregorianCalendar(year,month-1,day);
        return date;
	}


    /**
     * Verifies if a bibliographic product is a book.
     *
     * @param idBP The ID of the bibliographic product.
     * @return Returns true if the bibliographic product is a book, false otherwise.
     */
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

    /**
     * Verifies if a bibliographic product is a magazine.
     *
     * @param idBP The ID of the bibliographic product.
     * @return Returns true if the bibliographic product is a magazine, false otherwise.
     */
    public boolean verifyMagazine(String idBP){
        boolean isAMagazine = false;
        BibliographicProducts product =getBibliographicProduct(idBP);
        if(product!= null){
            if(product instanceof Magazine){
                isAMagazine=true;
            }
        }
        return isAMagazine;
    }


    /**
     * Retrieves a bibliographic product by its ID.
     *
     * @param idBP The ID of the bibliographic product.
     * @return Returns the bibliographic product matching the specified ID, or null if not found.
     */
    public BibliographicProducts getBibliographicProduct(String idBP){
        BibliographicProducts product = null;
        boolean found =false;
        //System.out.println("El codigo que llega: "+ idBP);

        for(int i=0; i<listAllBibliographicProducts.size()&&!found;i++){

            //System.out.println("Codigo en lista: "+listAllBibliographicProducts.get(i).getId());

            if(listAllBibliographicProducts.get(i).getId().equalsIgnoreCase(idBP)){

                found = true;

                //System.out.println("Entra aca");
                return listAllBibliographicProducts.get(i);
            }
        }
        return product;
    }
    

    /**
     * Searches for a user by their credit card number.
     *
     * @param ccUser The ID number of the user.
     * @return Returns the index of the user in the user list, or -1 if not found.
     */
    public int searchUser(String ccUser) {
       int pos = -1;
       for (int i = 0; i < listAllUsers.size(); i++) {
        if(ccUser.equals(listAllUsers.get(i).getCc())){
            pos = i;
        }
       } 
       return pos;
    }

    /**
     * Determines the type of user based on their credit card number.
     *
     * @param ccUser The ID number of the user.
     * @return Returns true if the user is a regular user, false if the user is a premium user or not found.
     */
    public boolean typeUser(String ccUser) {
        for (User user : listAllUsers) {
            if (user.getCc().equals(ccUser)) {
                if (user instanceof UserRegular) {
                    return true; // User is Regular
                } else if (user instanceof UserPremium) {
                    return false; // User is Premium
                }
            }
        }
        
        return false; // User not found
    }

    /**
     * Determines the type of bibliographic product based on its ID.
     *
     * @param idBP The ID of the bibliographic product.
     * @return Returns true if the bibliographic product is a book, false if it's a magazine or not found.
     */
    public boolean typeProducts(String idBP) {
        for (BibliographicProducts products: listAllBibliographicProducts) {
            if (products.getId().equals(idBP)) {
                if (products instanceof Book) {
                    return true; // User is Regular
                } else if (products instanceof Magazine) {
                    return false; // User is Premium
                }
            }
        }
        
        return false; // User not found
    }

    /**
     * Searches for a bibliographic product by its ID.
     *
     * @param idProduct The ID of the bibliographic product.
     * @return Returns the index of the product in the list of all bibliographic products, or -1 if not found.
     */
    public int searchBP(String idProduct) {
        int pos = -1;
        for (int i = 0; i < listAllBibliographicProducts.size(); i++) {
         if(idProduct.equals(listAllBibliographicProducts.get(i).getId())){
             pos = i;
         }
        } 
        return pos;
    }

    /**
     * Calculates the total number of pages read in books by all users.
     *
     * @return Returns the total number of pages read in books.
     */
    public int numPagesReadBook() {
        int acumReadB = 0;

        for (int i = 0; i < listAllUsers.size(); i++) {
            acumReadB += listAllUsers.get(i).sumNumPagesBook(); 
        }

        return acumReadB;
    }
    /**
     * Calculates the total number of pages read in magazines by all users.
     *
     * @return Returns the total number of pages read in magazines.
     */
    public int numPagesReadMagazine() {
        int acumReadB = 0;

        for (int i = 0; i < listAllUsers.size(); i++) {
            acumReadB += listAllUsers.get(i).sumNumPagesMagazine(); 
        }

        return acumReadB;
    }
    
    /**
     * Displays the most read genres for books and categories for magazines by users.
     * It shows the most read book genre, the number of pages read for books,
     * the most read magazine category, and the number of pages read for magazines.
     */
    public void showMostReadGenresAndCategories() {
        for (User user : listAllUsers) {
            TypeBook mostReadBookGenre = user.getMostReadBookGenre();
            TypeMagazine mostReadMagazineCategory = user.getMostReadMagazineCategory();
            int numPagesReadB = user.sumNumPagesBook();
            int numPagesReadM = user.sumNumPagesMagazine();
            
            System.out.println("Most Read Book Genre: " + mostReadBookGenre);
            System.out.println("Number of Pages Read of the book: " + numPagesReadB);
            System.out.println("Most Read Magazine Category: " + mostReadMagazineCategory);
            System.out.println("Number of Pages Read of the Magazine: " + numPagesReadM);
            System.out.println("-----------------------------------");
            break;
        }
        
    }

    /**
     * Calculates the number of books sold and their total value by genre.
     *
     * @return Returns a formatted message containing the number of books sold and their total value by genre.
     */
    public String sellingBooks() {

        String msg = "";
        int cont1 = 0;
        int cont2 = 0;
        int cont3 = 0;
        double value = 0;

        for (int i = 0; i < listAllBibliographicProducts.size(); i++) {
            if (listAllBibliographicProducts.get(i) instanceof Book) {

                TypeBook genreB  = ((Book) (listAllBibliographicProducts.get(i))).getGender();

                if (genreB == TypeBook.FANTASY) {
                    cont1++;
                    value += ((Book) listAllBibliographicProducts.get(i)).getSellingValue() * ((Book) listAllBibliographicProducts.get(i)).getNumCopies();
                }
                if (genreB == TypeBook.HISTORICAL_NOVEL) {
                    cont2++;
                    value += ((Book) listAllBibliographicProducts.get(i)).getSellingValue() * ((Book) listAllBibliographicProducts.get(i)).getNumCopies();
                }
                if (genreB == TypeBook.SCIENCE_FICTION) {
                    cont3++;
                    value += ((Book) listAllBibliographicProducts.get(i)).getSellingValue() * ((Book) listAllBibliographicProducts.get(i)).getNumCopies();
                }

            }

        }
        msg += "\nThe number of books sold in the: ";
        msg += "\nFantasy " + cont1 ;
        msg += "\nHistorical Novel " + cont2 ;
        msg += "\nScience Fiction " + cont3 ;

        msg += "\n\nThe value total : ";
        msg += "\nFantasy " + value;
        msg += "\nHistorical Novel " + value;
        msg += "\nScience Fiction " + value;


        return msg;
    }

    /**
     * Calculates the number of active subscriptions and their total value by magazine category.
     *
     * @return Returns a formatted message containing the number of active subscriptions and their total value by category.
     */
    public String numSubsActiveValueTotal(){

        String msg = "";

        int cont1 = 0;
        int cont2 = 0;
        int cont3 = 0;
        double value = 0;

        for (int i = 0; i < listAllBibliographicProducts.size(); i++) {
            if (listAllBibliographicProducts.get(i) instanceof Magazine) {

                TypeMagazine categoryM = ((Magazine) (listAllBibliographicProducts.get(i))).getCategory();

                if (categoryM == TypeMagazine.DESIGN) {
                    cont1++;
                    value += ((Magazine) listAllBibliographicProducts.get(i)).getValueSubscription() * ((Magazine) listAllBibliographicProducts.get(i)).getNumSubscription();
                }
                if (categoryM == TypeMagazine.SCIENTIFIC) {
                    cont2++;
                    value += ((Magazine) listAllBibliographicProducts.get(i)).getValueSubscription() * ((Magazine) listAllBibliographicProducts.get(i)).getNumSubscription();
                }
                if (categoryM == TypeMagazine.VARIETIES) {
                    cont3++;
                    value += ((Magazine) listAllBibliographicProducts.get(i)).getValueSubscription() * ((Magazine) listAllBibliographicProducts.get(i)).getNumSubscription();
                }

            }

        }

        msg += "\nThe number of books sold in the: ";
        msg += "\nDesing " + cont1 ;
        msg += "\nScientific " + cont2 ;
        msg += "\nVarieties " + cont3 ;

        msg += "\n\nThe value total: ";
        msg += "\nDesing " + value;
        msg += "\nScientific " + value;
        msg += "\nVarieties " + value;
        return msg;
    }

    /**
     * Converts a Calendar object to a formatted date string.
     *
     * @param date The Calendar object representing the date.
     * @return Returns the formatted date string.
     */
    public String changeFormat(Calendar date){
        String formatDate = simpleDateFormat.format(date.getTime());
        return formatDate;
    }

    /**
     * Identifies a bibliographic product by its position in a user's list.
     *
     * @param ccUser The ID number of the user.
     * @param row    The row position of the product in the user's list.
     * @param column The column position of the product in the user's list.
     * @return Returns the identified bibliographic product as a string.
     */

    public String identifyProduct(String ccUser, int row, int column) {
        String msg = "";
        User user = null;
    
        for (User currentUser : listAllUsers) {
            if (currentUser.getCc().equals(ccUser)) {
                user = currentUser;
                 // Salir del bucle después de encontrar al usuario
            }
        }
    
        if (user != null) {
            ArrayList<BibliographicProducts[][]> listAllBiblio = user.getListAllBiblio();
            BibliographicProducts[][] listOfBiblio = user.getListOfBiblio();
            BibliographicProducts product = listOfBiblio[row][column];
            BibliographicProducts products = listAllBiblio.get(0)[row][column];
            if (product != null) {
                msg = product.getNameBP();
            } else if(products != null) {
                msg = products.getNameBP();
            }else{
                msg = "No product in the specified position";
            }
        } else {
            msg = "User not found";
        }
    
        return msg;
    }
    

    /**
     * Retrieves the number of pages of a bibliographic product.
     *
     * @param ccUser The ID number of the user.
     * @param row    The row position of the product in the user's list.
     * @param column The column position of the product in the user's list.
     * @return Returns the number of pages of the product.
     */

    public int cantPages(String ccUser, int row, int column) {
        int msg = 0;
        User user = null;
    
        for (User currentUser : listAllUsers) {
            if (currentUser.getCc().equals(ccUser)) {
                user = currentUser;
                
            }
        }
    
        if (user != null) {
            ArrayList<BibliographicProducts[][]> listAllBiblio = user.getListAllBiblio();
            BibliographicProducts[][] listOfBiblio = user.getListOfBiblio();
            if (row >= 0 && row < listOfBiblio.length && column >= 0 && column < listOfBiblio[row].length) {
                BibliographicProducts product = listOfBiblio[row][column];
                BibliographicProducts products = listAllBiblio.get(0)[row][column];
                if (product != null) {
                    msg = product.getNumPages();
                } else if(products != null){
                    msg = products.getNumPages();
                }else{
                    msg = -1; // Valor predeterminado para indicar que no hay producto en la posición especificada
                }
            } else {
                msg = -1; // Valor predeterminado para indicar una posición inválida en la matriz de productos
            }
        } else {
            msg = -1; // Valor predeterminado para indicar que no se encontró el usuario
        }
    
        return msg;
    }

}

