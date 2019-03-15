package List;

import javax.naming.LimitExceededException;
import javax.security.auth.callback.LanguageCallback;

/** 
* @author lenovo
* @date 2019��3��11������6:37:44 
* @Description: 203. �Ƴ�����Ԫ��
*/
/**
 * ˼·�����ȴ���һ���ڵ�ָ��ͷ�ڵ㣬�������� ...
 */
public class RemoveElements {
	//˼·�����ȴ���һ���ڵ�ָ��ͷ�ڵ㣬�������� ...
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
		//���Դ���
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
 