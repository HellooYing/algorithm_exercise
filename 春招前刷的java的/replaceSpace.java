import java.util.*;

public class replaceSpace {
    public static void main(String[] args) throws Exception {
        StringBuffer a = new StringBuffer("?? ??  !");
        System.out.println(new replaceSpace().answer(a));
    }

    public String answer(StringBuffer str){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                str=str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }

}