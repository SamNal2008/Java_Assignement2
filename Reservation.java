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
    private Vehicle vehicle;
    private Customer customer;
    private Date today = new Date();//today's date
    private int period;
    private Date resDate = new Date();//reservation date
    private Date pupDate = new Date(); //pickup date
    private String pupLoc;//pickup location
    private Date retDate = new Date(); // return date
    private int nb_res;
    private Scanner read = new Scanner(System.in);
    private boolean exists = false;
    private Date realRetDate = null;

    public Reservation()
    {
    }

    public Reservation(Customer c,Vehicle v,Date pupDate,int period,String pupLoc,int resN)
    {
        this.nb_res = resN;
        setPupDate(pupDate);
        setVehicle(v);
        setCustomer(c);
        setResDate();
        setPeriod(period);
        setPupLoc(pupLoc);
        setRetDate();
        if(setVehicle(v)&& setCustomer(c)&&setResDate()&&setPupDate(pupDate)&&setPeriod(period)&&setPupLoc(pupLoc)&&setRetDate())
        {
            this.exists =true;
            System.out.println("The reservation has been created");
            System.out.println("***************************************");
        }

        /*System.out.println("When do you want to pickup the car ?");
        this.pupDate = read.next();*/

    }
    
    public boolean exists()
    {
        return this.exists;
    }
    
    public boolean setVehicle(Vehicle v)
    {
        if(v.getAvailableDate().before(this.pupDate))
        {
            this.vehicle = v;
            return true;
        }
        else
        {
            System.out.println("Sorry the vehicle is not available");
            return false;
        }
    }

    public boolean setCustomer(Customer c)
    {
        this.customer = c;
        return true;
    }

    public Reservation(Vehicle v, Customer c,Date pickupDate,int period,String pickupLocation, int NR)
    {
        this.vehicle = v;//need to take it from the list of vehicle
        this.customer = c;//same but customers
        setResDate();
        this.pupDate = pickupDate;
        this.period = period;
        this.pupLoc = pickupLocation;
        int hours = this.pupDate.getHours()+period;
        this.retDate.setDate(this.pupDate.getDate());
        this.retDate.setMonth(this.pupDate.getMonth());
        this.retDate.setYear(this.pupDate.getYear());
        this.retDate.setHours(hours);
        this.retDate.setMinutes(this.pupDate.getMinutes());
        this.exists = true;
        this.nb_res = NR;
    }
    public void setRealRetDate(Date date)
    {
        this.realRetDate = date;
    }
    public Date getRealRetDate()
    {
        return this.realRetDate;
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
            System.out.print("The reservation has been asked  this day : ");
            displayDate(this.resDate);
            System.out.println("");
            return true;
        }
    }

    public Date getResDate()
    {
        return this.resDate;
    }

    public boolean setPupDate(Date date)
    {
        if(this.resDate.before(date))
        {
            if(this.resDate.getDate() == date.getDate() && this.resDate.getMonth()==date.getMonth()&&this.resDate.getYear()==date.getYear())
            {
                int delai = (date.getHours()*60+date.getMinutes()) -  ( this.resDate.getHours()*60 + this.resDate.getMinutes() );
                if(this.customer.getCategory() == "budget")
                {
                    if(delai>(5*60))
                    {
                        this.pupDate = date;
                        System.out.println("The pick up date will be : " + this.pupDate.toString());
                        return true;
                    }
                    else
                    {
                        System.out.println("For the client of category : " + this.customer.getCategory()+ "the reservation  should be made 5 hours before");
                        return false;
                    }
                }
                else
                {
                    if(delai>60)
                    {
                        this.pupDate = date;
                        System.out.println("The pick up date will be : "+ this.pupDate.toString());
                        return true;
                    }
                    else
                    {
                       
                        System.out.println("For the client of category :" + this.customer.getCategory() + " the reservation should be made at least 1 hours before the pickup");
                        return false;
                    }
                }
            }
            else
            {
                
                int time = (date.getMonth()*30 + date.getDate()) - (this.resDate.getMonth() * 30 + this.resDate.getDate())  ;
                if(time<=30)
                {
                    this.pupDate = date;
                    System.out.println("The pickup date will be : " + this.pupDate.toString());
                    return true;
                }
                else
                {
                    
                    System.out.println("It's too early to make a reservation");
                    return false;
                }
            }
        }
        else
        {
            System.out.println("You cannot make a reservation for a past date");
            return false;
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
            if(this.customer.getCategory().equals("Premium"))
            {
                if(period<=20)
                {
                    this.period = period;
                    System.out.println("The period of hiring the vehicle is :"+this.period+" hours");
                    return true;
                }
                else
                {
                    System.out.println("The period for premium member can not exceed 20 hours");
                    return false;
                }
            }
            else
            {
                if(period<=15)
                {
                    this.period = period;
                    System.out.println("The period of hiring the vehicle is :"+this.period+" hours");
                    return true;
                }
                else
                {
                    System.out.println("The period for non premium member can not exceed 15 hours");
                    return false;
                }
            }
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

    public boolean setRetDate()
    {
        int hours = this.pupDate.getHours()+period;
        this.retDate.setDate(this.pupDate.getDate());
        this.retDate.setMonth(this.pupDate.getMonth());
        this.retDate.setYear(this.pupDate.getYear());
        this.retDate.setHours(hours);
        this.retDate.setMinutes(this.pupDate.getMinutes());
        return true;
    }

    public Date getRetDate()
    {
        return this.retDate;
    }
    public boolean setNbRes(int nb)
    {
        this.nb_res = nb;
        return true;
    }
    public int getNbRes()
    {
        return this.nb_res;
    }

    public Vehicle getVehicle()
    {
        return this.vehicle;
    }

    public Customer getCustomer()
    {return this.customer;}
    
    

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
