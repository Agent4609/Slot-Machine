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
        //2 matching symbols means 2.5x profit
        //3 matching symbols means 7x profit
        //

        System.out.println(" ******************");
        System.out.println("Welcome to Java Slots");
        System.out.println(" ******************");

        String[] slotSymbols = { "🍒", "🍋", "🔔", "💎"};
        String spin;
        System.out.println("How much are you Starting with?");
        double capital = in.nextDouble();
        in.nextLine();

        boolean spinAgain = false;
        do{



            System.out.println("Feeling lucky? y/n");
            spin = in.nextLine();
            Slots(slotSymbols);
        }while(spin.equalsIgnoreCase("y"));

    in.close();
    }
    public static void Slots(String[] slotSymbols){
        System.out.println("***********");
        for(int i = 0; i < 3; i++){

            System.out.print("|" + slotSymbols[rn.nextInt(slotSymbols.length)]);

        }
        System.out.println("|\n***********");



    }
}
