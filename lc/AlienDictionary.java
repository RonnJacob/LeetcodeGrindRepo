import java.util.*;
public class AlienDictionary {

    public static String alienOrder(String[] words){

        Map<Character, List<Character>> adjacentCharacters = new HashMap<>();
        Map<Character, Integer> indegreeCounts = new HashMap<>();


        for(int i=0; i<words.length; i++){
            for(char c: words[i].toCharArray()){
                adjacentCharacters.put(c, new ArrayList<>());
                indegreeCounts.put(c, 0);
            }
        }

        // Iterate till second last word, and start comparing letter by letter to see
        // till where the letter mismatches to figure out order.

        for(int i=0; i<words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];

            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }
            for(int j=0; j<Math.min(word1.length(), word2.length()); j++){

                // Can't say not equal to because of how we don't know the ordering.
                if(word1.charAt(j)!=word2.charAt(j)){
                    adjacentCharacters.getOrDefault(word1.charAt(j), new ArrayList<>()).add(word2.charAt(j));
                    indegreeCounts.put(word2.charAt(j), indegreeCounts.getOrDefault(word2.charAt(j), 0)+1);
                    break;
                }
            }

        }


        Queue<Character> queue = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry: indegreeCounts.entrySet()){
            if(entry.getValue() == 0){
                queue.offer(entry.getKey());
            }
        }
        StringBuilder sb = new StringBuilder("");
        Set<Character> visitedChar = new HashSet<>();
        while(!queue.isEmpty()){
            Character poppedChar = queue.poll();
            visitedChar.add(poppedChar);
            sb.append(poppedChar.toString());
            for(Character adjChar: adjacentCharacters.get(poppedChar)){
                int counter = indegreeCounts.getOrDefault(adjChar, 0)-1;
                indegreeCounts.put(adjChar, counter);
                if(counter == 0 && !visitedChar.contains(adjChar)){
                    queue.offer(adjChar);
                }

            }
        }


        if(sb.toString().length() < indegreeCounts.size()){
            return "";
        }
        return sb.toString();

    }

    public static void main(String[] args){
        System.out.println("\n269. Alien Dictionary");
        String[] words = new String[]{"ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"};
        System.out.println(alienOrder(words));

    }
    
}
