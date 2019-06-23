package List;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. �ཻ����
 * @author zhx
 */
public class GetIntersectionNode {

    //����set����
    public ListNode getIntersectionNode_01(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headA  != null){
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    // ������ѧ�ķ���������
    //�ȼ�����������ĳ��ȣ������ĸ����ܵ����̵Ķ��룬Ȼ��һ���ܣ������ľ��ǹ�ͬ�ڵ�
    public ListNode getIntersectionNode_02(ListNode headA, ListNode headB) {
        int len_A = 0;
        int len_B = 0;
        ListNode ha = headA;
        ListNode hb = headB;
        while(ha != null){
            len_A++;
            ha = ha.next;
        }
        while(hb != null){
            len_B++;
            hb = hb.next;
        }
        if(len_A > len_B){
            ListNode p = headA;

            for(int i = 0;i<len_A - len_B;i++){
                p = p.next;
            }
            while(p != null){
                if(p == headB){
                    return p;
                }
                p = p.next;
                headB = headB.next;
            }
            return null;
        }
        else if(len_A < len_B){
            ListNode p = headB;

            for(int i = 0;i<len_B - len_A;i++){
                p = p.next;
            }
            while(p != null){
                if(p == headA){
                    return p;
                }
                p = p.next;
                headA = headA.next;
            }
            return null;
        }
        else {
            while(headA != null){
                if(headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return null;
        }

    }
}
