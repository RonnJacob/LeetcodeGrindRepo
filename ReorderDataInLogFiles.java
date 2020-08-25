import java.util.*;
/*
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at 
least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically 
ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.

INT MAX VALUE CHECK NOTE !!!!!!!!!!!!!! Check for numbers not in the integer range.
 */



public class ReorderDataInLogFiles{

    public static boolean isDigitLog(String logMessage){
        int id_msg = logMessage.indexOf(" ", 0);
        String msg = logMessage.substring(id_msg+1, id_msg+2);
        try{
            Integer.parseInt(msg);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public static String[] reorderLogFiles(String[] logs) {
        System.out.println(Arrays.toString(logs));
        String[] result = new String[logs.length];

        List<String> digLogs = new ArrayList<>();
        Map<String, String> letterLogs = new TreeMap<>((a,b)-> a.compareTo(b));
        
        for(String log: logs){
            int id_msg = log.indexOf(" ", 0);
            String id = log.substring(0, id_msg);
            String msg = log.substring(id_msg);
            if(isDigitLog(log)){
                digLogs.add(log);
            }
            else{
                letterLogs.put(msg + "#" + id, log);
            }
        }

        int k=0;
        for(Map.Entry<String, String> entry: letterLogs.entrySet()){
            result[k] = entry.getValue();
            System.out.print(entry.getValue() + " ");
            k++;
        }

        for(int i=0; i<digLogs.size(); i++){
            result[k] = digLogs.get(i);
            System.out.print(digLogs.get(i) + " ");
            k++;
        }

        return result;
    }
    public static void main(String[] args){
        System.out.println("937. Reorder Data in Log Files\n");

        // Leetcode Example.
        // String[] logs1 = new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

        // Only letters
        // String[] logs2 = new String[] {"let1 art can","let2 own kit dig","let3 art zero"};

        // Only letters - tie.
        String[] logs3 = new String[] {"let2 art zero","let3 own kit dig","let1 art zero"};

        //Only digit
        // String[] logs4 = new String[] {"dig2 3 6", "dig3 1 9","dig1 4 3"};

        reorderLogFiles(logs3);
        System.out.println();

        

    }
}

