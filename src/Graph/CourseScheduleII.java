package Graph;

import java.util.*;

public class CourseScheduleII {

    public static void main(String args[]){
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0},{2, 0},{3, 1},{3, 2}};
        int[] res = findOrder(numCourses, prerequisites);
        for(int r : res){
            System.out.print(r + " ");
        }
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        Set<Integer> visitSet = new HashSet<>();
        Set<Integer> cycleSet = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }
        for(int[] pair : prerequisites){
            int course = pair[0];
            int prereq = pair[1];
            preMap.get(course).add(prereq);
        }

        //a course has three possible states
        //visited -> courses has been added to output
        //visiting -> courses not added to output, but added to cycle
        //unvisited -> courses not added to output or cycle
        List<Integer> res = new ArrayList<>();
        for (int crs = 0; crs < numCourses; crs++) {
            if (!dfs(crs, res, preMap, visitSet, cycleSet)) {
                return new int[0];
            }
        }

        return res.stream().mapToInt(Integer :: intValue).toArray();
    }
    private static boolean dfs(int course, List<Integer> res, Map<Integer, List<Integer>> preMap, Set<Integer> visitSet, Set<Integer> cycleSet){
        if(cycleSet.contains(course)){
            return false;
        }
        if(visitSet.contains(course)){
            return true;
        }
        visitSet.add(course);
        cycleSet.add(course);
        for(int pre : preMap.get(course)){
            if(!dfs(pre, res, preMap, visitSet, cycleSet)){
                return false;
            }
        }
        cycleSet.remove(course);
        res.add(course);
        return true;
    }
}
