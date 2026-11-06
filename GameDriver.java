package TextBased_VG;

public class GameDriver 
{
    public static void main (String [] args)
    {
        Game virtuoso = new Game();
        virtuoso.setUpGame();
        virtuoso.gameLoop();
    }
    
}
