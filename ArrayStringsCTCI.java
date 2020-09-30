import java.util.Arrays;
public class ArrayStringsCTCI {

    public static boolean isUnique(String word){
        int[] charChecker = new int[26];
        for(Character c: word.trim().toCharArray()){
            if(charChecker[c-'a'] == 1){
                return false;
            }
            charChecker[c-'a'] = 1;
        }
        return true;
    }

    public static boolean isPermutation(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        int[] charChecker = new int[26];

        for(Character c: s1.toCharArray()){
            charChecker[c-'a'] += 1;
        }

        for(Character c: s2.toCharArray()){
            if(charChecker[c-'a'] == 0){
                return false;
            }
            charChecker[c-'a'] -= 1;
        }

        return true;
    }

    public static boolean checkPermutation(String s1, String s2){
        int lengthOfMainString = s2.length();
        if(s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length()){
            return false;
        }
        int[] charChecker = new int[26];
        for(Character c: s1.trim().toCharArray()){
            charChecker[c-'a'] = 1;
        }
        for(int i=0; i<s2.length(); i++){
            if(charChecker[s2.charAt(i) -'a'] == 1 && i+s1.length() <= lengthOfMainString){
                System.out.println("Checking permutations: " + s1 + ", " + s2.substring(i, i+s1.length()));
                if(isPermutation(s1, s2.substring(i, i+s1.length()))){
                    return true;
                }
            }
        }
        return false;
    }


    public static String URLify(String word){
       int characterCounter = 0;
       int lastCharacterIndex = 0;
       int spaceCounter = 0;
       for(int i=0; i<word.length(); i++){
           if(word.charAt(i)!= ' ') {
                lastCharacterIndex = i;
                characterCounter += 1;
           }
       }
       spaceCounter = lastCharacterIndex+1-characterCounter;
       int actualIndex = (spaceCounter * 3) + characterCounter-1;
       char[] characterArray = word.toCharArray();
       while(lastCharacterIndex >= 0){
           if(characterArray[lastCharacterIndex] != ' '){
               characterArray[actualIndex--] = characterArray[lastCharacterIndex--];
           }
           else{
               characterArray[actualIndex] = '0';
               characterArray[actualIndex-1] = '2';
               characterArray[actualIndex-2] = '%';
               actualIndex -= 3;
               lastCharacterIndex--;
           }
       }
       return new String(characterArray);
    }

    public static boolean palindromePermutation(String word){
        int[] counter = new int[26];
        int evenValue= 0;
        for(Character c: word.toLowerCase().toCharArray()){
            if(c != ' '){

                counter[c-'a'] += 1;
                if(counter[c-'a']%2 == 0){
                    evenValue++;
                }
                else{
                    evenValue--;
                }
            }
            
        }
        return evenValue == 0 || evenValue == -1;
    }

    public static String stringCompression(String word){
        StringBuilder s = new StringBuilder("");
        if(word.length() == 0) return "";
        if(word.length() == 1) return (word + "1");

        Character currChar = word.charAt(0);
        int charCounter = 1;
        for(int i=1; i<word.length(); i++){
            if(word.charAt(i) != word.charAt(i-1)){
                s.append(currChar);
                s.append(charCounter);
                charCounter = 1;
                currChar = word.charAt(i);
            }
            else{
                charCounter++;
            }
        }

        s.append(currChar);
        s.append(charCounter);
        return s.toString();
    }

    public static boolean oneAwayDeletionHelper(String shorterWord, String longerWord){
        int i=0; 
        int j=0;
        int characterDiff = 0;
        while(i<longerWord.length() && j<shorterWord.length()){
            if(shorterWord.charAt(j) == longerWord.charAt(i)){
                i++;
                j++;
            }
            else{
                characterDiff++;
                if(characterDiff >1){
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static boolean oneWayEditHelper(String shorterWord, String longerWord){
        int i=0; 
        int j=0;
        int characterDiff = 0;
        while(i<longerWord.length() && j<shorterWord.length()){
            if(shorterWord.charAt(j) != longerWord.charAt(i)){
                characterDiff++;
                if(characterDiff >1){
                    return false;
                }
            }
            i++;
            j++;
        }
        return true;
    }
    public static boolean oneAway(String word1, String word2){
        
        if(word1.length() ==  word2.length()+1 || word2.length() == word1.length() + 1){
            String shorterString = word1.length() < word2.length()?word1: word2;
            String longerString = word1.equals(shorterString) ? word2: word1;
            return oneAwayDeletionHelper(shorterString, longerString);
        }
        else if(word1.length() == word2.length()){
            return oneWayEditHelper(word1, word2);
        }
        else{
            return false;
        }
    }
    
    public static boolean isRotation(String s1, String s2){
        return (s1+s1).indexOf(s2) >= 0;
    }

    public static void rotateMatrix(int[][] matrix){
        int n = matrix.length;
        for(int x=0; x<n/2; x++){
            for(int y=x; y<n-x-1; y++){
                int temp = matrix[n-1-y][x];
                matrix[n-1-y][x] = matrix[n-1-x][n-1-y];
                matrix[n-1-x][n-1-y] = matrix[y][n-1-x];
                matrix[y][n-1-x] = matrix[x][y];
                matrix[x][y] = temp;
            }
        }
    }

    public static void main(String[] args){
        System.out.println("\nCTCI : Arrays and Strings\n");

        // IsUnique
        System.out.println("1.1 Is Unique");
        String example1 = "leetcode";
        System.out.println(isUnique(example1));
        String example2 = " a";
        System.out.println(isUnique(example2));
        System.out.println();

        // IsPermutation
        System.out.println("1.2 Check Permutations");
        String word1 = "ab";
        String word2 = "abdboaoo";
        System.out.println(checkPermutation(word1, word2));
        System.out.println();

        // URLify
        System.out.println("\n1.3 URLify\n");
        String urlString = "Mr John Smith    ";
        System.out.println(URLify(urlString));
        System.out.println();


        // Palindrome Permutation
        System.out.println("\n1.4 Palindrome Permutation\n");
        String oneAwayExample = "pale";
        System.out.println(palindromePermutation(oneAwayExample) + " for " + oneAwayExample);
        System.out.println();

        // One Away
        System.out.println("\n1.5 One Away\n");
        String oneAwayWord1 = "ab";
        String oneAwayWord2 = "a";
        System.out.println(oneAway(oneAwayWord1,oneAwayWord2) + " for words : " +  oneAwayWord1 + " and " + oneAwayWord2);
        System.out.println();

        // String Compression
        System.out.println("\n1.6 String Compression\n");
        String stringCompression = "aabcccccaaa";
        System.out.println(stringCompression(stringCompression) + " for " + stringCompression);
        System.out.println();

        // 2D array rotation
        System.out.println("\n1.7 Matrix Rotation by 90 degrees\n");
        int[][] mat = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(Arrays.deepToString(mat));
        rotateMatrix(mat);
        System.out.println(Arrays.deepToString(mat));
        System.out.println();

        // String Rotation
        System.out.println("\n1.9 String Rotation\n");
        String rot1 = "waterbottle";
        String rot2 = "erbottlewat";
        System.out.println(isRotation(rot1, rot2));
        System.out.println();


         
    }


    
}
