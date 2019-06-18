package Bit_Operation;

/**
 * 461. 汉明距离
 * @author zhx
 */
public class HammingDistance {

    //先将十进制的数字转化为二进制的数字，再对每一位进行异或  相同为0不同为1  再计算1 的个数就是他们的距离
    public int hammingDistance(int x, int y) {
        return Integer.toBinaryString(1^4).replace("0", "").length();
    }

    public static void main(String[] args) {
        System.out.println(1^4);
    }

}
