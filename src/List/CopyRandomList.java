package List;

import java.util.HashMap;
import java.util.Map;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

/**
 * 138. 复制带随机指针的链表
 * @author zhx
 */
public class CopyRandomList {
    //双map法
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Node node = head;
        Map<Node, Node> map = new HashMap<>();
        while(node != null){
            Node clone = new Node(node.val, null, null);
            map.put(node, clone);
            node = node.next;
        }
        node = head;
        while(node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;

        }

        return map.get(head);
    }
}
