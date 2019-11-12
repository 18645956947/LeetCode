package ţ�����������.������.̰��;

import java.util.Arrays;
import java.util.Comparator;

/**
 * һЩ��ĿҪռ��һ�������������������Ҳ���ͬʱ����������Ŀ��������
 * ����ÿһ����Ŀ��ʼ��ʱ��ͽ�����ʱ��
 * (����һ�����飬���� ��һ�����������Ŀ)�����������������ճ�
 * Ҫ������ҽ��е������ĳ�����ࡣ������������������Ρ�
 *
 * ˼·����̰�Ĳ��ԣ�����ÿ����Ŀ�Ľ���ʱ�����㣬ÿ�ζ��ȼ������ʱ������ĵ���Ŀ����������Ļ����������ġ�
 * ʵ�ַ�������һ����
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
     * @param programs ��Ŀ����
     * @param cur ��ǰʱ�̣�Ҳ�ǵ�ǰʱ��
     * @return res ���Ŀ��������
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
