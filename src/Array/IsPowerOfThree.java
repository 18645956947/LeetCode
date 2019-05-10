package Array;

/**
 * 326. 3µÄÃÝ
 * @author zhx
 */
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        if(n <= 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        while(true){
            if(n % 3 == 0){
                n /= 3;
                return isPowerOfThree(n);
            }
            else{
                return false;
            }
        }
    }

}
