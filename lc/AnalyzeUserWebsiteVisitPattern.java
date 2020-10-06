import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {

    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Integer[] indices = new Integer[timestamp.length];
        for(int i=0; i<timestamp.length; i++){
            indices[i] = i;
        }
        Arrays.sort(indices, (a,b)->timestamp[a]-timestamp[b]);

        Map<String, ArrayList<String>> userSiteVisits = new HashMap<>();

        for(int i=0; i<username.length; i++){
            userSiteVisits.putIfAbsent(username[indices[i]], new ArrayList<>());
            userSiteVisits.get(username[indices[i]]).add(website[indices[i]]);
        }

        Map<String, Integer> tripletCount = new HashMap<>();

        for(String user: userSiteVisits.keySet()){
            ArrayList<String> sites = userSiteVisits.get(user);
            Set<String> countedTriplets = new HashSet<>();
            if(sites.size() < 3){
                continue;
            }

            for(int i=0; i<sites.size()-2; i++){
                for(int j = i+1; j<sites.size()-1; j++){
                    for(int k= j+1; k<sites.size(); k++){
                        String triplet = sites.get(i) + "," + sites.get(j) + "," + sites.get(k);
                        if(!countedTriplets.contains(triplet)){
                            tripletCount.put(triplet, tripletCount.getOrDefault(triplet, 0)+1);
                            countedTriplets.add(triplet);
                        }
                    }
                }
            }

        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b)->a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey())
        : Integer.compare(b.getValue(), a.getValue()));

        for(Map.Entry<String, Integer> entry: tripletCount.entrySet()){
            pq.offer(entry);
        }

        return Arrays.asList(pq.poll().getKey().split(","));

    }


    public static void main(String[] args){
        System.out.println("1152. Analyze User Website Visit Pattern");
        String[] username = new String[]{"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = new int[]{1,2,3,4,5,6,7,8,9,10};
        String[] websites = new String[]{"home","about","career","home","cart","maps","home","home","about","career"};
        System.out.println(mostVisitedPattern(username, timestamp, websites));
    }
}