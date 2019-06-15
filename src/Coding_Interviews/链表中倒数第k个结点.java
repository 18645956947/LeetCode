package Coding_Interviews;

/**
 * 剑指offer--链表中倒数第k个结点
 * @author zhx
 */
public class 链表中倒数第k个结点 {

    //第一种就是暴力解法。先求长度length 在遍历length-k次 这个节点即为所求（注意边界判断）
    public ListNode FindKthToTail_01(ListNode head,int k) {
        if(head == null){
            return head;
        }

        int sum = 0;//链表长度
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
     * 链接：https://www.nowcoder.com/questionTerminal/529d3ae5a407492994ad2a246518148a?toCommentId=3140497
     * 来源：牛客网
     *
     * 第二种就是双指针跑法
     * 思想就是一个指针先跑k-1个节点，此时让另一个指针跑，当开始跑的那个指针到头了，后跑的那个指针所指向的就是所求。
     * 实现起来简单 不好想 但是我们应该怎么想呢，
     * 一个链表我们不会知道他的长短的，那么只能判断当前的指针是否为空，
     * 那么利用这个，当我们一个指针跑到最后的时候，看看我们求的指针跟到最后的指针什么关系，这就算出来了。
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
            count++;//计算节点
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
