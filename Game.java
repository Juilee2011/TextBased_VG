package TextBased_VG;
import java.util.Scanner;

public class Game {
    private String roomInfo;
    public void setUpGame(){
        System.out.println("Welcome to Vituoso!");
        Room mainRoom = new Room ("This is the main lobby.", true, false);
        Room southRoom = new Room("This is the final boss room.", true, true);
        Room westRoom = new Room("This is the Dinning hall.", true, false);
        Room eastRoom = new Room("This is the dining hall.", true, true);
        Room northRoom = new Room("This is the Ice Cave", true, false);
        Player player1 = new Player(100, mainRoom, 0);
        
        System.out.println("Your three directions that you can choose from are south, west, and east: ");
        Scanner input = new Scanner(System.in);
        roomInfo = input.nextLine();
        
        if (roomInfo.equals("south")) {
            
        }
        else if (roomInfo.equals("west")) {

        }
        else {
            
        }
        
    }
    public void gameLoop() {
        boolean gameOver = false;
        while (!gameOver);
        {
            
        }
    }

}
