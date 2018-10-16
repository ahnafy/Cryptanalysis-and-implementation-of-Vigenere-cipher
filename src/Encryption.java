public class Encryption {

    public static void main(String[] args) {
        // Create our key and text
        String key = "CITADEL";
        String text ="mlpvtkzeeewapmjuxvpehcelmseibdvkhycsehzfbwxegclgweyccsnmxgsrdzfzbglpprmtggpwiwcebexmcqixwmmpnsovbxphppfnmxsieckxgxteadflbxtztclmvsxihcwjneyxjathftfxxbxyksxjxbubgkyilqlkxwesswjxtwpwicyxettrvrzlvsgigbvpiecxxqcxlmelxbbmamdmhhyxfsdxtltbmiomwomxuiprxbdrxremgsttkipvlsjahywhqswhvydmcufnkiyiguptlqfgwcemaiashwkboizyiqffxwlwlstnkvprizptkieltbvztxtztcexlwzgpzcxwufechlfvsxqjbzvtxtscgzlhrpsuhyxfscixbkxkidxxbxtitwmrokbhrdtaoegxhqsghyxyyeygsfyjylriidvhqayiwezkidipftaxvdmcqybgelrssclxasigszgmlpadfcwaegiqsxngiitacibgkeltdfmxrempzfyuytpswezjylriidgxxhsgyjnlmykivvltqptgwevbtwihpvabroujoemnqnsbdlmbrrxwstkxeemdbfymlpwtbvmpscohkfnehpztbkntpwcddvgmlphdciyhvlujoemnqtrisigxxlqdfvlxgfvtqfffyymrokbhrdchhvfbrhlxqybgjzvbokbhrtwhhfkxhlrshitgwxmihvwpmelprmtggphrfpimsrvpdyrlynlpbvmpscowcnxoicgdicwgxmiiflervpeawqxwyyxxzhntreybqffiyeiggsxvsxihqretfwilvzvajfxjfzlfvpessilmltrzkzeellteseuxjzvthnhsicsuwmxsicslocftvemhouwbrrvdpfmlxzmignhkoqsgqvtlmegdbkbgypwicjabjemchftlxzvttihgxqsghyxfsoigbnhkpoxwsixmetptfytlfpichvlmmykivvkhfzxhwetgyxftffylxzvtgzgtvvecgrliiyrhmcotrtepbuvtptjdfebtasigskaxccijgvwyscvtdvtmemptdixwmnxppcxtroqpbltexlwzgkaxdpvdgzqhrpqthvkmazjihreevzfdhjtkipujwgixhhmivrmhapvpbutlicmtgfyvexigojtgheltmdhoiftpbuwhayexgcxlwnecbzgzwsiajvlyscsjhfylxzgzwkxfwthtbkbyctrvwevhvcirhgkbgpwpbumtotrvbfmxsqagcezhvxmhgzgzplftzjwtxlmhhyxgtlwhsuhgxzibdchripwlvfiksnitrkhlxzgzwkxfwlrsqfkkinxbwjmtopwxbzmbewxtgklhjeltffuhxdlpjvuxiywjqtxlwqyasehnksjdfnteqlvihfxqtlrshyxbvcsqckyeipxicrghxsigtzoxdpvdgkhkiderffllxsirclgmvjfjgzgxwdmcgzwxvciecimlxsmhsoitrdmdbnbepmircdieieisppmaiprscwctrfegmkphdpvdcexxmrlikybeicihsrkvlpvhvroxqlrpuvwmsnvtokxjylriidvhqayisilmlpcpfvtepmyayptghzramnhkotrhdvvbewmosuxgztvdbdxgxdxwsixysciivvynxfvtcwjneyxjathftfxxbxftctrrzlwxxsiprfimmzrdtremicrphzoxwesivvlrweibgtnkvprizpuxmykrfvtmiomcqlmmmyktrxxeemsgokhkmpwivvitxsjdfntkhxenpvmavzyvvkaxgciphzhgsqwestbtptdtrthftfxtftabtdgpdrueizjuievmmzrxbxebopujoemnqnsbdlmxvdfjhjtgweltgktmizjivvtkxnsbdfgxrewivflxwjwisdlkibyxfvmaibypbknfgzqeikbgkcikccnmmzrrclewewwdkveefpkxbnbmleltomxkeriesilhrlgrsjlbrrefirgmyxgdagnmicxwffnzllgaclwliczxqvlngsehhyhlitfboewzszkasytoinvtokxwmelxbbrhycivczgzxzwtsxxgiceaomtbplfxzzmrsqwxaletxzvhoewxqfpphfklxseioixnwpjjzzgmlprtlkmpsqsjfdhgxswhozwaycptmjmbpwxwcjxlcdxtajphywhyijmuiltaotxaswhtfwhkxsigsrewilplvzvalpwtsjtkvtzxbxbgxsiccklhhtwioemyyeygszphywhacmxmsditolgbzpvhocjneyxjathftfxtfrotmweqzvtlilvawvktwelgsvmhjtztmvtkwzyioewbfppxsmxmllxrclewfptdgjbupp";

        // Encrypt
        String encryption = encrypt(text, key);
        System.out.println(encryption);

        // Decrypt
        String decryption = decrypt(encryption, key);
        System.out.println(decryption);
    }

    // Generate an encrypted string
    static String encrypt(String text, String key) {
        StringBuilder encryption = new StringBuilder();
        text = text.toUpperCase();

        for (int i = 0, j = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            // Ignore non-letter characters
            if (character < 65 || character > 90) continue;

            // Append encrypted characters to the encrypted string
            // After adding the character ASCII value and key character ASCII value, at minimum the result will be 130
            // (65+65 for two A's). So, subtract 130 so that we get a range 0-25. Then, mod 26 for each letter in the
            // alphabet and add 65 back to get an ASCII value for the encrypted character.
            encryption.append((char) ((character + key.charAt(j) - 130) % 26 + 65));

            // Cycle through the key
            j++;
            j = j % key.length();
        }
        return encryption.toString();
    }

    // Generate a decrypted string
    static String decrypt(String text, String key) {
        StringBuilder decryption = new StringBuilder();
        text = text.toUpperCase();

        for (int i = 0, j = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            // Ignore non-letter characters
            if (character < 65 || character > 90) continue;

            // Append decrypted characters to the decrypted string
            decryption.append((char) ((character - key.charAt(j) + 26) % 26 + 65));

            // Cycle through the key
            j++;
            j = j % key.length();
        }
        return decryption.toString();
    }

}
