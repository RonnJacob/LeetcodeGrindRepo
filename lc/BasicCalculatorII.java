import java.util.*;

public class BasicCalculatorII {


    public static int calculate(String s){

        String newS = removeSpacesInString(s);
        List<Character> ops = getOperators(newS);
        List<Integer> nums = getNumbers(newS);

        Stack<Integer> stk = new Stack<>();
        stk.push(nums.get(0));
        int numIndex = 1;
        int opIndex = 0;

        while(numIndex<nums.size() && opIndex < ops.size()){
            if(ops.get(opIndex) == '*'){
                stk.push(stk.pop() * nums.get(numIndex));
            }
            else if (ops.get(opIndex) == '/'){
                stk.push(stk.pop()/nums.get(numIndex));
            }

            else if (ops.get(opIndex) == '-'){
                stk.push(nums.get(numIndex)*-1);
            }

            else if (ops.get(opIndex) == '+'){
                stk.push(nums.get(numIndex));
            }
            numIndex++;
            opIndex++;
        }

        int answer = 0;
        while(!stk.isEmpty()){
            answer += stk.pop();
        }

        return answer;
    }
    public static List<Character> getOperators(String expression){
        List<Character> operators = new ArrayList<>();
        String[] expr_split = expression.split("[1234567890]");
        for(String op: expr_split){
            if(op.trim().length() != 0){
                operators.add(op.charAt(0));
            }
        }
        return operators;
    }


    public static String removeSpacesInString(String expression){
        StringBuilder sb = new StringBuilder("");
        String[] exp = expression.split("[ ]");
        for(String s: exp){
            sb.append(s);
        }
        return sb.toString();
    }

    public static List<Integer> getNumbers(String expression){
        List<Integer> numbers = new ArrayList<>();
        String[] expression_split = expression.split("[+-/*]");
        for(String number: expression_split){
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }
    public static void main(String[] args){
        System.out.println("\n227. Basic Calculator II\n");
        String expr = "3+2*2";

        System.out.println(calculate(expr));


    }
    
}