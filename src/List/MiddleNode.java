package List;

/** 
* @author ZHX
* @date 2019��3��15������2:26:32 
* @Description: 876. ������м���
* 
* ˼·���ȱ���һ�� ��������ȵģ�Ȼ�����ҵ��м������´�˼����ô��ֻ�Ǳ���һ��
*/
public class MiddleNode {
	public ListNode middleNode(ListNode head) {
        ListNode p = head;
        int num = 0;
        if(head.next == null){
            return head;
        }
        while(p != null){
            num++;
            p = p.next;
        }
        ListNode q = head;
        for(int i = 0;i<num/2;i++){
            q = q.next;
        }
        return q;
    }
}
 