package Array;

/**
 * 167. 两数之和 II - 输入有序数组
 * @author zhx
 * 相似题目：可以用对撞指针解法;125, 344, 345, 11
 */
public class TwoSum {
    //暴力解法  时间复杂度：O（N^2）
    //执行用时 : 145 ms, 在Two Sum II - Input array is sorted的Java提交中击败了7.97% 的用户
    //内存消耗 : 38.5 MB, 在Two Sum II - Input array is sorted的Java提交中击败了27.10% 的用户
    public int[] twoSum(int[] numbers, int target) {
        int[] a = new int[2];
        for(int i = 0;i<a.length;i++){
            a[i] = -1;
        }
        for(int i = 0;i<numbers.length;i++){
            for(int  j = i+1;j < numbers.length;j++){
                if((numbers[i]+numbers[j]) == target){
                    a[0] = i+1;
                    a[1] = j+1;
                    return a;
                }
            }
        }
        return a;
    }


    //二分查找方法
    //执行用时 : 6 ms, 在Two Sum II - Input array is sorted的Java提交中击败了27.08% 的用户
    //内存消耗 : 38.1 MB, 在Two Sum II - Input array is sorted的Java提交中击败了44.39% 的用户
    public int[] twoSum_02(int[] numbers, int target) {
        int[] a = new int[2];
        for(int i = 0;i<a.length;i++){
            a[i] = -1;
        }
        for(int i = 0;i<numbers.length;i++){
            int low = 0;
            int high = numbers.length-1;
            int temp = target - numbers[i];
            while(low <= high){
                int mid = (low + high)/2;
                if(temp == numbers[mid]){
                    if(mid == i){
                        low = mid+1;
                    }else{
                        a[0] = i+1;
                        a[1] = mid+1;
                        return a;
                    }
                }
                else if(temp < numbers[mid]){
                    high = mid -1;
                }
                else{
                    low = mid+1;
                }
            }
        }
        return a;
    }

    //对撞指针方法
    //执行用时 : 3 ms, 在Two Sum II - Input array is sorted的Java提交中击败了35.34% 的用户
    //内存消耗 : 38.7 MB, 在Two Sum II - Input array is sorted的Java提交中击败了23.20% 的用户
    //时间复杂度：O(N)
    //控件fuzad：O(1)
    public int[] twoSum_03(int[] numbers, int target){
        int[] a = new int[2];
        for(int i = 0;i<a.length;i++){
            a[i] = -1;
        }
        int l = 0;
        int r = numbers.length-1;
        while( l < r ){
            if(numbers[l] + numbers[r] == target){
                a[0] = l + 1;
                a[1] = r + 1;
                return a;

            }
            else if(numbers[l] + numbers[r] > target){
                r--;
            }
            else{
                l++;
            }
        }
        return a;
    }


}
