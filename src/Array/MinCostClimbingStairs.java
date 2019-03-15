package Array; 

/** 
* @author ZHX
* @date 2019��3��15������2:05:51 
* @Description: 746. ʹ����С������¥��
* 
*/
public class MinCostClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if(len==2)
        	return Math.min(cost[0], cost[1]);
        int [] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2;i<=len;i++){
        	dp[i] = Math.min(dp[i-2]+cost[i-2], cost[i-1]+dp[i-1]);
        }
        return dp[len];
    }
}
 