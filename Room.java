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
    }
    public void setEnemy(Enemy e)
    {
        //mutator method
    }
    public void search()
    {
        //put something in this
    }
    public void enterRoom(Player p)
    {
        //something
    }
    public String getDescription()
    {
        return description;
    }
    public Room getNeighbor (String direction)
    {
        //some mutator method
    }
    public Enemy getEnemy()
    {
        //accessor method
    }
    public boolean hasEnemy()
    {
        //boolean
    }
    
}
