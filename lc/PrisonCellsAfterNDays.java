import java.util.*;
public class PrisonCellsAfterNDays {

    public static int[] prisonAfterNDays(int[] cells, int N) {
        
        Map<String, Integer> map = new HashMap<>();
        int circle = 0;
        while(N-- > 0){
            int[] prison = new int[cells.length];
            map.put(Arrays.toString(cells), circle++);
            for(int i=1; i<7; i++){
                prison[i] = cells[i-1] == cells[i+1] ? 1 : 0;
            }
            cells = prison;

            if(map.containsKey(Arrays.toString(cells))){
                N %= circle - map.get(Arrays.toString(cells));
            }
        }        
        
        return cells;

    }
    public static void main(String[] args){
        System.out.println("\n957. Prison Cells After N Days");
        int[] cells = new int[]{0,1,0, 1,1,0,0,1};
        int[] resultant = prisonAfterNDays(cells, 7);
        System.out.println(Arrays.toString(resultant));
        

    }

    
}