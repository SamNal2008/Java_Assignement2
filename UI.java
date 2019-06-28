
/**
 * Décrivez votre classe UI ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class UI
{
    public static void main(String[] args) 
    {
        System.out.println("Bienvenido en el cartel de la coche y de la vane");
        Vehicle vec1 = new Car(12345, "aveo" , 2016,  "diesel",7);
        Vehicle vec2 = new Car(12346, "mini" , 2014,  "gasual",5);
        Vehicle vec3 = new Car(12347, "picaso" , 2010,  "oil",5);
        Vehicle vec4 = new Van(12348, "combi" , 2004,  "gasual",250);
        vec1.display();
        vec2.display();
        vec3.display();
        vec4.display();

    }

    public static void display_separation(int n)
    {
        for (int i = 0; i < n;i++)
        {
            System.out.print("+---");
        }
        System.out.println("+");
    }

    public static void display(int tab[][])
    {
        for(int i = 0; i < tab.length; i++)
        {
            display_separation(tab[i].length);
            for (int j = 0; j < tab[i].length;j++)
            {
                System.out.format("|%2d ",tab[i][j]);
            }
            System.out.println("|");
        }
    }
}
