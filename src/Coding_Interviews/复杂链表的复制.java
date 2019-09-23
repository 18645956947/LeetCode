package Coding_Interviews;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指offer -- 复杂链表的复制
 * @author zhx
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class 复杂链表的复制 {

    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null){
            return pHead;
        }
        RandomListNode node = pHead;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (node != null){
            RandomListNode clone = new RandomListNode(node.label);
            map.put(node, clone);
            node = node.next;
        }
        node = pHead;
        while (node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(pHead);
    }
}
