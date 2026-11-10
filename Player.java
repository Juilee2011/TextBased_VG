package TextBased_VG;

public class Player 
{
    //declare variables
    private int health;
    public Room currentRoom;
    private int numKeys = 0;

    //constructor 
    public Player(int health, Room currentRoom, int numKeys) {
        this.health = health;
        this.currentRoom = currentRoom;
        this.numKeys = numKeys;
    }

    //method that changes the number of keys that the user has
    public void addKeys(int keys) {
        numKeys++;
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

    //when called, substracts from user's health
    public void takeDamage(int damage){
     this.health = this.health - damage;

    }

    //attacks enemy and takes away their health
    public void attack(Enemy e) {
        //accessor method from the enemy class
      
        e.takeDamage(50);
    }

    //switches the location the user is in
    public void changeRooms(Room r) {
        this.currentRoom = r;
    }

    //accessor method returning the number of keys the user has
    public int getKeys() {
        return numKeys;
    }

    //accessor method for checking player's health
    public int getHealth() {
        return this.health;
    }

    //returns the room that the user is currently in
    public Room getRoom(){
         return this.currentRoom;
    }

}
