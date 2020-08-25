import java.util.*;
public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> wordCounter = new HashMap<>();
        for(String word: words){
            if(wordCounter.containsKey(word)){
                wordCounter.put(word, wordCounter.get(word) + 1);
            }
            else{
                wordCounter.put(word, 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : Integer.compare(b.getValue(), a.getValue()));
        
        for(Map.Entry<String, Integer> entry: wordCounter.entrySet()){
            pq.offer(entry);
        }

        for(int i=0; i<k; i++){
            result.add(pq.poll().getKey());
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println("\n692. Top K Frequent Words");
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        String[] words2 = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k2 = 4;
        System.out.println("Words: " + Arrays.toString(words));

        System.out.println(topKFrequent(words2, k2).toString());


    }
    
}