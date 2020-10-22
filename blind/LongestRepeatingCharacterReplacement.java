package blind;

public class LongestRepeatingCharacterReplacement {

    public static String longestPalindrome(String s){
        
        if(s == null || s.length() == 0){
            return "";
        }

        int count = 0;
        for(int i=0; i<s.length(); i++){
            int l1 = expandAroundCenter(s, i, i+1);
            int l2 = expandAroundCenter(s, i, i);
            count += l1+l2;
            System.out.println(count);
        }

        return "";
    }

    private static int expandAroundCenter(String s, int left, int right){
        int L = left;
        int R = right;
        int count = 0;
        while(L>=0 && R< s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
            count ++;
        }

        return count;
    }
    public static void main(String[] args){
        System.out.println("5. Longest Palindromic Substring");
        System.out.println(longestPalindrome("abc"));
    }
}
