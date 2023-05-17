package ui;

import java.util.Calendar;
import java.util.Scanner;

import model.Controller;

public class Main{
    private Scanner reader;
    private Controller controller;

    public Main() {

        reader = new Scanner(System.in);
        controller = new Controller();
    }

    public static void main(String[] args) {

        Main exe = new Main();
        exe.menu();

    }

    public void menu(){

        System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("* - Hello, welcome to your virtual library  *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");

        boolean cond=false;

        while(!cond){
            System.out.println("1. Register User (Regular and Premium)");
            System.out.println("2. Manage bibliographic products");
            System.out.println("3. Objects in the system for each type of user and bibliographic product");
            System.out.println("4. Here you can buy a book or subscribe to a magazine");
            System.out.println("5. Reading session");
            System.out.println("6. User Bibliographic Products Library");
            System.out.println("7. Generate reports");
            System.out.println("8. Exit");

            System.out.print("Select an option: ");
            int option = reader.nextInt();
            switch (option) {
                case 1:
                    registerUser();
                break;

                case 2:
                    System.out.println("* * * * * * * * * * * * * *");
                    System.out.println("* Bibliographic products: *");
                    System.out.println("* * * * * * * * * * * * * *");
                    System.out.println("1. Register books");
                    System.out.println("2. Register magazines");
                    System.out.println("3. Modify books");
                    System.out.println("4. Modify magazines");
                    System.out.println("5. Delete books");
                    System.out.println("6. Delete magazines");

                    int option3 = reader.nextInt();
                    
                    switch (option3){
                        
                        case 1:
                            registerBook();
                        break;

                        case 2:
                            registerMagazine();
                        break;

                        case 3:
                            modifyBook();
                        break;

                        case 4:
                            modifyMagazine();
                        break;

                        case 5:
                            deleteBook();
                        break;

                        case 6:
                            deleteMagazine();
                        break;
                    
                    }        

                break;

                case 3:
    
                    System.out.println(controller.getUsers());
                    System.out.println(controller.getProducts());
                    System.out.println();

                break;
                    
                case 4:
                    buyProduct();
                break;

                case 5:
                    simulateReadingSession();
                break;

                case 6:
                   
                break;

                case 7:
                   
                break;

                case 8:
                    System.out.println("Goodbye!");
                    cond=true;
                break;

                default:
                    System.out.println("Invalid option. Please try again.");
                break;

            }
        }
    }


    public void registerUser(){

        System.out.println("* * * * * * * * * * *");
        System.out.println("*  - Register User  *");
        System.out.println("* * * * * * * * * * *");

        System.out.println("What user do you want to register");
        System.out.println("1. Regular");
        System.out.println("2. Premium");

        int userType = reader.nextInt();

        System.out.println("Enter the name");
        String name = reader.nextLine();

        reader.nextLine(); // Limpieza de buffer

        System.out.println("Enter de cc");
        String cc = reader.nextLine();

        Calendar date = Calendar.getInstance();
        System.out.println(date);

        if(controller.createUser(userType, name, cc, date)){
            System.out.println("The User has been registered");
        }else{
            System.out.println("The user can not be registered");
        }
    }


    private void registerBook() {

        reader.nextLine();

        System.out.println("* * * * * * * * * * * * *");
        System.out.println("*  Register a New Book  *");
        System.out.println("* * * * * * * * * * * * *");

        reader.nextLine();

        System.out.println("Enter the book ID:");
        String idB = reader.nextLine();
        System.out.println("Enter the book name:");
        String nameBP = reader.nextLine();
        System.out.println("Enter the number of pages:");
        int numPagesB = reader.nextInt();
        System.out.println("Enter the publication day:");
        int dayB = reader.nextInt();
        System.out.println("Enter the publication month:");
        int monthB = reader.nextInt();
        System.out.println("Enter the publication year:");
        int yearB = reader.nextInt();
        System.out.println("Enter the URL:");
        String URLb = reader.next();
        System.out.println("Enter the pages acum");
        int acumReadPagesB = reader.nextInt();

        System.out.println("Enter the review:");
        String reviewShort = reader.next();

        reader.nextLine();

        System.out.println("Enter the genre (1. Science Fiction, 2. Fantasy, 3. Historical novel):");
        int genderIndex = reader.nextInt();
        System.out.println("Enter the selling value:");
        double sellingValue = reader.nextDouble();
        System.out.println("Enter the number of copies:");
        int numCopies = reader.nextInt();

        
        if (controller.registerBook(idB, nameBP, numPagesB, dayB, monthB, yearB, URLb, acumReadPagesB, reviewShort, genderIndex, sellingValue, numCopies)) {
            System.out.println("Book registered successfully!");
        } else {
            System.out.println("The book could not be registered");
        }
    }

