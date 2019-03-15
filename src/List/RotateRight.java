package List; 

/** 
* @author ZHX
* @date 2019��3��15������2:17:46 
* @Description: 61. ��ת����
*/
/**
 * �½�һ��ָ��p��ָ������ͷ��head
* �ƶ�p������β��������¼������
* �γɻ�״��p.next = head��
* p�ƶ����ֽ�㣬��p������k��Ԫ��
* head�ƶ���p.next
* �Ͽ�p��head������
* kҪ����k %= count��������תת��Ϊ��Ȧ��
 */
public class RotateRight {
	 public ListNode rotateRight(ListNode head, int k) {
	        ListNode p = head;
	        int count=1;
	        if(head == null || head.next == null){
	            return head;
	        }
	        while(p.next != null){
	            p = p.next;
	            count++;
	        }
	        p.next = head;
	        k %= count;
	        for(int i = 0;i<count-k;i++){
	            p = p.next;
	        }
	        head = p.next;
	        p.next = null;
	        return head;
	    }
}
 