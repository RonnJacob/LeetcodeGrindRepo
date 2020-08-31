import java.util.*;
public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList){
        Set<String> set = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for(String i : wordList){
            set.add(i);
        }
        if(!set.contains(endWord)){
            return 0;
        }
        LinkedList<String> q = new LinkedList<>();
        q.add(beginWord);
		seen.add(beginWord);
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0; k<size; k++){
                String word = q.poll();
                char[] w=word.toCharArray();
                for(int i = 0; i<w.length; i++){
                    char c = w[i];
                    for(char replace = 'a'; replace<='z'; replace++){
                        if(replace==c)
                            continue;
                        w[i] = replace;
                        String newWord = String.valueOf(w);
                        if(newWord.equals(endWord)){
                            return level+1;
                        }
                        if(!seen.contains(newWord) && set.contains(newWord)){
                            q.add(newWord);
                        }
                        seen.add(newWord);
                    }
                    w[i] = c;
                }
            }
            level++;
        }
        return 0;
    }
    public static void main(String[] args){
        System.out.println("\n127. Word Ladder");
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = new String[]{"hot","dot","dog","lot","log","cog"};
        System.out.println(ladderLength(beginWord, endWord, Arrays.asList(wordList)));


    }
    
}