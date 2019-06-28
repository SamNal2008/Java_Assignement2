import java.util.*;
/**
 * Write a description of class Vehicle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vehicle
{
    // instance variables - replace the example below with your own
    private int RN;//registration number
    private String modelName;
    private int year;//year of registration

    /**
     * Constructor for objects of class Vehicle
     */
    public Vehicle()
    {
        
    }
    
    public void setRN(int RN) //set registration number
    {
        this.RN = RN;
    }
    
    public int getRN() //get registration number
    {
        return this.RN;
    }
    
    public void setmodel(String modelName)
    {
        this.modelName = modelName;
    }
    
    public String getModel()
    {
        return this.modelName;
    }
    
    public void setYear(int year)
    {
        this.year = year;
    }
    
    public int getYear()
    {
        return this.year;
    }

}
