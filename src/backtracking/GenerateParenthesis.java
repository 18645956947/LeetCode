package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * @author zhx
 */
public class GenerateParenthesis {

    //回溯的方法，回溯也太难了把
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        backTrack(res, "", 0, 0, n);
        return res;
    }

    private void backTrack(List<String> res, String str, int left, int right, int max){
        if(str.length() == max * 2){
            res.add(str);
            return;
        }
        if(left < max){
            backTrack(res, str+"(", left + 1, right, max);
        }
        if(right < left){
            backTrack(res, str+")", left, right + 1, max);
        }
    }
}
