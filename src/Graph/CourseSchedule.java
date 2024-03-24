package Graph;

import java.util.*;

public class CourseSchedule {

    public static void main(String args[]){
        int numCourses = 5;
        int[][] prerequisites = new int[][]{{0,1},{0,2},{1,3},{1,4},{3,4}};
        boolean res = canFinish(numCourses, prerequisites);
        System.out.println(res);
    }

    public static HashMap<Integer, List<Integer>> preMap = new HashMap<>();
    public static Set<Integer> visitSet = new HashSet<>();
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //create prerequ map of empty list for each course
        for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }
        //populate map with course and it pre req
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            preMap.get(course).add(prerequisite);
        }
        for (int crs = 0; crs < numCourses; crs++) {
            if (!dfs(crs)) {
                return false;
            }
        }
        return true;
    }

    static boolean dfs(int crs){
        if (visitSet.contains(crs)) {
            return false;
        }
        if (preMap.get(crs).isEmpty()) {
            return true;
        }

        visitSet.add(crs);
        for (int pre : preMap.get(crs)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visitSet.remove(crs);
        preMap.get(crs).clear();
        return true;
    }

}
