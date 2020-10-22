package blind;

import java.util.*;
import java.util.stream.*;
public class EncodeAndDecodeStrings {

    public static String encode(List<String> strs){
        
    if (strs.size() == 0) return Character.toString((char)258);
        StringBuilder sb = new StringBuilder("");
        for(String str: strs){
                sb.append(str);
                sb.append(Character.toString(257));
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static List<String> decode(String s){
        String d = Character.toString((char)258);
        if (s.equals(d)) return new ArrayList();
        String[] strs = s.split(Character.toString(257),-1);
        
        return Arrays.asList(strs);
    }


    public static void main(String[] args){
        System.out.println("\n271. Encode and Decode Strings");
        System.out.println(encode(Arrays.asList(" ")));
        System.out.println(decode(" "));
    }
    
}