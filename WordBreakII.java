import java.util.*;

public class WordBreakII {
    class TrieNode{
        private TrieNode[] children;
        private boolean isEnd;
        private String word;

        TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
            word = "";
        }

        public boolean containsLetter(char ch){
            return this.children[ch-'a'] != null;
        }

        public TrieNode addLetter(char ch){
            this.children[ch-'a'] = new TrieNode();
            return this.children[ch-'a'];
        }

        public TrieNode getTrieNodeForLetter(char ch){
            return this.children[ch-'a'];
        }

        public void setEndOfWord(){
            this.isEnd = true;
        }

        public boolean isEnd(){
            return this.isEnd;
        }

        public void setWord(String word){
            this.word = word;
        }

        public String getWord(){
            return this.word;
        }
    }

    TrieNode root;

    public WordBreakII(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode parent = root;
        for(Character c: word.toCharArray()){
            if(!parent.containsLetter(c)){
                parent.addLetter(c);
            }
            parent = parent.getTrieNodeForLetter(c);
        }
        parent.setEndOfWord();
        parent.setWord(word);
    }

    public boolean search(String word){
        TrieNode parent = root;
        for(Character c: word.toCharArray()){
            if(!parent.containsLetter(c)){
                return false;
            }
            parent = parent.getTrieNodeForLetter(c);
        }

        return parent.isEnd();
    }

    public void getOneExampleWordBreak(String word, String result, List<String> results){
        TrieNode p1 = root;
        int i=0;

        if(word.length() == 0){
            return;
        }

        if(!p1.containsLetter(word.charAt(0))){
            return;
        }

        p1 = p1.getTrieNodeForLetter(word.charAt(0));
        while(i<word.length()){
            if(p1.isEnd()){
                result += p1.getWord() + " ";
                if(i==word.length()-1){

                    System.out.println(result);
                }
                getOneExampleWordBreak(word.substring(i+1), result, results);
                break;
            }
            else{
                if(!p1.containsLetter(word.charAt(i+1))){
                    return;
                }
                p1 = p1.getTrieNodeForLetter(word.charAt(i+1));
                i++;
            }
        }
    }

    public void wordBreak(String s, List<String> wordDict) {

        // Insert every word in the trie.
        for(String word: wordDict){
            insert(word);
        }

        // Do a search.
        String result = "";
        List<String> resultant = new ArrayList<>();
        getOneExampleWordBreak(s, result, resultant);
        System.out.println(result);
    }

    public static void main(String[] args){
        System.out.println("\n140. Word Break II");
        WordBreakII obj = new WordBreakII();
        obj.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));

    }
    
}
