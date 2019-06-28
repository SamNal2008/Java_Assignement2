import java.util.*;
/**
 * Write a description of class Company here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Company
{
    // instance variables - replace the example below with your own
    private String name;
    private ArrayList<Customer> customerList = new ArrayList();
    private ArrayList<Vehicle> vehicleList = new ArrayList();

    /**
     * Constructor for objects of class Company
     */
    public Company(String name)
    {
        this.name = name;
        Customer c = new Customer("none",0);
        this.customerList.add(c);
    }
    
    public boolean addVehicle(Vehicle vehicle)
    {
        ArrayList<Vehicle> newList = new ArrayList();
        boolean added = false;
        for(int i = 0;i<this.vehicleList.size()-1;i++)
        {
            if(this.vehicleList.get(i).getRN()==vehicle.getRN())
            {
                System.out.println("This vehicle is already registred");
                return false;
            }
            newList.add(this.vehicleList.get(i));
            if(this.vehicleList.get(i+1).getRN()>vehicle.getRN())  
            {
                newList.add(vehicle);
                added = true;
            }
        }
        newList.add(this.vehicleList.get(this.vehicleList.size()-1));
        if(!added)
        {
            newList.add(vehicle);
            this.vehicleList = newList;
            return true;
        }
        return false;
 
    }
    
    public ArrayList<Vehicle> getVehicleList()
    {
        return this.vehicleList;
    }
    
    public ArrayList<Customer> getCustomerList()
    {
        return this.customerList;
    }
    
    public boolean addCustomer(Customer customer)
    {
        ArrayList<Customer> newList = new ArrayList();
        boolean added = false;
        for(int i = 0;i<this.customerList.size()-1;i++)
        {
            if(this.customerList.get(i).getID()==customer.getID())
            {
                System.out.println("This customer is already registred");
                return false;
            }
            newList.add(this.customerList.get(i));
            if(this.customerList.get(i+1).getID()>customer.getID())  
            {
                newList.add(customer);
                added = true;
            }
        }
        newList.add(this.customerList.get(this.customerList.size()-1));
        if(!added)
        {
            newList.add(customer);
            this.customerList = newList;
            return true;
        }
        return false;
    }
        
   
}
