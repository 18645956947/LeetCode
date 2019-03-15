package List;

/** 
* @author zhx
* @date 2019年3月15日下午2:14:47 
* @Description: 206. 反转链表
* 
*/
public class ReverseList {
	public ListNode reverseList(ListNode head) {
		ListNode newHead = null;

	    // 不断取出和向后移动头节点
	    // 并将头节点连接到新头节点后面
	    while (head != null) {
	        // 单独取出下一个节点
	        ListNode next = head.next;
	        // 将头节点连接到新头节点后面
	        head.next = newHead;
	        newHead = head;
	        // 向后移动头节点
	        head = next;
	    }
	    return newHead;
	}
}
 