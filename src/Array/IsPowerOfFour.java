package Array;

/**
 * 342. 4µÄÃÝ
 * @author zhx
 */
public class IsPowerOfFour {
    public boolean isPowerOfFour(int num) {
        if(num == 0){
            return false;
        }
        else if(num == 1){
            return true;
        }
        else {
            while(true){
                if(num % 4 == 0){
                    num /= 4;
                    return isPowerOfFour(num);
                }
                else return false;
            }

        }
    }
}
