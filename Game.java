package TextBased_VG;
import java.util.Scanner;

public class Game {

        Room mainLobby = new Room("This is the main lobby.", true, false);
        Room duelRoom = new Room("This is the final boss room.", true, true);
        Room diningHall = new Room("This is the Dinning hall.", true, false);
        Room library = new Room("This is the dining hall.", true, true);
        Room iceCave = new Room("This is the Ice Cave", true, true);
        
        Player player1 = new Player(100, mainLobby, 0);
        Enemy iceYeti = new Enemy(50, "is an Ice Yeti");
        Enemy fireMonster = new Enemy(50, "is a Fire Monster");
        Enemy goblin = new Enemy(100, "is the final boss");

        Scanner input = new Scanner(System.in);
        String direction = "";
        Room nextRoom;
        Room currentRoom;
        String userChoice = "";
        Enemy currentEnemy;
        

    public void setUpGame(){
        //directions: south, east, west, north
        library.setNeighbors(null, null, mainLobby, null);
        mainLobby.setNeighbors(iceCave, library, diningHall, null);
        diningHall.setNeighbors(null, mainLobby, null, null);
        iceCave.setNeighbors(duelRoom, null, null, mainLobby);
        duelRoom.setNeighbors(null, null, null, iceCave);

        mainLobby.setEnemy(null);
        diningHall.setEnemy(null);
        iceCave.setEnemy(iceYeti);
        duelRoom.setEnemy(goblin);
        library.setEnemy(fireMonster);

        System.out.println("Welcome to Vituoso!");
        System.out.println("The objective of this game is to get keys in order to unlock new doors, battle monsters, and, finally, beat the boss-level monster.");
        System.out.println("You have a map in your inventory, do you want to use it? (yes or no): ");
            String mapChoice = input.nextLine();
                if (mapChoice.equals("yes")) {
                    System.out.println("_______________________________________________________________________");
                    System.out.println("MAP OF GAME:");
                    System.out.println("Main Lobby connects the Dining Room (west), the Ice Cave (south), and the Library (east).\nDining Room only has access to the Main Lobby (east). \nLibrary also only has access to the Main Lobby (west). \nThe Ice Cave connects the Main Lobby (north) and the Duel Stadium (south).\nThe Duel Stadium only can access to the Ice Cave (north).");
                    System.out.println("_______________________________________________________________________");
                }
            
                
        // System.out.println("Your starting position is in the main lobby. Your three directions that you can choose from are south, west, and east: ");
        
        //direction = input.nextLine();
        //Room nextRoom = player1.getRoom().getNeighbor(direction);

        
        
        
    }
    public void gameLoop() {
        boolean gameOver = false;
        while (!gameOver)
        {

            //if(direction.equalsIgnoreCase("west")||direction.equalsIgnoreCase("east")|| direction.equalsIgnoreCase("south")||direction.equalsIgnoreCase("north"))
            //{
                //IDK WHAT'S HAPPENING HERE, I JS MOVED RANDOM STUFF AHOEHOIFEJFEOEJO
                
                currentRoom = player1.getRoom();
                System.out.println("Current Location: " + currentRoom.getDescription());
                System.out.println("Choose your next room (north, south, east, west): ");

                 direction= input.nextLine();
            
            if(direction.equalsIgnoreCase("quit"))
            {
                //WE NEED TO CREDIT THIS LATER
                gameOver=true;
                break;
                //System.exit(0);
            }
            
                //direction = input.nextLine();
                nextRoom = currentRoom.getNeighbor(direction);
                

                if(nextRoom != null) {
                    player1.changeRooms(nextRoom);
                    currentRoom= player1.getRoom();
                }
                else {
                    System.out.println("There is no room to go into so you will stay in the same room");
                    continue;
                }
            
    
            if (currentRoom.hasEnemy() && currentRoom.getEnemy().isAlive()) {
                currentEnemy= currentRoom.getEnemy();
                System.out.println("There is an enemy in this room, be ready to fight!");
                System.out.println("What you are facing "+currentEnemy.getDescription());
                System.out.println("Do you want to attack? (yes or no): ");
                //userChoice = input.nextLine();
                while(currentEnemy.isAlive())
                {
                    userChoice= input.nextLine();
                    if(userChoice.equalsIgnoreCase("Yes")) {
                    player1.attack(currentRoom.getEnemy());

                    int randomNum = (int)(Math.random()*2) + 0;
                    int possibleDamage = (int)(Math.random() * 10) + 1;

                    if(randomNum == 1) {
                        player1.takeDamage(possibleDamage);
                    }
                    System.out.println("You have successfully attacked the enemy!");
                    System.out.println("You have recieved "+possibleDamage+" damage.");
                    }
                    else if (userChoice.equalsIgnoreCase("No")) {
                    player1.takeDamage(10);
                    System.out.println("You have choosen not to attack the enemy, so the enemy attacked you and you lost 10 health.");
                    
                    }
                    else if(userChoice.equalsIgnoreCase("quit"))
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Sorry, but your input was invalid. Please type in yes or no.");
                        userChoice= input.nextLine();
                    }
                    
                   
                    //    System.out.println("You have defeated the enemy! Congrats!");
                    //    System.out.println("You have won another key!");
                    //    player1.addKeys(1);
                    //    System.out.println("You now have "+player1.getKeys()+" keys");
                       
                    
                
                }
            }
            else {
                System.out.println("There is not an enemy in this room");
            }

            if(player1.getHealth()<=0)
            {
                System.out.println("GAME OVER! You ran out of health");
                gameOver = true;
            }
            else if(!goblin.isAlive())
            {
                System.out.println("Congratulations! You finished the game and defeated the final boss!");
                gameOver = true;
            }

            if(userChoice.equals("quit") || direction.equals("quit"))
            {
                gameOver=true;
            }
            
        }
        System.out.println("Thank you for playing!");
    }

}
