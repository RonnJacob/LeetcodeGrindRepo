import java.util.*;
public class BaseballGame {


    Stack<Integer> stk = new Stack<>();

    public void addIntPoint(String num){
        stk.push(Integer.parseInt(num));
    }

    public void removeInvalidPoint(){
        stk.pop();
    }

    public void doublePoint(){
        if(stk.isEmpty()){
            stk.push(0);
        }
        else{
            stk.push(stk.peek()*2);
        }
    }

    public void addLastTwo(){
        if(stk.isEmpty()){
            stk.push(0);
        }
        else if(stk.size() == 1){
            stk.push(stk.peek());
        }
        else{
            stk.push(stk.get(stk.size()-1) + stk.get(stk.size()-2));
        }
    }
    public int calPoints(String[] ops) {

        for(String op: ops){
            if(op.equals("C")){
                removeInvalidPoint();
            }
            else if(op.equals("D")){
                doublePoint();
            }
            else if(op.equals("+")){
                addLastTwo();
            }
            else{
                addIntPoint(op);
            }
        }

        int sum = 0;
        while(!stk.isEmpty()){
            sum += stk.pop();
        }
        return sum;

    }
    public static void main(String[] args){
        System.out.println("\n682. Baseball Game");
        String[] inp = new String[]{"36","28","70","65","C","+","33","-46","84","C"};
        BaseballGame game = new BaseballGame();
        System.out.println(game.calPoints(inp));
    }
    
}
