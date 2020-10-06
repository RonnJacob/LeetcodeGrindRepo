import java.util.*;

public class FirstUnique {

    static LinkedHashSet<Integer> mp;
    static Map<Integer, Boolean> isUnique;

    public FirstUnique(int[] nums) {
        mp = new LinkedHashSet<>();
        isUnique = new HashMap<>();
        for(int num: nums){
            add(num);
        }

        
    }
    
    public static int showFirstUnique() {
        if(!mp.isEmpty()){
            return mp.iterator().next();
        }
        return -1;
    }
    
    public static void add(int value) {
        if(mp.contains(value)){
            System.out.println("Already contains "  + value);
            isUnique.put(value, false);
            mp.remove(value);
        }
        else{

            if(!isUnique.containsKey(value)){
                System.out.println("Adding  "  + value);
                isUnique.put(value, true);
                mp.add(value);
            }
            
        }
    }

    public static void main(String[] args){
        System.out.println("\n1429. First Unique Number\n");
        FirstUnique obj = new FirstUnique(new int[]{1});
        obj.add(1);
        obj.add(1);
        
    }
    
}