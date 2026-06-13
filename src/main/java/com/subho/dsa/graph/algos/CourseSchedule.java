package com.subho.dsa.graph.algos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {             

        List<Integer> toposort = toposort(numCourses, prerequisites);
        return toposort.size() == numCourses;

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        List<Integer> toposort = toposort(numCourses, prerequisites);
        
        if(toposort.size() == numCourses) {
            for(int i=0; i<order.length; i++) {
                order[i] = toposort.get(i);
            } 
            return order;
        }

        return new int[] {};
    }

    private static List<Integer> toposort(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adList = new ArrayList<>();
        
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            adList.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++) {
            adList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for(List<Integer> adNbrs : adList) {
            for(int i=0; i<adNbrs.size(); i++) {
                indegree[adNbrs.get(i)]++;
            }
        }     

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        List<Integer> toposort = new ArrayList<>();

        while(!q.isEmpty()) {
            int curr = q.poll();
            toposort.add(curr);

            for(int adNbr : adList.get(curr)) {
                indegree[adNbr]--;
                if(indegree[adNbr] == 0) q.offer(adNbr); 
            }
        }  
        
        return toposort;
    }
}
