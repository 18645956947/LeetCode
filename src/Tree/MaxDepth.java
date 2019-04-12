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
        List<Node> list = new ArrayList<>();

        Node node = new Node();
        list.add(node);
        Node node1 = new Node(1, list);
    }
}
