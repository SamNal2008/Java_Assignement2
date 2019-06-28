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

    /**
     * Constructor for objects of class Customer
     */
    public Customer(String name,int ID)
    {
        this.name = name;
        this.ID = ID;
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

}
