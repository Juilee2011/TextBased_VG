package TextBased_VG;
import java.util.Scanner;

public class Game {

        Room mainLobby = new Room("This is the main lobby.", true, false);
        Room duelRoom = new Room("This is the final boss room.", true, true);
        Room diningHall = new Room("This is the Dinning hall.", true, false);
        Room library = new Room("This is the dining hall.", true, true);
        Room iceCave = new Room("This is the Ice Cave", true, true);
        Player player1 = new Player(100, mainLobby, 0);
        Enemy iceYeti = new Enemy(50, "This is an Ice Yeti");
        Enemy fireMonster = new Enemy(50, "This is a Fire Monster");
        Enemy goblin = new Enemy(100, "This is the final boss");

        Scanner input = new Scanner(System.in);

    public void setUpGame(){
        System.out.println("Welcome to Vituoso!");
        System.out.println("The objective of this game is to get keys in order to unlock new doors, battle monsters, and, finally, beat the boss-level monster.");
        System.out.println("Your starting position is in the main lobby. Your three directions that you can choose from are (south), west, and east: ");
        
        String direction = input.nextLine();
        Room nextRoom = player1.getRoom().getNeighbor(direction);

        if (nextRoom != null) {
            player1.changeRooms(nextRoom);
            System.out.println(nextRoom.getDescription());
            // if(nextRoom.equalsIgnoreCase("west")) {
            //     player1.getRoom().getNeighbor("West");
            // }
            // else if (nextRoom.equalsIgnoreCase("east")) {
            //     player1.getRoom().getNeighbor("East");
            // }
            // else if (nextRoom.equalsIgnoreCase("south")) {
            //     player1.getRoom().getNeighbor("South");
            // }
            // else if (nextRoom.equalsIgnoreCase("north")) {
            //     player1.getRoom().getNeighbor("North");
            // }
            // else {
            //     System.out.println("That direction is invalid.");
            // }
        }
        else {
            System.out.println("You can not go that direction because there is no room");
        }
        library.setNeighbors(null, null, mainLobby, null);
        mainLobby.setNeighbors(iceCave, library, diningHall, null);
        diningHall.setNeighbors(null, mainLobby, null, null);
        iceCave.setNeighbors(duelRoom, null, null, mainLobby);
        duelRoom.setNeighbors(null, null, null, iceCave);


        mainLobby.setEnemy(null);
        diningHall.setEnemy(iceYeti);
        iceCave.setEnemy(fireMonster);
        duelRoom.setEnemy(goblin);
        library.setEnemy(null);
        
    }
    public void gameLoop() {
        boolean gameOver = false;
        while (!gameOver);
        {
            Room currentRoom = player1.getRoom();
            System.out.println(currentRoom.getDescription());
    
            if (currentRoom.hasEnemy()) {
                System.out.println("There is an enemy in this room, be ready to fight!");
                System.out.println("Do you want to attack? (Yes or no): ");
                String userChoice = input.nextLine();
                if(userChoice.equalsIgnoreCase("Yes")) {
                    player1.attack(currentRoom.getEnemy());
                    int randomNum = (int)(Math.random()*2) + 1;
                    int possibleDamage = (int)Math.random() * 10;

                    if(randomNum == 1) {
                        player1.takeDamage(possibleDamage);
                    }
                    System.out.println("You have successfully attacked the enemy!");
                }
                else if (userChoice.equalsIgnoreCase("No")) {
                    player1.takeDamage(10);
                    System.out.println("You have choosen not to attack the enemy, so the enemy attacked you and you lost 10 health.");
                }
            }
            else {
                System.out.println("There is not an enemy in this room");
            }

            if(player1.getHealth()<=0)
            {
                gameOver = true;
            }
            else{
                gameOver = false;
            }


        }
    }

}
