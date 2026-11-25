import GamePackage.*;
import PlayerPackage.*;

import java.util.*;

public class Main {
    static public void displayMenu(){
        System.out.println("==== Game Menu ====");
        System.out.println("1) Make a Wish");
        System.out.println("2) No Mistakes");
        System.out.println("3) Take Chances (3 lives)");
        System.out.println("4) Time Trial");
        System.out.println("Choose a mode: ");
    }
    
    static public int getMode(Scanner input){
        int inMode = input.nextInt();
        return inMode;
    }
    
    static public int getPlayerNum(Scanner input){
        input.nextLine();
        
        System.out.println("How Many Players? ");
        int playerNum = input.nextInt();
        return playerNum;
    }

    static public void displayLeaderboard(Player[] playerArr){
        System.out.println("\n-- Leaderboard (Scory only) --");

        for(Player p: playerArr){
            System.out.println(p.userName + " : " + p.score);
        }
    }
    
    public static void main(String[] args) {
        Game ob = new Game();
        Scanner input = new Scanner(System.in);

        displayMenu();
        int mode = getMode(input);
        int playerNum = getPlayerNum(input);

        int maxTime = 0;
        int numQ = 0;

        Player[] p = new Player[playerNum];

            switch(mode){
                case 1: numQ = ob.getQuestionNum(); break;
                case 2: break;
                case 3: break;
                case 4: maxTime = ob.getTimeLimit(); break;
            }

        int i = 0;
        while(i < playerNum){
            System.out.println("\nEnter player " + (i+1) + " name: ");
            p[i] = new Player(i+1);

            switch(mode){
                case 1 -> ob.makeAWish(p[i], numQ); 
                case 2 -> ob.noMistakes(p[i]); 
                case 3 -> ob.takeChances(p[i]); 
                case 4 -> ob.timeTrial(p[i] ,maxTime);
            }
            i++;
        }

        Arrays.sort(p, (p1, p2) -> {
            if(p1.score.equals(p2.score)) return Integer.compare(p1.pNum, p2.pNum);

            return Integer.compare(p2.score, p1.score);
        });

        displayLeaderboard(p);

    }
}
