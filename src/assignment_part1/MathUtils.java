import java.io.File;

/**
 * Created by Thomas on 14/02/2017.
 */
public class MathUtils {
    public int max(String s) {
        if(s == null){
            throw new NullPointerException();
        }
        if (s.length() == 0)
            return 0;
        else {
            int result = Integer.MIN_VALUE;
            int tempR;
            String temp = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ',') {
                    tempR = Integer.parseInt(temp);
                    if (result < tempR) result = tempR;
                    temp = "";
                }
                else if(i == s.length()-1){
                    temp += s.charAt(i);
                    tempR = Integer.parseInt(temp);
                    if (result < tempR) result = tempR;
                }
                else if (Character.isDigit(s.charAt(i)) || s.charAt(i)=='-') {
                    temp += s.charAt(i);
                }
                else throw new NumberFormatException();
            }
            return result;
        }
    }

    public int max(File f){
        String s = f.toString();
        System.out.println(s);
        return max(f.toString());
    }
}