import java.util.Random;
import java.util.Scanner;
public class SlotMachine {
   public static Random rn = new Random();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

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

        String[] slotSymbols = { "🍒", "🍋", "🔔", "💎", "⭐"};
        String confirm;
        System.out.println("How much are you Starting with?");
        double capital = in.nextDouble();
        in.nextLine();

        boolean spinAgain = false;
        do{



            System.out.println("Feeling lucky? y/n");
            confirm = in.nextLine();
            Slots(slotSymbols);
        }while(confirm.equalsIgnoreCase("y"));

    in.close();
    }
    public static String[] Slots(String[] slotSymbols){

        String[] result = new String[3];
        System.out.println("***********");
        for(int i = 0; i < 3; i++){
            result[i] = slotSymbols[rn.nextInt(slotSymbols.length)];
            System.out.print("|" + result[i]);

        }
        System.out.println("|\n***********");
        return result;



    }
}
