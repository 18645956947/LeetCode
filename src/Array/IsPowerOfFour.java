package Array;

/**
 * 342. 4µÄÃÝ
 * @author zhx
 */
public class IsPowerOfFour {
    public boolean isPowerOfFour(int num) {
        if(num == 1) return true;
        if(num == 0 || num==2 || num==3 || num % 4 != 0) return false;
        num /= 4;
        return isPowerOfFour(num);
    }
}
