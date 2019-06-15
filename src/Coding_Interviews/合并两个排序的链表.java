package Coding_Interviews;

/**
 * 剑指offer---合并两个排序的链表
 * @author zhx
 */
public class 合并两个排序的链表 {


    //1.非递归版本
    public ListNode Merge_01(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        else if(list2 == null){
            return list1;
        }
        ListNode head = null;
        ListNode cur = null;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                if(head == null){
                    head = cur = list1;
                }
                else {
                    cur.next = list1;
                    cur = cur.next;
                }
                list1 = list1.next;
            }
            else {
                if(head == null){
                    head = cur = list2;
                }
                else {
                    cur.next = list2;
                    cur = cur.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 == null){
            cur.next = list2;
        }
        else if(list2 == null){
            cur.next = list1;
        }
        return head;
    }




}
