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

        //settings
        int verticalBorderSize = 8;
        int horizontalBorderSize = 16;

        ClearConsole();
        verticalBorderPrint(verticalBorderSize);
        TitlePrint(horizontalBorderSize);
        System.out.println("\n");
        horizontalBorderPrint(horizontalBorderSize);
        System.out.println("                           1. Play\n");
        horizontalBorderPrint(horizontalBorderSize);
        System.out.println("                           2. Help\n");
        horizontalBorderPrint(horizontalBorderSize);
        System.out.println("                           3. Exit\n");
        
        while(true){
            while(menuState == 0){

                switch(intInput()) { 
                    case 1: 
                        menuState = 1;        
                        ClearConsole();
                        resetBoard();
                        printBoard(horizontalBorderSize, verticalBorderSize);
                    break; 
                    case 2: 
                        menuState = 2;
                        ClearConsole(); 
                    break; 
                    case 3: 
                        ClearConsole();
                        verticalBorderPrint(verticalBorderSize);
                        horizontalBorderPrint(horizontalBorderSize);
                        System.out.println( "Goodbye world");
                        Thread.sleep(4000);
                        System.exit(0);
                    break; 
    
                }

            }

            while(menuState == 2){

                //slap the rules in here
                verticalBorderPrint(verticalBorderSize);
                System.out.println("");
                System.out.println("\n Enter to continue");
            }

            while(menuState == 1){

                resetBoard();
                Play(horizontalBorderSize, verticalBorderSize);

            }

        }
    }//end of main
    
