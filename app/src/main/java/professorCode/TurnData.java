package professorCode;

import java.util.concurrent.ThreadLocalRandom;

public class TurnData {

    private final char letter;
    private final boolean addFront;

    /**
     * Creates a valid Turn Data object. If a null or non-alphanumeric (A-z or 0-9) value is used for a letter a random
     * char will be chosen. If a null value is used for addFront then a random value is chosen.
     * @param letter a character that you would like to ass to the word fragment.
     * @param addFront The location the letter will be added to the word fragment, True = the letter will be added to the front,
     * False = the letter will be added to the back
     * @return
     */
    public static TurnData create(String teamName, Character letter, Boolean addFront) {

        if(letter == null) {
            System.err.println("["+teamName+"] A null 'letter' value used at construction of the TurnData. A random character is use.");
            letter = getRandomLetter().charAt(0);
        }

        if(!Character.isAlphabetic(letter) && !Character.isDigit(letter)) {
            System.err.println("["+teamName+"] A 'letter' value that was not alphanumeric (A-z or 0-9) was used. The letter chosen was \""+letter+"\", it is not alphanumeric. A random character is use.");
            letter = getRandomLetter().charAt(0);
        }

        letter = Character.toLowerCase(letter);

        if(addFront == null) {
            System.err.println("["+teamName+"] A null 'addFront' value used at construction of the TurnData so the letter will be randomly added to front or back of the fragment.");
            addFront = getRandomLocation();
        }


        return new TurnData(letter, addFront);
    }

    private TurnData (char letter, boolean addFront) {

        this.letter = letter;

        this.addFront = addFront;
    }

    /**
     * The letter to be played
     * @return
     */
    public char getLetter() {
        return letter;
    }

    /**
     * The location the letter will be played:
     * <br>
     * true - add letter to front
     * <br>
     * false - add letter to the back
     * @return
     */
    public boolean isAddFront() {
        return addFront;
    }

    public static String getRandomLetter() {
        char c = (char)(ThreadLocalRandom.current().nextInt(26) + 'a');

        return String.valueOf(c);
    }

    public static boolean getRandomLocation() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}