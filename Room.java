package TextBased_VG;
import java.util.Scanner;

public class Room 
{
    private String description;
    private int keys;
    private boolean isSearched;
    private boolean hasTreasure;
    private boolean isLocked;
    private boolean hasEnemy;
    private Room mainLobby;
    private Room iceCave;
    private Room diningHall;
    private Room library;
    private Room duelStadium;
    private String choice;

    //methods and constructors
    public Room (String description, boolean hasTreasure, boolean hasEnemy)
    {
        this.description = description;
        this.hasTreasure = hasTreasure;
        this.hasEnemy = hasEnemy;
    }
    public void setNeighbors(Room duel, Room s, Room e, Room w, Room main)
    {
        //mutator method
        mainLobby = main;
        iceCave = s;
        diningHall = w;
        library = e;
        duelStadium = duel;
    }
    public void setEnemy(Enemy e)
    {
        //mutator method

    }
    public void search()
    {
        //put something in this
        System.out.println("You have "+ keys +" keys in your inventory");
    }
    public void enterRoom(Player p)
    {
        //something
        if(p.getKeys()!= 0)
        {
            System.out.println("You have unlocked another room");
        }
    }
    public String getDescription()
    {
        return description;
    }
    public Room getNeighbor (String direction)
    {
        if(direction.equals("West"))
        {
            System.out.println("You have entered the Dining Hall. There is a bowl, a plate, and a treasure chest.");
            Scanner input = new Scanner(System.in);
            System.out.println("One of these objects has the key to enter the Ice Cave. Which one would you like to start with?");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("Bowl"))
            {
                System.out.println("Congratulations! You found the key. Please type 'go inside' to get into the Ice Cave!");
                
            }
        }
        
    }
    public Enemy getEnemy()
    {
        //accessor method
    }
    public boolean hasEnemy()
    {
        return hasEnemy;
    }
    
}
