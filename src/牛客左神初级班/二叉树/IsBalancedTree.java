package ţ�����������.������;

import Mathematics.Reverse;

/**
 * �ж��Ƿ���ƽ�������
 * ˼·���������������ֵ������Ȼ�����õݹ������⣬������Ҫ�߶��Լ�����ֵ���ͣ�����������Ҫ�Լ���װһ������ֵ���͡�
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
