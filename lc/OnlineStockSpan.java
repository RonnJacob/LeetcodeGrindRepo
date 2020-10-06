import java.util.*;
public class OnlineStockSpan {

    Stack<Integer> prices, weights;
    public OnlineStockSpan() {
        prices = new Stack<>();
        weights = new Stack<>();

        
    }
    
    public int next(int price) {
        int weight = 1;

        while(!prices.isEmpty() && prices.peek() <= price){
            prices.pop();
            weight += weights.pop();
        }

        prices.push(price);
        weights.push(weight);
        System.out.println(weight);
        return weight;
        
    }

    public static void main(String[] args){
        System.out.println("\n901. Online Stock Span\n");
        OnlineStockSpan solution = new OnlineStockSpan();
        solution.next(100);
        solution.next(80);
        solution.next(60);
        solution.next(70);
        solution.next(60);
        solution.next(75);
        solution.next(85);
    }
    
}