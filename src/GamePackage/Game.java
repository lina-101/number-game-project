package GamePackage;

import PlayerPackage.*;
import java.util.Scanner;


public class Game {
    
    Scanner input = new Scanner(System.in);
        
    int num1;
    int num2;
    int userAnswer;
    double doubleAnswer;

    public void displaySummary(Player p){
        System.out.println("\n-- Results --");
        System.out.println("Score: "+ p.score);
        System.out.println("\nSummary:"+ p.summary);
    }
    
    public void generateAddQuestion(Player p){
        num1 = (int)(Math.random() * 20) ; //num1: 0  to 19
        num2 = (int)(Math.random() * 20) ; 
        
        System.out.println("What is " + num1 + " + " + num2 + "?"); 
        
        userAnswer = input.nextInt();
        
        int actualAnswer = num1 + num2;
        if(actualAnswer == userAnswer){
            p.score++;
        }
        p.summary +="\n"+ num1+" + " + num2 + " = "+ userAnswer + " : "+ (actualAnswer == userAnswer);        
    }

    public void generateSubQuestion(Player p){
        num1 = (int)(Math.random()*20);
        num2 = (int)(Math.random()*20);

        if(num1 < num2){
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        System.out.println("What is " + num1 + " - " + num2 + "?"); 
        userAnswer = input.nextInt();
        
        int actualAnswer = num1 - num2;
        if(actualAnswer == userAnswer){
            p.score++;
        }
        
        p.summary +="\n"+ num1+" - " + num2 + " = " + userAnswer + " : " + (actualAnswer == userAnswer);
    }

    public void generateMulQuestion(Player p){
        num1 = (int)(Math.random()*20);
        num2 = (int)(Math.random()*20);

        System.out.println("What is "+num1+" * "+num2+"?"); 
        
        userAnswer = input.nextInt();
        
        int actualAnswer = num1 * num2;
        if(actualAnswer == userAnswer){
            p.score++;
        }
        
        p.summary +="\n"+ num1+" * "+num2+" = "+userAnswer+ " : "+(actualAnswer == userAnswer);
    }

    public void generateDivQuestion(Player p){
        num1 = (int)(Math.random()*20);
        num2 = (int)(Math.random()*9) + 1;

        System.out.println("What is "+num1+" / "+num2+"?"); 
        doubleAnswer = input.nextDouble();
        
        double actualAnswer = (double) num1 / num2;
        if(Math.abs(actualAnswer - doubleAnswer) <= 0.01){
            p.score++;
        }
        
        p.summary +="\n"+ num1+" / "+num2+" = "+doubleAnswer+ " : "+(Math.abs(actualAnswer - doubleAnswer) <= 0.01);
    }

    public void genRandomQuestion(Player p){
        int num = (int)(Math.random()*4);
        switch(num){
            case 0:
                generateAddQuestion(p);
                break;
            case 1:
                generateSubQuestion(p);
                break;
            case 2:
                generateMulQuestion(p);
                break;
            case 3:
                generateDivQuestion(p);
                break;
        }

    }

    Long endTime;
    Long startTime;
    Long totalTime;

    public int getQuestionNum(){
        System.out.println("How many Questions? ");
        int numQ = input.nextInt();

        return numQ;
    }
 
    public void makeAWish(Player p, int numQ){

        startTime = System.currentTimeMillis(); 
        for(int i = 0; i<numQ; i++){
            genRandomQuestion(p);
        }
        endTime = System.currentTimeMillis();
        totalTime = (endTime-startTime)/1000;

        System.out.println("\nYou have taken : "+totalTime+" seconds");
        displaySummary(p);
    }

    public void noMistakes(Player p){
        startTime = System.currentTimeMillis();

        for(int i = 0; i == p.score; i++){
            genRandomQuestion(p);
        }

        endTime = System.currentTimeMillis(); 
        totalTime = (endTime-startTime)/1000;
        
        System.out.println("-- Results --");
        System.out.println("Time Taken: " + totalTime + " seconds");
        System.out.println("Score: " + p.score);
    }

    public void takeChances(Player p){
        int lives = 3;
        int numQ = 0;
        while(lives > 0){

            System.out.println("[Lives " + lives + "]");
            genRandomQuestion(p);
            numQ++;

            if(numQ>p.score){
                lives--;
                numQ = p.score;
            }
        }

        System.out.println("Lives exhausted!\n");
        displaySummary(p);
    }

    public int getTimeLimit(){
        int maxTime;
        System.out.println("Enter time limit (seconds): ");
        maxTime = input.nextInt();

        return maxTime;
    }

    public void timeTrial(Player p, int maxTime){

        Long start = System.currentTimeMillis();

        int questionsAnswered = 0;
        while(System.currentTimeMillis() < start + maxTime*1000){
            genRandomQuestion(p);
            questionsAnswered++;
        }
        
        System.out.println("Time's Up!");
        System.out.println("\n-- Results --");
        System.out.println("Questions Answered: " + questionsAnswered);
        System.out.println("Score: "+ p.score);
        System.out.println("\nSummary:"+ p.summary);        
    }
}