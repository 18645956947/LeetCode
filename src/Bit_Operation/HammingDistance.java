package Bit_Operation;

/**
 * 461. ��������
 * @author zhx
 */
public class HammingDistance {

    //�Ƚ�ʮ���Ƶ�����ת��Ϊ�����Ƶ����֣��ٶ�ÿһλ�������  ��ͬΪ0��ͬΪ1  �ټ���1 �ĸ����������ǵľ���
    public int hammingDistance(int x, int y) {
        return Integer.toBinaryString(1^4).replace("0", "").length();
    }

    public static void main(String[] args) {
        System.out.println(1^4);
    }

}
