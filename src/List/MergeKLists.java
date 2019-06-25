package List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 23. 合并K个排序链表
 * @author zhx
 */
public class MergeKLists {

    //暴力解法 全部元素放入数组中 再排序 再接上
    public ListNode mergeKLists_01(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();

        for(ListNode i : lists){
            while(i != null){
                list.add(i.val);
                i = i.next;
            }

        }
        ListNode head = new ListNode(-1);
        ListNode l = head;
        Collections.sort(list);
        for(int i : list){
            ListNode t = new ListNode(i);
            l.next = t;
            l = l.next;
        }
        l.next = null;

        return head.next;

    }
}
