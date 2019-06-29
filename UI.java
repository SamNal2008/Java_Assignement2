import java.util.*;
/**
 * Décrivez votre classe UI ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
public class UI
{
    
    public static void main(String[] args) 
    {
        System.out.println("Bienvenido en el cartel de la coche y de la vane");
        //Creation Vehicles
        Vehicle vec1 = new Car(12345, "aveo" , 2016,  "diesel","Available",7);
        Vehicle vec2 = new Car(12346, "mini" , 2014,  "gasual","Available",5);
        Vehicle vec3 = new Car(12347, "picaso" , 2010,  "oil","Unvailbale",5);
        Vehicle vec4 = new Van(12348, "combi" , 2004,  "gasual","Available",250);
        
        //Creation customers
        
        Customer cus1 = new Customer("Sam",1);
        Customer cus2 = new Customer("Evan",2);
        
        //Creation Company
        Company comp = new Company("Mafia");
        //comp.display();
        System.out.println("*****************************");
        comp.addVehicle(vec1);
        comp.addVehicle(vec2);
        comp.addCustomer(cus1);
        comp.addCustomer(cus2);
        comp.display();
        System.out.println("*****************************");
        //Creation date
        Date resDate = new Date();
        resDate.setYear(2019);
        
        Date pupDate = new Date();
        pupDate.setDate(9);
        pupDate.setMonth(2);
        pupDate.setYear(2019);
        pupDate.setHours(11);
        pupDate.setMinutes(16);
        
        Date pupDate2 = new Date();
        pupDate2.setDate(10);
        pupDate2.setMonth(2);
        pupDate2.setYear(2019);
        pupDate2.setHours(11);
        pupDate2.setMinutes(16);
        
        int period = 5;
        int hours = (pupDate.getHours()+period);
        Date retDate = new Date();
        retDate.setDate(pupDate.getDate());
        retDate.setMonth(pupDate.getMonth());
        retDate.setYear(pupDate.getYear());
        retDate.setHours(hours);
        retDate.setMinutes(pupDate.getMinutes());
        
        System.out.println(hours);
        retDate.setHours(hours);

        //Reservation 
        Reservation res1 = new Reservation(comp.getVehicleList().get(1),cus1,resDate,pupDate,5,"12 Jhon Street",15498756);
        Reservation res2 = new Reservation(comp.getVehicleList().get(0),cus1,resDate,pupDate2,5,"12 Jhon Street",15498757);
        System.out.println("*****************************");
        comp.newRes(res1);
        comp.newRes(res2);
        comp.display();
        System.out.println("*****************************");
        comp.returnVehicle(res1);
        comp.display();

    }
}
