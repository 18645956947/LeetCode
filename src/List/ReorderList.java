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
 * 143. 重排链表
 *
 * 思路就是三步走
 * 第一步，快慢指针找中点，截为两段注意把第一段指针最后一个节点的下一个节点指向null
 * 第二步，把后半段链表反转
 * 第三步，按照后半段的长度，在第一个链表中隔一个插入一个
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
        
       //向第一个链表填充第二个链表的元素
        ListNode first = head;
        //以第二个链表的长度来插入
        while(second != null){
            ListNode next = first.next;
            first.next = second;
            second = second.next;
            first = first.next;
            first.next = next;
            first = first.next;
            
        }    
    }
        //反转后半边的链表
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
        