/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Random;
import java.util.Arrays;


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
        
        
        int[] racePos = new int[70];
        //System.out.println(racePos[0]);
        
        
        racePos[0] = 4;
        //System.out.println(racePos[0]);
        
        
        racing(racePos);
        
//        showRacingProgress(racePos);
//        System.out.print("Testing if a new line");
//        int[] arr = new int[] {3, 5, 1, 4, 2};
//        
//        int testIndex = indexOf(arr,4);
//        System.out.println(testIndex);
//        
//        int testRandomNum= randNum(1,10);
//        System.out.println(testRandomNum);
//        System.out.println(raceArr.length);
//        System.out.println(raceArr[1]);
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
     * method to return move of the Tortoise base on the random number got
     * @return 
     */
    public static int resultMoveNumTor(){
        int ranNum = randNum(1,10);
        int resultMove = 0;
        
        if (ranNum < 1 || ranNum >10)
            {
            resultMove = -10; // error in random Method
            
            }
        else if (ranNum < 6)
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
     * method to return move of the Hare base on the random number got
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
     * return a final index number of the Tortoise in the array
     * @param index
     * @return 
     */
    public static int indexAfterTor( int index){
        int moveNum = resultMoveNumTor();
        
        int finalIndex = index + moveNum;
        
        if(finalIndex <= 0){
            return 0;
        }
        else if (finalIndex < 69){
            return finalIndex;
        }
        else{
            return 100;
        }
        
        
    }
    /**
     * return a final index number of the Hare in the array
     * @param index
     * @return 
     */
    public static int indexAfterHar( int index) {
        int moveNum = resultMoveNumHar();
        
        int finalIndex = index + moveNum;
        if(finalIndex <= 0){
            return 0;
        }
        else if (finalIndex < 69){
            return finalIndex;
        }
        else{
            return 101;
        }
        
    }
    
    /**
     * return the index position of the number in the array
     * @param arr
     * @param searchValue
     * @return 
     */
    public static int indexOf( int[] arr, int searchValue){
        
        for (int i = 0; i < arr.length;i++){
            if (arr[i] != 0 && arr[i] == searchValue)
                return i;
        }
        return -1;
    }
    
    /**
     * racing logic method
     * @param arr 
     */
    public static void racing(int [] arr){
        int indexTor, indexHar, count;
        
        indexTor = indexHar = count = 0; // when the race start
        
        boolean condition = true;
        
        // the first time when the game start
        showRacingProgress(arr);
        arr[0]=3;
        count ++;
                
        
        // the loop until the game is finished
        while(condition){
            int oldIndexTor = indexTor;
            int oldIndexHar = indexHar;
            
            // searching for index position of 1:Tor and 2: Hare
            indexTor = indexOf(arr,1);
            indexHar = indexOf(arr,2);
            
            // searching for T and H position when there is no 1 and 2 in array
            if (indexTor == -1 || indexHar == -1){
                indexTor = indexOf(arr,3);
                indexHar = indexOf(arr,3);
            }
            
            
            indexTor = indexAfterTor(indexTor); // index of tor after random
            indexHar = indexAfterHar(indexHar); // index of hare after random
            
            
            
            // Tortoise win only
            if (indexTor == 101){
                System.out.println("Tortoise Wins");
                condition = false;
            }
            // Hare win only
            else if (indexHar == 101){
                System.out.println("Hare Wins");
                condition = false;
            }
            // Draw
            else if (indexTor == 101 && indexHar == 101){
                System.out.println("It is a draw");
                condition = false;
            }
            // Still in the race and Tor and Hare in the same location
            else if (indexTor != 101 && indexTor == indexHar){
                
                arr[indexTor] = 3;
                arr[oldIndexTor] = 0;
                arr[oldIndexHar] = 0;
                showRacingProgress(arr);
            }
            else{
                arr[indexTor] = 1;
                arr[indexHar] = 2;
                arr[oldIndexTor] = 0;
                arr[oldIndexHar] = 0;
                showRacingProgress(arr);
                
            }
//            
            count ++;
            
        }
        
        
        System.out.println(count);
        
        
        
    
    }
    
    /**
     * method to map the number in arrays with String value
     * @param arr
     * @param i
     * @return 
     */
    public static String convertResult(int[] arr, int i){
        switch (arr[i]){
            case 0 -> {return " ";}
            case 1 -> {return "T";}
            case 2 -> {return "H";}
            case 3 -> {return "Ouch";}
            case 4 -> {return "TH";}
            default -> {return "Unexpected input";}
        }
        
    }
    /**
     * method to print out the result inform of the text,
     * @param arr 
     */
    public static void showRacingProgress( int[] arr){
        for( int i = 0 ; i <arr.length; i++){
            String afterConvert = convertResult(arr, i);
            System.out.print(afterConvert);
            
        }
        System.out.print("\n");

    }
    
    
    
}
