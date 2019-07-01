package Array;

import java.util.LinkedList;

/**
 * 239. �����������ֵ
 * @author zhx
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length<2) return nums;
        // ˫����� ���浱ǰ�������ֵ������λ�� ��֤����������λ�õ������Ӵ�С����
        LinkedList<Integer> list = new LinkedList();
        // �������
        int[] result = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            // ��֤�Ӵ�С ���ǰ����С ����
            while(!list.isEmpty()&&nums[list.peekLast()]<=nums[i]){
                list.pollLast();
            }
            // ��ӵ�ǰֵ��Ӧ�������±�
            list.addLast(i);
            // ��ʼ������ �ȵ����ڳ���Ϊkʱ �´��ƶ���ɾ��������ֵ
            if(list.peek()<=i-k){
                list.poll();
            }
            // ���ڳ���Ϊkʱ �ٱ��浱ǰ���������ֵ
            if(i-k+1>=0){
                result[i-k+1] = nums[list.peek()];
            }
        }
        return result;
    }
}
