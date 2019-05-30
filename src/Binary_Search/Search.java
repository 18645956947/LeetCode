package Binary_Search;

/**
 * 704. 二分查找
 * @author zhx
 */
public class Search {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;//维护一个[l...r] 范围里寻找target
        while(l <= r){  //当 l == r 时仍然有效
            int mid = (l + r)/2; //这里容易出现整型溢出问题可以写成 int mid = l + (r - l)/2; 变成减法
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return -1;
    }
}
