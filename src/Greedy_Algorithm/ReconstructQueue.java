package Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 406. ��������ؽ�����
 * @author zhx
 */
public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {
        if (0 == people.length || 0 == people[0].length)
            return new int[0][0];
        //������߽��� K��������
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        //Kֵ����Ϊ ����hǰ������ߴ��ڻ����h������
        //��Ϊ����߽���ʼ���룬��ʱ��������߶����ڵ���h
        //���Kֵ��Ϊ��Ҫ�����λ��
        for (int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][]);

    }
}
