package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * @author zhx
 */
public class CombinationSum {


    //回溯法解决
    //具体见他人博客https://blog.csdn.net/versencoder/article/details/52071930 非常好的学习回溯的一篇文章
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList();
        backtracking(list, candidates, target, 0);
        return res;
    }
    private void backtracking(List<Integer> list, int[] candidates, int target, int start){
        if(target < 0){
            return;
        }
        else if(target == 0){
            res.add(new ArrayList(list));
        }
        else{
            for(int i = start;i < candidates.length;i++){
                list.add(candidates[i]);
                backtracking(list, candidates, target - candidates[i], i);
                list.remove(list.size() -1);
            }
        }
    }
}
