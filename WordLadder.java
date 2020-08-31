import java.util.*;
public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList){
        Set<String> wordListSet = new HashSet();

        for(String word: wordList){
            wordListSet.add(word);
        }
        
        if(!wordListSet.contains(endWord)){
            System.out.println("0");
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        int level = 1;

        queue.offer(beginWord);
        
        while(!queue.isEmpty()){
            for(int i=0; i<queue.size(); i++){
                String word = queue.poll();
                char[] wordArray = word.toCharArray();
                for(int j=0; j<wordArray.length; j++){
                    char originalChar = wordArray[j];
                    for(char k = 'a' ; k<'z'; k++){
                        if(wordArray[j] == k) continue;
                        wordArray[j] = k;
                        String wordUpdated = String.valueOf(wordArray);
                        if(wordUpdated.equals(endWord)){
                            return level+1;
                        }

                        if(wordListSet.contains(wordUpdated)){
                            wordListSet.remove(wordUpdated);
                            queue.offer(wordUpdated);
                        }
                    }
                    wordArray[j] = originalChar;
                }
            }
            level++;
        }
        return level;
    }
    public static void main(String[] args){
        System.out.println("\n127. Word Ladder");
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = new String[]{"hot","dot","dog","lot","log","cog"};
        System.out.println(ladderLength(beginWord, endWord, Arrays.asList(wordList)));


    }
    
}