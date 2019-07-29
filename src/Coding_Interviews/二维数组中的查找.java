package Coding_Interviews;

/**
 * ��ָoffer -- ��ά�����еĲ���
 * @author zhx
 */
public class ��ά�����еĲ��� {

    public static boolean Find(int target, int [][] array) {
        for(int i = 0;i < array.length;i++){
            int low = 0;
            int high = array.length-1;
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

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,3}, {2,3,4}, {3,4,5}};
        System.out.println(��ά�����еĲ���.Find( 5, a));
    }
}
