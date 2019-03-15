package Array;

import java.util.ArrayList;
import java.util.TreeMap;

/** 
* @author ZHX
* @date 2019年3月15日下午1:55:47 
* @Description: 350. 两个数组的交集 II
* 
*/
public class Intersect {
	public int[] intersect(int[] nums1, int[] nums2) {
        // 1.
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : nums1){
            if(!map.containsKey(num)){
                map.put(num, 1);
            } else{
                map.put(num, map.get(num) + 1);
            }
        }
        // 2.
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(map.containsKey(num)){
                list.add(num);
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0){
                    map.remove(num);
                }
            }
        }
        // 3. 输出
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
            System.out.println(res[i]);
        }
        return res;
    }
    public static void main(String[] args) {
    	Intersect s1 = new Intersect();
    	int []num1 = new int[]{2,2,3,3};
		int []num2 = new int[]{2,3,3,6};
		s1.intersect(num1, num2);
    }
}
 