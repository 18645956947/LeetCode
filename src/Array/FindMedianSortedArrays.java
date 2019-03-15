package Array;

import java.util.ArrayList;
import java.util.List;

/** 
* @author zhx
* @date 2019��3��15������1:48:58 
* @Description: 4. Ѱ�����������������λ��
* 
* Ҫ��ʱ�临�Ӷ�Ϊlog(m+n),��˼����ֻ�ܵ���ѭ��һ����������
* �ҵ�˼·�Ǵ����������бȽϴ�Сȡ������һ��list�У�����һ����С���������list��Ȼ��ֱ�Ӱ����ȡ��λ����
* m = (nums1_length + nums2_length) / 2
* ���list����ż�����򷵻�(list.get(m) + list.get(m-1))/2�����list�ĸ�����������ֱ�ӷ�����λ����
*/
public class FindMedianSortedArrays {
	 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 List<Double> list = new ArrayList();
		 double mid = 0;
		 boolean flag = true;
		 int nums1_length = nums1.length;
		 int nums2_length = nums2.length;
		 int m = (nums1_length + nums2_length) / 2;
		 //flag true����Ϊż�� ��֮Ϊ����
		 if((nums1_length + nums2_length) % 2 !=0) {
			 flag = false;
		 }
		 if(nums1_length == 0 && nums2_length != 0) {
			 if(nums2_length %2 == 0) {
				 return (nums2[nums2_length/2] + nums2[nums2_length/2-1])/2.0;
			 }
			 else {
				return nums2[nums2_length/2];
			}
		 }
		 else if (nums1_length != 0 && nums2_length == 0) {
			 if(nums1_length %2 == 0) {
				 return (nums1[nums1_length/2] + nums1[nums1_length/2-1])/2.0;
			 }
			 else {
				return nums1[nums1_length/2];
			}
		}
		 int i = 0, j = 0;
		 while(i < nums1_length && j < nums2_length) {
			 if(nums1[i] < nums2[j]) {
				 list.add((double) nums1[i]);
				 i++;
			 }
			 else if(nums1[i] == nums2[j]) {
				 list.add((double) nums1[i]);
				 list.add((double) nums2[j]);
				 i++;
				 j++;
			 }
			 else {
				list.add((double) nums2[j]);
				j++;
			}
		 }
		 if(i < nums1_length) {
			 while(i<nums1_length){
				 list.add((double) nums1[i]);
				 i++;
			 }
			
		 }
		 if(j < nums2_length) {
			 while(j<nums2_length) {
				 list.add((double) nums2[j]);
				 j++;
			 }
			 
		 }
		 if(flag) {
			 mid = (list.get(m) + list.get(m-1))/2;
		 }else {
			mid = list.get(m);
		}
		 return mid;
	 }
	 public static void main(String[] args) {
		int[] a = new int[] {};
		int[] b = new int[] {3,4};
		System.out.println(FindMedianSortedArrays.findMedianSortedArrays(a, b));
	}
}
 