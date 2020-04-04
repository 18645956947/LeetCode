package 剑指offer.代码的完整性;

/**
 * 剑指offer - 数值的整数次方
 * @author zhx
 */
public class 数值的整数次方 {
    boolean invalid_Input = false;
    public double Power(double base, int exponent) {
        if(equals(base, 0.0)){
            invalid_Input = true;
            return 0.0;
        }
        int absExponent = Math.abs(exponent);
        double result = powerWithUnsignedExponent(base, absExponent);
        if(exponent < 0){
            result = 1.0 / result;
        }
        return result;
    }

    public double powerWithUnsignedExponent(double base, int absExponent){
        double res = 1.0;
        for(int i = 0;i < absExponent;++i){
            res *= base;
        }
        return res;
    }

    //判断小数是否相等
    public boolean equals(double a, double b){
        if((a - b > -0.0000001 && (a - b < 0.0000001))){
            return true;
        }
        return false;
    }
}
