import java.util.*;
public class SortCharactersByFrequency {

    public static String frequencySort(String s) {
        Map<Character, Integer> charCounter = new TreeMap<>();

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)->Integer.compare(b.getValue(), a.getValue()));
        for(Character c: s.toCharArray()){
            charCounter.put(c, charCounter.getOrDefault(c,0)+1);
        }

        pq.addAll(charCounter.entrySet());

        StringBuilder result = new StringBuilder("");
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> a = pq.poll();
            result.append(a.getKey().toString().repeat(a.getValue()));
        }


        return result.toString();
    }

    public static void main(String[] args){
        System.out.println("\n 451. Sort Characters By Frequency");
        String example = "cccaaa";
        System.out.println(frequencySort(example));
    }
    

    
}
