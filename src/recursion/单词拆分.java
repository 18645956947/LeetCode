package recursion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 * @author zhx
 */
public class 单词拆分 {
    //1.暴力递归方法
    public boolean wordBreak(String s, List<String> wordDict) {
        return process(s, new HashSet<String>(wordDict), 0);
    }
    private boolean process(String s, Set<String> wordDict, int start){
        if(start == s.length()){
            return true;
        }
        for (int end = start + 1; end <= s.length();end++){
            if(wordDict.contains(s.substring(start, end)) && process(s, wordDict, end)){
                return true;
            }
        }
        return false;
    }

    // 2. 使用备忘录法
    public boolean wordBreak_01(String s, List<String> wordDict) {
        return process_01(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }
    private boolean process_01(String s, Set<String> wordDict, int start, Boolean[] memo){
        if(start == s.length()){
            return true;
        }
        if(memo[start] != null){
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if(wordDict.contains(s.substring(start, end)) && process_01(s, wordDict, end, memo)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}
