package blind;

public class LongestCommonSubsequence {

    public static int findOccurenceofCharacterInString(Character c, String text){
        int idx = 0;
        for(Character cr: text.toCharArray()){
            if(cr.equals(c)){
                return idx;
            }
            idx++;
        }
        return -1;
    }
    public static int longestCommonSubsequenceM(String text1, String text2) {

        if(text1.length() == 0 || text2.length() == 0){
            return 0;
        }

        int firstOccr = findOccurenceofCharacterInString(text1.charAt(0), text2);

        int firstCase = longestCommonSubsequenceM(text1.substring(1), text2);
        int secondCase = 0;
        if(firstOccr != -1){
            secondCase  = longestCommonSubsequenceM(text2.substring(1), text2.substring(firstOccr+1));
        }

        
        return text1.length() + text2.length();   
    }
    public static void main(String[] args){
        System.out.println("\n 1143. Longest Common Subsequence");
        System.out.println(longestCommonSubsequenceM("abc", "bcd"));
    }
    
}
