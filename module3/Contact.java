
import java.util.*; 


public class Contact {
    // Privates
    private String name;
    private String number;

    // Constructors
    public Contact(String var1, String var2){
        this.name = var1;
        this.number = var2;
    }

    // Some Getters
    public String getName() {return name;}
    public String getNumber() {return number;}

    // TOSTRING: what prints when you System.out.println(employee) 
    @Override 
    public String toString() { 
        return name + " | +1" + number; 
    }

}