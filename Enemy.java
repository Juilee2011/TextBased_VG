package TextBased_VG;

public class Enemy 
{
    //declare variables
    private int health;
    private String description;

    //constructor
    public Enemy(int health, String description)
    {
        this.health = health;
        this.description = description;
    }
    //method to check how many health the player has (in other words, to check if they are alive)
    public boolean isAlive()
    {
        if(health>0)
        {
            return true;
        }
        else
        return false;
    }
    //removes health if the player decides not to fight the yeti
    public void takeDamage(int damage)
    {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }
    //this is the method that happens while the player fights
    public void attack(Player p)
    {
        int damage = 10;
        p.takeDamage(damage);
        System.out.println("You are being attacked! You have lost " + damage + " health");
    }
    //returns the description of the class
    public String getDescription()
    {
        return description;
    }
     
}
