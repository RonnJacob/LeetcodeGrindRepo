import java.util.*;
public class WordSearchII {
    class TrieNode{
        public TrieNode[] children;
        private boolean isEnd;
        private String word = "";
    
        public TrieNode(){
            children = new TrieNode[26];
        }
    
        public void setEndOfWord(){
            isEnd = true;
        }
        public boolean isEnd(){
            return isEnd;
        }

        public void setWord(String word){
            this.word = word;
        }

        public String getWord(){
            return word;
        }
    
    }

    private TrieNode root;
    public WordSearchII(){
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
        parent.setWord(word);
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

    public List<String> findWords(char[][] board, String[] words) {

        // Creates the tree for the word.
        for(String word: words){
            insert(word);
        }


        // Let's get to searching.

        TrieNode parent = root;
        Set<String> result = new HashSet<>();

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(parent.children[board[i][j]-'a'] != null){
                    backtracking(i,j, parent, board, result);
                }
            }
        }

        System.out.println(result.toString());
        return new ArrayList<>(result);
    }

    public void backtracking(int r, int c, TrieNode par, char[][] board, Set<String> result){

        Character letter = board[r][c];
        TrieNode parent = par.children[letter-'a'];

        board[r][c] = '#';
        
        if(!parent.word.equals("")){
            result.add(parent.word);
        }


        if(r-1 >=0 && board[r-1][c] != '#' && parent.children[board[r-1][c]-'a'] != null){
            backtracking(r-1,c, parent, board, result);
        }

        if(r+1 < board.length && board[r+1][c] != '#' && parent.children[board[r+1][c]-'a'] != null){
            backtracking(r+1,c, parent, board, result);
        }

        if(c-1 >=0 && board[r][c-1] != '#' && parent.children[board[r][c-1]-'a'] != null){
            backtracking(r,c-1, parent, board, result);
        }

        if(c+1<board[0].length && board[r][c+1] != '#' && parent.children[board[r][c+1]-'a'] != null){
            backtracking(r,c+1, parent, board, result);
        }

        board[r][c] = letter;


    }

   

    public static void main(String[] args){
        System.out.println("\n212. Word Search II");
        Trie tr = new Trie();
        String[] words = new String[]{"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        char[][] board = new char[][]{{'a','b'}, {'a', 'a'}};
        tr.findWords(board, words);


    }
    
}
