package 牛客左神初级班.二叉树.贪心;

import java.awt.event.KeyEvent;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 假设 力扣（LeetCode）即将开始其 IPO。
 * 为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。
 * 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
 * 给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应的项目。
 * 最初，你有 W 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 * 总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。
 *
 * 先说下思路吧，思路很简单，用一个小顶堆我能做的项目（现有的资金大于项目资本）也就是按照C来排序
 * 用一个大顶堆，排序的方式按照能做的项目中的P（利润）
 * 然后循环的次数就是K，注意每次在小顶堆计算完往大顶堆放的时候，如果大顶堆没有东西了，代表着剩下的项目我们现有的资金做不了了。直接返回。
 * @author zhx
 */

public class IPO {

    public static class Node{
        //资本
        public int c;
        //利润
        public int p;
        public Node(int p, int c){
            this.c = c;
            this.p = p;
        }
    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        //初始话Node节点
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(Profits[i], Capital[i]);
        }
        PriorityQueue<Node> minCost = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxPro = new PriorityQueue<>(new MaxCostComparator());
        for (int i = 0; i < nodes.length; i++) {
            minCost.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) {
            // 队列里面有项目并且手里的钱大于投资的项目
            while (!minCost.isEmpty() && minCost.peek().c <= W){
                maxPro.add(minCost.poll());
            }
            //大顶堆为空代表 在剩下的项目中我们手里的钱什么也做不了。
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
            return o1.c - o2.c; // 小顶堆 小的放上面
        }
    }
    public static class MaxCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p; //  大顶堆，大的放上面
        }
    }

    //简单版本：一个函数搞定，适合leetcode
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