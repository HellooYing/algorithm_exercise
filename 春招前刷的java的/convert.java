import java.util.Arrays;
public class convert {
    public static void main(String[] args) throws Exception {
        String s ="ABC";
        int numRows = 2;
        System.out.println(new convert().answer(s,numRows));
    }
    public String answer(String s, int numRows) {
        int col,row;
        col=numRows;
        row=s.length()-col+1;
        if(col==1||s.length()<=col) return s;
        if(s.length()==0) {
            return "";
        }
        
        String z[][] = new String[col][row+1];
        int i,j;
        String result="";
        j=0;
        
        if(s.length()==1) {
            z[0][0]=s;
            s="";
        }
        else {
            z[0][0]=s.substring(0,1);
            s=s.substring(1);
        }
        while(!s.equals("")){
            for(i=1;i <col;i++){
                if(s.length()<=1) {
                    z[i][j]=s;
                    s="";
                    break;
                }
                else {
                    z[i][j]=s.substring(0,1);
                    s=s.substring(1);
                }
            }
            for(i=col-2;i>=0;i--){
                j++;
                if(s.length()<=1) {
                    z[i][j]=s;
                    s="";
                    break;
                }
                else {
                    z[i][j]=s.substring(0,1);
                    s=s.substring(1);
                }
            }
        }
        for (int ii=0;ii<z.length;ii++)
            System.out.println ( Arrays.toString (z[ii]));
        for(int q=0;q<z.length;q++){
            for(int p=0;p<z[q].length;p++){
                if(z[q][p]!=null){
                    result=result.concat(z[q][p]);
                }
            }
        }
        return result;
    }
}