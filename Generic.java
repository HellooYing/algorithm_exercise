import java.util.*;
public class Generic{
	public static void main(String[] args) throws Exception{
		String a="sth<int,map<int,int>>";
		System.out.println(new Generic().answer(a));
	}
	public String answer(String a){
		int i=0;
		List<String> word=new ArrayList<String>();
		while(i<a.length()){
			int t=(int)a.charAt(i);
			if(t == (int)'<'){
				word.add("<");
				i++;
			}
			else if(t == (int)'>'){
				word.add(">");
				i++;
			}
			else if(t == (int)','){
				word.add(",");
				i++;
			}
			else{
				String s="";
				while(((t >= 65 && t <= 90) || (t >= 97 && t <= 122) || (t >= 48 && t <= 57)||t==91||t==93)){
					s=s.concat(String.valueOf(a.charAt(i)));
					i++;
					t=(int)a.charAt(i);
				}
				word.add(s);
			}
			//这时word应该是["sth","<","int",",","map","<","int",",","int",">",">"]
//对每个括号中的内容进行递归下降分析。如果单词是泛型，则转换为Parameter(Name=word,subs=[泛型的语句])。如果单词不是泛型，则转换为Parameter(Name=word)。
//操作是，如果单词后是"<",则构建第一种语句，先加入Parameter(Name=word,subs=[，再加入递归调用函数分析<>中间的内容的返回语句，再加入]).如果单词后是“，”或者>，构建第二种语句加入Parameter(Name=word)
		}
        return dg(word,0,word.size());
	}
	String dg(List<String> word,int start,int end){
        String r="";
		for(int j=start;j<end;j++){
			if((!word.get(j).equals("<"))&&(!word.get(j).equals(">"))&&(!word.get(j).equals(","))){//是单词
				if((j+1<end)&&word.get(j+1).equals("<")){
					r=r.concat("Parameter(Name=").concat(word.get(j)).concat(",subs=[");
					int i;
					for(i=j+2;i<end;i++){
						if(word.get(i).equals(">")) break;
					}
                    String d=dg(word,j+2,i);
					r=r.concat(d).concat("])");
                    j=i+1;
				}
				else{
					r=r.concat("Parameter(Name=").concat(word.get(j)).concat(")");
				}
			}
            else if(word.get(j).equals(",")){
                r=r.concat(",");
            }
		}
		return r;
	}
}