package 牛客左神初级班.二叉树.贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
 * 给你每一个项目开始的时间和结束的时间
 * (给你一个数组，里面 是一个个具体的项目)，你来安排宣讲的日程
 * 要求会议室进行的宣讲的场次最多。返回这个最多的宣讲场次。
 *
 * 思路就是贪心策略，按照每个项目的结束时间来算，每次都先计算结束时间最早的的项目，这样来算的化是做的最多的。
 * 实现方法利用一个堆
 * @author zhx
 */
public class BestArrange {

    public static class Program{
        public int start;
        public int end;
        public Program(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    /**
     *
     * @param programs 项目数组
     * @param cur 当前时刻，也是当前时间
     * @return res 最大的开会的数量
     */
    public static int bestArrange(Program[] programs, int cur){
        Arrays.sort(programs, new ProgramComparator());
        int res = 0;
        for (int i = 0;i<programs.length;i++){
            if(cur <= programs[i].start){
                cur += programs[i].end;
                res++;
            }
        }
        return res;
    }

    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

}
