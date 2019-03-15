package List;

/** 
* @author zhx
* @date 2019��3��15������2:14:47 
* @Description: 206. ��ת����
* 
*/
public class ReverseList {
	public ListNode reverseList(ListNode head) {
		ListNode newHead = null;

	    // ����ȡ��������ƶ�ͷ�ڵ�
	    // ����ͷ�ڵ����ӵ���ͷ�ڵ����
	    while (head != null) {
	        // ����ȡ����һ���ڵ�
	        ListNode next = head.next;
	        // ��ͷ�ڵ����ӵ���ͷ�ڵ����
	        head.next = newHead;
	        newHead = head;
	        // ����ƶ�ͷ�ڵ�
	        head = next;
	    }
	    return newHead;
	}
}
 