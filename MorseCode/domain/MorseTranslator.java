package MorseCode.domain;

import java.util.Map;

public class MorseTranslator {

    Map<Character, String> stringToMorse = Map.ofEntries(
            Map.entry('A', ".-"), Map.entry('B', "-..."), Map.entry('C', "-.-."), Map.entry('D', "-.."),
            Map.entry('E', "."), Map.entry('F', "..-."), Map.entry('G', "--."), Map.entry('H', "...."),
            Map.entry('I', ".."), Map.entry('J', ".---"), Map.entry('K', "-.-"), Map.entry('L', ".-.."),
            Map.entry('M', "--"), Map.entry('N', "-."), Map.entry('O', "---"), Map.entry('P', ".--."),
            Map.entry('Q', "--.-"), Map.entry('R', ".-."), Map.entry('S', "..."), Map.entry('T', "-"),
            Map.entry('U', "..-"), Map.entry('V', "...-"), Map.entry('W', ".--"), Map.entry('X', "-..-"),
            Map.entry('Y', "-.--"), Map.entry('Z', "--.."), Map.entry('0', "-----"), Map.entry('1', ".----"),
            Map.entry('2', "..---"), Map.entry('3', "...--"), Map.entry('4', "....-"), Map.entry('5', "....."),
            Map.entry('6', "-...."), Map.entry('7', "--..."), Map.entry('8', "---.."), Map.entry('9', "----."),
            Map.entry('.', ".-.-.-"), Map.entry(',', "--..--"), Map.entry('?', "..--.."), Map.entry('!', "-.-.--"),
            Map.entry(':', "---..."), Map.entry(';', "-.-.-.")
    );

    public String translateToMorse(String text) {
        StringBuilder morseCode = new StringBuilder();
        for (char character : text.toUpperCase().toCharArray()) {
            if (stringToMorse.containsKey(character)) {
                morseCode.append(stringToMorse.get(character)).append(" ");
            } else if (character == ' ') {
                morseCode.append(" / "); // Add extra space for word separation
            } else {
                System.out.println("Character '" + character + "' is not supported.");
            }
        }
        return morseCode.toString().trim();
    }

    public void printMorseCode(String morseCode) {
        String[] morseWords = morseCode.split(" / ");
        for (String morseWord : morseWords) {
            String[] morseChars = morseWord.trim().split(" ");
            for (String morseChar : morseChars) {
                System.out.print(morseChar + " ");
            }
            System.out.print(" / "); // Add space between words
        }
    }
}
