import java.util.*;
public class GroupAnagrams {
 
    public static String initializeCharArrayCounter(String word){

        int[] charArray = new int[26];
        for(int i=0; i<word.length(); i++){
            charArray[word.charAt(i)-'a']++;
        }

        StringBuilder s = new StringBuilder("");
        for(Integer i: charArray){
            s.append(i.toString());
        }
        return s.toString();
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for(String word: strs){
            List<String> sameAnagram;
            String charCounter = initializeCharArrayCounter(word);
            if(mp.containsKey(charCounter)){
                sameAnagram = mp.get(charCounter);
                sameAnagram.add(word);
                mp.put(charCounter, sameAnagram);
            }
            else{
                sameAnagram = new ArrayList<>();
                sameAnagram.add(word);
                mp.put(charCounter, sameAnagram);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: mp.entrySet()){
            result.add(entry.getValue());
        }

        return result;
    }
    
    public static void main(String[] args){
        System.out.println("\n49. Group Anagrams\n");
        String[] words = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(Arrays.toString(words) + "\n");
        System.out.println(groupAnagrams(words).toString());


    }



}