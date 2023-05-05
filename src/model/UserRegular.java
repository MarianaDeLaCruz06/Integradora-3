package model;

import java.util.Calendar;

public class UserRegular extends User{

    private Book[] listOfBooks = new Book[5];
    private Magazine[] listOfmaMagazines = new Magazine[2];

    public UserRegular(String name, String cc, Calendar date) {
        super(name, cc, date);
    }

    
    
}
