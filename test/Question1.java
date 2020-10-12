import java.util.*;

public class Question1{


    class RoadLevel{
        Character roadChar;
        int level;
        RoadLevel(Character c, int l){
            this.roadChar = c;
            this.level = l;
        }
    }
    public Map<Character, List<Character>> createGraph(char[][] roads){
        Map<Character, List<Character>> adjRoads = new HashMap<>();
        for(int i=0; i<roads.length; i++){
            Character src= roads[i][0];
            Character dst = roads[i][1];
            if(!adjRoads.containsKey(src)){
                adjRoads.put(src, new ArrayList<>());
            }
            if(!adjRoads.containsKey(dst)){
                adjRoads.put(dst, new ArrayList<>());
            }

            adjRoads.getOrDefault(src, new ArrayList<>()).add(dst);
            adjRoads.getOrDefault(dst, new ArrayList<>()).add(src);
        }

        return adjRoads;
    }

    public int countSteps(Map<Character, List<Character>> adjRoads, int pace, Character startChar){
        RoadLevel start = new RoadLevel(startChar, 0);
        Queue<RoadLevel> queue = new LinkedList<>();
        queue.add(start);
        int minLevelPopped = Integer.MAX_VALUE;
        Set<Character> visited = new HashSet<>();
        while(!queue.isEmpty()){
            RoadLevel poppedRoad = queue.poll();
            Character roadPopped = poppedRoad.roadChar;
            int levelPopped = poppedRoad.level;
            System.out.println("Popped out road and level " + roadPopped.toString() + " : " + levelPopped);
            visited.add(roadPopped);
            if(roadPopped == 'H'){
                if(levelPopped < minLevelPopped){
                    minLevelPopped = levelPopped;
                }
            }

            for(Character neighborRoads: adjRoads.get(roadPopped)){
                if(!visited.contains(neighborRoads)){
                    queue.add(new RoadLevel(neighborRoads, levelPopped+pace));
                }
            }
        }
        System.out.println("\nDone");
        return minLevelPopped ==  Integer.MAX_VALUE ? -1 : minLevelPopped;
    }


    public static String raceWinner(int pace, char[][] roads){
        Question1 s = new Question1();
        Map<Character, List<Character>> mp = s.createGraph(roads);
        if(s.countSteps(mp, 1, 'F') < s.countSteps(mp, pace, 'Y')){
            return "FRIEND WINS";
        }
        else{
            return "YOU WIN";
        }
    }

    public static void main(String[] args){
        char[][] roads = new char[23][2];
        roads[0][0] = 'H';
        roads[0][1] = 'U';

        roads[1][0] = 'C';
        roads[1][1] = 'E';

        roads[2][0] = 'I';
        roads[2][1] = 'G';

        roads[3][0] = 'J';
        roads[3][1] = 'K';
        
        roads[4][0] = 'L';
        roads[4][1] = 'F';

        roads[5][0] = 'A';
        roads[5][1] = 'B';

        roads[6][0] = 'Y';
        roads[6][1] = 'A';

        roads[7][0] = 'B';
        roads[7][1] = 'H';

        roads[8][0] = 'U';
        roads[8][1] = 'E';

        roads[9][0] = 'C';
        roads[9][1] = 'I';

        roads[10][0] = 'G';
        roads[10][1] = 'J';

        roads[11][0] = 'K';
        roads[11][1] = 'L';

        roads[12][0] = 'F';
        roads[12][1] = 'Q';

        roads[13][0] = 'B';
        roads[13][1] = 'N';
        
        roads[14][0] = 'F';
        roads[14][1] = 'Z';

        roads[15][0] = 'N';
        roads[15][1] = 'O';

        roads[16][0] = 'C';
        roads[16][1] = 'O';

        roads[17][0] = 'X';
        roads[17][1] = 'R';

        roads[18][0] = 'P';
        roads[18][1] = 'G';

        roads[19][0] = 'X';
        roads[19][1] = 'P';

        roads[20][0] = 'L';
        roads[20][1] = 'R';

        roads[21][0] = 'R';
        roads[21][1] = 'Z';

        roads[22][0] = 'Q';
        roads[22][1] = 'Z';

        System.out.println(raceWinner(2, roads));

    }
}