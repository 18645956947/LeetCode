package Array; 

/** 
* @author ZHX
* @date 2019年3月15日下午2:05:51 
* @Description: 746. 使用最小花费爬楼梯
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
 