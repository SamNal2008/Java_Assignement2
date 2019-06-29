import java.io.*;
import java.util.*;
/**
 * Write a description of class Reservation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Reservation
{
    // instance variables - replace the example below with your own
    private Vehicle vehicle = new Vehicle();
    private Customer customer = new Customer();
    private Date today = new Date();//today's date
    private int period;
    private Date resDate = new Date();//reservation date
    private Date pupDate = new Date(); //pickup date
    private String pupLoc;//pickup location
    private Date retDate = new Date(); // return date
    private int nb_res;
    
    public Reservation()
    {
    }

    public Reservation(int RN,String name,int ID)
    {
        this.vehicle = new Vehicle();
        this.customer = new Customer(name,ID);
    }

    public Reservation(Vehicle v, Customer c,Date reservationDate,Date pickupDate,int period,String pickupLocation,Date returnDate,int res)
    {
        this.vehicle = v;//need to take it from the list of vehicle
        this.customer = c;//same but customers
        this.resDate = reservationDate;
        this.pupDate = pickupDate;
        this.period = period;
        this.pupLoc = pickupLocation;
        this.retDate = returnDate;
        this.nb_res = res;
        newReservation();
    }

    public void newReservation()
    {
        //this.vehicle.setStatut("Hired");
    }

    public boolean setResDate()
    {
        if(today.getHours()<4 &&today.getHours()>0)
        {
            System.out.println("Sorry you cannot make a reservation now you need to wait until 4am");
            return false;
        }
        else
        {
            this.resDate = this.today;
            System.out.println("The reservation has been made at this day :" + this.resDate);
            return true;
        }
    }

    public Date getResDate()
    {
        return this.resDate;
    }

    public boolean setPupDate(Date date)
    {
        if(this.today.after(date))
        {
            System.out.println("The entered date is already past");
            return false;
        }
        else
        {
            this.pupDate = date;
            System.out.println("The pick up date is : "+this.pupDate);
            return true;
        }
    }

    public Date getpupDate()
    {
        return this.pupDate;
    }

    public boolean setPeriod(int period)
    {
        if(period<0)
        {
            System.out.println("You cannot enter a negative period");
            return false;
        }
        else
        {
            this.period = period;
            System.out.println("The period of hiring the vehicle is :"+this.period+" hours");
            return true;
        }
    }

    public int getPeriod()
    {
        return this.period;
    }
    
    public boolean setPupLoc(String location)
    {
       if(!location.equals(""))
       {
           this.pupLoc = location;
           System.out.println("The pick up location is "+this.pupLoc);
           return true;
        }
        else
        {
            System.out.println("The location can not be empty");
            return false;
        }
    }
    
    public String getPupLoc()
    {
        return this.pupLoc;
    }
    
    public boolean setRetDate(Date date)
    {
        if(this.pupDate.before(date))
        {
            System.out.println("The return date should be after the pick up date");
            return false;
        }
        else
        {
            this.retDate = date;
            System.out.println("The return date is : "+this.retDate);
            return true;
        }
    }
    
    public Date getRetDate()
    {
        return this.retDate;
    }
    
    public void display()
    {

        System.out.format("|%5d",this.nb_res);
        this.vehicle.display();
        this.customer.display();
        System.out.format("%4d", this.period);
        System.out.format("|%10s",this.pupLoc);
        displayDate(this.resDate);
        displayDate(this.pupDate);
        displayDate(this.retDate);
        System.out.println("|");
    }
    
    public void displayDate(Date date)
    {
        String res = "";
        res+=Integer.toString(date.getMonth()) + "-" + Integer.toString(date.getDate()) + "-" + Integer.toString(date.getYear());
        res+=" ";
        res+=Integer.toString(date.getHours()) + ":" +Integer.toString(date.getMinutes());
        System.out.format("|%12s",res);
    }
    
    
}
