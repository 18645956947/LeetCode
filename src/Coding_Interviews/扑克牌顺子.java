package Coding_Interviews;

import java.util.Arrays;

/**
 * ��ָoffer - �˿���˳��
 * 1.����
 * 2.ͳ��0 �ĸ�����
 * 3.ͳ������֮��Ĳ�ֵ�Ƿ������0�ĸ���������
 * @author zhx
 */
public class �˿���˳�� {

    public boolean isContinuous(int [] numbers) {

        int len = numbers.length;
        //�������пղ���
        if(len != 5 || numbers == null){
            return false;
        }
        int zero = 0;
        int num = 0;
        //���Ÿ���
        Arrays.sort(numbers);
        for(int i = 0;i<len - 1;i++){
            //ͳ��0�ĸ���
            if(numbers[i] == 0){
                zero++;
                continue;
            }
            //������ͬ��ֱ�ӷ���false
            if(numbers[i] == numbers[i+1]){
                return false;
            }
            //ͳ�����ڵ��������Ĳ�ֵ�Ƿ������0�����
            num += numbers[i+1] - numbers[i] - 1;
        }
        //���ֱ���ж�0�ĸ������������е�Ԫ��
        if(zero >= num){
            return true;
        }
        return false;
    }
}
