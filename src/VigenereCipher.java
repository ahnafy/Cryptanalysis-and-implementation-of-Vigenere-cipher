package src;

public class VigenereCipher {

    public static void main(String[] args) {
        System.out.println("Encryption of our submitted text:");
        System.out.println(encrypt("strung tot as to bring on nights and nights of in- somnia? Did you so constantly snarl at it that it don't want you around? In fact, did you put any- thing in that back-path of yours which could bring sorrow to a child? Or start its distrust of you, as its rightful guardian? If so, go back right now, man, and fix up such spots by kindly acts from now on. Or, jump into a pond, and don't crawl out again!! For nobody wants you around!\" Lady Gadsby, as this oration was wafting off amongst lilac shrubs, and across soft, warm lawns, had sat, also thinking; finally coming out on-to that ivy-bound porch, and sitting down by His Honor, saying: —", "netizen"));
        System.out.println("Decryption of our encrypted text above:");
        System.out.println(decrypt("fxkcmkgbxtassoemgonravkabreaqrbogxfbjbvrszamtlhhlbylwbsafxtvsplfrtzkegvxmpzxvghhvsanaxrwteebyglhrsngmlhhlbyicsealxaqmkvaxaisfnpoiislbschcqwjumvpbshyhuzhrtfskznagbevphpqbvlbzvgvxllhwgeylbnjlbytahxfemzpsjhykniqhvnrbnrstbftkjvvtlmvnaznrtvcjvkyiatgufthbrflxmglkcnpxlnqszaspwmsewyfxhrgbeiwmhnahwwmxpeeptnygnktqmjberhjnhljegbrcbhekwtrqyewgfeqffrirxuvwhzzxvbrpiransxbvfsssefwmkfgpbtzgfuvnjreaqevznwffsybveezptemwunhliseyfsmphrxvrznhrnyprknqvakhcssagsmpzxvicuwtrqcskkgeaqwbbsmathhemflumlpnrbewtghrt", "netizen"));

        System.out.println("");

        System.out.println("Decryption of Ahnaf and John's ciphertext with the keyword our program produced:");
        System.out.println(decrypt("CAXCUIECTPABWSCATSWVPPOMHHRTPOXFIINVCIOQEYGEUOURQTQXNGWSKXTSGSPUBAEVLLTMWIPTCGALIRREJIGAQIIVMKNDPQKONRHMDVWULDQPVPXMHRZHBAEFVZYVAAYIMGKHMHYYKBXDOIDUJRTKITTAAAUIODMEIHJDYMHBVICXMMHDRMABAELVDJIKEGQTUOBVLRRUEAIFLLTMBNWLPOIBNHBEGZGAOPJFQKEFXPFQGTKITTIGAOCDGAOAUMZWAEYPEOGWYAOEDVIBROEFFMKBDGVIMHRJIDJMIAUHWALBAZIWNAYRDRNKAVAUZPTIGNDAPVPXRHPWCVWEPICAAMALRPUBAEFVZYVFEQLLXMUEFSXGUHRHEYFUHRHWFIOXSWMGGLXSSMEGBAEIENVBAAWRZVPBNJLLUJXEQTCQDXNQSMQLRHDWMGMGTUMPFIGDQSYGEBNISCOIMIRRSCAVOPIEQTBGKXEJMBREIWKMYSKEGGJXCRQPOWKEIEYEQYUOXSGQKHBTZVPXSHWWGALPUENVQVAOXSGQKCRYYUMELHWDIMKMDRPWVVOQJTTUXDVYDRQVIRREGVWSRZPTBBMHXZDMVOPIHKTYUOJLNTTCLSFUIGDSVPABHTKIGKKBSVMEWLXSRJXQWWIWENSCBRHWLNTMHHUFCTBTLIDQNVOPQZPANPHVDVQMIRRLPLMHHQPPWYTKINTWPNKSEGTPHRWPPMQUVSQCTEEJMLPKXIVWEKBVHHHLHBXRDPWKVMHHFCKOATWLCGIWOIXTOMTNGQZVQHNKEGGTBKHEWNUXNQSTOUNNLXJVWBNIPFGVVE", "citwdel"));
    }

    public static String encrypt(String plaintext, String keyword) {
        String cleanPlaintext = sanitizeText(plaintext);
        Integer[] keywordAsciiArray = stringToAsciiCode(keyword);
        Integer[] asciiCodeArray = stringToAsciiCode(cleanPlaintext);

        String ciphertext = "";

        for (int i = 0, j = 0; i < asciiCodeArray.length; i++) {
            if (asciiCodeArray[i] >= 'a' || asciiCodeArray[i] <= 'z') {
                ciphertext += ((char) (((asciiCodeArray[i] + keywordAsciiArray[j]) % 26) + 97));
                j = (j + 1) % keywordAsciiArray.length;
            }
        }

        return ciphertext;
    }

    public static String decrypt(String ciphertext, String keyword) {
        String cleanCipherText = sanitizeText(ciphertext);
        Integer[] keywordAsciiArray = stringToAsciiCode(keyword);
        Integer[] asciiCodeArray = stringToAsciiCode(cleanCipherText);

        String plaintext = "";

        for (int i = 0, j = 0; i < asciiCodeArray.length; i++) {
            if (asciiCodeArray[i] >= 'a' || asciiCodeArray[i] <= 'z') {
                plaintext += ((char) ((((asciiCodeArray[i] - keywordAsciiArray[j]) + 26) % 26) + 97));
                j = (j + 1) % keywordAsciiArray.length;
            }
        }

        return plaintext;
    }

    // Takes the plaintext string and maps it to an array with each character
    // represented by its ASCII Code

    private static Integer[] stringToAsciiCode(String plaintext) {
        return plaintext.chars().mapToObj(i -> i - 97).toArray(Integer[]::new);
    }

    // Removes every thing from the String besides lowercase letters

    public static String sanitizeText(String text) {
        String cleanText = text.toLowerCase();
        cleanText = cleanText.replaceAll("[^a-z]", "");
        return cleanText;
    }
}