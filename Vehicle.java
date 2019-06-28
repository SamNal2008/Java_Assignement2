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
    protected boolean repair;

    /**
     * Constructor for objects of class Vehicle
     */
    public Vehicle()
    {
        this.RN = 0;
        this.modelName = "";
        this.year = 0;
        this.TypeFuel = "";
        this.repair = false;
    }


    public Vehicle(int RN, String model , int year,  String fuel)
    {
        this.RN = RN;
        this.modelName = model;
        this.year = year;
        this.TypeFuel = fuel;
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

    public boolean getRepair()
    {
        return this.repair;
    }

    public void setRepair(boolean repair)
    {
        this.repair = repair;
    }

    public void display()
    {
        System.out.format("|%5d",this.RN);
        System.out.format("|%10s",this.modelName);
        System.out.format("|%4d" , this.year);
        System.out.format("|%10s",this.TypeFuel);
        if (this.repair)
        {
            System.out.print("|   Yes");
        }
        else
        {
            System.out.print("|    No");
        }
    }
    
    public String toString()
    {
        String res = "the vehicle " + this.modelName + " : " + this.RN + " from " + this.year + ". the type of the fuel is : " + this.TypeFuel ; 
        return res;
    }

}
