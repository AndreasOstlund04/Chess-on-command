import java.io.IOException;
import java.util.Scanner;

//Todo
//Long algebraic chess notation
//K for king, Q for queen, R for rook, B for bishop, N for knight, empty space for pawn

public class ChessOnCommand {

    //the board represented with a two dimensional string array
    static String[][]chessboard = new String[8][8];

    public static void main (String []args ) throws InterruptedException{

        //control variables
        int menuState = 0;
        int currentTurn = 0;

        //settings
        int verticalBorderSize = 8;
        int horizontalBorderSize = 16;

        Scanner input = new Scanner(System.in);

        ClearConsole();
        verticalBorderPrint(verticalBorderSize);
        TitlePrint(horizontalBorderSize);
        System.out.println();
        System.out.println();
        horizontalBorderPrint(horizontalBorderSize);
        System.out.println("                           1. Play");
        System.out.println();
        horizontalBorderPrint(horizontalBorderSize);
        System.out.println("                           2. Help");
        System.out.println();
        horizontalBorderPrint(horizontalBorderSize);
        System.out.println("                           3. Exit\n");
        
        while(menuState == 0){

            switch(intInput()) { 
                case 1: 
                    ClearConsole();
                    resetBoard();
                    printBoard(horizontalBorderSize, verticalBorderSize);
                break; 
                case 2: 
                    ClearConsole();
                    //slap the rules in here
                    System.out.println("");
                    System.out.println("\n Enter to continue");
                break; 
                case 3: 
                    ClearConsole();
                    System.out.println( "Goodbye world");
                    Thread.sleep(4000);
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

    public static void TitlePrint(int horizontalBorderSize){

        horizontalBorderPrint(horizontalBorderSize);
        System.out.println("_________  .__");
        horizontalBorderPrint(horizontalBorderSize);
        System.out.println("\\_   ___ \\ |  |__    ____    ______  ______    ____    ____");
        horizontalBorderPrint(horizontalBorderSize);
        System.out.println("/    \\  \\/ |  |  \\ _/ __ \\  /  ___/ /  ___/   /  _ \\  /    \\");
        horizontalBorderPrint(horizontalBorderSize);
        System.out.println("\\     \\____|   Y  \\  ___/   \\___ \\  \\___ \\   (  <_> )|   |  \\");
        horizontalBorderPrint(horizontalBorderSize);
        System.out.println(" \\______  /|___|  / \\___  >/____  >/____  >   \\____/ |___|\n");
        horizontalBorderPrint(horizontalBorderSize);
        System.out.println("                                                      .___");
        horizontalBorderPrint(horizontalBorderSize);
        System.out.println("  ____    ____    _____    _____  _____     ____    __| _/");
        horizontalBorderPrint(horizontalBorderSize);
        System.out.println("_/ ___\\  /  _ \\  /     \\  /     \\ \\__  \\   /    \\  / __ | ");
        horizontalBorderPrint(horizontalBorderSize);
        System.out.println("\\  \\___ (  <_> )|  Y Y  \\|  Y Y  \\ / __ \\_|   |  \\/ /_/ | ");
        horizontalBorderPrint(horizontalBorderSize);
        System.out.println(" \\___  > \\____/ |__|_|  /|__|_|  /(____  /|___|  /\\____ | ");
        horizontalBorderPrint(horizontalBorderSize);
        System.out.println("     \\/               \\/       \\/      \\/      \\/      \\/ ");
    }    

    static void clearBoard(){

        for(int i = 0; i<8; i++){

            for(int i2 = 0; i2<8; i2++){
            
                chessboard[i][i2] = "Clear";
            }   
        }
    }

    static void resetBoard(){

        for(int vertical = 0; vertical<8; vertical++){

            for(int horizontal = 0; horizontal<8; horizontal++){

                switch(vertical){

                    case 0:
                    switch (horizontal){

                        case 0:
                        chessboard[vertical][horizontal] = "Black Rook";  
                        break;
                        case 1:
                        chessboard[vertical][horizontal] = "Black Knight";
                        break;
                        case 2:
                        chessboard[vertical][horizontal] = "Black Bishop";
                        break;
                        case 3:
                        chessboard[vertical][horizontal] = "Black Queen";
                        break;
                        case 4:
                        chessboard[vertical][horizontal] = "Black King";
                        break;
                        case 5:
                        chessboard[vertical][horizontal] = "Black Bishop";
                        break;
                        case 6:
                        chessboard[vertical][horizontal] = "Black Knight";
                        break;
                        case 7:
                        chessboard[vertical][horizontal] = "Black Rook";
                        break;

                    }
                    break;
                    case 1:
                    chessboard[vertical][horizontal] = "Black Pawn";
                    break;
                    case 2:
                    chessboard[vertical][horizontal] = "Clear";
                    break;
                    case 3:
                    chessboard[vertical][horizontal] = "Clear";
                    break;
                    case 4:
                    chessboard[vertical][horizontal] = "Clear";
                    break;
                    case 5:
                    chessboard[vertical][horizontal] = "Clear";
                    break;
                    case 6:
                    chessboard[vertical][horizontal] = "White Pawn";
                    break;
                    case 7:
                    switch (horizontal){

                        case 0:
                        chessboard[vertical][horizontal] = "White Rook";  
                        break;
                        case 1:
                        chessboard[vertical][horizontal] = "White Knight";
                        break;
                        case 2:
                        chessboard[vertical][horizontal] = "White Bishop";
                        break;
                        case 3:
                        chessboard[vertical][horizontal] = "White Queen";
                        break;
                        case 4:
                        chessboard[vertical][horizontal] = "White King";
                        break;
                        case 5:
                        chessboard[vertical][horizontal] = "White Bishop";
                        break;
                        case 6:
                        chessboard[vertical][horizontal] = "White Knight";
                        break;
                        case 7:
                        chessboard[vertical][horizontal] = "White Rook";
                        break;

                    }
                    break;

                }
            }   
        }
    }

    static void verticalBorderPrint(int verticalBorderSize){

        //goes brrrrrrr
        for(int i = 0; i < verticalBorderSize; i++){

            System.out.println();

        }
    }

    static void horizontalBorderPrint(int horizontalBorderSize){

        //also goes brrrrrrr
        for(int i = 0; i < horizontalBorderSize; i++){

            System.out.print(" ");

        }

    }

    static void printBoard(int horizontalBorderSize, int verticalBorderSize){

        int length = 5;
        verticalBorderPrint(verticalBorderSize);

        for(int vertical = 0; vertical<8; vertical++){

            if(vertical == 0){

                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX");
            }

            for(int horizontal = 0; horizontal<8; horizontal++){

                if(horizontal == 0){
                    
                horizontalBorderPrint(horizontalBorderSize);
                }


                length = chessboard[vertical][horizontal].length();

                if(vertical % 2 == 0){

                    if(horizontal % 2 == 0){

                        System.out.print(".. ");
                        System.out.print(chessboard[vertical][horizontal]);

                        for(int i = length;i < 12; i++){
                            System.out.print(" ");
                        }

                        System.out.print(" ..");

                    } else {

                        System.out.print("XX ");
                        System.out.print(chessboard[vertical][horizontal]);

                        for(int i = length;i < 12; i++){
                            System.out.print(" ");
                        }

                        System.out.print(" XX");

                    }

                } else{

                    if(horizontal % 2 == 0){

                        System.out.print("XX ");
                        System.out.print(chessboard[vertical][horizontal]);

                        for(int i = length;i < 12; i++){
                            System.out.print(" ");
                        }

                        System.out.print(" XX");

                    } else {

                        System.out.print(".. ");
                        System.out.print(chessboard[vertical][horizontal]);

                        for(int i = length;i < 12; i++){
                            System.out.print(" ");
                        }

                        System.out.print(" ..");

                    }
                }
            }//end of "horizontal" for loop

            System.out.println();
            switch(vertical){
                case 0:
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..");
                break;
                case 1:
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX");
                break;
                case 2:
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..");
                break;
                case 3:
                horizontalBorderPrint(horizontalBorderSize);
                
                System.out.println("XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX");
                break;
                case 4:
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..");
                break;
                case 5:
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX");
                break;
                case 6:
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..");
                break;
                case 7:
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................");
                break;
            }

        }//end of "vertical" for loop
    }

    static int intInput(){
        //Takes input and checks if integer
        //if not informs user and tries again
        Scanner input = new Scanner(System.in);
        int tempControl = 0;
        Integer processedInput = 0;
        

        while(tempControl == 0){

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