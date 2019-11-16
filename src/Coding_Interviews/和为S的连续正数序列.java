package Coding_Interviews;

import java.util.ArrayList;

/**
 * 剑指offer - 和为S的连续正数序列
 * 思路就是滑动窗口。
 * @author zhx
 */
public class 和为S的连续正数序列 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //滑动窗口
        int slow = 1;
        int fast = 2;
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if(sum == 0){
            ArrayList<Integer> list = new ArrayList();
            list.add(0);
            res.add(list);
            return res;
        }

        while(fast > slow){
            int cur = (slow + fast)*(fast - slow + 1) / 2;
            if(sum == cur){
                ArrayList<Integer> list = new ArrayList();
                for(int i = slow;i <= fast;i++){
                    list.add(i);
                }
                res.add(list);
                slow++;
            }else if(sum > cur){
                fast++;
            }else{
                slow++;
            }
        }
        return res;
    }
}
