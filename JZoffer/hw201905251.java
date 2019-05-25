import java.util.*;

public class hw201905251 {
    //输入两个ip和子网掩码，判断两个ip是否是同一网段
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String input=in.nextLine();
        String[] a=input.split(" ");
        new hw201905251().answer(a);
    }
    public void answer(String[] a){
        //1.获取二进制字符串
        String[] ip1=new String[4];
        String[] ip2=new String[4];
        String[] zwym=new String[4];
        String[] s=a[0].replace(".","-").split("-");
        for (int i = 0; i < 4; i++) {
            ip1[i]=toBinary(Integer.parseInt(s[i]));
        }
        s=a[1].replace(".","-").split("-");
        for (int i = 0; i < 4; i++) {
            ip2[i]=toBinary(Integer.parseInt(s[i]));
        }
        s=a[2].replace(".","-").split("-");
        for (int i = 0; i < 4; i++) {
            zwym[i]=toBinary(Integer.parseInt(s[i]));
        }
        //2.将两个ip和子网掩码按位与，看结果是否相同，相同输出1，不同输出0，然后输出第一个ip按位与的结果
        String[] r1=new String[4];//第一个ip按位与
        String[] r2=new String[4];//第二个ip按位与
        for (int b = 0; b <4 ; b++) {
            String r11="";
            for (int c = 0; c < 8; c++) {
                if(ip1[b].substring(c,c+1).equals("1")&&zwym[b].substring(c,c+1).equals("1"))
                    r11=r11.concat("1");
                else r11=r11.concat("0");
            }
            r1[b]=r11;
        }
        for (int b = 0; b <4 ; b++) {
            String r22="";
            for (int c = 0; c < 8; c++) {
                if(ip2[b].substring(c,c+1).equals("1")&&zwym[b].substring(c,c+1).equals("1"))
                    r22=r22.concat("1");
                else r22=r22.concat("0");
            }
            r2[b]=r22;
        }
        int[] ip3=new int[4];
        int[] ip4=new int[4];
        for (int b = 0; b < 4; b++) {
            ip3[b]=toInt(r1[b]);
            ip4[b]=toInt(r2[b]);
        }
        int r=1;
        for (int b = 0; b <4 ; b++) {
            if(ip3[b]!=ip4[b]) r=0;
        }
        System.out.print(r);
        System.out.print(" ");
        for (int b = 0; b <3 ; b++) {
            System.out.print(ip3[b]+".");
        }
        System.out.print(ip3[3]);
    }
    public String toBinary(int i){
        String r=Integer.toBinaryString(i);
        if(r.length()<8){
            int j=8-r.length();
            for (int k = 0; k < j; k++) {
                r="0".concat(r);
            }
        }
        return r;
    }
    public int toInt(String i){
        int r=0;
        for (int j = 0; j < 8; j++) {
            if(i.substring(j,j+1).equals("1")){
                r=r+(int)Math.pow(2,7-j);
            }
        }
        return r;
    }
}
