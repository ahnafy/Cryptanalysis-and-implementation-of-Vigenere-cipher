import java.util.Arrays;

public class Decipher {

    public static void main(String[] args) {
        String encryptedText = "wsrrrbdrwllhuegfpvvlgveezyckxuludsjolfddpfafttsbuuwppfarwllrhtnwpbbewteazldyifhjadmgouthvlayhrjbybduiavuioijhqilhoyyckwqveavajogazxgochjvrlawvayzaglipogcnpbbbebxfaftdvraawalnajxlwvuudlmaycblqoyycjibmyhovbbbcvavaghalragblssugvoxgoyialrnppcifhjanecplvdmqlcklvlvltsigzddyxuoghzteprtprgocroyejflhcchrwzxbnjxkinublljnppxlwgoyikseblqfxulrgptylftjeglqilezmpdtxulnglwruatvjgochbrsvjavavueshvxuchzpvrcpkvrhkcvanycuysypacvxntmjzifoyashvzrjyfgoghoeysmllhuvshlmntqtuxjprwivbvkqljbycivwjlcealrkshafrogckxulbdvvbicgvrgopdbkuaftoshzcvpzrnyioieplvsmtorqfxulbthhnubsysjzwupvrlttycrsdpuhshggfwcygillbwyhsmtorpzfvybuyszipxlvnubiomfkgiacnmrtyqrzgcneakbpugrpriymcwgcnplagihrvhdxywgycwleezcnvyezmcnflymilxblyroabybpdeeijxukavrtoeakgcoeakuxalshggfkehatdmysutzmanyckfylqhalvznahgrvztysaumlbrgpjioioycprsskynalevsvoxupqwvyflcpjlshggfwgyynasgocqlwgipxkiolblppydclompoznbwfoyasfylqhlholyckxulghzyraftyipycpairccgzlnsjqljbyrjueglqdzlnsjpspgocrvycschalelctcieapjlmasmkprticpuhgocqssgzmuuegbptzlnubhoeysldamaaftpvvzqjlwghlsuiilpbvproyglpvwldywphpcvvzhpzwvbkgvpshzqjjlnzyglhrznxziqplchxvcgifwuhjabtburwlmejfxshellqlavafiomfmgtshqlurvrflaghxrlttycshggfxnrcwpwthgihrqlyrowrccghppoybiieijtzwgopdbkuafxztnsyrlavafhdiranthgrhlsalrvuclvbmgiiprzrtciezfpspvuqpmigfptzxgygehanfkpriavqihczlcitinsjqffelyzvjqhwebgxpdllwuhbddwuhttvjsllslhgogcrfharwpwnubpspvzktuhrkrwhxlvswhzrisizphtztyiqocglaupjtalrzckpwvvlhkmqhneleehlsalvzuthonubxkprafttiavkdyilpcakmanzjaeqycptkruralwqvldavrwptoiakgufshwygksadclppytcckeakyhpezhlwvrrzrebgxpdlllnccjuinyltkphjicvagvqrhtraftziewccawgvlvbijluxspzhithqrubhlvrsmcniyzcioicbazhpvhprhpyzmvvsqugvoxhurdfshhjanmilktfshyfpuhfpdllfrmpxlrqzyckvbigczlnsjglwgvpthqrubh\n";
        String everyNth = "wblfgyloptwrhbeyauabioiyvjxjwaobxdwjuaqjhbarsoiphcmltdoerolrnnjlillyeldnugrvscrraycmovfolstjvlickrxvgpahzovrlnsptdhclspbinmatgkrmnidyeyniyyekocuhemzcqzrsbickexvpgygwklcofflcgapizqrlnpvhcaaruqmbneatqhipldphbsjgnpvwbwflvmsralsxpiycpizdfsvihsumrisppynihijlqgldtlgfppkklzztcprwkelznptdcnqkldpkhspcyhrgljljgtzcllzqlccbvpvvrhisulpzblltb";
        String[] everyNthArr = everyNth.split("");
        String encryptedText2 = encryptedText.substring(1, encryptedText.length());
        String[] firstTwo = encryptedText.split("(?<=\\G.{3})");
        String[] secondTwo = encryptedText2.split("(?<=\\G.{3})");
        String[] thirdTwo = encryptedText2.split("(?<=\\G.{3})");
        System.out.println("First array: " + Arrays.toString(firstTwo));
        mostFrequent(firstTwo);
        System.out.println("Second array: " + Arrays.toString(secondTwo));
        mostFrequent(secondTwo);
        System.out.println("Third array: " + Arrays.toString(thirdTwo));
        mostFrequent(thirdTwo);

        nthElement(encryptedText, 5);
        mostFrequent(everyNthArr);

    }

    private static String nthElement(String encryptedText, int n) {
        StringBuilder result= new StringBuilder();
        for(int i=0; i<encryptedText.length(); i=i+n){
            result.append(encryptedText.charAt(i));
        }
        System.out.println("Every nth element is: " + result);
        return result.toString();
    }

    private static String mostFrequent(String[] stringArr) {
        Arrays.sort(stringArr);
        System.out.println("Sorted array is: " + Arrays.toString(stringArr));
        int curr = 1;
        int max = 1;
        String result = stringArr[0];
        for (int i = 1; i < stringArr.length; i++) {
            if (stringArr[i].equals(stringArr[i-1]))
                curr++;
            else {
                if (curr > max) {
                    max = curr;
                    result = stringArr[i-1];
                }
                curr = 1;
            }

        }
        System.out.println("The string: " + result + " occurred " + max + " times");
        return result;
    }

}
