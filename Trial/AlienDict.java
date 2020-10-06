package Trial;

import java.util.*;
public class AlienDict{

    public void createMapping(String[] words){
        Map<Character, List<Character>> characterGraph = new HashMap<>();
        //Create an adjacency matrix.
        for(String word: words){
            for(int i=0; i<word.length(); i++){
                characterGraph.put(word.charAt(i), new ArrayList<>());
            }
        }

        // Find mapping.
        for(int i=0; i<words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            int index = 0;
            while(index < word1.length() && index < word2.length()){
                if(word1.charAt(index) != word2.charAt(index)){
                    characterGraph.get(word1.charAt(index)).add(word2.charAt(index));
                }
                index++;
            }
        }

        for(Map.Entry<Character, List<Character>> entry: characterGraph.entrySet()){

            System.out.println(entry.getKey() + " " + entry.getValue().toString());
        }
        
    }
    public static void main(String[] args){
        System.out.println("\n Alien Dictionary");
        String[] words = new String[]{ "wrt", "wrf","er","ett","rftt"};
        AlienDict dict = new AlienDict();
        dict.createMapping(words);
    }
}