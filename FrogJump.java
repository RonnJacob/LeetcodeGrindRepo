import java.util.*;

public class FrogJump{

    public static boolean canCross(int[] stones) {
        int[][] memogap = new int[stones.length][stones.length];
        for(int[] row: memogap){
            Arrays.fill(row, -1);
        }
        return can_Cross( stones, 0, 0, memogap);
    }

    public static boolean can_Cross(int[] stones, int index, int jump, int[][] memogap){
        if(memogap[index][jump] != -1){
            return true;
        }
        for(int i=index+1; i<stones.length; i++){
            int gap = stones[i]-stones[index];
            if(gap>=jump-1 && gap <= jump+1 && can_Cross(stones, i, gap, memogap)){
                    memogap[i][gap] = 1;
                    return true;
            }
        }

        memogap[index][jump] = index==stones.length-1?1:-1; 
        return index == stones.length-1;
    }

    static Map<Integer, List<Integer>> adjMatrix = new HashMap<>();
    class Stone{
        int stoneLocation;
        int jumpsize;
        Stone(int stoneLoc, int jump){
            this.stoneLocation = stoneLoc;
            this.jumpsize = jump;
        }
    }

    public boolean constructAdjacencyMatrix(int[] arr){
        // Start off with 0,0
        // Check if 0+1/0-1 is in set of stone locations
        // Since one is present, we add 1, loc+jumpsize, jumpsize

        // Now we have 1,1 in the queue.
        // Check if 1+2/1+1/1-2 is present
        // Since 1+2 is present we move to 2, and we proceed to add 3,2
        Stack<Stone> stk = new Stack<>();
        stk.push(new Stone(arr[0], 0));
        Set<Integer> setOfStones = new HashSet<>();
        for(int num: arr){
            setOfStones.add(num);
        }

        Set<String> seenStones = new HashSet<>();
        while(!stk.isEmpty()){
            Stone poppedStone = stk.pop();
            int stoneLocation = poppedStone.stoneLocation;
            if(stoneLocation == arr.length-1){
                return true;
            }
            int currJumpSize = poppedStone.jumpsize;
            System.out.println("Stone: " + stoneLocation + " Current Jump Value: " + currJumpSize);

            seenStones.add(stoneLocation+"#"+currJumpSize);
            int start = currJumpSize - 1 >=0 ? currJumpSize-1:0;
            int end = currJumpSize + 1 <arr.length?currJumpSize+2:arr.length;
            for(;start<end;start++){
                int newstoneloc = stoneLocation + start;
                if(!seenStones.contains(newstoneloc+"#"+start) && setOfStones.contains(newstoneloc)){
                    stk.add(new Stone(stoneLocation+start, start));
                }
            }
        }


        return false;
    

    }
    public static void main(String[] args){
        System.out.println("\n403. Frog Jump");
        int[] arr_test1 = new int[]{0,1,2,3,4,8,9,11};
        // System.out.println(canCross(arr_test1));
        FrogJump solution = new FrogJump();
        solution.constructAdjacencyMatrix(arr_test1);
    }


}