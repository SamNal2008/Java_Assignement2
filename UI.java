
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
int t22[][] = {{1,2,3},
               {4,5,6},
               {7,8,9}};
display(t22);
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
