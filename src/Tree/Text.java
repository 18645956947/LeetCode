package Tree;

import java.util.concurrent.TimeoutException;

/**
 * 感受递归的调用过程
 * @author zhx
 */
public class Text {
    public int  depth(int n){
        if(n == 1){
            return 1;
        }
        return n * depth(n-1);
    }
    public static void main(String[] args){
        Text text = new Text();
        System.out.println(text.depth(4));
    }
}
