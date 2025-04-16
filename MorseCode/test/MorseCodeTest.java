package MorseCode.test;

import MorseCode.domain.MorseTranslator;
import MorseCode.domain.StringTranslator;

import java.util.Scanner;

public class MorseCodeTest {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            MorseTranslator morseTranslator = new MorseTranslator();
            StringTranslator stringTranslator = new StringTranslator();

            while (true) {
                System.out.println("--- Welcome to the Morse Code Translator and String Translator! --- ");
                System.out.println("This program translates text to Morse Code and Strings.");
                System.out.println("Supported characters: A-Z, 0-9, '.', ',', '?', '!', ':', ';'");
                System.out.println(" / is used to separate words.");
                System.out.println("-----------------------------\n");
                System.out.println("Please choose an option:");
                System.out.println("1. Translate Morse Code to String");
                System.out.println("2. Translate String to Morse Code");
                System.out.println("3. Exit");
                System.out.println("-----------------------------\n");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character left by nextInt()

                switch (choice){
                    case 1:
                        System.out.print("\nPlease enter the text you want to translate to Morse Code: ");
                        String inputText = scanner.nextLine();
                        morseTranslator.printMorseCode(morseTranslator.translateToMorse(inputText));
                        break;
                    case 2:
                        System.out.print("Please enter the Morse Code you want to translate to String: ");
                        String stringcode = scanner.nextLine();
                        stringTranslator.printString(stringTranslator.translateToString(stringcode));
                        break;
                    case 3:
                        System.out.println("Exiting the program. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                System.out.println("\nWould you like to perform another translation? (yes/no)");
                String response = scanner.nextLine();
                System.out.println("Thank you for using the Morse Code Translator and String Translator!");
                if (!response.equalsIgnoreCase("yes")) {
                    break;
                }

            }




    }
}
