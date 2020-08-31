import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {

    // Map<Username, TreeMap<TimeStamp, Website>> mp = new


    public static List<String> getThreeSequences(Map<String, TreeMap<Integer, String>> visits){
        List<String> visitResults = new ArrayList<>();
        for(Map.Entry<String, TreeMap<Integer, String>> entry: visits.entrySet()){  
            TreeMap<Integer, String> siteVisits = entry.getValue();
            System.out.println(entry.getKey());
            int k=0;
            StringBuilder sb = new StringBuilder("");
            for(Map.Entry<Integer, String> sites: siteVisits.entrySet()){
                sb.append(sites.getValue()+"#");

            }
            visitResults.add(sb.toString());
            sb = new StringBuilder("");
        }
        return visitResults;
    }

    public static String counter(List<String> visits){
        TreeMap<String, Integer> mp = new TreeMap<>();
        int maxLevel = 0;
        String maxVisits = "";
        for(String visit: visits){
            System.out.println("\n" + visit );
            String[] sities = visit.split("#");
            int i=0; 
            while(i+2<sities.length){
                String s = sities[i] + "," +sities[i+1] + "," + sities[i+2];
                System.out.println(s);
                if(mp.containsKey(s)){
                    int count = mp.get(s) + 1;
                    if(maxLevel < count ){
                        maxLevel = count;
                        maxVisits = s;
                    }
                    else if( maxLevel == count){
                        maxVisits =  s.compareTo(maxVisits) < 0  ? s : maxVisits;
                    }
                    mp.put(s, mp.get(s)+1);
                }
                else{
                    if(maxLevel == 0){
                        maxLevel = 1;
                        maxVisits = s;
                    }
                    else if(maxLevel == 1){
                        maxVisits =  s.compareTo(maxVisits) < 0  ? s : maxVisits;
                    }
                    mp.put(s, 1);
                }
                i++;
            }
        }
        return maxVisits;
    }
    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = website.length;
        if(username.length != n || timestamp.length != n){
            return new ArrayList<>();
        }

        Map<String, TreeMap<Integer, String>> uNameVisitsMap = new HashMap<>();
        for(int i=0; i<n; i++){
            if(!uNameVisitsMap.containsKey(username[i])){
                TreeMap<Integer, String> websiteVisits = new TreeMap<>((a,b)-> Integer.compare(a, b));
                websiteVisits.put(timestamp[i], website[i]);
                uNameVisitsMap.put(username[i], websiteVisits);
            }
            else{
                TreeMap<Integer, String> websiteVisits = uNameVisitsMap.get(username[i]);
                websiteVisits.put(timestamp[i], website[i]);
                uNameVisitsMap.put(username[i], websiteVisits);
            }
        }

        String[] results = counter(getThreeSequences(uNameVisitsMap)).split(",");
        return Arrays.asList(results);
    }


    public static void main(String[] args){
        String[] username = new String[]{"zkiikgv","zkiikgv","zkiikgv","zkiikgv"};
        int[] timestamp = new int[]{436363475,710406388,386655081,797150921};
        String[] websites = new String[]{"wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"};
        mostVisitedPattern(username, timestamp, websites);
    }
}