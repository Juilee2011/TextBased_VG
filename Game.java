package TextBased_VG;
import java.util.Scanner;

public class Game {

        Room mainLobby = new Room("This is the main lobby.", true, false);
        Room duelRoom = new Room("This is the final boss room.", true, true);
        Room diningHall = new Room("This is the dining hall.", true, false);
        Room library = new Room("This is the library.", true, true);
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
        String choice= "";
        
        

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

        mainLobby.setIsLocked();
        //currentRoom= mainLobby;
        //player1.getHealth();
        System.out.println("Welcome to Vituoso!");
        System.out.println("The objective of this game is to get keys in order to unlock new doors, battle monsters, and, finally, beat the boss-level monster.");
        System.out.println("Type in search to search rooms for any treasure (if you don't want to try this out, just type anything else to skip)");
        
            String choice = input.nextLine();
                if (choice.equals("search")) 
                {
                    System.out.println("You found a key!");
                    player1.addKeys(1);
                    System.out.println("You now have " + player1.getKeys() + " keys");
                    System.out.println("Congrats, you found a map! Would you like to pick it up? (yes or no): ");
                    choice= input.nextLine();
                    if(choice.equals("yes"))
                    {
                        System.out.println("_______________________________________________________________________");
                        System.out.println("MAP OF GAME:");
                        System.out.println("Main Lobby connects the Dining Room (west), the Ice Cave (south), and the Library (east).\nDining Room only has access to the Main Lobby (east). \nLibrary also only has access to the Main Lobby (west). \nThe Ice Cave connects the Main Lobby (north) and the Duel Stadium (south).\nThe Duel Stadium only can access to the Ice Cave (north).");
                        System.out.println("_______________________________________________________________________");
                    }
                    else
                    {
                        System.out.println("Have fun guessing your way around!");
                    }
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
                System.out.println("****************************************************************");
                System.out.println("Current Location: " + currentRoom.getDescription());
                System.out.println("Health: " + player1.getHealth());
                System.out.println("Keys: " + player1.getKeys());
                System.out.println("****************************************************************");
                
                System.out.println("Choose your next room (north, south, east, west), type quit to quit, or search to search the room");
                direction= input.nextLine();
            
            if(direction.equalsIgnoreCase("quit"))
            {
                //WE NEED TO CREDIT THIS LATER
                gameOver=true;
                break;
                //System.exit(0);
            }
            else if(direction.equalsIgnoreCase("search") ) {
                // currentRoom= player1.getRoom();
                     
                // if(currentRoom==null)
                // {
                //     System.out.println("Sorry, but since this room doesn't exist, that means that you can't search it for treasure!");
                // }
                // else
                // {
                     currentRoom.search(player1); 
                // }
            }
            
            else if(direction.equalsIgnoreCase("west") || direction.equalsIgnoreCase("east") || direction.equalsIgnoreCase("north") || direction.equalsIgnoreCase("south"))
            {
                nextRoom = currentRoom.getNeighbor(direction);    
                if(nextRoom == null) {
                    System.out.println("There is no room in that direction!");
                    //System.out.println("Please input a valid direction");
                    //direction= input.nextLine();
                    continue;
                }
                else{
                if(nextRoom.getIsLocked()) {
                    if (player1.getKeys()==0) {
                        System.out.println("You need a key to unlock this room!");
                    }
                    else
                    {
                        nextRoom.enterRoom(player1);
                        
                    }
                }
            
                else {
                    System.out.println("You have already unlocked this room.");
                }
            }
            

                player1.changeRooms(nextRoom);
                currentRoom = player1.getRoom();

                System.out.println("\nRoom Location: " + nextRoom.getDescription());

                if (currentRoom.getIsSearched()) {
                    System.out.println("You have already searched this room.");
                }
            }
            else
            {
                System.out.println("Invalid input! Please only type a direction, search, or quit as your input.");
                System.out.println("NOTE: if you are not choosing to quit, type whatever and the program will prompt you again (second time actually put a direction or search");
                direction= input.nextLine();
                if(direction.equalsIgnoreCase("quit"))
                {
                    break;
                }
                else
                {
                    continue;
                }
            }
           
    
            if (currentRoom.hasEnemy()==true) 
            {
                currentEnemy= currentRoom.getEnemy();
                if(currentEnemy.isAlive())
                {
                    System.out.println("****************************************************************");
                    System.out.println("There is an enemy in this room, be ready to fight!");
                    System.out.println("What you are facing "+currentEnemy.getDescription());
                    
                    //userChoice = input.nextLine();
                    while(currentEnemy.isAlive())
                    {
                        System.out.println("Do you want to attack? (yes or no): ");
                        userChoice= input.nextLine();
                        if(userChoice.equalsIgnoreCase("Yes")) 
                        {
                            player1.attack(currentRoom.getEnemy());

                            //int randomNum = (int)(Math.random()*2) + 0;
                            int possibleDamage = (int)(Math.random() * 41) + 1;

                    
                            player1.takeDamage(possibleDamage);
                    
                            System.out.println("You have recieved "+possibleDamage+" damage.");
                            System.out.println("NOTE: Your current health is "+player1.getHealth());
                        
                        }
                        else if (userChoice.equalsIgnoreCase("No")) {
                        player1.takeDamage(100);
                        System.out.println("You have chosen not to attack the enemy, so the enemy attacked you and you lost 100 health (AKA all your health).");
                        System.out.println("Unfortunately, you lost the game.");
                        System.out.println("****************************************************************");
                        break;
                    
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
                    }
                    if(player1.getHealth()>0)
                    {
                        System.out.println("Congrats! You defeated the enemy!");
                    }
                    System.out.println("****************************************************************");
                    
                
                }
                else if(!currentEnemy.isAlive() && !direction.equals("search"))
                {
                    System.out.println("The enemy in this room has been defeated.");
                    System.out.println();
                    System.out.println("Would you like to search this room for treasure? If yes, type search, and if no, type anything else to skip");
                    System.out.println();
                    userChoice= input.nextLine();
                    if(userChoice.equalsIgnoreCase("search"))
                    {
                        currentRoom.search(player1);
                    }
                }
            }
            else {
                
                    System.out.println("There is no enemy in this room");
                    System.out.println("Would you like to search this room for treasure? Type search if yes, otherwise type anything to skip");
                    userChoice= input.nextLine();
                    if(userChoice.equalsIgnoreCase("search"))
                    {
                        currentRoom.search(player1);
                        
                    }
                    
                
            }

            if(player1.getHealth()<=0)
            {
                System.out.println("GAME OVER! You ran out of health");
                gameOver = true;
                break;
            }
            else if(!goblin.isAlive())
            {
                System.out.println("Congratulations! You finished the game and defeated the final boss!");
                gameOver = true;
                break;
            }

            if(userChoice.equals("quit") || direction.equals("quit"))
            {
                gameOver=true;
                break;
            }

            
        
        
    }
    System.out.println("Thank you for playing!");
}
}


