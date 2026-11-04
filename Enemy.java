package TextBased_VG;

public class Enemy 
{
    private int health;
    private String description;

    public Enemy(int health, String description)
    {
        health= this.health;
        description= this.description;
    }

    public boolean isAlive()
    {
        if(health>0)
        {
            return true;
        }
        else
        return false;
    }

    public void takeDamage(int damage)
    {
        health= health-damage;
    }

    public void attack(Player p)
    {
        System.out.println("You are being attacked! You have lost 10 health");
    }

    public String getDescription()
    {
        return description;
    }
}
