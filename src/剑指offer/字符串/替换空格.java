package ��ָoffer.�ַ���;

/**
 * ��ָoffer - �滻�ո�
 * @author zhx
 */
public class �滻�ո� {

    public String replaceSpace(StringBuffer str) {

        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) != ' '){
                sb.append(str.charAt(i));
            }
            else{
                sb.append("%20");
            }
        }
        return sb.toString();

    }
}