    public void registerMagazine(){

        reader.nextLine();

        System.out.println("* * * * * * * * * * * * * * *");
        System.out.println("*  Register a new magazine  *");
        System.out.println("* * * * * * * * * * * * * * *");

        reader.nextLine();

        System.out.println("Enter the ID:");
        String idM = reader.nextLine();
        System.out.println("Enter the name:");
        String namePB= reader.nextLine();
        System.out.println("Enter the number of pages:");
        int numPagesM = reader.nextInt();
        System.out.println("Enter the publication day:");
        int dayM = reader.nextInt();
        System.out.println("Enter the publication month:");
        int monthM = reader.nextInt();
        System.out.println("Enter the publication year:");
        int yearM = reader.nextInt();
        System.out.println("Enter the URL:");
        String URLm = reader.nextLine();
        System.out.println("Enter the accumulated read pages:");
        int acumReadPagesM = reader.nextInt();

        reader.nextLine();

        System.out.println("Enter the category index (1. Varieties, 2. Design, 3. Scientific):");
        int categoryIndex = reader.nextInt();
        System.out.println("Enter the value of subscription:");
        double valueSubscription = reader.nextDouble();
        System.out.println("Enter the emission period:");
        String emissionPeriod = reader.nextLine();
        System.out.println("Enter the number of subscriptions:");
        int numSubscription = reader.nextInt();

        // Registrar la nueva revista en la biblioteca
        boolean magazineRegistered = controller.registerMagazine(idM, namePB, numPagesM, dayM, monthM, yearM, URLm, acumReadPagesM, categoryIndex, valueSubscription, emissionPeriod, numSubscription);

        // Comprobar si la revista fue registrada exitosamente
        if (magazineRegistered) {
            System.out.println("Magazine registered successfully");
        } else {
            System.out.println("Error registering magazine");
        }

    }

    public void modifyBook(){
        String view = controller.getBPBook();

        if(view.equals("")){
            System.out.println("There are no bibliographic products");

        }else{
            System.out.println(view);

            System.out.println("Enter the option you want modify");

            System.out.println("* * * * * * * * * * * *");
            System.out.println("*  Modify a New Book  *");
            System.out.println("* * * * * * * * * * * *");
           
            System.out.println("Select the book you were saying to modify");
            int optionModify = reader.nextInt();

            reader.nextLine();

            System.out.println("Enter the book ID:");
            String idBModify = reader.nextLine();
            System.out.println("Enter the book name:");
            String nameBPModify = reader.nextLine();
            System.out.println("Enter the number of pages:");
            int numPagesBModify = reader.nextInt();
            System.out.println("Enter the publication day:");
            int dayBModify = reader.nextInt();
            System.out.println("Enter the publication month:");
            int monthBModify = reader.nextInt();
            System.out.println("Enter the publication year:");
            int yearBModify = reader.nextInt();
            System.out.println("Enter the URL:");
            String URLBModify = reader.next();
            System.out.println("Enter the URL:");
            int acumReadPagesBModify = reader.nextInt();
            System.out.println("Enter the review:");
            String reviewShortModify = reader.next();
            System.out.println("Enter the genre (1. Science Fiction, 2. Fantasy, 3. Historical novel):");
            int genderIndexModify = reader.nextInt();
            System.out.println("Enter the selling value:");
            double sellingValueModify = reader.nextDouble();
            System.out.println("Enter the number of copies:");
            int numCopiesModify = reader.nextInt();
    
            
            if (controller.modifyBook(optionModify, idBModify, nameBPModify, numPagesBModify, dayBModify, monthBModify, yearBModify, URLBModify, acumReadPagesBModify, reviewShortModify, genderIndexModify, sellingValueModify, numCopiesModify)) {
                System.out.println("Book modify successfully!");
            } else {
                System.out.println("The book could not be modify");
            }
        }
    
    }

