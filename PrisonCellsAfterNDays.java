
import java.util.*;
public class PrisonCellsAfterNDays {

    public static void occupyCells(int[] cells){
        Map<Integer, Integer> cellsMapping = new HashMap<>();
        for(int i=0; i<cells.length; i++){
            cellsMapping.put(i, cells[i]);
        }


        for(int i=1; i<cells.length-1; i++){
            if(cellsMapping.get(i-1) == cellsMapping.get(i+1)){
                cells[i] = 1;
            }
            else{
                cells[i] = 0;
            }
        }
        cells[0] = 0;
        cells[cells.length-1] = 0;
    }

    public static void showInmates(int[] cells){
        for(int i=0; i<cells.length; i++){
            System.out.print(cells[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        System.out.println("\n957. Prison Cells After N Days");
        int[] cells = new int[]{0,1,0, 1,1,0,0,1};
        for(int i=0; i<7; i++){
            occupyCells(cells);
            showInmates(cells);
        }

    }
    
}