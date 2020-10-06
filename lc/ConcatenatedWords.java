import java.util.*;
public class ConcatenatedWords {

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.asList(words).sort((a,b)->Integer.compare(a.length(), b.length()));
        List<String> result = new ArrayList<>();
        Set<String> wordsBeforeCurrentWord = new HashSet<>();
        for(String word: Arrays.asList(words)){
            if(canForm(word, wordsBeforeCurrentWord)){
                result.add(word);
            }
            wordsBeforeCurrentWord.add(word);
        }
        return result;
    }


    public static boolean canForm(String word, Set<String> dict){
        if(dict.isEmpty()){
            return false;
        }

        boolean[] dp = new boolean[word.length()+1];
        dp[0] = true;
        for(int i=1; i<=word.length(); i++){
            for(int j=0; j<i; j++){
                if(dp[j] && dict.contains(word.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[word.length()];
    }
    public static void main(String[] args){
        System.out.println("\n472. Concatenated Words");
        String[] words = new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(findAllConcatenatedWordsInADict(words).toString());


    }
    
}
