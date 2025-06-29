
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class SlotMachine {
    public static Random rn = new Random();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String[]> spinHistory = new ArrayList<>();

        // Welcome
        //Symbols
        // "🃏", "💰", "⭐"
        //Enter starting capital, no changes to capital
        // betting amount

        //spin
        //3 matching symbols means 7x profit
        //

        System.out.println(" ******************");
        System.out.println("Welcome to Java Slots");
        System.out.println(" ******************");

        String[] slotSymbols = {"🍒", "🍋", "🔔", "💎", "⭐"};
        String[] spin;
        double multiplier;
        double winnings;
        double finalWinnings = 0;
        boolean isRepeat = false;
        int count = 0;
        double betAmount = 0;



        System.out.println("How much are you putting in?");
        double capital = in.nextDouble();
        double startingCapital = capital;
        in.nextLine();

        System.out.println("Feeling lucky?");

        do {
            System.out.println("Your balance is $" + capital);


                System.out.println("How would you like to bet?");
                System.out.println("1. All IN");
                System.out.println("2. Manual bet");
            System.out.println("3. Add funds");
                int option = in.nextInt();
                in.nextLine();

                if(option == 1) {
                  betAmount = capital;
                }else if(option == 2){
                    System.out.println("Enter bet amount");
                    betAmount = in.nextDouble();
                    in.nextLine();
                }


                if (betAmount > capital || betAmount <= 0) {
                    System.out.println("Insufficient balance/Invalid amount");
                    break;
                } else {
                    capital -= betAmount;
                    if (capital < 0) {
                        System.out.println("You're out of funds!");
                        System.out.println("Would you like to add more?");
                        String option1 = in.nextLine();

                        if(option1.equalsIgnoreCase("y")){
                            System.out.println("How much are you adding?");
                            capital = in.nextInt();
                            in.nextLine();
                        }
                        else if(option1.equalsIgnoreCase("n"))
                            break;
                        }
                }

                spin = Slots(slotSymbols);
                spinHistory.add(spin.clone());
                System.out.println("Spinning...");
                if (spin[0].equals(spin[1]) && spin[1].equals(spin[2])) {
                    multiplier = switch (spin[0]) {
                        case "🍒" -> 2;
                        case "🍋" -> 3;
                        case "🔔" -> 5;
                        case "⭐" -> 10;
                        case "💎" -> 20;
                        default -> 1;
                    };
                    winnings = multiplier * betAmount;
                    capital += winnings;
                    finalWinnings += winnings;
                    System.out.println("JACKPOT!!! you won $" + winnings + "!");
                }else if
                (spin[0].equals(spin[1]) || spin[1].equals(spin[2]) || spin[0].equals(spin[2])) {
                    multiplier = switch (spin[0]) {
                        case "🍒" -> 1.5;
                        case "🍋" -> 1.75;
                        case "🔔" -> 2.25;
                        case "⭐" -> 4.25;
                        case "💎" -> 7.5;
                        default -> 1;
                    };
                    winnings = multiplier * betAmount;
                    capital += winnings;
                    finalWinnings += winnings;
                    System.out.println("Two symbols matched!!! you won $" + winnings + "!");

                }
                else {
                    System.out.println("No match... better luck next time!");
                }

                // [Winning logic continues here...]



            System.out.println("Would you like to continue?");
            String repeat = in.nextLine();

            if(repeat.equalsIgnoreCase("yes") || repeat.equalsIgnoreCase("y")){
                isRepeat = true;
            }else if(repeat.equalsIgnoreCase("no") || repeat.equalsIgnoreCase("n")){
                break;

            }
            if (capital == 0) {
                System.out.println("You're out of funds!");
                System.out.println("Would you like to add more?");
                String option1 = in.nextLine();

                if(option1.equalsIgnoreCase("y")){
                    System.out.println("How much are you adding?");
                    capital = in.nextInt();
                    in.nextLine();
                }
                else if(option1.equalsIgnoreCase("n"))
                    break;
            }
            count++;
        }
        while(isRepeat);

        endMessage(capital, startingCapital, count, finalWinnings, spinHistory);



        in.close();
    }
    public static String[] Slots (String[]slotSymbols){

        String[] result = new String[3];
        System.out.println("***********");
        for (int i = 0; i < 3; i++) {
            result[i] = slotSymbols[rn.nextInt(slotSymbols.length)];
            System.out.print("|" + result[i]);

        }
        System.out.println("|\n***********");
        return result;


    }
    public static void endMessage(double capital, double startingCapital, int count, double finalWinnings,List<String[]> history){
        System.out.println("\n🎰 SESSION SUMMARY 🎰");
        System.out.printf("💵 You started with:   $%.2f\n", startingCapital);
        System.out.printf("💰 You finished with:  $%.2f\n", capital);
        System.out.printf("📈 Total winnings:     $%.2f\n", finalWinnings);
        System.out.printf("🎲 Total spins:        %d\n", count);

        System.out.println("\n🕹️ Spin History:");
        for (int i = 0; i < history.size(); i++) {
            String[] spin = history.get(i);
            boolean isJackpot = spin[0].equals(spin[1]) && spin[1].equals(spin[2]);
            String label = isJackpot ? " 🎉 JACKPOT!" : "";
            System.out.printf("  Spin %d: |%s|%s|%s|%s\n", i + 1, spin[0], spin[1], spin[2], label);

        }

        System.out.println("Have a wonderful day!");
    }
}

