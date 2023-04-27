package ui;

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

        System.out.println("Welcome to Green SQA");
        boolean cond=false;

        while(!cond){
            System.out.println("1. Register User (Regular and Premium)");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("4. ");
            System.out.println("5. ");
            System.out.println("6. Publicate capsules");
            System.out.println("7. Other funtions");
            System.out.println("8. Exit");

            System.out.print("Select an option: ");
            int option=reader.nextInt();
            switch (option) {
                case 1:
                    
                break;

                case 2:
                    
                break;

                case 3:
                   
                break;

                case 4:
                    
                break;

                case 5:
                   
                break;

                case 6:
                   
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
}