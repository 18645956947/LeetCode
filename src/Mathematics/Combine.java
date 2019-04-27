package Mathematics;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. ×éºÏ
 * @author zhx
 */
public class Combine {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if(n <= 0 || k <= 0 || k > n){
            return res;
        }
        List<Integer> list = new ArrayList<>();
        generateCombine(n, k, 1, list);
        return res;
    }
    private void generateCombine(int n, int k, int start, List<Integer> list){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        else{
            for(int i = start;i<=n;i++){
                list.add(i);
                generateCombine(n, k, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}
