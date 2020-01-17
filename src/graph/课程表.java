package graph;

import java.util.LinkedList;

/**
 * leetcode - 207. 课程表
 * @author zhx
 * 关于图的问题还是不会呀
 */
public class 课程表 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for (int[] cp : prerequisites) {
            // 入度 就是需要选的课
            indegrees[cp[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            Integer pre = queue.removeFirst();
            numCourses--;
            for (int[] req : prerequisites) {
                if(req[1] != pre){
                    continue;
                }
                if(--indegrees[req[0]] == 0){
                    queue.add(req[0]);
                }
            }
        }
        return numCourses == 0;
    }
}
