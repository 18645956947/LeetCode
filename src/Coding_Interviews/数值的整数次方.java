package Coding_Interviews;

/**
 * ��ָOFFER--��ֵ�������η�
 * @author zhx
 */
public class ��ֵ�������η� {
    //������
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
