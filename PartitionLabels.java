import java.util.*;
public class PartitionLabels {

    public static List<Integer> partitionLabel(String S){
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> lastIndexOfCharacterMapping = new HashMap<>();
        for(int i=0; i<S.length(); i++){
            lastIndexOfCharacterMapping.put(S.charAt(i), i);
        }


        int lastIndexBiggest = lastIndexOfCharacterMapping.get(S.charAt(0));
        int k=1;
        for(int i=0; i<S.length(); i++){
            lastIndexBiggest = Math.max(lastIndexBiggest, lastIndexOfCharacterMapping.get(S.charAt(i)));
            if(i==lastIndexBiggest){
                result.add(k);
                k=0;
            }
            k++;
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println("\n763. Partition Labels\n");

        String S = "ababcbacadefegdehijhklij";
        System.out.println("String: " + S + "\n");
        System.out.println(partitionLabel(S).toString());

    }
    
}