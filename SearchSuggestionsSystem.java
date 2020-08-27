import java.util.*;

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    List<String> suggestedWords;

    TrieNode(){
        for(int i=0; i<26; i++){
            children[i] = null;
        }
        suggestedWords = new ArrayList<>();
    }
}
public class SearchSuggestionsSystem {

    

    static TrieNode root;
    public static void insert(String key){
        TrieNode inserter = root;
        for(int i=0; i<key.length(); i++){
            int index = key.charAt(i) - 'a';
            if(inserter.children[index] == null){
                inserter.children[index] = new TrieNode();
            }
            inserter = inserter.children[index];
            if(inserter.suggestedWords.size() <3){
                inserter.suggestedWords.add(key);
            }
        }
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord)   {
        
        root = new TrieNode();
        List<String> productsList = Arrays.asList(products);
        Collections.sort(productsList);
        for(String product: productsList){
            insert(product);
        }
        
        List<List<String>> res = new ArrayList<>();
        for(int i=0; i<searchWord.length(); i++){
            System.out.print(searchWord.substring(0,i+1) + " ---> ");
            int index = searchWord.charAt(i) - 'a';
            if(root!= null){
                root = root.children[index];
            }

            if(root == null){
                res.add(new ArrayList<>());
                System.out.println("[]");
            }

            else{
                res.add(root.suggestedWords);
                System.out.println(root.suggestedWords.toString());
            }
        }
        return res;
        
    }
    public static void main(String[] args){
        System.out.println("\n 1268. Search Suggestions System\n");
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        System.out.println();
        suggestedProducts(products, searchWord);
    }
    
}