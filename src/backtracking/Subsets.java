package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * @author zhx
 */
public class Subsets {

    //回溯方法
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums.length == 0){
            return res;
        }
        getNo(nums, 0, new ArrayList<>(), res);
        return res;
    }
    private void getNo(int[] nums, int index, ArrayList<Integer> list, List<List<Integer>> res){
        res.add(new ArrayList<Integer>(list));
        for(int i = index;i<nums.length;i++){
            list.add(nums[i]);
            getNo(nums, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
