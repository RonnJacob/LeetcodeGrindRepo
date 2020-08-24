public class FloodFill {

    public static void printArray(int[][] mat){
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                System.out.print(mat[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    public static void dfs(int[][] image, int sr, int sc, int newColor, int oldColor){
        if(sr <0 || sc <0 || sr>=image.length || sc >=image[0].length){
            return;   
        }

        if(image[sr][sc] != oldColor || image[sr][sc] == newColor){
            return;
        }

        oldColor = image[sr][sc];
        image[sr][sc] = newColor;

        dfs(image, sr-1, sc, newColor, oldColor);
        dfs(image, sr+1, sc, newColor, oldColor);
        dfs(image, sr, sc-1, newColor, oldColor);
        dfs(image, sr, sc+1, newColor, oldColor);
    }

    public static void main(String[] args){
        System.out.println("\n733. Flood Fill\n");
        int[][] initialArray = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        printArray(initialArray);

        int[][] floodFilledArray = floodFill(initialArray, 0, 0, 2);
        printArray(floodFilledArray);
        
    }
}