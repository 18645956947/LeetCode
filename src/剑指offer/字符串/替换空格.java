package ½£Ö¸offer.×Ö·û´®;

/**
 * ½£Ö¸offer - Ìæ»»¿Õ¸ñ
 * @author zhx
 */
public class Ìæ»»¿Õ¸ñ {

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
