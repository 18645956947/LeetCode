package Array;

/**
 * 167. ����֮�� II - ������������
 * @author zhx
 * ������Ŀ�������ö�ײָ��ⷨ;125, 344, 345, 11
 */
public class TwoSum {
    //�����ⷨ  ʱ�临�Ӷȣ�O��N^2��
    //ִ����ʱ : 145 ms, ��Two Sum II - Input array is sorted��Java�ύ�л�����7.97% ���û�
    //�ڴ����� : 38.5 MB, ��Two Sum II - Input array is sorted��Java�ύ�л�����27.10% ���û�
    public int[] twoSum(int[] numbers, int target) {
        int[] a = new int[2];
        for(int i = 0;i<a.length;i++){
            a[i] = -1;
        }
        for(int i = 0;i<numbers.length;i++){
            for(int  j = i+1;j < numbers.length;j++){
                if((numbers[i]+numbers[j]) == target){
                    a[0] = i+1;
                    a[1] = j+1;
                    return a;
                }
            }
        }
        return a;
    }


    //���ֲ��ҷ���
    //ִ����ʱ : 6 ms, ��Two Sum II - Input array is sorted��Java�ύ�л�����27.08% ���û�
    //�ڴ����� : 38.1 MB, ��Two Sum II - Input array is sorted��Java�ύ�л�����44.39% ���û�
    public int[] twoSum_02(int[] numbers, int target) {
        int[] a = new int[2];
        for(int i = 0;i<a.length;i++){
            a[i] = -1;
        }
        for(int i = 0;i<numbers.length;i++){
            int low = 0;
            int high = numbers.length-1;
            int temp = target - numbers[i];
            while(low <= high){
                int mid = (low + high)/2;
                if(temp == numbers[mid]){
                    if(mid == i){
                        low = mid+1;
                    }else{
                        a[0] = i+1;
                        a[1] = mid+1;
                        return a;
                    }
                }
                else if(temp < numbers[mid]){
                    high = mid -1;
                }
                else{
                    low = mid+1;
                }
            }
        }
        return a;
    }

    //��ײָ�뷽��
    //ִ����ʱ : 3 ms, ��Two Sum II - Input array is sorted��Java�ύ�л�����35.34% ���û�
    //�ڴ����� : 38.7 MB, ��Two Sum II - Input array is sorted��Java�ύ�л�����23.20% ���û�
    //ʱ�临�Ӷȣ�O(N)
    //�ؼ�fuzad��O(1)
    public int[] twoSum_03(int[] numbers, int target){
        int[] a = new int[2];
        for(int i = 0;i<a.length;i++){
            a[i] = -1;
        }
        int l = 0;
        int r = numbers.length-1;
        while( l < r ){
            if(numbers[l] + numbers[r] == target){
                a[0] = l + 1;
                a[1] = r + 1;
                return a;

            }
            else if(numbers[l] + numbers[r] > target){
                r--;
            }
            else{
                l++;
            }
        }
        return a;
    }


}
