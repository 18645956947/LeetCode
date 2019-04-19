package Array;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * @author zhx
 */
public class LetterCombinations {
    //定义每个数字对应的字符
    private final static String[] a = new String[]{
            " ",//0
            "",//1
            "abc",//2
            "def",//3
            "ghi",//4
            "jkl",//5
            "mno",//6
            "pqrs",//7
            "tuv",//8
            "wxyz"//8
    };
    private List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        res.clear();
        if(digits == ""){
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }
    private void findCombination(String digite, int index, String s){
        System.out.println(index + " : " + s);
        if(index == digite.length()){
            if(s != ""){
                System.out.println("get "+s+" return");
                res.add(s);
            }
            return;
        }
        char c = digite.charAt(index);
        String letters = a[c - '0'];
        for(int i = 0;i<letters.length();i++){
            System.out.println("digite["+index+"]= "+c+" use "+letters.toCharArray()[i]);

            findCombination(digite, index+1, s + letters.toCharArray()[i]);
        }
        System.out.println(" digite[ "+index+"]= "+c+" complete return");
    }
    public static void main(String[] args){
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> list = letterCombinations.letterCombinations("23");
        for (int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}