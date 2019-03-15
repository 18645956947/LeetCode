package List;

import java.util.Stack;

/** 
* @author lenovo
* @date 2019年3月12日上午10:26:26 
* @Description:445. 两数相加 II 
*/
/**
 * 利用栈来实现，先把两个链表节点值压入两个栈，然后出栈计算，每计算出一个节点就把当前节点插到结果链表的头部。
 */
//445. 两数相加 II
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
 