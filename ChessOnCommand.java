import java.io.IOException;
import java.util.Scanner;

public class ChessOnCommand {
    public static void main (String []args ) throws InterruptedException{

        //control variables
        int menuState = 0;

        //the board represented with a two dimensional string array
        String chessboard[][];

        Scanner input = new Scanner(System.in);

        ClearConsole();
        TitlePrint();


        System.out.println("1. Play\n");
        System.out.println("2. Help\n");
        System.out.println("3. Exit\n");
        
        while(menuState == 0){

            switch(intInput()) { 
                case 1: 
                    ClearConsole();
                    break; 
                case 2: 
                    ClearConsole();
                    //slap the rules in here
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("\n Enter to continue");
                    break; 
                case 3: 
                    ClearConsole();
                    System.out.println( "Goodbye world");
                    Thread.sleep(5000);
                    System.exit(0);
                    break; 
    
            }
        }
        
        input.close();
    }//end of main
    
//here be functions
    
    public static void ClearConsole() {

        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {
        }
    }

    public static void TitlePrint(){

        System.out.println("_________  .__");
        System.out.println("\\_   ___ \\ |  |__    ____    ______  ______    ____    ____");
        System.out.println("/    \\  \\/ |  |  \\ _/ __ \\  /  ___/ /  ___/   /  _ \\  /    \\");
        System.out.println("\\     \\____|   Y  \\  ___/   \\___ \\  \\___ \\   (  <_> )|   |  \\");
        System.out.println(" \\______  /|___|  / \\___  >/____  >/____  >   \\____/ |___|\n");
        System.out.println("                                                      .___");
        System.out.println("  ____    ____    _____    _____  _____     ____    __| _/");
        System.out.println("_/ ___\\  /  _ \\  /     \\  /     \\ \\__  \\   /    \\  / __ | ");
        System.out.println("\\  \\___ (  <_> )|  Y Y  \\|  Y Y  \\ / __ \\_|   |  \\/ /_/ | ");
        System.out.println(" \\___  > \\____/ |__|_|  /|__|_|  /(____  /|___|  /\\____ | ");
        System.out.println("     \\/               \\/       \\/      \\/      \\/      \\/ ");
    }    

    static int intInput(){
        //Takes input and checks if integer
        //if not informs user and tries again
        Scanner input = new Scanner(System.in);
        int tempControl = 0;
        Integer processedInput = 0;
        

        while(tempControl == 0){

            System.out.print(":");

            if(input.hasNextLine()){

                String rawInput = input.nextLine();

                try {

                    processedInput = Integer.parseInt(rawInput);
                    tempControl = 1;

                } catch (NumberFormatException e) {

                    System.out.println("Input must be an integer");

                }

            } else {

                tempControl = 1;

            }
        }

        input.close();
        return processedInput;

    }

}//end of program