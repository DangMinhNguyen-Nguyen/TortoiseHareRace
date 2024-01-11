/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Random;
import java.lang.Thread;


/**
 *
 * @author nguyendangminhnguyen
 */
public class Race_App_Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        appStart();
        racing();
        
}
    
    /**
     * method to print the 3 beginning lines
     */
    public static void appStart(){
        System.out.println("ON YOUR WAY, GET SET");
        System.out.println("BANG !!!!!");
        System.out.println("AND THEY'RE OFF !!!!!");
    }
    
    /**
     * method to random a number from a range
     * @param min
     * @param max
     * @return 
     */
    public static int randNum(int min, int max){
        Random rand = new Random();
        int randNum = rand.nextInt((max - min) +1) + min ;
        return randNum;
    }
    
    /**
     * method to return number of move for the Tortoise base on the random number got
     * @return 
     */
    public static int resultMoveNumTor(){
        int ranNum = randNum(1,10);
        int resultMove = 0;
        
        if (ranNum < 6)
            {
            resultMove = 3; // fast plod
            
            }
        else if (ranNum < 8 )
        {
            resultMove = -6; // slip
            
        }
        else if (ranNum < 11 )
        {
            resultMove = 1; // slow plod
            
        }
        return resultMove;
    }
    
    /**
     * method to return number of move for the Hare base on the random number got
     * @return 
     */
    public static int resultMoveNumHar(){
        int ranNum = randNum(1,10);
        int resultMove = 0;
        
        if (ranNum < 1 || ranNum >10)
            {
            resultMove = -10; // error in random Method
            
            }
        else if (ranNum < 3)
            {
            resultMove = 0; // sleep
            
            }
        else if (ranNum < 5 )
        {
            resultMove = 9; // big hop
            
        }
        else if (ranNum < 6 ) 
        {
            resultMove = -12; // big slip
            
        }
        else if (ranNum < 9 ) 
        {
            resultMove = 1; // small hop
            
        }
        else if (ranNum < 11 ) 
        {
            resultMove = -2; // snall slip
            
        }
        return resultMove;
    }
    
    
    /**
     * return a final position number of the Tortoise in the array
     * @param pos
     * @return 
     */
    public static int posAfterTor( int pos){
        int moveNum = resultMoveNumTor();
        
        int finalPos = pos + moveNum;
        
        if(finalPos <= 0){
            finalPos = 0;
            return finalPos;
        }
        else if (finalPos < 69){
            return finalPos;
        }
        else{
            return finalPos;
        }
        
        
    }
    /**
     * return a final position number of the Hare in the array
     * @param pos
     * @return 
     */
    public static int posAfterHar( int pos) {
        int moveNum = resultMoveNumHar();
        
        int finalPos = pos + moveNum;
        if(finalPos <= 0){
            finalPos = 0;
        }
        else if (finalPos < 69){
            return finalPos;
        }
        return finalPos;
    }
    
    
    /**
     * racing logic method 
     */
    public static void racing(){
        int posTor, posHar, count;
        
        posTor = posHar = count = 0; // when the race start
        
        boolean isRacing = true;
        
        // the first time when the game start
        for( int i = 0 ; i <70; i++){
            if(i == 0){
                System.out.print("TH");
            }
            else {
                System.out.print("_");
            }
        }
        System.out.print("\n");
        
                
        // the loop until the game is finished
        try{
            while(isRacing){
                Thread.sleep(1000);

                posTor = posAfterTor(posTor); // Position of tortoise after random
                posHar = posAfterHar(posHar); // position of hare after random


                // Tortoise win situation
                if (posTor >= 69){
                    System.out.println("Tortoise Wins");
                    isRacing = false; // race end
                }
                // Hare win situation
                else if (posHar >=69){
                    System.out.println("Hare Wins");
                    isRacing = false; // race end
                }
                // A Tie situation
                else if (posTor >=69 && posHar >=69){
                    System.out.println("It is a draw");
                    isRacing = false; // race end
                }

                else {
                    // when there is still no winner
                    drawMap(posTor,posHar);
                }
          
                count ++;

            }
        }
        catch (InterruptedException e){
            System.out.println("There is interruption during sleep");
        }
        
        
        System.out.println("TIME ELAPSED = " + count + " seconds");
        
        
        
    
    }
    
    
    /**
     * method to display the racing map
     * @param torPos
     * @param harPos 
     */
    public static void drawMap( int torPos, int harPos){
        for( int i = 0 ; i <70; i++){
            
            // display OUCH!!! when Tortoise and Hare are in the same position
            if(i == torPos && i ==harPos){
                System.out.print("OUCH!!!");
            }
            // display T at Tortoise position
            else if (i == torPos){
                System.out.print("T");
            }
            // display H at Hare position
            else if (i == harPos){
                System.out.print("H");
            }
            //display the racing map by print out _
            else {
                System.out.print("_");
            }
        }
        System.out.print("\n");

    }
    
    
    
}
