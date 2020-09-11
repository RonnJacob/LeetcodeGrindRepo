public class Trie {

    class TrieNode{
        public TrieNode[] children;
        private boolean isEnd;
    
        public TrieNode(){
            children = new TrieNode[26];
        }
    
        public void setEndOfWord(){
            isEnd = true;
        }
        public boolean isEnd(){
            return isEnd;
        }
    
    }

    private TrieNode root;
    public Trie(){
        root= new TrieNode();
    }

    public void insert(String word) {
        TrieNode parent = root;
        for(Character ch: word.toCharArray()){
            if(parent.children[ch-'a'] == null){
                parent.children[ch-'a'] = new TrieNode();
            }
            parent = parent.children[ch-'a'];
        }
        parent.setEndOfWord();
    }

    public boolean search(String word){
        TrieNode parent = root;
        for(Character ch: word.toCharArray()){
            if(parent.children[ch-'a'] == null){

                System.out.println("NOT FOUND");
                return false;
            }
            parent = parent.children[ch-'a'];
        }
        if(parent.isEnd()){
            System.out.println("FOUND");
            return true;
        }

        System.out.println("NOT FOUND");
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode parent = root;
        for(Character ch: prefix.toCharArray()){
            if(parent.children[ch-'a'] == null){

                return false;
            }
            parent = parent.children[ch-'a'];
        }

        return true;
    }
    
}
