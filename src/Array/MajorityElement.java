package Array;

/**
 * 169. ÇóÖÚÊı
 * @author zhx
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int value = 0;
        for(int i : nums){
            if(count == 0){
                value = i;
                count = 1;
            }else{
                if(i == value){
                    count++;

                }
                else{
                    count--;
                }
            }

        }
        return value;
    }
}
