import java.io.IOException;

public class ChessOnCommand {
    public static void main (String []args ){

        ClearConsole();
        TitlePrint();

    }
    
//The functions lie after this line
    
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

}//End of program
