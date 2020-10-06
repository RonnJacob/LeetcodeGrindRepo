import java.util.*;
/*

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
            int idMsg = log.indexOf(" ", 0);
            String id = log.substring(0, idMsg);
            String msg = log.substring(idMsg);
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
        String[] logs1 = new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

        reorderLogFiles(logs1);
        System.out.println();

        

    }
}

