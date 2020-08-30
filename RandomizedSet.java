import java.util.*;
public class RandomizedSet {

    static Map<Integer, Integer> location;
    static LinkedList<Integer> randomList;
    static int size;
    static Random r;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        location = new HashMap<>();
        randomList = new LinkedList<>();
        size = 0;
        r = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public static boolean insert(int val) {
        if(!location.containsKey(val)){
            location.put(val, size);
            randomList.add(val);
            size++;
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public static boolean remove(int val) {
        if(location.containsKey(val)){
            int loc = location.get(val);
            int lastEl = randomList.get(size-1);

            randomList.set(loc, lastEl);

            randomList.removeLast();

            size--;
            location.put(lastEl, loc);
            location.remove(val);
            return true;
        }
        return false;
    }

    

    public static void printExistingVals(){
        System.out.println();
        for(Map.Entry<Integer, Integer> entry: location.entrySet()){
            System.out.print(entry.getKey()+"," + entry.getValue() + " ");
        }
        System.out.println();
        for(int i=0; i<randomList.size(); i++){
            System.out.print(randomList.get(i) + " ");
        }
        System.out.println();
    }
    
    /** Get a random element from the set. */
    public static int getRandom() {

        
        if(size == 0){
            return -1;
        }

        return randomList.get(r.nextInt(size));
    }

    public static void main(String[] args){

        System.out.println("\n380. Insert Delete GetRandom O(1)\n");
        RandomizedSet obj = new RandomizedSet();
        
        System.out.println(obj.remove(0));
        System.out.println(obj.remove(0));
        System.out.println(obj.insert(0));
        System.out.println(obj.insert(13));
        System.out.println(obj.insert(2));
        System.out.println(obj.insert(100));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(0));
    }
    
}