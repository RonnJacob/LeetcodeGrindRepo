import java.util.*;
public class Citrix {

    static int countPairs(List<Integer> numbers, int k){
        Map<Integer, LinkedList<Integer>> mp = new HashMap<>();
        int count = 0;
        for(int i=0; i<numbers.size(); i++){
            LinkedList<Integer> s = mp.getOrDefault(numbers.get(i), new LinkedList<>());
            s.add(i);
            mp.put(numbers.get(i), s);
        }

        for(int i=0; i<numbers.size(); i++){
            if(mp.keySet().contains(numbers.get(i)-k)){

                mp.get(numbers.get(i)-k).pop();
                if(mp.get(numbers.get(i)-k).isEmpty()){
                    mp.remove(numbers.get(i)-k);
                }
                count++;

            }
        }
        return count;
    }

    static int countPairs2(List<Integer> numbers, int k, int[] arr){
        int count = 0; 
        Arrays.sort(arr); // Sort array elements 
    
        numbers.sort((a,b)->Integer.compare(a,b));
        int l = 0; 
        int r = 0; 
        while(r < arr.length) 
        { 
            if(arr[r] - arr[l] == k) 
            { 
                count++; 
                l++; 
                r++; 
            } 
            else if(arr[r] - arr[l] > k) 
                l++; 
            else // arr[r] - arr[l] < sum 
                r++; 
        }  
        return count; 
    }


    public static String convertToCharacterCountArray(String word){
        int[] charCounter = new int[26];
        for(Character c: word.toCharArray()){
            charCounter[c-'a']+=1;
        }
        return Arrays.toString(charCounter);
    }
    public static long[] checkAnagrams(List<String> words, List<String> sentences){
        Map<String, Integer> anagramCounter = new HashMap<>();
        for(String word: words){
            String anagramSerialized = convertToCharacterCountArray(word);
            anagramCounter.put(anagramSerialized, anagramCounter.getOrDefault(anagramSerialized, 0)+1);
        }

        long[] result = new long[sentences.size()];
        int resultIdx = 0;
        for(String sentence: sentences){
            String[] wordsOfSentence = sentence.split(" ");
            int permCounter = 1;
            for(String word: wordsOfSentence){
                permCounter *= anagramCounter.getOrDefault(convertToCharacterCountArray(word), 1);
            }
            result[resultIdx++] = permCounter;
        }

        return result;
    }

    public static void main(String[] args){
        String[] words = new String[]{"the", "bats", "tabs", "in", "cat", "act"};
        String[] sentences = new String[] {"cat the bat", "a", "act tabs in"};
        System.out.println(Arrays.toString(checkAnagrams(Arrays.asList(words), Arrays.asList(sentences))));
    }


    
}
