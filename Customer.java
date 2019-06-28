import java.util.*;
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
    // instance variables - replace the example below with your own
    private int ID;
    private String name;
    private String category;
    //private enum category {premium, standard,budget};
    /**
     * Constructor for objects of class Customer
     */
    public Customer(String name,int ID)
    {
        this.name = name;
        this.ID = ID;
    }
    public Customer(String name,int ID,String category)
    {
        this.name = name;
        this.ID = ID;
        this.category = category;
    }
    
    public Customer()
    {
    }
    
    public void setID(int ID)
    { 
        this.ID = ID;
    }
    
    public int getID()
    {
        return this.ID;
    }
    
    public void setCategory(String category)
    {
        this.category = category;
    }
    
    public String getCategory()
    {
        return this.category;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void display()
    {
        System.out.format("%4s",this.name);
        System.out.format("|%4d",this.ID);
        System.out.format("|%7s",this.category);
        System.out.print("|");
    }
    
    public String toString()
    {
        String res = "the customer " + this.name + " : " + this.ID + " who has the category " + this.category; 
        return res;
    }
}
