package Coding_Interviews;

public class �����е�����k����� {

    //��һ�־��Ǳ����ⷨ�����󳤶�length �ڱ���length-k�� ����ڵ㼴Ϊ����ע��߽��жϣ�
    public ListNode FindKthToTail_01(ListNode head,int k) {
        if(head == null){
            return head;
        }
        int sum = 0;//������
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
