import java.util.*;
public class MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        Collections.addAll(bannedWords, banned);

        Map<String, Integer> wordCounter = new HashMap<>();
        String[] words = paragraph.toLowerCase().split(" ");

        String mostCommonW = "";
        int maxCount = 0;
        for(String word: words){
            String[] newWord = word.split("[!?',;.]");
            if(!bannedWords.contains(newWord[0])){
                int count;
                if(wordCounter.containsKey(newWord[0])){
                    count = wordCounter.get(newWord[0]) + 1;
                    wordCounter.put(newWord[0], count);
                    
                }
                else{
                    count = 1;
                    wordCounter.put(newWord[0], 1);
                }
                if(count > maxCount){
                    mostCommonW = newWord[0];
                    maxCount = count;
                }
            }
            
        }

        return mostCommonW;
    }
    
    public static void main(String[] args){
        System.out.println("\n819. Most Common Word\n");
        String[] banned = new String[]{"bob", "hit"};
        System.out.println("Banned Words");
        for(String word: banned){
            System.out.print(word + " ");
        }
        String paragraph = "Bob. hIt, baLl";
        System.out.println("\nParagraph:" + "\n" + paragraph);

        System.out.println("\nMost Common Word : " + mostCommonWord(paragraph, banned));

    }
    
}