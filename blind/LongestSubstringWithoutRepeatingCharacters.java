package blind;

import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int longestLength = 0; 
        int i=0;
        int j=0;
        Set<Character> set = new HashSet<>();

        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                longestLength = Math.max(longestLength, set.size());
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return longestLength;
    }
    public static void main(String[] args){
        System.out.println("\n 3. Longest Substring Without Repeating Characters");
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    
}
