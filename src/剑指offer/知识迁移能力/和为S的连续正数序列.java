package ��ָoffer.֪ʶǨ������;

import java.util.ArrayList;

/**
 * ��ָoffer - ��ΪS��������������
 * @author zhx
 */
public class ��ΪS�������������� {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if(sum <= 2){
            return res;
        }
        int slow = 1;
        int fast = 2;

        while(fast > slow){
            int cur = (slow + fast) * (fast - slow + 1) / 2;
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList();
                for(int i = slow;i <= fast;i ++){
                    list.add(i);
                }
                res.add(list);
                fast++;
            }
            else if(sum > cur){
                fast++;
            }else{
                slow++;
            }
        }
        return res;
    }
}
