package List; 

/** 
* @author lenovo
* @date 2019��3��12������10:03:18 
* @Description: 142. �������� II
*/
/**
 * ����˼·�����������裬����ͨ������ָ��ķ����ж������Ƿ��л�������������л�����Ѱ���뻷�ĵ�һ���ڵ㡣����ķ���Ϊ
 * �����ȼٶ�������㵽�뻷�ĵ�һ���ڵ�A�ĳ���Ϊa��δ֪����������ָ�������Ľڵ�B�ĳ���Ϊ��a + b���������������֪�ġ���
 * ����������֪��a��ֵ��ע�⵽��ָ��fastʼ������ָ��p�߹����ȵ�2����������ָ��slow��B�����ߣ�a + b�����ܻص�B�㣬
 * ���ֻ��a�����Ⱦ��ܻص��ڵ�A������a��ֵ�ǲ�֪���ģ����˼·�����߾ȹ���
 * ע�⵽��㵽A�ĳ�����a����ô������һ������㿪ʼ����ָ��p�ʹӽڵ�B��ʼ����ָ��slowͬ���ߣ������ĵط���Ȼ���뻷�ĵ�һ���ڵ�A��
 */
public class DetectCycle {
	public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                flag = true;
                break;
            }
            
        }
        if(flag){
            ListNode p = head;
            while(p != slow){
                p = p.next;
                slow = slow.next;
            }
            return p;
        }
        else
            return null;
    }
}
 