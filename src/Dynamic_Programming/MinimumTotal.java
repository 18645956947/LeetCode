package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * @author zhx
 */

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }

        int[] dp = new int[triangle.size()+1];
        for(int i = triangle.size()-1;i>=0;i--){
            List<Integer> curTr = triangle.get(i);

            for(int j = 0;j<curTr.size();j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + curTr.get(j);
                System.out.println("j = " +j+" "+ dp[j]);
            }

        }
        return dp[0];
    }
    public static void main(String[] args){
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<Integer>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        for (int i = 0; i < triangle.size(); i++) {
            System.out.println("triangle = " + triangle.get(i));
        }

        MinimumTotal minimumTotal = new MinimumTotal();
        System.out.println("minimumTotal = " + minimumTotal.minimumTotal(triangle));
    }
}
