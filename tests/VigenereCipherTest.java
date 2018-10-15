package tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import src.VigenereCipher;

class VigenereCipherTest {

    @Test
    void sanitizePlaintext() {
        VigenereCipher vigenereCipher = new VigenereCipher();
        String dirtyText = "This isn't a very clean sentence. There are at least 5 things wrong!";
        String cleanText = vigenereCipher.sanitizeText(dirtyText);

        Assertions.assertFalse(isTextClean(dirtyText));
        Assertions.assertTrue(isTextClean(cleanText));
    }

    @Test
    void encrypt() {
        VigenereCipher vigenereCipher = new VigenereCipher();
        String dirtyText = "This isn't a very clean sentence. There are at least five things wrong!";
        String cleanText = vigenereCipher.sanitizeText(dirtyText);
        String cipherText = vigenereCipher.encrypt(cleanText, "key");

        Assertions.assertFalse(cleanText.equals(cipherText));
        Assertions.assertTrue(cipherText.equals("dlgcmqxxyfipigjoelcildilmirripoepoerviycxdszcdlgxkqgvmxk"));

        cipherText = vigenereCipher.encrypt(cleanText, "zzz");

        Assertions.assertTrue(cipherText.equals("sghrhrmszudqxbkdzmrdmsdmbdsgdqdzqdzskdzrsehudsghmfrvqnmf"));

        cipherText = vigenereCipher.encrypt(cleanText, "aaa");

        Assertions.assertTrue(cipherText.equals("thisisntaverycleansentencethereareatleastfivethingswrong"));
    }

    @Test
    void decrypt() {
        VigenereCipher vigenereCipher = new VigenereCipher();
        String dirtyText = "This isn't a very clean sentence. There are at least five things wrong!";
        String cleanText = vigenereCipher.sanitizeText(dirtyText);
        String cipherText = "dlgcmqxxyfipigjoelcildilmirripoepoerviycxdszcdlgxkqgvmxk";
        String decryptText;
        String key = "key";

        Assertions.assertTrue(cipherText.equals(vigenereCipher.encrypt(cleanText, "key")));

        decryptText = vigenereCipher.decrypt(cipherText, "key");

        Assertions.assertTrue(decryptText.equals(cleanText));


    }

    private boolean isTextClean(String plaintext) {
        Pattern pattern = Pattern.compile("[a-z]*");
        Matcher matcher = pattern.matcher(plaintext);

        return matcher.matches();
    }
}