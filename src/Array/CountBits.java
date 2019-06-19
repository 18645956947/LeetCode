package Array;

/**
 * 338. ����λ����
 * @author zhx
 */
public class CountBits {
    //��Ϊ����ż����˵���㣬�����Ķ����Ƶ�1�ĸ�������ǰһλҲ����ż���ĸ���
    //ż���ĸ�����ż����2�ĸ���
    //���https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/ ��λ���еĽ���˼·
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for(int i = 1;i<=num;i++){
            if(i % 2 == 1){
                //����Ϊ����
                res[i] = res[i-1]+1;
            }
            else{
                res[i] = res[i/2];
            }
        }
        return res;

    }
}
