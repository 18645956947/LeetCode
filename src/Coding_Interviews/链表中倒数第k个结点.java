package Coding_Interviews;

/**
 * ��ָoffer--�����е�����k�����
 * @author zhx
 */
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

    /**
     * ���ӣ�https://www.nowcoder.com/questionTerminal/529d3ae5a407492994ad2a246518148a?toCommentId=3140497
     * ��Դ��ţ����
     *
     * �ڶ��־���˫ָ���ܷ�
     * ˼�����һ��ָ������k-1���ڵ㣬��ʱ����һ��ָ���ܣ�����ʼ�ܵ��Ǹ�ָ�뵽ͷ�ˣ����ܵ��Ǹ�ָ����ָ��ľ�������
     * ʵ�������� ������ ��������Ӧ����ô���أ�
     * һ���������ǲ���֪�����ĳ��̵ģ���ôֻ���жϵ�ǰ��ָ���Ƿ�Ϊ�գ�
     * ��ô���������������һ��ָ���ܵ�����ʱ�򣬿����������ָ���������ָ��ʲô��ϵ�����������ˡ�
     */
    public ListNode FindKthToTail_02(ListNode head,int k) {
        if(head == null){
            return head;
        }
        int count = 0;
        ListNode first = head;
        ListNode last = head;
        int a = k;
        while(first != null){
            count++;//����ڵ�
            first = first.next;
            if(a < 1){
                last = last.next;
            }
            a--;
        }
        if(k > count){
            ListNode temp = null;
            return temp;
        }
        return last;
    }

}
