package TextBased_VG;
import java.util.Scanner;

public class Room 
{
    private String description;
    private int keys;
    private boolean isSearched;
    private boolean hasTreasure;
    private boolean isLocked= true;
    private boolean hasEnemy;
    private Room north;
    private Room south;
    private Room west;
    private Room east;
    private Room farSouth;
    private String choice;
    private Enemy enemy;

    //methods and constructors
    public Room (String description, boolean hasTreasure, boolean hasEnemy)
    {
        this.description = description;
        this.hasTreasure = hasTreasure;
        this.hasEnemy = hasEnemy;
    }
    public void setNeighbors(Room s, Room e, Room w, Room n)
    {
        //mutator method
        north = n;
        south = s;
        west = w;
        east = e;
    }
    public void setEnemy(Enemy e)
    {
        this.enemy = e;
        if (e != null) {
            this.hasEnemy = true;
        }
        else {
            this.hasEnemy = false;
        }
    }
    public void search()
    {
        //put something in this
        System.out.println("You have "+ keys +" keys in your inventory");
    }
    public void enterRoom(Player p)
    {
        if(p.getKeys()!= 0)
        {
            System.out.println("You have unlocked another room");
        }
    }
    public String getDescription()
    {
        return description;
    }
    public Room getNeighbor(String direction)
    {
        if(direction.equalsIgnoreCase("West"))
        {
            // System.out.println("You have entered the Dining Hall. There is a bowl, a plate, and a treasure chest.");
            // Scanner input = new Scanner(System.in);
            // System.out.println("One of these objects has the key to enter the Ice Cave. Which one would you like to start with?");
            // choice = input.nextLine();

            // if (choice.equalsIgnoreCase("Bowl"))
            // {
            //     System.out.println("Congratulations! You found the key. Please type 'go inside' to get into the Ice Cave!");
                
            // }
            return west;
        }
        else if(direction.equalsIgnoreCase("East"))
        {
            return east;
        }
        else if(direction.equalsIgnoreCase("North"))
        {
            return north;
        }
        else if(direction.equalsIgnoreCase("South"))
        {
            return south;
        }
        // else if(direction.equals("Duel"))
        // {
        //     return duelStadium;
        // }
        
        else 
        {
            System.out.println("Your input is invalid. Please type in \"West\",\"East\",\"North\",\"South\",or \"Duel\" only please");
            return null;
        }
        
    }
    
    public Enemy getEnemy()
    {
        //accessor method
        return enemy;
    }
    public boolean hasEnemy()
    {
        return hasEnemy;
    }
    
}
