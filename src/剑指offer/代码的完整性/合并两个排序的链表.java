package 剑指offer.代码的完整性;

import 剑指offer.ListNode;

import java.util.ArrayList;

/**
 * 剑指offer - 合并两个排序的链表
 * @author zhx
 */
public class 合并两个排序的链表 {

    //使用迭代方式来做
    public ListNode Merge_01(ListNode list1, ListNode list2) {
        ArrayList<ListNode> c = new ArrayList();
        if(list1 == null && list2 == null){
            return null;
        }
        if(list1 == null && list2 != null){
            return list2;
        }
        if(list1 != null && list2 == null){
            return list1;
        }
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode p = null;
        ListNode root = null;
        while(l1 !=  null && l2 != null){
            if(l1.val >= l2.val){
                if(p == null){
                    p = l2;
                    root = p;
                }else{
                    p.next = l2;
                    p = p.next;
                }
                l2 = l2.next;
            }else{
                if(p == null){
                    p = l1;
                    root = p;
                }else{
                    p.next = l1;
                    p = p.next;
                }
                l1 = l1.next;
            }
        }
        while(l1 != null){
            p.next = l1;
            p = p.next;
            l1 = l1.next;
        }
        while(l2 != null){
            p.next = l2;
            p = p.next;
            l2 = l2.next;
        }
        return root;
    }
    //递归
    public ListNode Merge_02(ListNode list1,ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        if(list1 == null && list2 != null){
            return list2;
        }
        if(list1 != null && list2 == null){
            return list1;
        }
        return get(list1, list2);
    }
    private ListNode get(ListNode list1, ListNode list2){
        ListNode l1 = list1;
        ListNode l2 = list2;

        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        ListNode root = null;
        if(l1.val >= l2.val){
            root = l2;
            root.next = get(l1, l2.next);
        }else{
            root = l1;
            root.next = get(l1.next, l2);
        }
        return root;
    }
}
