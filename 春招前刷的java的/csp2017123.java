import java.util.*;
import java.text.*;
public class csp2017123 {
    static class thing{
        String thing;
        List<String> month=null;
        List<String> day=null;
        List<String> hour=null;
        List<String> minute=null;
        List<String> week=null;
        thing(String s){
            this.thing=s;
        }
        void setmo(String s){
            this.month=new ArrayList<String>();
            s=s.replace("Jan","1");
            s=s.replace("Feb","2");
            s=s.replace("Mar","3");
            s=s.replace("Apr","4");
            s=s.replace("May","5");
            s=s.replace("Jun","6");
            s=s.replace("Jul","7");
            s=s.replace("Aug","8");
            s=s.replace("Sep","9");
            s=s.replace("Oct","10");
            s=s.replace("Nov","11");
            s=s.replace("Dec","12");
            if(s.equals("*")){
                this.month.add("*");
            }
            else{
                boolean hd,hj;
                hd=havedouhao(s);
                hj=havejianhao(s);
                if(!hd&&!hj) this.month.add(s);
                else if(hd&&!hj){
                    String[] ss=s.split(",");
                    for(int i=0;i<ss.length;i++){
                        this.month.add(ss[i]);
                    }
                }
                else if(!hd&&hj){
                    int start=Integer.parseInt(s.split("-")[0]);
                    int end=Integer.parseInt(s.split("-")[1]);
                    for(int i=start;i<=end;i++){
                        this.month.add(String.valueOf(i));
                    }
                }
                else{
                    String[] ss=s.split(",");
                    for(int i=0;i<ss.length;i++){
                        if(!havejianhao(ss[i])) this.month.add(ss[i]);
                        else{
                            int start=Integer.parseInt(ss[i].split("-")[0]);
                            int end=Integer.parseInt(ss[i].split("-")[1]);
                            for(int j=start;j<=end;j++){
                                this.month.add(String.valueOf(j));
                            }
                        }
                    }
                }
            }
        }
        void setd(String s){
            this.day=new ArrayList<String>();
            if(s.equals("*")){
                this.day.add("*");
            }
            else{
                boolean hd,hj;
                hd=havedouhao(s);
                hj=havejianhao(s);
                if(!hd&&!hj) this.day.add(s);
                else if(hd&&!hj){
                    String[] ss=s.split(",");
                    for(int i=0;i<ss.length;i++){
                        this.day.add(ss[i]);
                    }
                }
                else if(!hd&&hj){
                    int start=Integer.parseInt(s.split("-")[0]);
                    int end=Integer.parseInt(s.split("-")[1]);
                    for(int i=start;i<=end;i++){
                        this.day.add(String.valueOf(i));
                    }
                }
                else{
                    String[] ss=s.split(",");
                    for(int i=0;i<ss.length;i++){
                        if(!havejianhao(ss[i])) this.day.add(ss[i]);
                        else{
                            int start=Integer.parseInt(ss[i].split("-")[0]);
                            int end=Integer.parseInt(ss[i].split("-")[1]);
                            for(int j=start;j<=end;j++){
                                this.day.add(String.valueOf(j));
                            }
                        }
                    }
                }
            }
        }
        void seth(String s){
            this.hour=new ArrayList<String>();
            if(s.equals("*")){
                this.hour.add("*");
            }
            else{
                boolean hd,hj;
                hd=havedouhao(s);
                hj=havejianhao(s);
                if(!hd&&!hj) this.hour.add(s);
                else if(hd&&!hj){
                    String[] ss=s.split(",");
                    for(int i=0;i<ss.length;i++){
                        this.hour.add(ss[i]);
                    }
                }
                else if(!hd&&hj){
                    int start=Integer.parseInt(s.split("-")[0]);
                    int end=Integer.parseInt(s.split("-")[1]);
                    for(int i=start;i<=end;i++){
                        this.hour.add(String.valueOf(i));
                    }
                }
                else{
                    String[] ss=s.split(",");
                    for(int i=0;i<ss.length;i++){
                        if(!havejianhao(ss[i])) this.hour.add(ss[i]);
                        else{
                            int start=Integer.parseInt(ss[i].split("-")[0]);
                            int end=Integer.parseInt(ss[i].split("-")[1]);
                            for(int j=start;j<=end;j++){
                                this.hour.add(String.valueOf(j));
                            }
                        }
                    }
                }
            }
        }
        void setmi(String s){
            this.minute=new ArrayList<String>();
            if(s.equals("*")){
                this.minute.add("*");
            }
            else{
                boolean hd,hj;
                hd=havedouhao(s);
                hj=havejianhao(s);
                if(!hd&&!hj) this.minute.add(s);
                else if(hd&&!hj){
                    String[] ss=s.split(",");
                    for(int i=0;i<ss.length;i++){
                        this.minute.add(ss[i]);
                    }
                }
                else if(!hd&&hj){
                    int start=Integer.parseInt(s.split("-")[0]);
                    int end=Integer.parseInt(s.split("-")[1]);
                    for(int i=start;i<=end;i++){
                        this.minute.add(String.valueOf(i));
                    }
                }
                else{
                    String[] ss=s.split(",");
                    for(int i=0;i<ss.length;i++){
                        if(!havejianhao(ss[i])) this.minute.add(ss[i]);
                        else{
                            int start=Integer.parseInt(ss[i].split("-")[0]);
                            int end=Integer.parseInt(ss[i].split("-")[1]);
                            for(int j=start;j<=end;j++){
                                this.minute.add(String.valueOf(j));
                            }
                        }
                    }
                }
            }
        }
        void setw(String s){
            s=s.replace("Sun","0");
            s=s.replace("Mon","1");
            s=s.replace("Tue","2");
            s=s.replace("Wed","3");
            s=s.replace("Thu","4");
            s=s.replace("Fri","5");
            s=s.replace("Sat","6");
            this.week=new ArrayList<String>();
            if(s.equals("*")){
                this.week.add("*");
            }
            else{
                boolean hd,hj;
                hd=havedouhao(s);
                hj=havejianhao(s);
                if(!hd&&!hj) this.week.add(s);
                else if(hd&&!hj){
                    String[] ss=s.split(",");
                    for(int i=0;i<ss.length;i++){
                        this.week.add(ss[i]);
                    }
                }
                else if(!hd&&hj){
                    int start=Integer.parseInt(s.split("-")[0]);
                    int end=Integer.parseInt(s.split("-")[1]);
                    for(int i=start;i<=end;i++){
                        this.week.add(String.valueOf(i));
                    }
                }
                else{
                    String[] ss=s.split(",");
                    for(int i=0;i<ss.length;i++){
                        if(!havejianhao(ss[i])) this.week.add(ss[i]);
                        else{
                            int start=Integer.parseInt(ss[i].split("-")[0]);
                            int end=Integer.parseInt(ss[i].split("-")[1]);
                            for(int j=start;j<=end;j++){
                                this.week.add(String.valueOf(j));
                            }
                        }
                    }
                }
            }
        }


    }
    public static void main(String[] args) throws Exception {
        //System.out.println();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String start=sc.next();
        String end=sc.next();
        sc.nextLine();
        String t;
        String[] tt;
        thing ttt;
        List<thing> todo=new ArrayList<thing>();
        for(int i=0;i<n;i++){
            t=sc.nextLine();
            tt=t.split(" ");
            ttt=new thing(tt[5]);
            ttt.setmo(tt[3]);
            ttt.setd(tt[2]);
            ttt.seth(tt[1]);
            ttt.setmi(tt[0]);
            ttt.setw(tt[4]);
            todo.add(ttt);
        }
        sc.close();
        int[] st=stime(start);
        int[] ed=stime(end);
        String y,mo,d,h,mi,w;
        for(;!same(st,ed);st=nextminute(st)){
            y=String.valueOf(st[0]);
            mo=String.valueOf(st[1]);
            d=String.valueOf(st[2]);
            h=String.valueOf(st[3]);
            mi=String.valueOf(st[4]);
            w=String.valueOf(getweek(y.concat("/").concat(mo).concat("/").concat(d)));
            for(int j=0;j<todo.size();j++){
                thing th=todo.get(j);
                if(match(th.month,mo)&&match(th.day,d)&&match(th.hour,h)&&match(th.minute,mi)&&match(th.week,w)){
                    String[] sts=new String[5];
                    sts[0]=y;
                    sts[1]=mo;
                    sts[2]=d;
                    sts[3]=h;
                    sts[4]=mi;
                    System.out.println(stimes(sts).concat(" ").concat(th.thing));
                }
            }
        }
    }
    static boolean same(int[] a,int[] b){
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
    static void show(List<thing> todo){
        for(int i=0;i<todo.size();i++){
            thing t=todo.get(i);
            System.out.println(t.thing+" "+t.month+" "+t.day+" "+t.hour+" "+t.minute+" "+t.week);
        }
    }
    static int getweek(String d){
        DateFormat in=DateFormat.getDateInstance(DateFormat.SHORT);
        DateFormat r=DateFormat.getDateInstance(DateFormat.FULL);
        try{
            Date a=in.parse(d);//"1970/12/15"
            String s=r.format(a);
            s=s.substring(s.length()-1,s.length());
            if(s.equals("一")) return 1;
            else if(s.equals("二")) return 2;
            else if(s.equals("三")) return 3;
            else if(s.equals("四")) return 4;
            else if(s.equals("五")) return 5;
            else if(s.equals("六")) return 6;
            else if(s.equals("日")) return 0;
            else return -1;
        }
        catch(ParseException e){
            return -1;
        }
    }
    static int[] stime(String d){
        //yyyy mm dd hh mm ->y,m,d,h,m,w
        int[] r=new int[6];
        r[0]=Integer.parseInt(d.substring(0,4));
        r[1]=Integer.parseInt(d.substring(4,6));
        r[2]=Integer.parseInt(d.substring(6,8));
        r[3]=Integer.parseInt(d.substring(8,10));
        r[4]=Integer.parseInt(d.substring(10,12));
        r[5]=getweek(d.substring(0,4).concat("/").concat(d.substring(4,6)).concat("/").concat(d.substring(6,8)));
        return r;
    }
    static int[] nextminute(int[] t){
        int y,mo,d,h,mi;
        int[] month={0,31,28,31,30,31,30,31,31,30,31,30,31};
        y=t[0];
        mo=t[1];
        d=t[2];
        h=t[3];
        mi=t[4];
        mi++;
        if(mi==60){
            mi=0;
            h++;
        }
        if(h==24){
            h=0;
            d++;
        }
        if(d==month[mo]+1){
            d=1;
            mo++;
        }
        if(mo==13){
            mo=1;
            y++;
        }
        t=new int[5];
        t[0]=y;
        t[1]=mo;
        t[2]=d;
        t[3]=h;
        t[4]=mi;
        return t;
    }

    static String times(int[] t){
        //yyyy mm dd hh mm ->y,m,d,h,m,w
        String r="";
        for(int i=0;i<t.length-1;i++){
            if(t[i]!=0) r=r.concat(String.valueOf(t[i]));
            else r=r.concat("00");
        }
        return r;
    }

    static String stimes(String[] t){
        String r=t[0];
        if(t[1].length()<2) r=r.concat("0");
        r=r.concat(t[1]);
        if(t[2].length()<2) r=r.concat("0");
        r=r.concat(t[2]);
        if(t[3].length()<2) r=r.concat("0");
        r=r.concat(t[3]);
        if(t[4].length()<2) r=r.concat("0");
        r=r.concat(t[4]);
        return r;
    }

    static boolean havedouhao(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==',') return true;
        }
        return false;
    }
    static boolean havejianhao(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='-') return true;
        }
        return false;
    }
    static void printS(String[] a){
        for(String b:a) System.out.print(b+" ");
    }
    static void printI(int[] a){
        for(int b:a) System.out.print(b+" ");
    }
    static void printLS(List<String[]> r){
		for(String[] a:r){
			for(String aa:a){
				System.out.print(aa);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
    static boolean match(List<String> a,String b){
        if(a.get(0).equals("*")) return true;
        else{
            int flag=0;
            for(String aa:a){
                if(aa.equals(b)){
                    flag=1;
                    break;
                }
            }
            if(flag==1) return true;
            else return false;
        }
    }
}