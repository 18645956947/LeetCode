package Array;

/**
 * 11. ʢ���ˮ������
 * @author zhx
 */
public class MaxArea {
    //������
    /**
     * ִ����ʱ :
     * 403 ms
     * , ������Java�ύ�л�����
     * 26.46%
     * ���û�
     * �ڴ����� :
     * 44.7 MB
     * , ������Java�ύ�л�����
     * 63.89%
     * ���û�
     * @param height
     * @return
     */
    public int maxAre_01(int[] height) {
        int res= 0;
        for(int i = 0;i<height.length;i++){
            for(int j = i+1;j<height.length;j++){
                res = Math.max(res, Math.min(height[i], height[j]) * (j-i));
            }
        }
        return res;
    }

    //��ײָ���˼��

    /**
     * ִ����ʱ :
     * 6 ms
     * , ������Java�ύ�л�����
     * 81.27%
     * ���û�
     * �ڴ����� :
     * 44.5 MB
     * , ������Java�ύ�л�����
     * 67.54%
     * ���û�
     * @param height
     * @return
     */
    public int maxArea_02(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length-1;
        while( l < r ){
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return res;
    }
}
