package TextBased_VG;

public class Player {
    private int health;
    private Room currentRoom;
    private static int numKeys = 0;

    //creates a player object which 
    public Player(int health, Room currentRoom, int numKeys) {
        this.health = health;
        this.currentRoom = currentRoom;
        this.numKeys = numKeys;
    }

    //method that changes the number of keys that the user has
    public void addKeys(int keys) {
        numKeys++;
        numKeys = keys;
    }
    
    //a method to check to see if the user has any keys
    public boolean hasKey() {
        if(numKeys != 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void takeDamage(int health){
     health-=10;   
    }

    public void attack(Enemy e) {
        //accessor method from the enemy class
        e.takeDamage(10);
    }

    public void changeRooms(Room r) {
        this.currentRoom = r;
    }

    public int getKeys() {
        return numKeys;
    }

    public int getHealth() {
        return health;
    }

    public Room getRoom(){
         return this.currentRoom;
    }

}
