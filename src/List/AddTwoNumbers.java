package List;

import java.util.Stack;

/** 
* @author lenovo
* @date 2019��3��12������10:26:26 
* @Description:445. ������� II 
*/
/**
 * ����ջ��ʵ�֣��Ȱ���������ڵ�ֵѹ������ջ��Ȼ���ջ���㣬ÿ�����һ���ڵ�Ͱѵ�ǰ�ڵ�嵽��������ͷ����
 */
//445. ������� II
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
        ListNode head = null;
		while(l1 != null) {
			s1.push(l1.val);
            l1 = l1.next;
		}
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            int sum = 0;
            if(!s1.isEmpty()){
                sum += s1.pop();
            }
            if(!s2.isEmpty()){
                sum += s2.pop();
            }
            ListNode temp = new ListNode((carry + sum) % 10);
            temp.next = head;
            head = temp;
            carry = (sum + carry)/10;
        }
        if(carry != 0){
            ListNode temp = new ListNode(1);
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
 