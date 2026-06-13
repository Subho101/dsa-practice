package com.subho.dsa.algos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.subho.dsa.graph.algos.CourseSchedule;

public class CourseScheduleTest {

    @Test
    public void canFinishTest1() {
        int numCourses = 2; 
        int[][] prerequisites = {{1,0}};

        assertTrue(CourseSchedule.canFinish(numCourses, prerequisites));
    }

    @Test
    public void canFinishTest2() {
        int numCourses = 2; 
        int[][] prerequisites = {{1,0}, {0,1}};

        assertFalse(CourseSchedule.canFinish(numCourses, prerequisites));
    }

    @Test
    public void findOrderTest3() {
        int numCourses = 2; 
        int[][] prerequisites = {{1,0}};

        assertArrayEquals(new int[] {0,1}, CourseSchedule.findOrder(numCourses, prerequisites));
    }

    @Test
    public void findOrderTest4() {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

        assertArrayEquals(new int[] {0,1,2,3}, CourseSchedule.findOrder(numCourses, prerequisites));
    }

}
