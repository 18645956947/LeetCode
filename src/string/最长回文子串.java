package string;

/**
 * ����һ���ַ��� "abacd" ��� "aba" �ҳ��������Ļ����Ӵ�
 * @author zhx
 */
public class ������Ӵ� {

    //�����ķ�ʽ - ������չ��
    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        //��������Ӵ�
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");
        String s1 = sb.toString();
        System.out.println("s1:"+s1);
        int len = 0;
        String res = "";
        for (int i = 0; i < s1.length(); i++) {
            System.out.println("��"+i+"��");
            String ss = append(s1, i);
            System.out.println(ss);
            res = ss.length() > len ? ss : res;
            len = ss.length() > len ? ss.length():len;
            System.out.println(res);
        }
        return res.replace("#", "");
    }
    //���ػ����Ӵ�
    public static String append(String str, int index){
        String res = "";
        for(int i = 0;i <= index && i < str.length() - index;i++){
            if(str.charAt(index - i) == str.charAt(index + i)){
                res = str.substring(index - i, index + i + 1);
            }else{
                break;
            }
        }
        return res;
    }

    static boolean areChareterUnique(String str)
    {
        int check=0;
        for(int i=0;i<str.length();i++)
        {
            int val=(str.charAt(i)-'a');
            System.out.println("val1:"+val);
            if((check&(1<<val))>0){
                System.out.println("check1:"+check);
                //��val�ŵ�check�ж�Ӧ��λ��
                //������ظ��򷵻�FALSE
                return false;
            }
            check|=(1<<val);
            System.out.println("val2:"+(1<<val));
            System.out.println("check2:"+check);
        }
        return true;
    }


    public static void main(String[] args) {
        String str = "abbasg";
        //str.substring(0,1);
        //str.substring(0,1);
//        System.out.println(str);
//        System.out.println("����ǣ�"+longestPalindrome(str));
        System.out.println(areChareterUnique(str));
    }
}
