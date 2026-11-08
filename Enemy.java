package TextBased_VG;

public class Enemy 
{
    private int health;
    private String description;

    public Enemy(int health, String description)
    {
        this.health = health;
        this.description = description;
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
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void attack(Player p)
    {
        int damage = 10;
        p.takeDamage(damage);
        System.out.println("You are being attacked! You have lost " + damage + " health");
    }

    public String getDescription()
    {
        return description;
    }
     
}
