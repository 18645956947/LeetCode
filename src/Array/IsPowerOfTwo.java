package Array;

/**
 * 231. 2µÄÃÝ
 * @author zhx
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n == 0){
            return false;
        }
        else if(n == 1){
            return true;
        }
        else {
            while(true){
                if(n % 2 == 0){
                    n /=2;
                    return isPowerOfTwo(n);
                }
                else return false;
            }

        }
    }
}
