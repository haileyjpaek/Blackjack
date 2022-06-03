import java.util.Scanner;


public class Blackjack {
    public static void main(String [] args)
    {
        // instantiate a Scanner object
        Scanner scanner = new Scanner(System.in);
        P1Random rand = new P1Random();
        // initialize variables for the game
        int option = 1;
        int iValue = 0;
        int dealValue = 0;
        int iHand = 0;
        int newGame = 1;
        int totalGames = 1;
        int iError = 0;
        int playerWins = 0;
        int dealerWins = 0;
        int tieGames = 0;
        // start while loop to loop for everytime the user does not want to hold their hand or when variable newGame = 1
        while (option != 2 || newGame == 1) {
            // loop random number for the card value if iError = 0
            if(iError == 0) {
               int myValue = rand.nextInt(13) + 1;
               iValue = myValue;
            }
            // loop starting a new game if iError = 0
            if (iError == 0) {
                if (newGame == 1) {
                    System.out.println("START GAME #" + totalGames );
                }
                // start switch statement to assign values to card values
                switch (iValue) {
                    // case 1 - 5 for cards ace - 5
                    case 1:
                        System.out.println("Your card is a ACE!");
                        break;
                    case 2:
                        System.out.println("Your card is a 2!");
                        break;
                    case 3:
                        System.out.println("Your card is a 3!");
                        break;
                    case 4:
                        System.out.println("Your card is a 4!");
                        break;
                    case 5:
                        System.out.println("Your card is a 5!");
                        break;
                    // case 6 - 10 for card #'s 6 - 10
                    case 6:
                        System.out.println("Your card is a 6!");
                        break;
                    case 7:
                        System.out.println("Your card is a 7!");
                        break;
                    case 8:
                        System.out.println("Your card is a 8!");
                        break;
                    case 9:
                        System.out.println("Your card is a 9!");
                        break;
                    case 10:
                        System.out.println("Your card is a 10!");
                        break;
                    // case 11 - 13 for cards jack, queen, and king
                    case 11:
                        System.out.println("Your card is a JACK!");
                        break;
                    case 12:
                        System.out.println("Your card is a QUEEN!");
                        break;
                    case 13:
                        System.out.println("Your card is a KING!");
                        break;
                    default:
                        return;
                }

                if (iValue > 10){
                    iValue = 10;
                }
                // assign iHand to the total of all the values you get in one game to get the value of your hand
                iHand += iValue;
                System.out.println("Your hand is: " + iHand);
            } // end of IError

            if (iHand < 21) {
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.print("Choose an option:  ");
                option = scanner.nextInt();
                // start switch statement to option values to what you want each option to do
                switch (option) {
                    // case 1 for dealing a card again
                    case 1:
                        newGame = 2;
                        iError = 0;
                        break;
                    // case 2 for holding your hand
                    case 2:
                        // getting dealer hand
                        int dValue = rand.nextInt(11) + 16;
                        dealValue = dValue;
                        System.out.println("Dealer's hand: " + dealValue);
                        System.out.println("Your hand is: " + iHand);
                        // getting result for a tie
                        if (dealValue == iHand){
                            System.out.println("It's a tie! No one wins!");
                            tieGames++;
                        }
                        // getting result for a player win
                        if (dealValue > 21 || dealValue < iHand) {
                            System.out.println("You win!");
                            playerWins++;
                        }
                        // getting result for the dealer win
                        if (dealValue <= 21 && dealValue > iHand){
                            System.out.println("Dealer wins!");
                            dealerWins++;
                        }
                        totalGames++;
                        newGame = 1;
                        iHand = 0;
                        iValue = 0;
                        iError = 0;
                        break;
                    // case 3 for printing statistics
                    case 3:
                        System.out.println("Number of Player wins: " + playerWins);
                        System.out.println("Number of Dealer wins: " + dealerWins);System.out.println("Number of tie games: " + tieGames);
                        System.out.println("Total # of games played is: " + (totalGames - 1));
                        System.out.println("Percentage of Player wins: " + String.format("%.1f", (((double) (playerWins)) / (totalGames - 1)) * 100) + "%");
                        newGame = 2;
                        iError = 1;
                        break;
                    // case 4 for exiting games
                    case 4:
                        return;
                    default:
                        System.out.println("\nInvalid input!");
                        System.out.println("Please enter an integer value between 1 and 4.");
                        newGame = 2;
                        iError = 1;
                        break;
                } //end switch
            } // end If
            else
            {
                // getting result for when player goes over 21
                int iResult = iHand;
                if(iResult > 21)
                {
                    System.out.println("You exceeded 21! You lose.");
                    dealerWins++;
                }
                // getting result for when player gets 21
                if(iResult == 21)
                {
                    System.out.println("BLACKJACK! You win!");
                    playerWins++;
                }
                totalGames++;
                newGame = 1;
                iHand = 0;
                iValue = 0;
            } // else if
        } // end while
    } // main end
} // class end