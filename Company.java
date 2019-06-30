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
    private Scanner scan = new Scanner(System.in);
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
    
    public ArrayList<Reservation> getResList()
    {
        return this.resList;
    }

    public boolean addCustomer(Customer customer)
    {
        customer.setID(this.customerList.size());
        this.customerList.add(customer);
        return true;
    }
    
    public Customer getCustomer(int ID)
    {
        for(int i = 0;i<this.customerList.size();i++)
        {
            if(this.customerList.get(i).getID() == ID)
            {
                return this.customerList.get(i);
            }
        }
        System.out.println("User was not found, let's create a new customer");
        System.out.println("What is the name of the new customer");
        String name = scan.nextLine();
        System.out.println("What is the category of the new customer");
        String category = scan.nextLine();
        Customer cus = new Customer(name,ID,category);
        this.customerList.add(cus);
        return cus;
    }
    
    public Vehicle getVehicle(int RN)
    {
        Vehicle vec = new Vehicle();
        for(int i = 0;i<this.vehicleList.size();i++)
        {
            if(this.vehicleList.get(i).getRN() == RN)
            {
                vec =  this.vehicleList.get(i);
                return vec;
            }
        }
        System.out.println("This vehicle doesnt exist");
        return vec;
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
        if(reservation.exists())
        {
            for(int i = 0;i<this.vehicleList.size();i++)
            {
                if(this.vehicleList.get(i).getRN() == reservation.getVehicle().getRN())
                {
                    this.vehicleList.get(i).setState("Hired");
                    this.vehicleList.get(i).setAvailableDate(reservation.getRetDate());
                    reservation.setNbRes(this.resList.size());
                    this.resList.add(reservation);
                    System.out.println("The reservation has been added successfully");
                    sorted();
                    return true;
                }

            }
            System.out.println("You don't have vehicle yet");
            return false;
        }
        else
        {
            System.out.println("The reservation is not valid");
            return false;
        }
    }

    public void sorted()
    {
        ArrayList<Reservation> sortedList = new ArrayList();

        while(!this.resList.isEmpty())
        {
            Reservation mini = resList.get(0);
            for(int j = 0;j<this.resList.size();j++)
            {
                if(this.resList.get(j).getpupDate().before(mini.getpupDate()))
                {
                    mini = this.resList.get(j);
                }
            }
            sortedList.add(mini);
            this.resList.remove(mini);
        }
        this.resList = sortedList;
    }

    public int returnVehicle(int NR)
    {
        Date today = new Date();
        Reservation reservation = new Reservation();
        for(int i = 0;i<this.resList.size();i++)
        {
            if(this.resList.get(i).getNbRes()==NR)
            {
                reservation =this.resList.get(i);
                break;
            }
        }
        
        for(int i = 0;i<this.vehicleList.size();i++)
        {
            if(this.vehicleList.get(i).equals(reservation.getVehicle()))
            {
                this.vehicleList.get(i).setState("Available");
            }
        }

        if(today.before(reservation.getRetDate()))
        {
            System.out.println("Thank you everything is ok");
            reservation.setRealRetDate(today);
            return 0;
        }
        else
        {
            int price = (today.getHours() - reservation.getRetDate().getHours()) * reservation.getVehicle().getHourlyRate();
            reservation.setRealRetDate(today);
            System.out.println("You need to pay extra fees: "+ price +" dollars");
            return price;
        }
    }

    public void showAvailableVeh()
    {
        for(int i = 0;i<this.vehicleList.size();i++)
        {
            if(this.vehicleList.get(i).isFree())//&& this.vehicleList.get(i) instanceof Car)
                {
                    this.vehicleList.get(i).display();
                    System.out.println();
                }
        }
    }


    public void display()
    {
        System.out.println("The name of company is :" + this.name);
        System.out.println("---------------------------------------");
        System.out.println("Here is the list of the vehicle");
        if(this.vehicleList.size()==0)
        {
            System.out.println("You dont have vehicle yet");
        }
        for(int i = 0;i<this.vehicleList.size();i++)
        {
            vehicleList.get(i).display();
            System.out.println("");
        }
        System.out.println("---------------------------------------");
        System.out.println("Here is the list of the Customers");
        if(this.customerList.size()==0)
        {
            System.out.println("You dont have customer yet");
        }
        for(int i = 0;i<this.customerList.size();i++)
        {
            customerList.get(i).display();
            System.out.println("");
        }
        System.out.println("---------------------------------------");
        System.out.println("Here is the list of the reservation");
        if(this.resList.size()==0)
        {
            System.out.println("You dont have reservation yet");
        }
        for(int i = 0;i<this.resList.size();i++)
        {
            resList.get(i).display();
            System.out.println("");
        }
        System.out.println("---------------------------------------");

    }

}
