package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. ����ܺ�
 * @author zhx
 */
public class CombinationSum {


    //���ݷ����
    //��������˲���https://blog.csdn.net/versencoder/article/details/52071930 �ǳ��õ�ѧϰ���ݵ�һƪ����
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
