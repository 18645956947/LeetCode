package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 * @author zhx
 */
public class 合并区间 {
    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList();
        if(intervals.length == 0 || intervals == null){
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while(i < intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i+1][0] <= right){
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2}, {2,6}, {8,10}, {15, 18}};
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[i].length; j++) {
//                System.out.println(a[i][j]);
//            }
//            System.out.println();
//        }
        int[][] b = 合并区间.merge(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println(b[i][j]);
            }
            System.out.println();
        }
    }

}
