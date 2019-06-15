package Coding_Interviews;

/**
 * 剑指OFFER--数值的整数次方
 * @author zhx
 */
public class 数值的整数次方 {
    //暴力法
    public double Power(double base, int exponent) {
        double sum = 1;
        if(exponent == 0){
            return sum;
        }
        for(int i = 0;i< Math.abs(exponent);i++){
            sum = base * sum;
        }
        if(exponent < 0){
            return 1/sum;
        }
        return sum;
    }
}
