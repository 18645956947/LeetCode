package Coding_Interviews;

import java.util.ArrayList;

/**
 * ��ָoffer --��С��K����
 * @author zhx
 */
public class GetLeastNumbers_Solution {
    //��ǰ�����ÿ�����������
    //�����������ð������
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(input.length < k){
            return list;
        }
        for(int i = 0;i<k;i++){
            for(int j = 0;j<input.length-i-1;j++){
                if(input[j] < input[j+1]){
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;

                }
            }
            list.add(input[input.length-i-1]);
        }
        return list;
    }
}
