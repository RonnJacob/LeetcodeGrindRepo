package blind;

public class LongestCommonSubsequence {

    public static int lcs_recursive(String s1, String s2, int i, int j){
        if(i == -1 || j == -1){
            return 0;
        }

        if(s1.charAt(i)  == s2.charAt(j)){
            return lcs_recursive(s1, s2, i-1, j-1) + 1;
        }
        else{
            return Math.max(lcs_recursive(s1, s2, i-1, j), lcs_recursive(s1, s2, i, j-1));
        }
    }


    public static int lcs_memo(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] =  1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];

    }
    public static void main(String[] args){
        System.out.println("\n 1143. Longest Common Subsequence");
        String s1 = "babcde";
        String s2 = "acze";

        

        // // Memoized Approach
        long startTime = System.nanoTime();
        System.out.println(lcs_memo(s1, s2));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  
        System.out.println(duration + ": ms for memoized approach");

        // Recursive Approach
        startTime = System.nanoTime();
        System.out.println(lcs_recursive(s1, s2, s1.length() -1, s2.length()-1));
        endTime = System.nanoTime();
        duration = (endTime - startTime);  
        System.out.println(duration + ": ms for recursive approach");

    }
    
}
