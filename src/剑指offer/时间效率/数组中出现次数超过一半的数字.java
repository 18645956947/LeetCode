package ��ָoffer.ʱ��Ч��;

/**
 * ��ָoffer - �����г��ִ�������һ�������
 * @author zhx
 */
public class �����г��ִ�������һ������� {
    //ʱ�临�Ӷ�O��N��
    //��������ķ�ʽ����ͬ�����ͼ�һ������ͬ�ͼ�һ������������¸�ֵ
    //Ȼ���ж��������Ƿ��Ǵ������鳤�ȵ�һ��
    public int MoreThanHalfNum_Solution(int [] array) {
        if(!check(array, array.length)){
            return 0;
        }
        int time = 1;
        int res = array[0];
        for(int i = 1;i < array.length;i++){
            if(time == 0){
                res = array[i];
                time++;
            }else if(res == array[i]){
                time++;
            }else{
                time--;
            }
        }
        if(checkMore(array, array.length,res)){
            return res;
        }
        return 0;
    }
    private boolean checkMore(int[] array, int len, int result){
        int num = 0;
        for(int i = 0;i < len;i++){
            if(array[i] == result){
                num++;
            }
        }
        if(num > len / 2){
            return true;
        }
        return false;
    }

    private boolean check(int[] array,int len){
        if(array == null || len == 0){
            return false;
        }
        return true;
    }
}
