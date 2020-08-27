import java.util.*;

class DoublyLinkedList{
    int key;
    int value;
    DoublyLinkedList prev;
    DoublyLinkedList next;
    DoublyLinkedList(int k, int v){
        key = k;
        value = v;
        prev = null;
        next = null;
    }
}


public class LRUCache {

    static Map<Integer, DoublyLinkedList> mapping;
    static int capacity;
    static int size;
    static DoublyLinkedList head;
    static DoublyLinkedList tail;


    private static void addNode(DoublyLinkedList node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;

    }

    private static void removeNode(DoublyLinkedList node){
        DoublyLinkedList prev = node.prev;
        DoublyLinkedList next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private static void moveToHead(DoublyLinkedList node){
        removeNode(node);
        addNode(node);
    }

    private static DoublyLinkedList popTail(){
        DoublyLinkedList t = tail.prev;
        removeNode(t);
        return t;
    }


    public LRUCache(int cap){
        capacity = cap;
        size = 0;
        mapping = new HashMap<>();
        head = new DoublyLinkedList(0,0);
        tail = new DoublyLinkedList(0,0);

        head.next = tail;
        tail.prev = head;
    }


    public static int get(int k){
        DoublyLinkedList n = mapping.get(k);
        if(n == null){
            System.out.println("Cache Miss for " + k);
            return -1;
        }

        moveToHead(n);
        System.out.println("Cache Hit : " + n.value);
        return n.value;

    }

    public static void put(int k, int v){
        DoublyLinkedList n = mapping.get(k);
        if(n == null){
            DoublyLinkedList newNode = new DoublyLinkedList(k, v);
            addNode(newNode);
            mapping.put(k, newNode);
            System.out.println("Added value for " + k + " : " + v);

            size = size + 1;

            if(size > capacity){
                DoublyLinkedList end = popTail();
                mapping.remove(end.key);
                size = size-1;
            }
        }
        else{
            n.value = v;
            System.out.println("Updated value of " + k + " to " + v);
            moveToHead(n);
        }
    }

    public static void main(String[] args){
        System.out.println("\n146. LRU Cache\n");

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3, 3); 
        cache.get(2);
        cache.put(4, 4);   
        cache.get(1);       
        cache.get(3);       
        cache.get(4);       

    }
    
}