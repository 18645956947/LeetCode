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

    //分治法
    public ListNode mergeKLists_02(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        int interval = 1;
        while(interval < lists.length){
            for(int i = 0;i + interval< lists.length;i=i+interval*2){
                lists[i] = mergeTwoLists(lists[i], lists[i+interval]);
            }
            interval *= 2;
        }
        return lists[0];




    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode h = new ListNode(0);
        ListNode ans = h;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            }
            else{
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }

        if(l1 == null){
            h.next = l2;
        }

        if(l2 == null){
            h.next = l1;
        }
        return ans.next;

    }



}
