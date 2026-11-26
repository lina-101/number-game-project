package PlayerPackage;

import java.util.*;

public class Player {
    public Integer pNum = 0; //player number, preserves the order of play
    public String userName;
    public Integer score;
    public String summary;
    
    Scanner input = new Scanner(System.in);

    public Player(Integer playerNum){
        pNum = playerNum;
        userName = getPlayerName();
        score = 0;
        summary = "";
    }

    public String getPlayerName(){
        userName = input.nextLine();
        return userName;
    }
}
