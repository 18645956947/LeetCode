package string; 

/** 
* @author ZHX
* @date 2019��3��15������2:12:26 
* @Description: 8. �ַ���ת������ (atoi)
* 
*/
public class MyAtoi {
	public int myAtoi(String str) {
		//�жϵ�һ������Ԫ���±�
		int index = 0;
		//����Ϊ1 ����Ϊ-1
		int flag = 1;
		//ת���������
		int base = 0;
		//�ж������Ƿ�Ϊ��
		if (str.isEmpty()) return 0;
		while(index<str.length() && str.charAt(index) == ' ') {
			index++;
		}
		if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-'))
			if(str.charAt(index) == '+') {
				flag = 1;
				index++;
			}
			else {
				flag = -1;
				index++;
			}
		
		while(index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
			// ����жϣ�MAX_VALUE�ĸ�λΪ7
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(index) - '0' > 7))
                if (flag == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            //char-'0' ���Int ����
			base = base * 10 + str.charAt(index++) - '0';
		}
		return base * flag;
	}
}
 