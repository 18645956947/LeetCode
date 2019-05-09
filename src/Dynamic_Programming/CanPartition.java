package Dynamic_Programming;

/**
 * 416. 分割等和子集
 * @author zhx
 */
public class CanPartition {
    int[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }

        if(sum % 2 != 0){
            return false;
        }
        memo = new int[nums.length][sum/2+1];
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<sum/2+1;j++){
                memo[i][j] = -1;
            }

        }
        return tryPartition(nums, nums.length-1, sum/2);

    }

    private boolean tryPartition(int[] nums, int index, int sum){

        if(sum == 0){
            return true;
        }
        if(index < 0 || sum < 0){
            return false;
        }
        if(memo[index][sum] != -1){
            return memo[index][sum] == 1;
        }
        memo[index][sum] = (tryPartition(nums, index-1, sum)
                || tryPartition(nums, index-1, sum - nums[index])) ? 1 : 0;
        return memo[index][sum] == 1;
    }
}
