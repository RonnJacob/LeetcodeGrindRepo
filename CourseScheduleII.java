import java.util.*;

public class CourseScheduleII {

    public static int[] findOrder(int numCourses, int[][] prerequisites){
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> nodeIndegrees = new HashMap<>();
        Set<Integer> nodesWithZeroDegree = new HashSet<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=0; i<numCourses; i++){
            nodeIndegrees.put(i, 0);
            nodesWithZeroDegree.add(i);
            adjList.put(i, new ArrayList<>());
        }


        for(int i=0; i<prerequisites.length; i++){

            List<Integer> adder = adjList.get(prerequisites[i][1]);
            adder.add(prerequisites[i][0]);
            adjList.put(prerequisites[i][1], adder);

            if(nodeIndegrees.containsKey(prerequisites[i][0])){
                nodeIndegrees.put(prerequisites[i][0], nodeIndegrees.get(prerequisites[i][0])+1);
            }
            else{
                nodeIndegrees.put(prerequisites[i][0], 1);
            }
            nodesWithZeroDegree.remove(prerequisites[i][0]);
        }

        for(Integer d: nodesWithZeroDegree){
            queue.offer(d);
        }

        int[] result = new int[numCourses];
        int k = 0;
        int l  = 0;
        while(!queue.isEmpty()){
            int poppedValue = queue.poll();
            result[k++] = poppedValue;
            l++;
            for(Integer d: adjList.get(poppedValue)){
                int newIndegreeCount = nodeIndegrees.get(d)-1;
                if(newIndegreeCount == 0){
                    queue.offer(d);
                    nodesWithZeroDegree.add(d);
                }
                nodeIndegrees.put(d, newIndegreeCount);
            }
        }

        if(l != numCourses){
            return new int[]{};
        }
        return result;
    }


    public static void main(String[] args){
        System.out.println("\n210. Course Schedule II");


        int numCourses= 2;
        int [][]prerequisites = new int[][]{{1,0}};


        int numCourses2= 4;
        int [][]prerequisites2 = new int[][]{{1,0},{2,0},{3,1},{3,2}};

        int numCourses3= 6;
        int [][]prerequisites3 = new int[][]{{1,0},{2,1},{0,3},{4,3},{3,5},{4,5}};

        int numCourses4= 1;
        int [][]prerequisites4 = new int[][]{};
        System.out.println(Arrays.toString(findOrder(numCourses4, prerequisites4)));


    }
    
}