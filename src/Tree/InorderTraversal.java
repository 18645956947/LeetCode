package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * @author zhx
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        Stack<Command> stack = new Stack<>();
        Command command = new Command("go", root);
        stack.push(command);
        while (!stack.isEmpty()){
            command = stack.pop();
            if(command.s == "print"){
                list.add(command.node.val);
            }
            else {
                if(command.node.right != null){
                    stack.push(new Command("go", command.node.right));
                }
                stack.push(new Command("print", command.node));
                if(command.node.left != null){
                    stack.push(new Command("go", command.node.left));
                }

            }
        }
        return list;
    }
}
