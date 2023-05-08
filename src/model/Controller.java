package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller{

    private ArrayList<User> listAllUsers;
    private ArrayList<BibliographicProducts> listAllBibliographicProducts;

    public Controller(){
        listAllUsers = new ArrayList<>();
        listAllBibliographicProducts = new ArrayList<>();
    }

    public boolean createUser(int userType, String name, String cc, int day, int month, int year){
        

        Calendar date = new GregorianCalendar(year,month-1,day);
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

    public boolean registerBook(String id, String nameBP, int numPages, int dayB, int monthB, int yearB, String URL, String reviewShort, int genderIndex, double sellingValue, int numCopies){

       TypeBook gender = TypeBook.values()[genderIndex-1];


       Book newBook = new Book(id, nameBP, numPages, new GregorianCalendar(yearB, monthB, dayB), URL, numPages, reviewShort, gender, sellingValue, numCopies);

       return listAllBibliographicProducts.add(newBook);
        
    }

    public boolean registerMagazine(String id, String nameBP, int numPages, int dayM, int monthM, int yearM, String URL, int acumReadPages, int categoryIndex, double valueSuscription, String emissionPeriod, int numSuscription){

        TypeMagazine category = TypeMagazine.values()[categoryIndex-1];

        Magazine newMagazine = new Magazine(id, nameBP, numPages, new GregorianCalendar(yearM, monthM, dayM), URL, acumReadPages, category, valueSuscription, emissionPeriod, numSuscription);

        return listAllBibliographicProducts.add(newMagazine);

    }

    public boolean modifyBook(String idBModify, String nameBPModify, int numPagesModify, int dayBModify, int monthBModify, int yearBModify, String URLModify, String reviewShortModify, int genderIndexModify, double sellingValueModify, int numCopiesModify){
        


        return false; 
    }

    public boolean modifyMagazine(String idMModify, String namePBModify, int numPagesModify, int dayMModify, int monthMModify, int yearMModify, String URLModify, int acumReadPagesModify, int categoryIndexModify, double valueSuscriptionModify, String emissionPeriodModify, int numSuscriptionModify){



        return false;
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

    public String getProducts(){
        String msg = "";

        for(int i=0; i>listAllBibliographicProducts.size();i++){

             msg = "\n" + (i+1) +". "+ listAllBibliographicProducts.get(i).getId()+"-"+listAllBibliographicProducts.get(i).getNameBP();

        }
        
        return msg;
    }

    public String getBPBook(){
        
        String msg = "";

        for(int i=0; i>listAllBibliographicProducts.size();i++){

             msg = "\n" + (i+1) +". "+ listAllBibliographicProducts.get(i).getId()+"-"+listAllBibliographicProducts.get(i).getNameBP();

        }
        
        return msg;
    }



    public Calendar createDate(int day, int month, int year){
		Calendar date = new GregorianCalendar(year,month-1,day);
        return date;
	}
}

