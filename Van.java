
/**
 * Décrivez votre classe Car ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Van extends Vehicle
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int LoadCapacity; // Capacity in the Van  

    /**
     * Constructor for objects of class Vehicle
     */
    public Van()
    {
        super();
        this.LoadCapacity = 0;
    }
    
    public Van(int RN, String model , int year,  String fuel,int Capacity)
    {
        super(RN,model,year,fuel);
        this.LoadCapacity = Capacity;
    }
    
    public void setLCapacity(int Capacity) //set registration number
    {
        this.LoadCapacity = Capacity;
    }
    
    public int getLCapacity() //get registration number
    {
        return this.LoadCapacity;
    }
    
    public void display()
    {
        super.display();
        System.out.format("|%4d",this.LoadCapacity);
        System.out.println("|");       
    }
    
}
