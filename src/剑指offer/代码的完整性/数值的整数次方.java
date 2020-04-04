package ��ָoffer.�����������;

/**
 * ��ָoffer - ��ֵ�������η�
 * @author zhx
 */
public class ��ֵ�������η� {
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

    //�ж�С���Ƿ����
    public boolean equals(double a, double b){
        if((a - b > -0.0000001 && (a - b < 0.0000001))){
            return true;
        }
        return false;
    }
}
