
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZFS {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> r = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] md = input.split(" ");
        for (String st : md) {
            if (!st.equals(""))
                r.add(Integer.parseInt(st));
        }
        int[] result = new int[r.size()];
        int z = 0, f = 0;
        int a=-1,b=-1,flag1=0,flag2=0;
        int n = 0;
        while (flag1==0||flag2==0) {
            for (int i = z; i < r.size(); i++) {
                if (r.get(i) >= 0) {
                    z = i + 1;
                    break;
                }
            }
            for (int i = f; i < r.size(); i++) {

                if (r.get(i) < 0) {
                    f = i + 1;
                    break;
                }
            }
            if(a!=z){
                System.out.print(r.get(z-1));
                System.out.print(" ");
                a=z;
            }
            else flag1=1;
            if(b!=f){
                System.out.print(r.get(f-1));
                System.out.print(" ");
                b=f;
            }
            else flag2=1;
        }
    }
}