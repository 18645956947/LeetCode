package List;


/** 
* @author ZHX
* @date 2019��3��15������2:27:09 
* @Description: 92. ��ת���� II
* 
*/
public class ReverseBetween {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newhead = new ListNode(-1);
        newhead.next = head;
         
        if(head==null||head.next==null)
            return newhead.next;
             
        ListNode startpoint = newhead;//startpointָ����Ҫ��ʼreverse��ǰһ��
        ListNode node1 = null;//��Ҫreverse������ȥ�Ľڵ�
        ListNode node2 = null;//��Ҫreverse��ǰ��ȥ�Ľڵ�
         
        for (int i = 0; i < n; i++) {
            if (i < m-1){
                startpoint = startpoint.next;//��������startpoint
            } else if (i == m-1) {//��ʼ��һ��
                node1 = startpoint.next;
                node2 = node1.next;
            }else {
                node1.next = node2.next;//node1������node2�ĺ���
                node2.next = startpoint.next;//node2�������ʼ
                startpoint.next = node2;//node2��Ϊ�µĵ�
                node2 = node1.next;//node2�ع鵽node1����һ������������
            }
        }
        return newhead.next;
    }
}
 