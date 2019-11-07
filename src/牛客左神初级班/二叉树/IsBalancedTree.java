package 牛客左神初级班.二叉树;

import Mathematics.Reverse;

/**
 * 判断是否是平衡二叉树
 * 思路就是捋清楚问题出现的情况，然后利用递归大方向解题，由于需要高度以及返回值类型，所以我们需要自己封装一个返回值类型。
 * @author zhx
 */
public class IsBalancedTree {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public static class ReturnData{
        public int h;
        public boolean isB;
        public ReturnData(boolean isB, int h){
            this.h = h;
            this.isB = isB;
        }
    }

    public static boolean isB(Node head){
        if(head == null){
            return true;
        }
        return process(head).isB;
    }

    public static ReturnData process(Node head){
        if(head == null){
            return new ReturnData(true, 0);
        }
        ReturnData leftData = process(head.left);
        if(!leftData.isB){
            return new ReturnData(false, 0);
        }
        ReturnData rightData = process(head.right);
        if(!rightData.isB){
            return new ReturnData(false, 0);
        }
        return new ReturnData(true, Math.max(leftData.h, rightData.h)+1);
    }
}
