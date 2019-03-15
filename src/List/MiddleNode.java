package List;

/** 
* @author ZHX
* @date 2019年3月15日下午2:26:32 
* @Description: 876. 链表的中间结点
* 
* 思路是先遍历一遍 获得链表长度的，然后再找到中间结果，下次思考怎么能只是遍历一遍
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
 