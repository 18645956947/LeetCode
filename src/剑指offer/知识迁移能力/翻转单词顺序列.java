package ��ָoffer.֪ʶǨ������;

/**
 * ��ָoffer - ��ת����˳����
 * @author zhx
 */
public class ��ת����˳���� {
    public String ReverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        if(str == null){
            return null;
        }

        int length = str.length();
        String[] s = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = s.length - 1;i >= 0;i--){
            sb.append(s[i]+" ");
        }
        return sb.toString().trim();
    }
}
