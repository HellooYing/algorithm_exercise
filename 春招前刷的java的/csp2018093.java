import java.util.*;

public class csp2018093 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); 
        int n= sc.nextInt();
        int m= sc.nextInt();
        sc.nextLine();

        String t="";
        int pointnum;
        List<String> fa=new ArrayList<String>();
        String[] c;
        List<String[]> elem=new ArrayList<String[]>();
        List<String> search=new ArrayList<String>();
        List<List<Integer>> r=new ArrayList<List<Integer>>();
        List<Integer> rr;
        for(int i=0;i<n;i++){
            t=sc.nextLine();
            if(fa.size()==0&&!(t.charAt(0)=='.')) fa.add(t);
            else{
                for(pointnum=0;pointnum<t.length();pointnum++){
                    if(!(t.charAt(pointnum)=='.')) break;
                }
                if((int)(pointnum/2)+1>fa.size()){
                    fa.add(dxx(t.substring(pointnum)));
                }
                else{
                    while((int)(pointnum/2)+1<=fa.size()){
                        fa.remove(fa.size()-1);
                    }
                    fa.add(dxx(t.substring(pointnum)));
                }
            }
            c=new String[fa.size()];
            for(int j=0;j<fa.size();j++){
                c[j]=fa.get(j);
            }
            elem.add(c);
        }

        for(int i=0;i<m;i++){
            search.add(dxx(sc.nextLine()));
        }
        sc.close();
        for(int i=0;i<search.size();i++){
            rr=new ArrayList<Integer>();
            if(search.get(i).charAt(0)=='#'){
                for(int j=0;j<elem.size();j++){
                    c=elem.get(j);
                    t=c[c.length-1];
                    if(haveID(t)){
                        t=t.split(" ")[1];
                        if(t.equals(search.get(i))){
                            rr.add(j+1);
                        }
                    }
                }
            }//查的是id
            else if(search.get(i).split("#").length>1&&(search.get(i).split("#")[0].split(" ").length>1||search.get(i).split("#")[1].split(" ").length>1)){
            String[] s=mysplit(search.get(i));
                for(int j=0;j<elem.size();j++){
                    if(elem.get(j).length<s.length) continue;
                    if(!elem.get(j)[elem.get(j).length-1].equals(s[s.length-1])) continue;
                    c=elem.get(j);
                    int flag=0;
                    int q=0;
                    String tt="";
                    String ttt="";
                    String tttt="";
                    for(int k=0;k<s.length;k++){
                        for(;q+k<c.length;q++){
                            
                            t=c[c.length-1-k-q];
                            tt=s[s.length-1-k];
                            if(haveID(t)){tttt=t.split("#")[0];tttt=tttt.substring(0,tttt.length()-1);}
                            if(haveID(tt)){ttt=s[s.length-1-k].split("#")[0];ttt=ttt.substring(0,ttt.length()-1);}
                            if(t.equals(tt)||t.equals(ttt)||tttt.equals(tt)||tttt.equals(ttt)) {break;}
                        }
                        if(!t.equals(tt)&&!t.equals(ttt)&&!tttt.equals(tt)&&!tttt.equals(ttt)) flag=1;
                    }
                    if(flag==0) rr.add(j+1);
                }
                
            }//后代带id
            else if(haveID(search.get(i))){
                for(int j=0;j<elem.size();j++){
                    c=elem.get(j);
                    t=c[c.length-1];
                    if(t.equals(search.get(i))){
                        rr.add(j+1);
                    }
                }
            }//元素带id
            else if(search.get(i).split(" ").length>1){
                String[] s=search.get(i).split(" ");
                for(int j=0;j<elem.size();j++){
                    if(elem.get(j).length<s.length) continue;
                    c=elem.get(j);
                    int flag=0;
                    int q=0;
                    String tt="";
                    for(int k=0;k<s.length;k++){
                        for(;q+k<c.length;q++){
                            t=c[c.length-1-k-q];
                            if(haveID(t)){t=c[c.length-1-k].split("#")[0];t=t.substring(0,t.length()-1);}
                            tt=s[s.length-1-k];
                            if(haveID(tt)){tt=s[s.length-1-k].split("#")[0];tt=tt.substring(0,tt.length()-1);}
                            if(t.equals(tt)) break;
                        }
                        if(!t.equals(tt)) flag=1;
                    }
                    if(flag==0) rr.add(j+1);
                }
            }//后代
            else{
                for(int j=0;j<elem.size();j++){
                    c=elem.get(j);
                    t=c[c.length-1];
                    if(haveID(t)){
                        t=t.split(" ")[0];
                    }
                    if(t.equals(search.get(i))){
                        rr.add(j+1);
                    }
                }
            }//标签
            r.add(rr);
        }
        printLLI(r);
    }
    static void printLLI(List<List<Integer>> r){
		for(List<Integer> a:r){
            System.out.print(a.size());System.out.print(" ");
			for(int aa:a){
				System.out.print(aa);
				System.out.print(" ");
			}
			System.out.println();
		}
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
    static boolean haveID(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#') return true;
        }
        return false;
    }
    static String[] mysplit(String s){
        int l=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==' '&&s.charAt(i+1)!='#') l++;
        }
        String[] r=new String[l+1];
        int j=0;
        int n=0;
        int i;
        for(i=0;i<s.length()-1;i++){
            if(s.charAt(i)==' '&&s.charAt(i+1)!='#'){
                r[n]=s.substring(j,i);
                j=i+1;
                n++;
            }
        }
        r[n]=s.substring(j,i+1);
        return r;
    }
    static String dxx(String s){
        StringBuilder ss=new StringBuilder(s);
        if(!haveID(s)){
            for(int j=0;j<s.length();j++){
                if((int)s.charAt(j)<97&&(int)s.charAt(j)>64) ss.replace(j,j+1,String.valueOf(Character.toLowerCase(s.charAt(j))));
            }
        }
        else{
            int j=0;
            while(s.charAt(j)!='#'){
                if((int)s.charAt(j)<97&&(int)s.charAt(j)>64) ss.replace(j,j+1,String.valueOf(Character.toLowerCase(s.charAt(j))));
                j++;
            }
        }
        return ss.toString();
    }
}