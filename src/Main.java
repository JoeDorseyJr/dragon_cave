import java.util.Scanner;

public class Main {
    public static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        boolean play = true;
        int doorNumber = 0;
        do {//Runs the game continuously.
            int friendlyDoor = caveNumber();//Store the winning door.
            do {//Validates the correct input (int).
                try {//Start game and collect the user input.
                    gameStart();
                    doorNumber = userInput.nextInt();
                } catch (Exception e){
                    System.err.println("Wrong Input Type.");
                    userInput.nextLine();
                    doorNumber = 0;
                }
            } while (doorNumber != 1 && doorNumber != 2); //End of validating the input.

            boolean win = friendlyDoor == doorNumber;

            try {
                System.out.println(resultsMessage(win));
                play = playAgain();
            } catch (InterruptedException e) {
                System.err.println("resultsMessage thread interrupted.");
                userInput.nextLine();
            }

        } while (play);// The End
    }

    public static boolean playAgain(){
        /** Queries the user if they want to continue playing and outputs a true or false. */
       boolean run = true;
       String ans;
        do {//Ensure the correct input is gathered.
            System.out.println("\nWould you like to play again? (Y or N)");
            ans = userInput.next();
            if (ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("n")){
                run = false;
            }
        } while (run);

        if (ans.equalsIgnoreCase("n")) {
            System.out.println("Goodbye!");
        }
        return ans.equalsIgnoreCase("Y");
    }

    public static int caveNumber(){
        /** Randomly outputs an integer equal to 1 or 2. */
        return (int) Math.round(Math.random()+1);
    }

    public static void gameStart(){
        /** Prints the initial message to the screen. */
        String message1 = "\nYou are in a land full of dragons. In front of you, you see two caves.\nIn one cave, the dragon is friendly and will share his treasure with you.\nThe other dragon is greedy and hungry and will eat you on sight.";
        String message2 = "Which cave will you go into? \u001B[1m(1 or 2)?\u001B[0m\n";
        System.out.println(message1);
        System.out.println(message2);
    }

    public static String resultsMessage(boolean win) throws InterruptedException {
        /** Takes in a boolean to determine which message should be returned. */
        String[] messages = {"\nYou approach the cave...","It's dark and spooky...","A large dragon jumps out in front of you! He opens his jaws and..."};
        int delay = 1750;

        for (String message : messages) {
            System.out.println(message);
            Thread.sleep(delay);
            delay += 500;//add suspense and drama
        }

        if (win) {
            return "Tells you all about his day. He is friendly and wants to share his treasure with you.\n\u001B[1mYou survived!\u001B[0m";
        }
        return "Gobbles you down in one bite.\nYou died.";
    }
}
