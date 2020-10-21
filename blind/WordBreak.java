package blind;
import java.util.*;
public class WordBreak{ 

    public static boolean wordBreak(String s, List<String> wordDict){
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;

        for(int i=1; i<=s.length(); i++){
            for(int j= 0; j<i; j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    
    public static void main(String[] args){
        String s = "leetcode";
        String[] wordDict = new String[]{"leet", "code"};
        System.out.println("\n Word Break\n");
        System.out.println(wordBreak(s, Arrays.asList(wordDict)));
    }
}