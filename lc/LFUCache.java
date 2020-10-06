import java.util.*;
public class LFUCache{

     Map<Integer, Integer> keyValueStore;
     Map<Integer, Integer> keyCounts;
     Map<Integer, LinkedHashSet<Integer>> frequencyList;
     int size;
     int minFrequency;


    // Constructor that initiates the maps for storing the necessary maps.
    public LFUCache(int capacity){

        // A map to store the key value stores.
        keyValueStore = new HashMap<>();

        // A map to store the counts of the all the keys.
        keyCounts = new HashMap<>();

        // A map to store the list of elements with a particular frequency.
        frequencyList = new HashMap<>();

        // The size of the cache.
        size = capacity;

        // The minimum frequency of an element.
        minFrequency = -1;

        frequencyList.put(1, new LinkedHashSet<>());
    }


    public void updateMin(int count){
        if(minFrequency == count && frequencyList.get(count).isEmpty()){
            minFrequency = count +1;
        }

        if(frequencyList.get(count).isEmpty()){
            frequencyList.remove(count);
        }
    } 

    public int get(int key) {
        if(size == 0){
            return -1;
        }
        if(!keyValueStore.containsKey(key)){
            return -1;
        }
        
        int count = keyCounts.get(key);
        frequencyList.get(count).remove(key);
        updateMin(count);
        if(!frequencyList.containsKey(count+1)){
            frequencyList.put(count+1, new LinkedHashSet<>());
        }
        frequencyList.get(count+1).add(key);
        keyCounts.put(key, count+1);

        return keyValueStore.get(key);
    }

    public void printList(){
        System.out.println("\n===========Current Cache Values======");
        for(Map.Entry<Integer, LinkedHashSet<Integer>> entry: frequencyList.entrySet()){
            System.out.print(entry.getKey() + " : ");
            for(Integer d: entry.getValue()){
                System.out.print(d + "," + keyValueStore.get(d) + " ");
            }
            System.out.println();
        }
        System.out.println();

       
    }
    
    public void put(int key, int value) {

        if(size == 0){
            return;
        }
        
        // If the key value store contains a key. Update the value and frequency. 
        // Then update the frequency list.
        if(keyValueStore.containsKey(key)){
            keyValueStore.put(key, value);

            // Get frequency of the key.
            int count = keyCounts.get(key);
            
            // Update the keyCount with a new frequency.
            keyCounts.put(key, count +1);

            // Remove the key from that frequency count and add it to the count+1 frequency.
            frequencyList.get(count).remove(key);

            if(!frequencyList.containsKey(count+1)){
                frequencyList.put(count+1, new LinkedHashSet<>());
            }
            
            frequencyList.get(count+1).add(key);
            updateMin(count);
        }
        else{
            if(keyValueStore.size() + 1 > size){
                
                Object d =  frequencyList.get(minFrequency).toArray()[0];
                keyValueStore.remove(d);
                frequencyList.get(minFrequency).remove(d);
                keyCounts.remove(d);
            }
            keyValueStore.put(key, value);
            keyCounts.put(key, 1);
            minFrequency = 1;
            if(!frequencyList.containsKey(1)){
                frequencyList.put(1, new LinkedHashSet<>());
            }
            frequencyList.get(1).add(key);
        }
    }


    public static void main(String[] args){
        System.out.println("\n460. LFU Cache");

        LFUCache cache = new LFUCache(0);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        System.out.println(" \nRetrieving 2 value from cache: " + cache.get(2));
        System.out.println(" \nRetrieving 2 value from cache: " + cache.get(3));
        cache.put(4,4);
        System.out.println(" \nRetrieving 2 value from cache: " + cache.get(1));
        System.out.println(" \nRetrieving 2 value from cache: " + cache.get(3));
        System.out.println(" \nRetrieving 2 value from cache: " + cache.get(4));
        cache.printList();

    }
}