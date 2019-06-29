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
        Vehicle vec1 = new Car(12345, "aveo" , 2016,  "diesel","reaparation",7);
        Vehicle vec2 = new Car(12346, "mini" , 2014,  "gasual","Available",5);
        Vehicle vec3 = new Car(12347, "picaso" , 2010,  "oil","Unvailbale",5);
        Vehicle vec4 = new Van(12348, "combi" , 2004,  "gasual","Available",250);
        
        //Creation customers
        
        Customer cus1 = new Customer("Sam",1);
        Customer cus2 = new Customer("Evan",2);
        
        //Creation Company
        Company comp = new Company("Mafia");
        comp.addVehicle(vec1);
        comp.addVehicle(vec2);
        comp.addCustomer(cus1);
        comp.addCustomer(cus2);
        comp.display();
        //Creation date
        Date resDate = new Date();
        resDate.setDate(10);
        resDate.setMonth(2);
        resDate.setYear(2019);
        resDate.setHours(10); 
        resDate.setMinutes(7);
        
        Date pupDate = new Date();
        pupDate.setDate(10);
        pupDate.setMonth(2);
        pupDate.setYear(2019);
        pupDate.setHours(10);
        pupDate.setMinutes(6);
        
        Date retDate = new Date(2019,5,5);
        //Reservation 
        Reservation res1 = new Reservation(vec1,cus1,resDate,pupDate,5,"12 Jhon Street",retDate,15498756);
        res1.display();

    }
}
