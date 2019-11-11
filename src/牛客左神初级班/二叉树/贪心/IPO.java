package ţ�����������.������.̰��;

import java.awt.event.KeyEvent;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ���� ���ۣ�LeetCode��������ʼ�� IPO��
 * Ϊ���Ը��ߵļ۸񽫹�Ʊ��������Ͷ�ʹ�˾������ ϣ���� IPO ֮ǰ��չһЩ��Ŀ���������ʱ���
 * ������Դ���ޣ���ֻ���� IPO ֮ǰ������ k ����ͬ����Ŀ������ ���� ��������� k ����ͬ��Ŀ��õ�������ʱ��ķ�ʽ��
 * �������ɸ���Ŀ������ÿ����Ŀ i��������һ�������� Pi��������Ҫ��С���ʱ� Ci ��������Ӧ����Ŀ��
 * ��������� W �ʱ����������һ����Ŀʱ���㽫��ô����������󽫱���ӵ�������ʱ��С�
 * �ܶ���֮���Ӹ�����Ŀ��ѡ����� k ����ͬ��Ŀ���б�����������ʱ�����������տɻ�õ�����ʱ���
 *
 * ��˵��˼·�ɣ�˼·�ܼ򵥣���һ��С��������������Ŀ�����е��ʽ������Ŀ�ʱ���Ҳ���ǰ���C������
 * ��һ���󶥶ѣ�����ķ�ʽ������������Ŀ�е�P������
 * Ȼ��ѭ���Ĵ�������K��ע��ÿ����С���Ѽ��������󶥶ѷŵ�ʱ������󶥶�û�ж����ˣ�������ʣ�µ���Ŀ�������е��ʽ��������ˡ�ֱ�ӷ��ء�
 * @author zhx
 */

public class IPO {

    public static class Node{
        //�ʱ�
        public int c;
        //����
        public int p;
        public Node(int p, int c){
            this.c = c;
            this.p = p;
        }
    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        //��ʼ��Node�ڵ�
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(Profits[i], Capital[i]);
        }
        PriorityQueue<Node> minCost = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxPro = new PriorityQueue<>(new MaxCostComparator());
        for (int i = 0; i < nodes.length; i++) {
            minCost.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) {
            // ������������Ŀ���������Ǯ����Ͷ�ʵ���Ŀ
            while (!minCost.isEmpty() && minCost.peek().c <= W){
                maxPro.add(minCost.poll());
            }
            //�󶥶�Ϊ�մ��� ��ʣ�µ���Ŀ�����������ǮʲôҲ�����ˡ�
            if(maxPro.isEmpty()){
                return W;
            }
            W += maxPro.poll().p;
        }
        return W;
    }

    public static class MinCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c; // С���� С�ķ�����
        }
    }
    public static class MaxCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p; //  �󶥶ѣ���ķ�����
        }
    }

    //�򵥰汾��һ�������㶨���ʺ�leetcode
    public int findMaximizedCapital_02(int k, int W, int[] Profits, int[] Capital) {
        if(Profits.length < 1){
            return W;
        }
        PriorityQueue<int[]> minCost = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> maxPro = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int i = 0; i < Profits.length; i++) {
            minCost.add(new int[]{Capital[i], Profits[i]});
        }
        for (int i = 0; i < k; i++) {
            while (!minCost.isEmpty() && minCost.peek()[0] <= W){
                maxPro.add(minCost.poll());
            }
            if(maxPro.isEmpty()){
                break;
            }
            W += maxPro.poll()[1];
        }
        return W;
    }
}