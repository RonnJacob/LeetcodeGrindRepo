import java.util.*;
public class NumberofAtoms {

    public static String countOfAtoms(String formula) {
        int index = 0;
        int N = formula.length();
        Stack<TreeMap<String, Integer>> stk = new Stack<>();

        

        stk.push(new TreeMap());
        while(index < N){
            if(formula.charAt(index) == '('){
                stk.push(new TreeMap<>());
                index++;
            }
            else if(formula.charAt(index) == ')'){
                Map<String, Integer> mp = stk.pop();
                index++;
                int start = index;
                int multiplicity = 1;
                while(index < N && Character.isDigit(formula.charAt(index))){
                    index++;
                }

                if(index > start){
                    multiplicity = Integer.parseInt(formula.substring(start, index));
                }
                for(String c: mp.keySet()){
                    int v = mp.get(c);
                    stk.peek().put(c, stk.peek().getOrDefault(c,0) + v * multiplicity );
                }
            }
            else{
                int elStart = index;
                // First character is a uppercase
                index++;
    
                //Iterate till you don't find lowercase character
                while(index < N && Character.isLowerCase(formula.charAt(index))){
                    index++;
                }
    
                String element = formula.substring(elStart, index);
                
                int countStart = index;
    
               //Iterate till you don't find digits 
                while(index < N && Character.isDigit(formula.charAt(index))){
                    index++;
                }
    
                Integer c = 1;
                if(index > countStart){
                    c = Integer.parseInt(formula.substring(countStart, index));
                }
    
                stk.peek().put(element, stk.peek().getOrDefault(element, 0) + c);
            }
            
        }

        StringBuilder ans = new StringBuilder();
        for (String name: stk.peek().keySet()) {
            ans.append(name);
            int multiplicity = stk.peek().get(name);
            if (multiplicity > 1) ans.append("" + multiplicity);
        }
        System.out.println(ans.toString());
        return new String(ans);

    }

    public static void main(String[] args){
        System.out.println("\n726. Number of Atoms");
        String formula = "K4(ON(SO3)2)2";
        countOfAtoms(formula);
    }
    
}
