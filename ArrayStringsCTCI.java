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

    public static void main(String[] args){
        System.out.println("\nCTCI : Arrays and Strings");

        // IsUnique
        String example1 = "leetcode";
        System.out.println(isUnique(example1));
        String example2 = " a";
        System.out.println(isUnique(example2));


    }
    
}
