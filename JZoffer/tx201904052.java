import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class tx201904052 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        LinkedList a=new LinkedList<Byte>();
        String s=in.nextLine();
        in.close();
        for(int i=0;i<s.length();i++){
            byte b=Byte.parseByte(s.substring(i,i+1));
            a.offer(b);
        }
        answer(a);
    }
    static void answer(LinkedList<Byte> a){
        int i=0;
        while(a.size()>1&&i<a.size()-1){
            if(a.get(i)!=a.get(i+1)){
                a.remove(i+1);
                a.remove(i);
                i=0;
            }
            else{
                i++;
            }
        }
        System.out.println(a.size());
    }
}