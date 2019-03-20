package List;

/** 
* @author zhx
* @date 2019.3.20
* @Description: 109.将有序链表转化为二叉搜索树
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
 