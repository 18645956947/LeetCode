package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 590. N²æÊ÷µÄºóÐò±éÀú
 * @author zhx
 *
 */
public class Postorder {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<Node> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            list.add(0, temp.val);
            for(Node node : temp.children){
                stack.push(node);
            }
        }
        return list;
    }
}
