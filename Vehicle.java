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
    protected int RN;//registration number
    protected String modelName;
    protected int year;//year of registration
    protected String TypeFuel;
    protected String state;
    protected int hourlyRate;
    protected Date availableDate = new Date();

    /**
     * Constructor for objects of class Vehicle
     */
    public Vehicle()
    {
        this.RN = 0;
        this.modelName = "";
        this.year = 0;
        this.TypeFuel = "";
        this.state = "Free";
    }


    public Vehicle(int RN, String model , int year,  String fuel, String state)
    {
        this.RN = RN;
        this.modelName = model;
        this.year = year;
        this.TypeFuel = fuel;
        this.state = state;
    }
    public boolean equals(Vehicle v)
    {
        return this.RN == v.getRN();
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

    public String getFuel()
    {
        return this.TypeFuel;
    }

    public void setFuel(String Fuel)
    {
        this.TypeFuel = Fuel;
    }

    public String getState()
    {
        return this.state;
    }

    public void setState(String state)
    {
        this.state = state;
    }
    
    public boolean isFree()
    {
        return this.state.equals("Available");
    }
    
    public boolean setAvailableDate(Date date)
    {
        if(date.before(this.availableDate))
        {
            System.out.println("The available is after the new entered");
            return false;
        }
        else
        {
            this.availableDate = date;
            return true;
        }
    }
    
    public Date getAvailableDate()
    {
        return this.availableDate;
    }
            
    public int getHourlyRate()
    {
        return this.hourlyRate;
    }
    public void display()
    {
        System.out.format("|%5d",this.RN);
        System.out.format("|%10s",this.modelName);
        System.out.format("|%4d" , this.year);
        System.out.format("|%10s",this.TypeFuel);
        System.out.format("|%13s",this.state);

    }
    
    public String toString()
    {
        String res = "the vehicle " + this.modelName + " : " + this.RN + " from " + this.year + ". the type of the fuel is : " + this.TypeFuel ; 
        return res;
    }

}
