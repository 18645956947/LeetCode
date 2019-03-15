package List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.security.auth.callback.LanguageCallback;
import java.util.List;

/** 
* @author lenovo
* @date 2019��3��11������2:44:24 
* @Description: 109. ��������ת������������
*/
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
        	return null;
        }
        else return toBST(head, null);
    }
    private TreeNode toBST(ListNode head, ListNode tail) {
    	ListNode slow = head;
    	ListNode fast = head;
    	if(head == tail) {
    		return null;
    	}
    	//���ÿ���ָ�� ���������м�ڵ�
    	while(fast != tail && fast.next != tail) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	//�����������
    	TreeNode tNode = new TreeNode(slow.val);
    	tNode.left = toBST(head, slow);
    	tNode.right = toBST(slow.next, tail);
    	return tNode;
    }
}
 