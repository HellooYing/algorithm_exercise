import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhaole.myy
 * @date 2019/9/20
 */
public class tx2019092001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> l=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            sc.nextInt();
            sc.nextLine();
            l.add(sc.nextLine());
        }
        for (int i = 0; i < l.size(); i++) {
            String s=l.get(i);
            answer(s);
        }
    }
    public static void answer(String s){
        if(s.length()<11) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i <s.length()&&s.length()-i>=11 ; i++) {
            if(s.charAt(i)=='8'){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
