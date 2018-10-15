package src;

import java.util.HashMap;
import java.util.Map;

public class Breaking {

    public static void main(String[] args) {
        int keywordLength = 7; // Our guess for the length of keyword used in the encryption of this ciphertext
        String cipherText = "CAXCUIECTPABWSCATSWVPPOMHHRTPOXFIINVCIOQEYGEUOURQTQXNGWSKXTSGSPUBAEVLLTMWIPTCGALIRREJIGAQIIVMKNDPQKONRHMDVWULDQPVPXMHRZHBAEFVZYVAAYIMGKHMHYYKBXDOIDUJRTKITTAAAUIODMEIHJDYMHBVICXMMHDRMABAELVDJIKEGQTUOBVLRRUEAIFLLTMBNWLPOIBNHBEGZGAOPJFQKEFXPFQGTKITTIGAOCDGAOAUMZWAEYPEOGWYAOEDVIBROEFFMKBDGVIMHRJIDJMIAUHWALBAZIWNAYRDRNKAVAUZPTIGNDAPVPXRHPWCVWEPICAAMALRPUBAEFVZYVFEQLLXMUEFSXGUHRHEYFUHRHWFIOXSWMGGLXSSMEGBAEIENVBAAWRZVPBNJLLUJXEQTCQDXNQSMQLRHDWMGMGTUMPFIGDQSYGEBNISCOIMIRRSCAVOPIEQTBGKXEJMBREIWKMYSKEGGJXCRQPOWKEIEYEQYUOXSGQKHBTZVPXSHWWGALPUENVQVAOXSGQKCRYYUMELHWDIMKMDRPWVVOQJTTUXDVYDRQVIRREGVWSRZPTBBMHXZDMVOPIHKTYUOJLNTTCLSFUIGDSVPABHTKIGKKBSVMEWLXSRJXQWWIWENSCBRHWLNTMHHUFCTBTLIDQNVOPQZPANPHVDVQMIRRLPLMHHQPPWYTKINTWPNKSEGTPHRWPPMQUVSQCTEEJMLPKXIVWEKBVHHHLHBXRDPWKVMHHFCKOATWLCGIWOIXTOMTNGQZVQHNKEGGTBKHEWNUXNQSTOUNNLXJVWBNIPFGVVE";
        cipherText = cipherText.toLowerCase();

        for(int i = 0; i < keywordLength; i++){
            decrypt(cipherText, keywordLength, i);
        }

    }

    // Outputs a suspected keyword for a given key length

    private static void decrypt(String ciphertext, int keywordLength, int position) {
        HashMap<Character, Integer> numOfLetters = new HashMap<>(26);
        char[] ciphertextChars = ciphertext.toCharArray();
        int highestCount = 0;
        char freqChar1 = ' ';
        char freqChar2 = ' ';

        updateLetterTotal(keywordLength, position, numOfLetters, ciphertextChars);

        for (Map.Entry<Character, Integer> entry: numOfLetters.entrySet()) {
            if(entry.getValue() == highestCount){
                freqChar2 = entry.getKey();
                highestCount = entry.getValue();
            }
            if (entry.getValue() > highestCount) {
                freqChar1 = entry.getKey();
                highestCount = entry.getValue();
            }
        }

        System.out.println("column " + position + ": " + numOfLetters);

        shift(freqChar1);

        shift(freqChar2);
    }

    // Adds one to that letters total in the HashMap

    private static void updateLetterTotal(int keywordLength, int position, HashMap<Character, Integer> numOfLetters, char[] ciphertextChars) {
        for (int i = position; i < ciphertextChars.length; i = i + keywordLength) {

            if (numOfLetters.get(ciphertextChars[i]) != null) {
                numOfLetters.put(ciphertextChars[i], numOfLetters.get(ciphertextChars[i]) + 1);
            } else {
                numOfLetters.put(ciphertextChars[i], 1);
            }

        }
    }

    // Calculates the shift distance of the most frequent character and the character 'e'

    private static int shift(char freqChar) {
        int shift = freqChar - 'e';
        if (shift < 0) {
            shift = shift + 123;
        } else {
            shift = shift + 97;
        }
        System.out.print((char)shift + "; ");
        return shift;
    }
}
