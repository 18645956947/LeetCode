package Coding_Interviews;

public class 链表中倒数第k个结点 {

    //第一种就是暴力解法。先求长度length 在遍历length-k次 这个节点即为所求（注意边界判断）
    public ListNode FindKthToTail_01(ListNode head,int k) {
        if(head == null){
            return head;
        }
        int sum = 0;//链表长度
        ListNode cur = null;
        ListNode temp = null;
        cur = head;
        while(cur != null){
            sum++;
            cur = cur.next;
        }
        if(k > sum){
            return temp;
        }
        for(int i = 0;i<sum-k;i++){
            head = head.next;
        }
        return head;
    }
}
