import java.util.*;
import java.io.FileReader;
import java.io.IOException;
 
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
        cus1.setCategory("Premium");
        cus2.setCategory("Premium");
        
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
      
        
        Date pupDate = new Date();
        pupDate.setDate(23);
        pupDate.setMonth(6);
        pupDate.setHours(8);
        pupDate.setMinutes(50);
        
        Date pupDate2 = new Date();
        pupDate2.setDate(24);
        pupDate2.setMonth(6);
        pupDate2.setHours(10);
        pupDate2.setMinutes(50);
        
        int period = 17;
        int hours = (pupDate.getHours()+period);
        Date retDate = new Date();
        retDate.setDate(pupDate.getDate());
        retDate.setMonth(pupDate.getMonth());
        retDate.setYear(pupDate.getYear());
        retDate.setHours(hours);
        retDate.setMinutes(pupDate.getMinutes());
        
       

        //Reservation 
        Reservation res = new Reservation(cus2,comp.getVehicleList().get(0),pupDate2,period,"Rue jean jaures");
        
        //Other constructor for reservation
        //Reservation res1 = new Reservation(comp.getVehicleList().get(1),cus1,pupDate,5,"12 Jhon Street",15498756);
        //Reservation res2 = new Reservation(comp.getVehicleList().get(0),cus2,pupDate2,5,"12 Jhon Street",15498757);
        
        System.out.println("*****************************");
        comp.newRes(res);
        Reservation res2 = new Reservation(cus2,comp.getVehicleList().get(1),pupDate,period,"Rue du palmier");
        comp.newRes(res2);
        
        comp.display();
        /*
        comp.newRes(res2);
        System.out.println("*****************************");
        System.out.println("*****************************");
        */

        //comp.returnVehicle(res);
        //comp.display();
        
        
        try {
            FileReader reader = new FileReader("MyFile.txt");
            int character;
 
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
