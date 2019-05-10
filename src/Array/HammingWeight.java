package Array;

/**
 * 191. λ1�ĸ���
 * @author zhx
 */
public class HammingWeight {


    //5 ms	33.1 MB
    public int hammingWeight(int n) {
        int num = 0;
        String s = Integer.toBinaryString(n);
        int a = s.length();
        for(int i = 0;i<a;i++){
            if(s.charAt(i) == '1'){
                num += 1;
            }

        }
        return num;
    }

    //4 ms	33.7 MB
    public int hammingWeight_02(int n) {
        if(n == 0){
            return 0;
        }
        int count = 0;
        while((n & (n - 1)) != 0){//���n & (n - 1)������0��˵��n�л���1
            count++;
            n = n & (n - 1);
        }
        count++;//��ԭ����ֻ��һ��1����ôû����ѭ����ͽ����ˣ����Դ˴�Ҫcount++
        return count;
    }

    //λ����
    //ִ����ʱ : 3 ms, ��Number of 1 Bits��Java�ύ�л�����94.90% ���û�
    //�ڴ����� : 32.8 MB, ��Number of 1 Bits��Java�ύ�л�����51.16% ���û�
    public int hammingWeight_03(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if((n & (1 << i - 1)) != 0)
                count++;
        }
        return count;
    }

}
