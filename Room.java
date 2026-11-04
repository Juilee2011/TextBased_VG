package TextBased_VG;

public class Room 
{
    private String description;
    private int keys;
    private boolean isSearched;
    private boolean hasTreasure;
    private boolean isLocked;
    private boolean hasEnemy;
    private Room northRoom;
    private Room southRoom;
    private Room westRoom;
    private Room eastRoom;

    //methods and constructors
    public Room (String description, boolean hasTreasure, boolean hasEnemy)
    {
        this.description = description;
        this.hasTreasure = hasTreasure;
        this.hasEnemy = hasEnemy;
    }
    public void setNeighbors(Room n, Room s, Room e, Room w)
    {
        //mutator method
        northRoom= n;
        southRoom= s;
        westRoom= w;
        eastRoom= e;
    }
    public void setEnemy(Enemy e)
    {
        //mutator method

    }
    public void search()
    {
        //put something in this
        System.out.println("You have "+keys+" keys in your inventory");
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
        //some mutator method
        if(direction.equals("West"))
        {
            
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
