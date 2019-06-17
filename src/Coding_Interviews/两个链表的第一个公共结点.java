package Coding_Interviews;

/**
 * 剑指offer --两个链表的第一个公共结点
 * @author zhx
 */
public class 两个链表的第一个公共结点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p = pHead1;
        ListNode q = pHead2;
        while(p != q){
            p = (p == null ? pHead1 : p.next);
            q = (q == null ? pHead2 : q.next);
        }
        return p;
    }
}
