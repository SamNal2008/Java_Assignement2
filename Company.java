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
    private ArrayList<Reservation> resList = new ArrayList();
    /**
     * Constructor for objects of class Company
     */
    public Company(String name)
    {
        this.name = name;
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
        this.customerList.add(customer);
        return true;
    }

    public boolean addVehicle(Vehicle vehicle)
    {
        this.vehicleList.add(vehicle);
        return true;
    }

    public boolean deleteVehicle(int RN)//delete the vehicle with the RN entered
    {
        for(int i = 0;i<this.vehicleList.size();i++)
        {
            if(this.vehicleList.get(i).getRN()==RN)
            {
                this.vehicleList.remove(this.vehicleList.get(i));
                System.out.println("Your vehicle has been deleted successfully");
                return true;
            }
        }
        System.out.println("Your vehicle has not been found");
        return false;
    }
    
    public boolean deleteCustomer(int ID)//delete the customer with the ID entered
    {
        for(int i = 0;i<this.customerList.size();i++)
        {
            if(this.customerList.get(i).getID()==ID)
            {
                this.customerList.remove(this.customerList.get(i));
                System.out.println("Your vehicle has been deleted successfully");
                return true;
            }
        }
        System.out.println("Your vehicle has not been found");
        return false;
    }
    
    public boolean newRes(Reservation reservation)
    {
        for(int i = 0;i<this.resList.size();i++)
        {
           if(resList.get(i).getNbRes()==reservation.getNbRes())
           {
               System.out.println("This reservation is already registred");
               return false;
            }
        }
        resList.add(reservation);
        return true;
        
    }
           
            
    public void display()
    {
        System.out.println("The name of company is :" + this.name);
        System.out.println("---------------------------------------");
        System.out.println("Here is the list of the vehicle");
        for(int i = 0;i<this.vehicleList.size();i++)
        {
            vehicleList.get(i).display();
            System.out.println("");
        }
        System.out.println("---------------------------------------");
        System.out.println("Here is the list of the vehicle");
        for(int i = 0;i<this.customerList.size();i++)
        {
            customerList.get(i).display();
            System.out.println("");
        }
        System.out.println("---------------------------------------");
        
    }

}
