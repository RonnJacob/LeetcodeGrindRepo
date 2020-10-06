import java.util.*;



public class SlidingWindowPoorva {

    // This function returns the length of the pattern in a string starting from the first index
    // and includes all indices up until the pattern has been found.

    // Pattern : adkc | String: aaadkccc | 
    //
    // We start from index 0 of String and move till index 5 because we have found
    // all the characters in the pattern at this point. We then return 6 which is the length of
    // of the occurence of the pattern in the String starting from the first index.
    public static int lengthSmallestSubString(String s, String pattern){
        int mainStringPointer = 0;
        int patternPointer = 0;

        //Start pointers for both strings.
        while(patternPointer < pattern.length() && mainStringPointer < s.length()){

            // If character at a particular index in a pattern matches a character
            // at a particular index in String, then we can increase the pointer for the pattern
            // along with the pointer for the string.
            if(pattern.charAt(patternPointer) == s.charAt(mainStringPointer)){
                patternPointer++;
            }

            // We would keep incrementing the pointer for the string no matter what
            // to keep finding the next character in the pattern up until the very end
            // if need be.
            mainStringPointer++;
        }


        // If we've reached the end of the string, and not found the pattern, return -1.
        if(mainStringPointer == s.length() && patternPointer != pattern.length()){
            return -1;
        }

        return mainStringPointer;   
    }

    // This function prints out the smallest substring in a pattern in the string.
    public static void checkSubStringPattern(String s, String pattern){


        Map<Integer, Character> charIndex = new TreeMap<>();
        Set<Character> patternChar = new HashSet<>();


        for(int i=0; i<pattern.length(); i++){
            patternChar.add(pattern.charAt(i));
        }

        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<s.length(); i++){
            if(patternChar.contains(s.charAt(i))){
                charIndex.put(i, s.charAt(i));
                sb.append(s.charAt(i));
            }
        }


        int minSize = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        for(int i=0; i<sb.toString().length(); i++){
           

            int l = lengthSmallestSubString(sb.toString().substring(i), pattern);
            if(l != -1 && l< minSize){
                start = i;
                end = i+l-1;
            }
            
        }

        int k = 0;
        int actualStart = 0;
        int actualEnd = 0;
        for(Map.Entry<Integer, Character> entry: charIndex.entrySet()){
            if(k==start){
                actualStart = entry.getKey();
            }

            if(k==end){
                actualEnd = entry.getKey();
            }
            k++;
        }

        System.out.println(s.substring(actualStart, actualEnd+1));

    }
    
    public static void main(String[] args){
        System.out.println("\nTrying this out!");

        // Pattern for checking.
        String pattern = "ABC";

        // String to check in.
        String s = "ADOBECODEBANC";

        checkSubStringPattern(s, pattern);


    }
    
}