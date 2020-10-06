import java.util.*;
public class AlienDict {

    public void createMapping(String[] words){
        Map<Character, Set<Character>> characterGraph = new HashMap<>();
        Map<Character, Integer> indegreeMap = new HashMap<>();
        //Create an adjacency matrix.
        for(String word: words){
            for(int i=0; i<word.length(); i++){
                characterGraph.put(word.charAt(i), new HashSet<>());
                indegreeMap.put(word.charAt(i), 0);
            }
        }

        // Find mapping.
        for(int i=0; i<words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            int index = 0;
            if(word1.length() > word2.length()){
                return;
            }
            while(index < word1.length() && index < word2.length()){
                if(word1.charAt(index) != word2.charAt(index)){
                    if(!characterGraph.get(word1.charAt(index)).contains(word2.charAt(index))){
                        characterGraph.get(word1.charAt(index)).add(word2.charAt(index));
                        int indeg = indegreeMap.get(word2.charAt(index));
                        indegreeMap.put(word2.charAt(index), indeg+1);
                    }   
                    break;
                }
                index++;
            }
        }

        Stack<Character> stk = new Stack<>();
        for(Map.Entry<Character, Set<Character>> entry: characterGraph.entrySet()){
            System.out.println(entry.getKey()  + " " + entry.getValue());
            if(indegreeMap.get(entry.getKey()) == 0){
                stk.push(entry.getKey());
            }
        }

        Set<Character> seenChars = new HashSet<>();
        StringBuilder sb = new StringBuilder("");
        while(!stk.isEmpty()){
            Character popped = stk.pop();
            System.out.println("Popped out: " + popped);
            seenChars.add(popped);
            sb.append(popped.toString());

            for(Character neighbor: characterGraph.getOrDefault(popped, new HashSet<>())){
                int indegreeNeighbor = indegreeMap.get(neighbor)-1;

                System.out.println("Checking out neighbor: " + neighbor + " with indegree count " + indegreeNeighbor);
                indegreeMap.put(neighbor, indegreeNeighbor);
                if(indegreeNeighbor == 0){
                    stk.push(neighbor);
                }
            }
        }

        System.out.println(sb.toString());
    }
    public static void main(String[] arg){
        System.out.println("\n Alien Dict");
        String[] words = new String[]{ "abc", "ab"};
        AlienDict dict = new AlienDict();
        dict.createMapping(words);
    }
 
}
