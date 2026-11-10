package TextBased_VG;

public class GameDriver 
{
    public static void main (String [] args)
    {
        //creates a game object to call its two method to set up the game
        Game virtuoso = new Game();
        virtuoso.setUpGame();
        virtuoso.gameLoop();
    }
    
}
