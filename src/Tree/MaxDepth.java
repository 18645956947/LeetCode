package Tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 559. N叉树的最大深度
 * @author zhx
 *
 */
public class MaxDepth {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        else {
            int max = 0;
            for(int i = 0;i<root.children.size();i++){
                max = Math.max(max, maxDepth(root.children.get(i)));
            }
            return max+1;
        }
    }


    public static void main(String[] args){
        Node child5 = new Node(11,null);
        Node child6 = new Node(12,null);
        Node child7 = new Node(21,null);
        List<Node> list2 = new ArrayList<>();
        list2.add(child5);
        list2.add(child6);
        list2.add(child7);
        Node child2 = new Node(2, list2);
        Node child3 = new Node(3, null);
        Node child4 = new Node(4, null);
        List<Node> list1 = new ArrayList<>();
        list1.add(child2);
        list1.add(child3);
        list1.add(child4);
        Node root = new Node(1, list1);

    }

}

