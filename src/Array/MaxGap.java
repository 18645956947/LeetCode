package Array;

import javax.print.attribute.standard.NumberUp;

/**
 * ����һ���������飬���������֮����������������ֵ��Ҫ��ʱ �临�Ӷ�O(N)����Ҫ�����÷ǻ��ڱȽϵ�����
 * @author zhx
 */
public class MaxGap {

    public static int maxGap(int[] nums){
        if(nums == null || nums.length < 2){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = nums.length;
        //�ҵ���������������Сֵ
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        //������ֵ����Сֵ��ͬ�Ļ���ô����ֵΪ0
        if(max == min){
            return 0;
        }

        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);
            System.out.println(bid+" "+min + " " + max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i < len; i++) {
            if(hasNum[i]){
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;

    }

    /**
     * �����һ������������������һ��Ͱ
     * @param num ������
     * @param len �������鳤��
     * @param min �����������Сֵ
     * @param max ������������ֵ
     * @return Ͱ��
     */
    public static int bucket(int num, int len, int min, int max){
        return (int)((num - min) * len / (max - min));
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,6,9,1};
        System.out.println(maxGap(a));
    }
}
