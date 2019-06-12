package Array;

/**
 * 11. 盛最多水的容器
 * @author zhx
 */
public class MaxArea {
    //暴力法
    /**
     * 执行用时 :
     * 403 ms
     * , 在所有Java提交中击败了
     * 26.46%
     * 的用户
     * 内存消耗 :
     * 44.7 MB
     * , 在所有Java提交中击败了
     * 63.89%
     * 的用户
     * @param height
     * @return
     */
    public int maxAre_01(int[] height) {
        int res= 0;
        for(int i = 0;i<height.length;i++){
            for(int j = i+1;j<height.length;j++){
                res = Math.max(res, Math.min(height[i], height[j]) * (j-i));
            }
        }
        return res;
    }

    //对撞指针的思想

    /**
     * 执行用时 :
     * 6 ms
     * , 在所有Java提交中击败了
     * 81.27%
     * 的用户
     * 内存消耗 :
     * 44.5 MB
     * , 在所有Java提交中击败了
     * 67.54%
     * 的用户
     * @param height
     * @return
     */
    public int maxArea_02(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length-1;
        while( l < r ){
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return res;
    }
}
