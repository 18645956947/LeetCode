package Coding_Interviews;

import java.util.HashMap;
import java.util.Map;

/**
 * ��ָoffer -- ������ֻ����һ�ε�����
 * @author zhx
 */
public class ������ֻ����һ�ε����� {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i])+1);
            }
            else{
                map.put(array[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println("entry.getKey() = " + entry.getKey() + " entry.getValue() = "+ entry.getValue());
            if(entry.getValue() == 1){
                if(num1[0] == 0){
                    num1[0] = entry.getKey();
                }
                else {
                    num2[0] = entry.getKey();
                }
            }
        }

    }

    public static void main(String[] args) {
        ������ֻ����һ�ε����� n = new ������ֻ����һ�ε�����();
        int[] arr = new int[]{2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        System.out.println(num1[0]);
        System.out.println(num2[0]);
        System.out.println("-------------�ֽ���------------");
        n.FindNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