    public void modifyMagazine(){
        String view = controller.getBPMagazine();

        if(view.equals("")){
            System.out.println("There are no bibliographic products");

        }else{
            System.out.println(view);

            System.out.println("* * * * * * * * * * * * * *");
            System.out.println("*  Modify a new magazine  *");
            System.out.println("* * * * * * * * * * * * * *");

            System.out.println("Select the magazine you werw saying to modify");
            int optionMModify = reader.nextInt();

            reader.nextLine();
            System.out.println("Enter the ID:");
            String idMModify = reader.nextLine();
            System.out.println("Enter the name:");
            String namePBModify = reader.nextLine();
            System.out.println("Enter the number of pages:");
            int numPagesMModify = reader.nextInt();
            System.out.println("Enter the publication day:");
            int dayMModify = reader.nextInt();
            System.out.println("Enter the publication month:");
            int monthMModify = reader.nextInt();
            System.out.println("Enter the publication year:");
            int yearMModify = reader.nextInt();
            System.out.println("Enter the URL:");
            String URLMModify = reader.nextLine();
            System.out.println("Enter the accumulated read pages:");
            int acumReadPagesMModify = reader.nextInt();
            System.out.println("Enter the category index (1. Varieties, 2. Design, 3. Scientific):");
            int categoryIndexModify = reader.nextInt();
            System.out.println("Enter the value of subscription:");
            double valueSubscriptionModify = reader.nextDouble();
            System.out.println("Enter the emission period:");
            String emissionPeriodModify = reader.nextLine();
            System.out.println("Enter the number of subscriptions:");
            int numSubscriptionModify = reader.nextInt();
    
            // Registrar la nueva revista en la biblioteca
            boolean magazineModify = controller.modifyMagazine(optionMModify,idMModify, namePBModify, numPagesMModify, dayMModify, monthMModify, yearMModify, URLMModify, acumReadPagesMModify, categoryIndexModify, valueSubscriptionModify, emissionPeriodModify, numSubscriptionModify);
    
            // Comprobar si la revista fue registrada exitosamente
            if (magazineModify) {
                System.out.println("Magazine modify successfully");
            } else {
                System.out.println("Error modify magazine");
            }
        }
    }

    public void deleteBook() {

        reader.nextLine();

        String view = controller.getBPBook();

        if(view.equals("")){
            System.out.println("There are no bibliographic products");
        } else{
            
            System.out.println(view);

            System.out.println("* * * * * * * * * *");
            System.out.println("*  Delete a Book  *");
            System.out.println("* * * * * * * * * *");
            reader.nextLine();
            System.out.println("Enter the ID of the book to delete:");
            String idB = reader.nextLine();
            boolean deleted = controller.deleteBook(idB);
            if (deleted) {
                System.out.println("Book deleted successfully");
            } else {
                System.out.println("Error deleting book");
            }
        }
            

     
    }

    public void deleteMagazine() {

        reader.nextLine();

        String view = controller.getBPMagazine();

        if(view.equals("")){
            System.out.println("There are no bibliographic products");
        } else{
            System.out.println(view);

            System.out.println("* * * * * * * * * * * *");
            System.out.println("*  Delete a magazine  *");
            System.out.println("* * * * * * * * * * * *");
            reader.nextLine();
            System.out.println("Enter the ID of the magazine to delete:");
            String idM = reader.nextLine();
            boolean deleted = controller.deleteMagazine(idM);
            if (deleted) {
                System.out.println("Magazine deleted successfully");
            } else {
                System.out.println("Error deleting magazine");
            }
        }
    }

    public void buyProduct(){
        String view = controller.getUsers();
        System.out.println(view);

        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*  - Buy a book or subscribe a magazine *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        reader.nextLine();
        System.out.println("Enter the ID number of the user you want");
        String ccUser = reader.nextLine();

        String view2 = controller.getProducts();
        System.out.println(view2);

        System.out.println("Enter the ID number of the book you want");
        String idPB = reader.nextLine();
        
        
        if(controller.verifyBook(idPB)){

            controller.buyOrSubscribe(ccUser, idPB);
            

        }
       

    }

    public void simulateReadingSession() {
        System.out.println("Simulación de sesión de lectura");
        System.out.println("-----------------------------");
        

        // Obtener el producto bibliográfico y la página actual de alguna manera
        String productName = "Caperucita Roja";
        int currentPage = 1;
        
        boolean reading = true;

        while (reading) {
            System.out.println("Product: " + productName);
            System.out.println("Current page: " + currentPage);
            System.out.println("Navigation options:");
            System.out.println("1. Read previous page");
            System.out.println("2. Read next page");
            System.out.println("3. Return to the Library");
            
            System.out.print("Select an option: ");
            int option = reader.nextInt();
            
            switch (option) {
                case 1:
                    if (currentPage > 1) {
                        currentPage--;
                        System.out.println("You have moved to the previous page.");
                    } else {
                        System.out.println("It is already on the first page.");
                    }
                    break;
                case 2:
                    // Aquí podrías implementar la lógica para verificar si la página siguiente existe
                    currentPage++;
                    System.out.println("You have moved on to the next page.");
                    break;
                case 3:
                    System.out.println("Back to the Library...");
                    reading = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
            
            System.out.println();
        }
    }


    

}
