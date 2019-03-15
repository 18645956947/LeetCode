package List;

import javax.naming.LimitExceededException;
import javax.security.auth.callback.LanguageCallback;

/** 
* @author lenovo
* @date 2019年3月11日下午6:37:44 
* @Description: 203. 移除链表元素
*/
/**
 * 思路就是先创建一个节点指向头节点，挨个遍历 ...
 */
public class RemoveElements {
	//思路就是先创建一个节点指向头节点，挨个遍历 ...
	public  static ListNode removeElements(ListNode head, int val) {
        ListNode newNode = new ListNode(-1);
        ListNode p = newNode;
        newNode.next = head;
        while(p.next != null){
            if(p.next.val == val){
                p.next = p.next.next;
            }
            else
                p = p.next;
        }
        return newNode.next;
    }
	public static void main(String[] args) {
		//测试代码
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(6);
		RemoveElements.removeElements(node, 6);
		while(node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
 