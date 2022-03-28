import java.util.Scanner;

/**
 * @author luojie
 * @Description
 * @date 2022/3/21 15/51
 */
public class huiwen {

    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for(int i=0;i < length;i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sgood.append(ch);
            }
        }
        int n = sgood.length();
        int left = 0;
        int rigth = n-1;
        while (left < rigth) {
            if(Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(rigth))){
                return false;
            }
            left++;
            rigth--;
        }
        return true;


    }

    public static void main(String[] args) {
        String s;
        Scanner scan = new Scanner(System.in);
        s = scan.next();
        huiwen huiwen = new huiwen();
        boolean b = huiwen.isPalindrome(s);
        if(b==true){
            System.out.println("true");
        }else {
            System.out.println("fales");
        }

    }
}
