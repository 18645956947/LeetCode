package List;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


/**
 * 143. ��������
 *
 * ˼·����������
 * ��һ��������ָ�����е㣬��Ϊ����ע��ѵ�һ��ָ�����һ���ڵ����һ���ڵ�ָ��null
 * �ڶ������Ѻ�������ת
 * �����������պ��εĳ��ȣ��ڵ�һ�������и�һ������һ��
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return ;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        second = revlseList(second);
        
       //���һ���������ڶ��������Ԫ��
        ListNode first = head;
        //�Եڶ�������ĳ���������
        while(second != null){
            ListNode next = first.next;
            first.next = second;
            second = second.next;
            first = first.next;
            first.next = next;
            first = first.next;
            
        }    
    }
        //��ת���ߵ�����
        public ListNode revlseList(ListNode head){
            ListNode pre = null;
            ListNode next = null;
            while(head != null){
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    
}
        