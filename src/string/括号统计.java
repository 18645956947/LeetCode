package string;

import java.util.Scanner;
import java.util.*;

public class ¿®∫≈Õ≥º∆ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack();
        int num = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < chs.length; i++) {
            if(chs[i] == '('){
                stack.push(chs[i]);
            }else if(chs[i] == ')'){
                if(!stack.isEmpty()){
                    char c = stack.pop();
                    num++;
                }else{
                    right++;
                }
            }
        }
        left = stack.size();
        int[] res = new int[]{num, left, right};
        System.out.println(num + " " + left + " "+ right);
    }
}
