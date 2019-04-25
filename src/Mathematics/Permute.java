package Mathematics;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. È«ÅÅÁĞ
 * @author zhx
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                used[i] = true;
                temp.add(nums[i]);
                dfs(res, temp, nums, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args){
        Permute permute = new Permute();
        int[] a = new int[]{1,2,3};
        List<List<Integer>> list = permute.permute(a);
        for(List<Integer> ll : list){
            System.out.println(ll);
        }
    }
}
