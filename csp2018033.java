import java.util.*;

public class csp2018033 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); 
        int n= sc.nextInt();
        int m= sc.nextInt();
        sc.nextLine();

        String[] name=new String[n];
        List<String[]> rule=new ArrayList<String[]>();
        List<String[]> search=new ArrayList<String[]>();
        List<String[]> result=new ArrayList<String[]>();
        List<String> ttt=new ArrayList<String>();
        String[] r;
        String[] s;
        String t,tt;
        int flag=0,j=0;
        for(int i=0;i<n;i++){
            t=sc.nextLine().substring(1);
            name[i]=t.split(" ")[1];
            rule.add(t.split(" ")[0].split("/"));
        }

        for(int i=0;i<m;i++){
            search.add(sc.nextLine().substring(1).split("/"));
        }
        sc.close();
        for(int i=0;i<m;i++){
            s=search.get(i);
            flag=0;
            if(alllegal(s)){
                for(j=0;j<n;j++){
                    r=rule.get(j);
                    //从第一位开始match，不match就不对，直到走到search和r的最后一步或者r的最后一步是path那么后面默认match
                    int k=0;
                    if(!(r.length==s.length||r.length<s.length&&havePath(r))) continue;
                    ttt=new ArrayList<String>();
                    ttt.add(name[j]);
                    if(havePath(r)){
                        while(!r[k].equals("<path>")){
                            if(r[k].charAt(0)=='<'){
                                if(!match(r[k],s[k])) {
                                    //System.out.println("42");
                                    flag=0;break;}
                                else{
                                    //System.out.print("44进来过");
                                    flag=1;
                                    if(r[k].equals("<int>")){
                                        String tttt=String.valueOf(Integer.parseInt(s[k]));
                                        ttt.add(tttt);
                                    }
                                    else{
                                        ttt.add(s[k]);
                                    }
                                }
                            }
                            else{
                                if(!r[k].equals(s[k])) {
                                    //System.out.println("49");
                                    flag=0;break;}
                                else{
                                    //System.out.print("52进来过");
                                    flag=1;
                                    //ttt.add(s[k]);
                                }
                            }
                            k++;
                        }
                        if(flag==1){
                            String ss=s[k];
                            for(int kk=k+1;kk<s.length;kk++){
                                ss=ss.concat("/").concat(s[kk]);
                            }
                            ttt.add(ss);
                        }
                    }
                    else{
                        while(k<r.length){
                            if(r[k].charAt(0)=='<'){
                                if(!match(r[k],s[k])) {
                                    //System.out.println("68");
                                    flag=0;break;}
                                else{
                                    //System.out.print("71进来过");
                                    flag=1;
                                    if(r[k].equals("<int>")){
                                        String tttt=String.valueOf(Integer.parseInt(s[k]));
                                        ttt.add(tttt);
                                    }
                                    else{
                                        ttt.add(s[k]);
                                    }
                                        
                                }
                            }
                            else{
                                if(!r[k].equals(s[k])) {
                                    //System.out.println("75"+r[k]+s.length);
                                    flag=0;break;}
                                else{
                                    //System.out.print("79进来过");
                                    flag=1;
                                    //ttt.add(s[k]);
                                }
                            }
                            k++;
                        }
                    }
                    if(flag==1) {result.add(lstos(ttt));break;}
                }
            }
            if(flag==0){
                ttt=new ArrayList<String>();
                ttt.add("404");
                result.add(lstos(ttt));
            }
        }
        printLS(result);
    }

    static void printS(String[] a){
        for(String b:a) System.out.print(b+" ");
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

    static boolean match(String a,String b){
        if(a.equals("<int>")){
            return allint(b);
        }
        else if(a.equals("<str>")){
            return true;
        }
        else return false;
    }

    static String[] lstos(List<String> l){
        String[] r=new String[l.size()];
        for(int i=0;i<l.size();i++){
            r[i]=l.get(i);
        }
        return r;
    }

    static boolean legal(String b){
        int ascii;
        for(int i=0;i<b.length();i++){
            ascii=(int)b.charAt(i);
            if((ascii>=65&&ascii<=90)||(ascii>=48&&ascii<=57)||(ascii>=97&&ascii<=122)||b.charAt(i)=='-'||b.charAt(i)=='_'||b.charAt(i)=='.') continue;
            else return false;
        }
        return true;
    }

    static boolean alllegal(String[] a){
        for(String b:a){
            if(!legal(b)) return false;
        }
        return true;
    }

    static boolean havePath(String[] a){
        if(a[a.length-1].equals("<path>")) return true;
        return false;
    }

    static boolean allint(String b){
        int ascii;
        for(int i=0;i<b.length();i++){
            ascii=(int)b.charAt(i);
            if(ascii>=48&&ascii<=57) continue;
            else return false;
        }
        return true;
    }
}