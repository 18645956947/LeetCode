package Array;

/**
 * 27. ÒÆ³ıÔªËØ
 * @author zhx
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int a = nums.length;
        for(int i = 0; i < a; i++){
            if(nums[i] != val){
                if(i != index){
                    nums[index] = nums[i];
                    index++;
                }else{
                    index++;
                }
            }
        }
        return index;
    }
}
