package Coding_Interviews;

/**
 * 剑指offer -- 二维数组中的查找
 * @author zhx
 */
public class 二维数组中的查找 {

    public static boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0){
            return false;
        }
        for(int i = 0;i < array.length;i++){
            int low = 0;
            int high = array[i].length-1;
            while (low <= high){
                int mid = (low + high)/2;
                if(array[i][mid] == target){
                    return true;
                }
                else if(array[i][mid] < target){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public static boolean Find02(int target, int [][] array) {
        if(array == null || array.length == 0){
            return false;
        }
        int row = 0;
        int col = array[0].length - 1;
        while(row <= array.length - 1 && col >= 0){
            if(target == array[row][col]){
                return true;
            }
            else if(target < array[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,3}, {2,3,4}, {3,4,5}};
        System.out.println(二维数组中的查找.Find02( 5, a));
    }
}
