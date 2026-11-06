package TextBased_VG;


public class Room 
{
    private String description;
    private int keys;
    private boolean isSearched;
    private boolean hasTreasure;
    private boolean isLocked;
    private boolean hasEnemy;
    private Room north;
    private Room south;
    private Room west;
    private Room east;
    //private String choice;
    private Enemy enemy;

    //methods and constructors
    public Room (String description, boolean hasTreasure, boolean hasEnemy)
    {
        description= this.description;
        hasTreasure= this.hasTreasure;
        hasEnemy= this.hasEnemy;
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
            keys--;
            isLocked= false;
        }
        else
        {
            System.out.println("Sorry, you don't have enough keys to enter");
            isLocked= true;
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
