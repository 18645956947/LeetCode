package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 144. ��������ǰ�����
 * @author zhx
 * ��ϵͳջģ��ݹ�Ĳ�������ʾ����ǰ�����
 */
class Command{
    String s ;//go print
    TreeNode node;
    Command(String s, TreeNode node){
        this.s = s;
        this.node = node;
    }
}

public class PreorderTraversa2 {
    public List<Integer> preorderTraversa2(TreeNode root) {
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
                }if(command.node.left != null){
                    stack.push(new Command("go", command.node.left));
                }
                stack.push(new Command("print", command.node));
            }
        }
        return list;
    }
}
