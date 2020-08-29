public class LongestPalindromicSubstring {



    public static String longestPalindrome(String s) {
        


        if( s == null || s.length() < 1){
            return "";
        }

        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++){
            int len = Math.max(expandFromMiddle(s, i, i), expandFromMiddle(s, i, i+1));
            if(len>end-start){
                start = i-((len-1)/2);
                end = i+(len/2);
            }
        }
        return s.substring(start, end+1);
        
    }
    public static int expandFromMiddle(String s, int left, int right){

        if(s == null || left > right){
            return 0;
        }

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right-left-1;

    }
    public static void main(String[] args){
        System.out.println("\n5. Longest Palindromic Substring\n");
        String example = "abba";
        String example2 = "racecar";
        String example3 = "a";
        String example4 = " ";
        String example5 = "1234321";

        System.out.println(longestPalindrome(example));
        System.out.println(longestPalindrome(example2));
        System.out.println(longestPalindrome(example3));
        System.out.println(longestPalindrome(example4));
        System.out.println(longestPalindrome(example5));
    }
    
}