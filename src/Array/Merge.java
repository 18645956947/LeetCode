package Array;

import java.util.Arrays;

import zhx.day0215.Solution;

/** 
* @author ZHX
* @date 2019年3月15日下午2:00:59 
* @Description: 88. 合并两个有序数组
* 
*/
public class Merge {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i>=0 && j >= 0) {
        	if(nums1[i] > nums2[j]) {
        		nums1[k] = nums1[i];
        		i--;
        		
        	}
        	else if(nums1[i] < nums2[j]) {
        		nums1[k] = nums2[j];
        		j--;
        	}
        	k--;
        }
        while(i>=0) {
        	nums1[k] = nums1[i];
        	i--;
        	k--;
        }
        while(j>=0) {
        	nums1[k] = nums2[j];
        	j--;
        	k--;
        }
        
    }
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {1,2,3,0,0,0};
		int[] B = {4,5,6};
		solution.merge(A,3,B,3);
		System.out.println(Arrays.toString(A));
		
		
	}
}
 