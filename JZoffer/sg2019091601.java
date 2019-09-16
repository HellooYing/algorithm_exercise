import java.util.Scanner;

/**
 * @author zhaole.myy
 * @date 2019/9/16
 */
public class sg2019091601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ruleNum = sc.nextInt();
        int ipNum=sc.nextInt();
        sc.nextLine();
        String[] rules=new String[ruleNum];
        String[] ips=new String[ipNum];
        for (int i = 0; i <ruleNum ; i++) {
            rules[i]=sc.nextLine();
        }
        for (int i = 0; i <ipNum ; i++) {
            ips[i]=sc.nextLine();
        }
        sc.close();
        answer(rules,ips);
    }
    public static void answer(String[] rules,String[] ips){
        // ip如果能被任意一个rule匹配，就会被过滤输出1，否则要验证下一条匹配规则。
        // 如果所有规则都不匹配，才输出0
        for (int i = 0; i <ips.length ; i++) {
            boolean print0=true;
            for (int j = 0; j <rules.length ; j++) {
                if(match(rules[j],ips[i])){
                    print0=false;
                    System.out.print("1 ");
                    break;
                }
            }
            if(print0) System.out.print("0 ");
        }
    }
    private static boolean match(String rule,String ip){
        String[] rt=rule.replace('.','#').split("#");
        String[] r=new String[4];
        if(rt.length!=4){
            if(rt.length==1){
                r[0]="*";
                r[1]="*";
                r[2]="*";
                r[3]="*";
            }
            else if(rt[0].equals("*")){
                int starNum=4-rt.length;
                for (int i = 0; i <starNum ; i++) {
                    r[i]="*";
                }
                for (int i = starNum; i <4 ; i++) {
                    r[i]=rt[i-starNum];
                }
            }
            else if(rt[rt.length-1].equals("*")){
                int starNum=4-rt.length;
                for (int i = 3; i >=starNum ; i--) {
                    r[i]="*";
                }
                for (int i = starNum-1; i>=0 ; i--) {
                    r[i]=rt[i];
                }
            }
        }
        else r=rt;
        String[] i=ip.replace('.','#').split("#");
        boolean match=true;
        for (int j = 0; j <r.length ; j++) {
            if(r[j].equals("*")) continue;
            else{
                if(!r[j].equals(i[j])){
                    match=false;
                }
            }
        }
        return match;
    }
}
