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
        int newWordAdded = -1;
        while(i<word.length()){
            if(p1.isEnd()){
                result += p1.getWord() + " ";
                newWordAdded = p1.getWord().length() + 1;
                if(i==word.length()-1){
                    results.add(result.trim());
                    break;
                }
                getOneExampleWordBreak(word.substring(i+1), result, results);
            }


            
            if(newWordAdded != -1){
                result = result.substring(0,result.length()-newWordAdded);
                newWordAdded = -1;
            }

            if(i+1 >= word.length()){
                return;
            }
            if(!p1.containsLetter(word.charAt(i+1))){
                return;
            }
            p1 = p1.getTrieNodeForLetter(word.charAt(i+1));
            i++;
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        // Insert every word in the trie.
        for(String word: wordDict){
            insert(word);
        }

        // Do a search.
        String result = "";
        List<String> resultant = new ArrayList<>();
        getOneExampleWordBreak(s, result, resultant);
        System.out.println(resultant.toString());
        return resultant;
    }


    protected Set<String> wordSet;
    protected HashMap<String, List<List<String>>> memo;

    public List<String> wordBreak2(String s, List<String> wordDict) {
        wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        memo = new HashMap<String, List<List<String>>>();

        _wordBreak_topdown(s);

        // chain up words together
        List<String> ret = new ArrayList<String>();
        for (List<String> words : memo.get(s)) {
            StringBuffer sentence = new StringBuffer();
            for (String word : words) {
                sentence.insert(0, word);
                sentence.insert(0, " ");
            }
            ret.add(sentence.toString().strip());
        }

        return ret;
    }

    protected List<List<String>> _wordBreak_topdown(String s) {
        if (s.equals("")) {
            List<List<String>> solutions = new ArrayList<List<String>>();
            solutions.add(new ArrayList<String>());
            return solutions;
        }

        if (memo.containsKey(s)) {
            return memo.get(s);
        } else {
            List<List<String>> solutions = new ArrayList<List<String>>();
            memo.put(s, solutions);
        }

        for (int endIndex = 1; endIndex <= s.length(); ++endIndex) {
            String word = s.substring(0, endIndex);
            if (wordSet.contains(word)) {
                List<List<String>> subsentences = _wordBreak_topdown(s.substring(endIndex));
                for (List<String> subsentence : subsentences) {
                    List<String> newSentence = new ArrayList<String>(subsentence);
                    newSentence.add(word);
                    memo.get(s).add(newSentence);
                }
            }
        }
        return memo.get(s);
    }
    public static void main(String[] args){
        System.out.println("\n140. Word Break II");
        WordBreakII obj = new WordBreakII();
        obj.wordBreak("bb", Arrays.asList("a","b","bbb","bbbb"));
        

    }
    
}
