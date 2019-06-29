
/**
 * Décrivez votre classe Car ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Car extends Vehicle
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int EngineCapacity; // number of place in the car 

    /**
     * Constructor for objects of class Vehicle
     */
    public Car()
    {
        super();
        this.EngineCapacity = 0;
    }
    
    public Car(int RN, String model , int year,  String fuel,String repair,int Capacity)
    {
        super(RN,model,year,fuel,repair);
        this.EngineCapacity = Capacity;
    }
    
    public void setECapacity(int Capacity) //set registration number
    {
        this.EngineCapacity = Capacity;
    }
    
    public int getRN() //get registration number
    {
        return this.EngineCapacity;
    }
    
    public void display()
    {
        super.display();
        System.out.format("|%4d",this.EngineCapacity);
        System.out.print("|");       
    }
}
