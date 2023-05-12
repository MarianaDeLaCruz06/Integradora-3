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
            System.out.println("3. ");
            System.out.println("4. Here you can buy a book or subscribe to a magazine");
            System.out.println("5. Reading session");
            System.out.println("6. Biblioteca de Productos Bibliográficos");
            System.out.println("7. Exit");

            System.out.print("Select an option: ");
            int option=reader.nextInt();
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
                   buyProduct();
                break;

                case 4:
                    
                break;

                case 5:
                   
                break;

                case 6:
                   
                break;

                case 7:
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

        System.out.println("Enter the book ID:");
        String idB = reader.nextLine();
        System.out.println("Enter the book name:");
        String nameBP = reader.nextLine();
        System.out.println("Enter the number of pages:");
        int numPages = reader.nextInt();
        System.out.println("Enter the publication day:");
        int dayB = reader.nextInt();
        System.out.println("Enter the publication month:");
        int monthB = reader.nextInt();
        System.out.println("Enter the publication year:");
        int yearB = reader.nextInt();
        System.out.println("Enter the URL:");
        String URL = reader.next();
        System.out.println("Enter the pages acum");
        int acumReadPages = reader.nextInt();

        System.out.println("Enter the review:");
        String reviewShort = reader.next();

        reader.nextLine();

        System.out.println("Enter the genre (1. Science Fiction, 2. Fantasy, 3. Historical novel):");
        int genderIndex = reader.nextInt();
        System.out.println("Enter the selling value:");
        double sellingValue = reader.nextDouble();
        System.out.println("Enter the number of copies:");
        int numCopies = reader.nextInt();

        
        if (controller.registerBook(idB, nameBP, numPages, dayB, monthB, yearB, URL, acumReadPages, reviewShort, genderIndex, sellingValue, numCopies)) {
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

        System.out.println("Enter the ID:");
        String idM = reader.nextLine();
        System.out.println("Enter the name:");
        String namePB= reader.nextLine();
        System.out.println("Enter the number of pages:");
        int numPages = reader.nextInt();
        System.out.println("Enter the publication day:");
        int dayM = reader.nextInt();
        System.out.println("Enter the publication month:");
        int monthM = reader.nextInt();
        System.out.println("Enter the publication year:");
        int yearM = reader.nextInt();
        System.out.println("Enter the URL:");
        String URL = reader.nextLine();
        System.out.println("Enter the accumulated read pages:");
        int acumReadPages = reader.nextInt();
        System.out.println("Enter the category index (1. Varieties, 2. Design, 3. Scientific):");
        int categoryIndex = reader.nextInt();
        System.out.println("Enter the value of subscription:");
        double valueSuscription = reader.nextDouble();
        System.out.println("Enter the emission period:");
        String emissionPeriod = reader.nextLine();
        System.out.println("Enter the number of subscriptions:");
        int numSuscription = reader.nextInt();

        // Registrar la nueva revista en la biblioteca
        boolean magazineRegistered = controller.registerMagazine(idM, namePB, numPages, dayM, monthM, yearM, URL, acumReadPages, categoryIndex, valueSuscription, emissionPeriod, numSuscription);

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
            
            System.out.println("Select the book you werw saying to modify");
            int optionModify = reader.nextInt();
            System.out.println("Enter the book ID:");
            String idBModify = reader.nextLine();
            System.out.println("Enter the book name:");
            String nameBPModify = reader.nextLine();
            System.out.println("Enter the number of pages:");
            int numPagesModify = reader.nextInt();
            System.out.println("Enter the publication day:");
            int dayBModify = reader.nextInt();
            System.out.println("Enter the publication month:");
            int monthBModify = reader.nextInt();
            System.out.println("Enter the publication year:");
            int yearBModify = reader.nextInt();
            System.out.println("Enter the URL:");
            String URLModify = reader.next();
            System.out.println("Enter the URL:");
            int acumReadPagesModify = reader.nextInt();
            System.out.println("Enter the review:");
            String reviewShortModify = reader.next();
            System.out.println("Enter the genre (1. Science Fiction, 2. Fantasy, 3. Historical novel):");
            int genderIndexModify = reader.nextInt();
            System.out.println("Enter the selling value:");
            double sellingValueModify = reader.nextDouble();
            System.out.println("Enter the number of copies:");
            int numCopiesModify = reader.nextInt();
    
            
            if (controller.modifyBook(optionModify, idBModify, nameBPModify, numPagesModify, dayBModify, monthBModify, yearBModify, URLModify, acumReadPagesModify, reviewShortModify, genderIndexModify, sellingValueModify, numCopiesModify)) {
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
            System.out.println("Enter the ID:");
            String idMModify = reader.nextLine();
            System.out.println("Enter the name:");
            String namePBModify = reader.nextLine();
            System.out.println("Enter the number of pages:");
            int numPagesModify = reader.nextInt();
            System.out.println("Enter the publication day:");
            int dayMModify = reader.nextInt();
            System.out.println("Enter the publication month:");
            int monthMModify = reader.nextInt();
            System.out.println("Enter the publication year:");
            int yearMModify = reader.nextInt();
            System.out.println("Enter the URL:");
            String URLModify = reader.nextLine();
            System.out.println("Enter the accumulated read pages:");
            int acumReadPagesModify = reader.nextInt();
            System.out.println("Enter the category index (1. Varieties, 2. Design, 3. Scientific):");
            int categoryIndexModify = reader.nextInt();
            System.out.println("Enter the value of subscription:");
            double valueSuscriptionModify = reader.nextDouble();
            System.out.println("Enter the emission period:");
            String emissionPeriodModify = reader.nextLine();
            System.out.println("Enter the number of subscriptions:");
            int numSuscriptionModify = reader.nextInt();
    
            // Registrar la nueva revista en la biblioteca
            boolean magazineModify = controller.modifyMagazine(optionMModify,idMModify, namePBModify, numPagesModify, dayMModify, monthMModify, yearMModify, URLModify, acumReadPagesModify, categoryIndexModify, valueSuscriptionModify, emissionPeriodModify, numSuscriptionModify);
    
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
        System.out.println("Enter the ID number of the user you want");
        String ccUser = reader.nextLine();

        String view2 = controller.getProducts();
        System.out.println(view2);

        System.out.println("Enter the ID number of the book you want");
        String idPB = reader.nextLine();
        
        //mostrar el usuario
        //Pedir el usuario que compra
        //Muestro los productos
        //Pido el producto
        
        if(controller.verifyBook(idPB)){

            controller.buyBook(ccUser, idPB);
            System.out.println("Buy the book");

        }
        else{
            controller.subscribeMagazine(ccUser, idPB);
            System.out.println("Buy the Magazine");
        }
        //Verificar si es libro o un magazine
        // Si es libro llamo al metodo comprar Libro y viceversa

    }




    

}
