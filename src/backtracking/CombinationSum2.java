package backtracking;

import java.util.*;

/**
 * 40. 组合总和 II
 * @author zhx
 */
public class CombinationSum2 {


    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList();
        backtracking(list, candidates, target, 0);
        //去重

        Set<List<Integer>> set = new HashSet<>(res);
        res = new ArrayList<>(set);
        return res;
    }
    private void backtracking(List<Integer> list, int[] candidates, int target, int start){
        if(target < 0){
            return;
        }
        else if(target == 0){
            res.add(new ArrayList<>(list));
        }
        else{
            for(int i = start;i < candidates.length;i++){
                list.add(candidates[i]);
                backtracking(list, candidates, target - candidates[i], i+1);
                list.remove(list.size() -1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum2 c = new CombinationSum2();
        int[] a = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> p = c.combinationSum2(a, 8);
        /*List<List<Integer>> ll = new ArrayList();
        List<Integer> q = new ArrayList();
        q.add(1);
        q.add(2);
        q.add(3);
        ll.add(q);
        System.out.println(q.hashCode());
        System.out.println(new ArrayList<>(q).hashCode());*/

    }
}