//here be functions
    
    public static String Play(int horizontalBorderSize, int verticalBorderSize) throws InterruptedException{

        Scanner input = new Scanner(System.in);

        String gameResult = "1/2-1/2";

        int currentTurn = 1;

        boolean whitesTurn = true;
        boolean gameOver = false;
        boolean homeSquareExists = false;
        boolean targetSquareExists = false;

        //forgive me, this abomination is used to check if a chosen square exists
        String[]existingSquares = {"A1","B1","C1","D1","E1","F1","G1","H1",
        "A2","B2","C2","D2","E2","F2","G2","H2",
        "A3","B3","C3","D3","E3","F3","G3","H3",
        "A4","B4","C4","D4","E4","F4","G4","H4",
        "A5","B5","C5","D5","E5","F5","G5","H5",
        "A6","B6","C6","D6","E6","F6","G6","H6",
        "A7","B7","C7","D7","E7","F7","G7","H7",
        "A8","B8","C8","D8","E8","F8","G8","H8",};

        while(gameOver == false){

            //pick square to move from
            //check if square has any legal moves
            //pick square to move to
            //replace target square with moving squares value, except if target square is promotion zone and moving piece can promote there
            //in that case replace target square with appropriate promoted piece, set home square to "clear"
            while(homeSquareExists == false){
                ClearConsole();
                printBoard(horizontalBorderSize, verticalBorderSize);

                System.out.println();
                horizontalBorderPrint(horizontalBorderSize);
                System.out.print("Select square to move from:");

                String chosenSquare = input.nextLine();

                //check if home square exists
                for(int i = 0; i < 64; i++){

                    int verticalPosition = 0;

                    if(existingSquares[i] == chosenSquare){

                        homeSquareExists = true;
                        break;
                    }

                    if(i % 8 == 0){
                        verticalPosition++;
                    }

                }

                //check if home square has legal moves
                
                if(homeSquareExists){

                    ClearConsole();
                    printBoard(horizontalBorderSize, verticalBorderSize);
        
                    System.out.println();
                    horizontalBorderPrint(horizontalBorderSize);
                    System.out.print("Select square to move to");
                    

                } else {

                    homeSquareExists = false;
                }

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //We live on the edge, but the wrong side
            }

        }

        return gameResult;
    }

    public static String Move(){
        return "to be written later, possibly permanently unused";
    }


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
        //chessboard[3][3] = "White Queen";
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
                System.out.println("..................................................................................................................................................................");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..................................................................................................................................................................");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println(".........XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX...........................");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println(".........XX     A8       XX..      B8      ..XX      C8      XX..      D8      ..XX      E8      XX..      F8      ..XX      G8      XX..      H8      ...........");
            }

            for(int horizontal = 0; horizontal<8; horizontal++){

                if(horizontal == 0){
                    
                horizontalBorderPrint(horizontalBorderSize);
                System.out.print(".........");
                }


                length = chessboard[vertical][horizontal].length();

                if(vertical % 2 == 0){

                    if(horizontal % 2 == 0){

                        System.out.print("XX ");
                        if(chessboard[vertical][horizontal] == "Clear"){

                            length = 0;

                        } else {

                            System.out.print(chessboard[vertical][horizontal]);

                        }

                        for(int i = length;i < 12; i++){
                            System.out.print(" ");
                        }

                        System.out.print(" XX");

                    } else {

                        System.out.print(".. ");
                        if(chessboard[vertical][horizontal] == "Clear"){

                            length = 0;

                        } else {

                            System.out.print(chessboard[vertical][horizontal]);

                        }

                        for(int i = length;i < 12; i++){
                            System.out.print(" ");
                        }

                        System.out.print(" ..");

                    }

                } else{

                    if(horizontal % 2 == 0){

                        System.out.print(".. ");
                        if(chessboard[vertical][horizontal] == "Clear"){

                            length = 0;

                        } else {

                            System.out.print(chessboard[vertical][horizontal]);

                        }

                        for(int i = length;i < 12; i++){
                            System.out.print(" ");
                        }

                        System.out.print(" ..");

                    } else {

                        System.out.print("XX ");
                        if(chessboard[vertical][horizontal] == "Clear"){

                            length = 0;

                        } else {

                            System.out.print(chessboard[vertical][horizontal]);

                        }

                        for(int i = length;i < 12; i++){
                            System.out.print(" ");
                        }

                        System.out.print(" XX");

                    }
                }
                if(horizontal == 7){

                    System.out.print(".........");

                }

            }//end of "horizontal" for loop

            System.out.println();
            switch(vertical){
                case 0:
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println(".........XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ...........");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println(".........XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX...........................");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("...........................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX.........");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("...........      A7      ..XX      B7      XX..      C7      ..XX      D7      XX..      E7      ..XX      F7      XX..      G7      ..XX      H7      XX.........");
                break;
                case 1:
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("...........              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX.........");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("...........................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX.........");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println(".........XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX...........................");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println(".........XX      A6      XX..      B6      ..XX      C6      XX..      D6      ..XX      E6      XX..      F6      ..XX      G6      XX..      H6      ...........");
                break;
                case 2:
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println(".........XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ...........");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println(".........XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX...........................");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("...........................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX.........");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("...........      A5      ..XX      B5      XX..      C5      ..XX      D5      XX..      E5      ..XX      F5      XX..      G5      ..XX      H5      XX.........");
                break;
                case 3:
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("...........              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX.........");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("...........................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX.........");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println(".........XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX...........................");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println(".........XX      A4      XX..      B4      ..XX      C4      XX..      D4      ..XX      E4      XX..      F4      ..XX      G4      XX..      H4      ...........");
                break;
                case 4:
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println(".........XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ...........");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println(".........XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX...........................");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("...........................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX.........");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("...........      A3      ..XX      B3      XX..      C3      ..XX      D3      XX..      E3      ..XX      F3      XX..      G3      ..XX      H3      XX.........");
                break;
                case 5:
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("...........              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX.........");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("...........................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX.........");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println(".........XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX...........................");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println(".........XX      A2      XX..      B2      ..XX      C2      XX..      D2      ..XX      E2      XX..      F2      ..XX      G2      XX..      H2      ...........");
                break;
                case 6:
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println(".........XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX..              ...........");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println(".........XXXXXXXXXXXXXXXXX...................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX...........................");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("...........................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX.........");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("...........      A1      ..XX      B1      XX..      C1      ..XX      D1      XX..      E1      ..XX      F1      XX..      G1      ..XX      H1      XX.........");
                break;
                case 7:
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("...........              ..XX              XX..              ..XX              XX..              ..XX              XX..              ..XX              XX.........");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("...........................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX..................XXXXXXXXXXXXXXXXXX.........");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..................................................................................................................................................................");
                horizontalBorderPrint(horizontalBorderSize);
                System.out.println("..................................................................................................................................................................");
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

        return processedInput;

    }

}//end of program