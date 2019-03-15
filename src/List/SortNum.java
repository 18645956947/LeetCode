package List;

import java.time.temporal.Temporal;
import java.util.function.IntPredicate;

/** 
* @author lenovo
* @date 2019年3月14日上午9:26:32 
* @Description: 
*/
public class SortNum {
	//冒泡排序
	public static int[] bubbleSort(int[] sum) {
		int tem = 0;
		for(int i = 0;i<sum.length-1;i++) {
			for(int j = 0;j<sum.length-1-i;j++) {
				if(sum[j] > sum[j+1]) {
					tem = sum[j+1];
					sum[j+1] = sum[j];
					sum[j] = tem;
				}
			}
		}
		return sum;
	}
	
	//选择排序
	public static int[] selectionSort(int[] sum) {
		int minIndex,temp;
		for(int i = 0;i<sum.length-1;i++) {
			minIndex = i;
			for(int j = i+1;j<sum.length;j++) {
				if(sum[j] < sum[minIndex]) {
					minIndex = j;
				}
			}
			temp = sum[i];
			sum[i] = sum[minIndex];
			sum[minIndex] = temp;
		}
		return sum;
	}
	
	
	
	public static void main(String[] args) {
		//快慢指针找中间节点
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		//head.next.next.next = new ListNode(4);
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println("---");
		
		
		
		//选择排序
		int[] sum = new int[] {3,2,1,4};
		selectionSort(sum);
		for(int i = 0;i<sum.length;i++) {
			System.out.print(sum[i]);
		}
		
	}
}
 