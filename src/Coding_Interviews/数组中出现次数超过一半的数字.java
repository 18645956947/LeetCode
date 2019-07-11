package Coding_Interviews;

import java.util.HashMap;
import java.util.Map;

/**
 * ��ָoffer -- �����г��ִ�������һ�������
 * @author zhx
 */
public class �����г��ִ�������һ������� {

        public int MoreThanHalfNum_Solution(int [] array) {

            if(array == null || array.length == 0){
                return 0;
            }
            if(array.length == 1){
                return array[0];
            }
            Map<Integer, Integer> map = new HashMap();
            for(int i = 0;i < array.length;i++){
                if(map.containsKey(array[i])){
                    map.put(array[i], map.get(array[i]) + 1);
                    if(map.get(array[i]) > array.length/2){
                        return array[i];
                    }
                }
                else{
                    map.put(array[i], 1);
                }
            }
            return 0;
        }
}
