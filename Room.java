package TextBased_VG;


public class Room 
{
    private String description;
    //private int keys;
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
    public Room (String description, boolean hasTreasure, boolean hasEnemy, boolean isLocked)
    {
        this.description = description;
        this.hasTreasure = hasTreasure;
        this.hasEnemy = hasEnemy;
        this.isSearched = false;
        this.isLocked = isLocked;
        //this.keys = 1;
    }
    //changes the surrounding rooms' directions
    public void setNeighbors(Room s, Room e, Room w, Room n)
    {
        //mutator method
        north = n;
        south = s;
        west = w;
        east = e;
    }
    //sets the enemy of each room that has an enemy
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
    //checks whether the room has treasure
    public void search(Player p)
    {
        //put something in this
        if(isSearched==true)
        {
            System.out.println("You have already searched this room");
        }
        else
        {
            isSearched = true;
            if(hasTreasure==true)
            {
                System.out.println("[^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^]");
                System.out.println("You found a key!");
                p.addKeys(1);
                System.out.println("You now have " + p.getKeys() + " key(s).");
                System.out.println("[^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^]");
            }
            else
            {
                System.out.println("Sorry, there's no treasure");
            }
        }
    
    }

    //allows the user to enter a room so long as they have enough keys and/or the room is unlocked
    public void enterRoom(Player p)
    {
        if (isLocked == false) {
            System.out.println("You have already unlocked this room.");
            if(isSearched == true) {
                System.out.println("You have already searched this room.");
            }
        }

        if(isSearched == false)
        {
            if(p.getKeys()> 0)
            {
                System.out.println("You used a key to unlock a new room, so ");
                isLocked = false;
                p.minusKeys(1);
                
                System.out.println("you now have " + p.getKeys() + " keys");
            
            }
            else
            {
                System.out.println("Sorry, you don't have enough keys to enter that room");
                isLocked = true;
                isSearched = false;
            }
        }
      
    }

    //returns the description of the room
    public String getDescription()
    {
        return description;
    }
    //finds which room the user wants to go to that is the neighbor of the room they are in currently
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
            System.out.println("Your input is invalid. Please type in \"West\",\"East\",\"North\", or \"South\" only please if you are trying to enter a room!");
            return null;
        }
        
    }
    
    //returns the description of the enemy
    public Enemy getEnemy()
    {
        //accessor method
        return enemy;
    }
    //checks if a room has an enemy
    public boolean hasEnemy()
    {
        return hasEnemy;
    }
    //returns if the room is locked
    public boolean getIsLocked()
    {
        return isLocked;
    }
    //returns if the room has been searched
    public boolean getIsSearched() {
        return isSearched;
    }
    //sets the isLocked method to false, especially for the mainLobby since it should already be unlocked
    public void setIsLocked()
    {
        isLocked = false;
    }
    
}
