import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
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
    private static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        
        System.out.println("We need to load the information of the company");
        Company myCompany = loadinfo("companyName");
        myCompany.display();

        printMenu();
        nextAction(myCompany);
    }

    //PRINT THE MENU
    public static void printMenu()
    {
        System.out.println("What do you want to do ?");
        System.out.println("---------------------------------------------");
        System.out.println("1.	Show available vehicles ");
        System.out.println("2.	Reserve a vehicle for a customer ");
        System.out.println("3.	Show hiring records for a customer ");
        System.out.println("4.	Show hiring records for a vehicle ");
        System.out.println("5.	Show not returned (overdue) vehicles");
        System.out.println("6.	Return vehicle from hire ");
        System.out.println("7.  Exit");
        System.out.println("---------------------------------------------");

    }

    //DO THE NEXT ACTION
    public static void nextAction(Company myCompany)
    {
        
        String nextAction = scan.nextLine();
        while(!nextAction.equals("7"))
        {
            if(nextAction.equals("1"))
            {
                myCompany.showAvailableVeh();
            }
            else if(nextAction.equals( "2"))
            {
                System.out.println("Enter the ID of the customer ! ");
                int ID = scan.nextInt();
                Customer cus = myCompany.getCustomer(ID);
                System.out.println("Enter the registration number of the vehicule !");
                int RN = scan.nextInt();
                Vehicle vec = myCompany.getVehicle(RN);
                System.out.println("Enter the date of the reservation");
                int day = scan.nextInt();
                System.out.println("Enter the month of the reservation");
                int month = scan.nextInt();
                System.out.println("Enter the year of the reservation");
                int year = scan.nextInt();
                System.out.println("Enter the hour of the reservation");
                int hours = scan.nextInt();
                Date date = new Date(year,month,day);
                date.setHours(hours);
                System.out.println("Enter the period of the reservation");
                int period = scan.nextInt();
                Reservation res = new Reservation(cus,vec,date,period,"Random place",myCompany.getResList().size());
                myCompany.newRes(res);
            }
            else if(nextAction.equals ("3"))
            {
                System.out.println("What is the ID of the customer that you want to see the record");
                int ID = scan.nextInt();
                myCompany.getResList();
                for(int i = 0;i<myCompany.getResList().size();i++)
                {
                    if(myCompany.getResList().get(i).getCustomer().getID()==ID)
                    {
                        myCompany.getResList().get(i).display();
                    }
                }
            }
            else if(nextAction.equals("4"))
            {
                System.out.println("What is the registration number of the vehicle that you want to see the record");
                int RN = scan.nextInt();
                ArrayList<Reservation> resList = myCompany.getResList();
                for(int i = 0;i<resList.size();i++)
                {
                    if(resList.get(i).getVehicle().getRN()==RN)
                    {
                        resList.get(i).display();
                    }
                }
            }
            else if (nextAction.equals("5"))
            {
               ArrayList<Reservation> resList = myCompany.getResList();
                for(int i = 0;i<resList.size();i++)
                {
                    if(resList.get(i).getRealRetDate()==null)
                    {
                        resList.get(i).display();
                    }
                } 
            }
            else if(nextAction.equals("6"))
            {
                System.out.println("What is the number of the reservation to return the vehicule");
                int NR = scan.nextInt();
                myCompany.returnVehicle(NR);
            }
            printMenu();
            System.out.println("What else ?");
            nextAction = scan.nextLine();
           
        }
        System.out.println("Thank you for using our application see you soon");
        System.out.println("                  .");
        System.out.println("    __  Max       |\\");
        System.out.println(" __/__\\ __________| \\");
        System.out.println("|   ___    |  ,|   ___`-.");
        System.out.println("|  /   \\   |___/  /   \\  `-.");
        System.out.println("|_| (O) |________| (O) |____|");
        System.out.println("   \\___/          \\___/");
     
        
        
    }

    //LOAD INFO from file
    public static Company loadinfo(String companyName)
    {

        Company myCompany = new Company(companyName);
        try {
            FileReader reader = new FileReader("MyVehicles.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int count = 0; 
                int RN = 0;
                String model = null;
                int year = 0;
                String typefuel = null;
                String state=null;
                int capacity = 0;
                String S = "";
                for(int i = 0;i<line.length();i++)
                {

                    if(line.charAt(i)!=','){
                        S+=line.charAt(i);}
                    else
                    {
                        if(count==0)
                        {
                            RN = Integer.parseInt(S);
                            S = "";
                        }
                        if(count == 1)
                        {
                            model = S;
                            S ="";
                        }
                        if(count == 2)
                        {
                            year = Integer.parseInt(S);
                            S ="";
                        }
                        if(count==3)
                        {
                            typefuel = S;
                            S ="";
                        }
                        if(count==4)
                        {
                            state = S;
                            S ="";
                        }
                        if(count==5)
                        {
                            capacity = Integer.parseInt(S);
                            S = "";
                        }
                        count++;
                    }
                }
                Vehicle vec = new Vehicle(RN,model,year,typefuel,state);
                myCompany.addVehicle(vec);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //LOAD CUSTOMERS
        try {
            FileReader reader = new FileReader("MyCustomers.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int count = 0; 
                int ID = 0;
                String name = null;
                String category = null;

                String S = "";
                for(int i = 0;i<line.length();i++)
                {

                    if(line.charAt(i)!=','){
                        S+=line.charAt(i);}
                    else
                    {
                        if(count == 0)
                        {
                            name = S;
                            S ="";
                        }
                        if(count==1)
                        {
                            ID = Integer.parseInt(S);
                            S = "";
                        }

                        if(count == 2)
                        {
                            category = S;
                            S ="";
                        }

                        count++;
                    }
                }
                Customer cus = new Customer(name,ID,category);
                myCompany.addCustomer(cus);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //LOAD RESERVATION
        try {
            FileReader reader = new FileReader("MyReservations.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int count = 0; 
                int ID = 0;
                String name = null;
                String category = null;
                int RN = 0;
                String model = null;
                int year = 0;
                String typefuel = null;
                String state=null;
                String pupLoc = null;
                int yearRes= 0;
                int monthRes = 0;
                int dayRes = 0;
                int period = 0;
                int minutes = 0;
                int hours = 0;
                int capacity =0;
                int resNum = 0;
                String S = "";
                for(int i = 0;i<line.length();i++)
                {

                    if(line.charAt(i)!=','){
                        S+=line.charAt(i);}
                    else
                    {
                        if(count == 0)
                        {
                            name = S;
                            S ="";
                        }
                        if(count==1)
                        {
                            ID = Integer.parseInt(S);
                            S = "";
                        }
                        if(count == 2)
                        {
                            category = S;
                            S ="";
                        }
                        if(count==3)
                        {
                            RN = Integer.parseInt(S);
                            S = "";
                        }
                        if(count == 4)
                        {
                            model = S;
                            S ="";
                        }
                        if(count == 5)
                        {
                            year = Integer.parseInt(S);
                            S ="";
                        }
                        if(count==6)
                        {
                            typefuel = S;
                            S ="";
                        }
                        if(count==7)
                        {
                            state = S;
                            S ="";
                        }
                        if(count == 8)
                        {
                            capacity = Integer.parseInt(S);
                            S = "";
                        }
                        if(count==9)
                        {
                            yearRes = Integer.parseInt(S);
                            S ="";
                        }
                        if(count==10)
                        {
                            monthRes = Integer.parseInt(S);
                            S ="";
                        }
                        if(count==11)
                        {
                            dayRes = Integer.parseInt(S);
                            S ="";
                        }
                        if(count == 12)
                        {
                            hours = Integer.parseInt(S);
                            S = "";
                        }
                        if(count ==13)
                        {
                            minutes = Integer.parseInt(S);
                            S = "";
                        }
                        if(count==14)
                        {
                            period = Integer.parseInt(S);
                            S = "";
                        }
                        if(count ==15)
                        {
                            pupLoc = S;
                            S ="";
                        }
                        if(count == 16)
                        {
                            resNum = Integer.parseInt(S);
                            S="";
                        }

                        count++;
                    }
                }
                Customer cus = new Customer(name,ID,category);
                Vehicle vec = new Vehicle(RN,model,year,typefuel,state);
                Date date = new Date();
                date.setYear(yearRes);
                date.setMonth(monthRes);
                date.setDate(dayRes);
                date.setHours(hours);
                date.setMinutes(minutes);

                Reservation res = new Reservation(vec,cus,date,period,pupLoc,resNum);
                myCompany.newRes(res);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return myCompany;
    }

    
}
