public class findIn10000 {
    public static void main(String[] args) throws Exception {
        int[] l1=new int[10000];
        int i;
        for(i=0;i<5467;i++){
            l1[i]=i;
        }
        for(i=5467;i<10000;i++){
            l1[i]=i+1;
        }
        System.out.println(new findIn10000().answer(l1));
    }
public int answer(int[] l1){
    int l=0,r=9999;
    int t;
    while(r-l!=1){
        t=(r-l+1)/2;
        if(l1[l+t]==l+t){
            l=l+t;
        }
        else if(l1[l+t]==l+t+1){
            r=r-t;
        }
    }
    if(l1[r]-l1[l]==2){
        return (l1[r]+l1[l])/2;
    }
    else if(l1[r]-l1[l]==1){
        if(r+1==10000) return 10000;
        else if(l-1==0) return 0;
        else{

            if(l1[r+1]-l1[r]==2) return (l1[r+1]+l1[r])/2;
            else if(l1[l]-l1[l-1]==2) return (l1[l]+l1[l-1])/2;
            else return 123456;
        }
    }
    else return 123457;
    }
}