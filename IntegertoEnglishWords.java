public class IntegertoEnglishWords{

    public static String singles(int num){
        switch(num){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default: return "";
        }
    }

    public static String twenties(int num){
        switch(num){
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
            default: return "";
        }
    }

    public static String tens(int num){
        switch(num){
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
            default: return "";
        }
    }

    public static String places(int place){
        switch(place){
            case 0: return "";
            case 1: return "Thousand";
            case 2: return "Million";
            case 3: return "Billion";
            case 4: return "Trillion";
            default: return "";
        }
    }

    public static String convertToString(int num){
        if(num == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        if(num >= 100){
            sb.append(singles(num/100) + " Hundred ");
            num = num%100;
        }
        if(num < 20 && num >=10){
            sb.append(twenties(num));
        }
        else{
            if(tens(num/10)!= ""){  
                sb.append(tens(num/10) + " ");
            }
            num = num%10;
            sb.append(singles(num));
        }
        return sb.toString().trim();
    }

    public static String convertToWords(String word, int l, int r, int level){
        if(l>r){
            return "";
        }
        
        
        if(r-l <= 3){
            Integer n = Integer.parseInt(word.substring(l,r));
            String res = convertToString(n);
            if(n!=0){
                
                return res + " " + places(level) + " ";
            }
            else{
                return "";
            }
            
        }

        return convertToWords(word, l, r-3, level+1) + convertToWords(word, r-3, r, level);
    }
    
    
    public String numberToWords(int num) {
        
        if(num == 0){
            return "Zero";
        }
        String numString = String.valueOf(num);
        return convertToWords(numString, 0, numString.length(), 0).trim();
    }
}
        