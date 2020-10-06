import java.util.*;



// code | c, od, e

// [0,1,2,3,4]
// [t,f,f,f,f]

// c
//[t,t,f,f,f]

//co
//[t,t,f,f,f]

//cod
//[t,t,f,t,f]

//code
//[t,t,f,t,t]

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict){
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length()+1];

        dp[0] = true;
        for(int i=1; i<=s.length(); i++){
            for(int j= 0; j< i; j++){
                if(dp[j] && wordDictSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public static void main(String[] args){
        System.out.println("\n139. Word Break");
        String s = "catsandog";
        String[] wordDict = new String[]{"cats", "dog", "sand", "and", "cat"};
        System.out.println(wordBreak(s, Arrays.asList(wordDict)));
        
    }
    
}