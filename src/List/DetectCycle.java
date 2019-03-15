package List; 

/** 
* @author lenovo
* @date 2019年3月12日上午10:03:18 
* @Description: 142. 环形链表 II
*/
/**
 * 解题思路：分两个步骤，首先通过快慢指针的方法判断链表是否有环；接下来如果有环，则寻找入环的第一个节点。具体的方法为
 * ，首先假定链表起点到入环的第一个节点A的长度为a【未知】，到快慢指针相遇的节点B的长度为（a + b）【这个长度是已知的】。
 * 现在我们想知道a的值，注意到快指针fast始终是慢指针p走过长度的2倍，所以慢指针slow从B继续走（a + b）又能回到B点，
 * 如果只走a个长度就能回到节点A。但是a的值是不知道的，解决思路是曲线救国，
 * 注意到起点到A的长度是a，那么可以用一个从起点开始的新指针p和从节点B开始的慢指针slow同步走，相遇的地方必然是入环的第一个节点A。
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
 