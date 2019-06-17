package Coding_Interviews;

/**
 * ��ָoffer --��������ĵ�һ���������
 * @author zhx
 */
public class ��������ĵ�һ��������� {

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
