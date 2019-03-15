package Array; 

/** 
* @author ZHX
* @date 2019年3月15日下午1:57:29 
* @Description: 26. 删除排序数组中的重复项
* 
*/
public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
    	int number = 0;
        for(int i = 0;i<nums.length;i++){
        	if(nums[i]!=nums[number]){
        		number++;
        		nums[number] = nums[i];
        	}
        }
        number+=1;
		return number;
    }
    public static void main(String[] args){
        int []num = new int[]{1,5,0,0,1,2};
        RemoveDuplicates so = new RemoveDuplicates();
        System.out.println(so.removeDuplicates(num));
    }
}
 