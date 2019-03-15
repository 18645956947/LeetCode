package List; 

/** 
* @author ZHX
* @date 2019年3月15日下午2:17:46 
* @Description: 61. 旋转链表
*/
/**
 * 新建一个指针p，指向链表头部head
* 移动p到链表尾部，并记录链表长度
* 形成环状（p.next = head）
* p移动到分界点，即p后面有k个元素
* head移动到p.next
* 断开p和head的链接
* k要经过k %= count处理，将旋转转换为单圈。
 */
public class RotateRight {
	 public ListNode rotateRight(ListNode head, int k) {
	        ListNode p = head;
	        int count=1;
	        if(head == null || head.next == null){
	            return head;
	        }
	        while(p.next != null){
	            p = p.next;
	            count++;
	        }
	        p.next = head;
	        k %= count;
	        for(int i = 0;i<count-k;i++){
	            p = p.next;
	        }
	        head = p.next;
	        p.next = null;
	        return head;
	    }
}
 