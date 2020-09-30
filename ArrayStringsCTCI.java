public class ArrayStringsCTCI {


    public static boolean isUnique(String word){
        int[] charChecker = new int[26];
        for(Character c: word.trim().toCharArray()){
            if(charChecker[c-'a'] == 1){
                return false;
            }
            charChecker[c-'a'] = 1;
        }
        return true;
    }

    public static boolean isPermutation(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        int[] charChecker = new int[26];

        for(Character c: s1.toCharArray()){
            charChecker[c-'a'] += 1;
        }

        for(Character c: s2.toCharArray()){
            if(charChecker[c-'a'] == 0){
                return false;
            }
            charChecker[c-'a'] -= 1;
        }

        return true;
    }

    public static boolean checkPermutation(String s1, String s2){
        int lengthOfMainString = s2.length();
        if(s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length()){
            return false;
        }
        int[] charChecker = new int[26];
        for(Character c: s1.trim().toCharArray()){
            charChecker[c-'a'] = 1;
        }
        for(int i=0; i<s2.length(); i++){
            if(charChecker[s2.charAt(i) -'a'] == 1 && i+s1.length() <= lengthOfMainString){
                System.out.println("Checking permutations: " + s1 + ", " + s2.substring(i, i+s1.length()));
                if(isPermutation(s1, s2.substring(i, i+s1.length()))){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println("\nCTCI : Arrays and Strings\n");

        // IsUnique
        System.out.println("1.1 Is Unique");
        String example1 = "leetcode";
        System.out.println(isUnique(example1));
        String example2 = " a";
        System.out.println(isUnique(example2));
        System.out.println();

        // IsPermutation
        System.out.println("1.2 Check Permutations");
        String word1 = "ab";
        String word2 = "abdboaoo";
        System.out.println(checkPermutation(word1, word2));
        System.out.println();


    }
    
}
