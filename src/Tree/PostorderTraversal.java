package Tree;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * @author zhx
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
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
                //入栈：头，right,left
                //出栈：left,right,头
                stack.push(new Command("print", command.node));

                if(command.node.right != null){
                    stack.push(new Command("go", command.node.right));
                }

                if(command.node.left != null){
                    stack.push(new Command("go", command.node.left));
                }
            }
        }
        return list;
    }
}
