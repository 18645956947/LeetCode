package Binary_Search;

/**
 * 704. ���ֲ���
 * @author zhx
 */
public class Search {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;//ά��һ��[l...r] ��Χ��Ѱ��target
        while(l <= r){  //�� l == r ʱ��Ȼ��Ч
            int mid = (l + r)/2; //�������׳�����������������д�� int mid = l + (r - l)/2; ��ɼ���
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
