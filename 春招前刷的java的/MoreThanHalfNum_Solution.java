import java.util.*;

public class MoreThanHalfNum_Solution {
    public static void main(String[] args) throws Exception {
        int[] a={4,2,1,4,2,4};
        System.out.println(new MoreThanHalfNum_Solution().answer2(a));
    }

    public int answer1(int[] array){
        //巧方法：先想到一次删去两个不同的元素，直到只剩下一种元素，它的值就会是想要的
        //但这种方法无法确定这个元素是否超过一半，需要n空间保留原来的数组以供最后检查，因此想办法进行改良
        //则可以通过记录的方式顶替删除，类似的操作是两两消除。记录单个元素和它出现的次数，如果当前元素与下一个元素相同则次数+1，不同-1.
        //当次数为0时就记录再下个元素，且次数恢复为1.
        //仍然无法确定最终获取的元素是超过一半的，需要最终遍历一遍。
        if(array.length==0) return 0;
        int e=array[0],n=1;
        for(int i=1;i<array.length;i++){
            if(array[i]==e) n++;
            else n--;
            if(n==0){
                i++;
                if(i==array.length) return 0;
                e=array[i];
                n=1;
            }
        }
        n=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==e) n++;
        }
        if(n<=array.length/2) return 0;
        else return e;
    }
    public int answer2(int[] array){
        //另一种方法是用map，以元素为key，以出现次数为值。依次记录最终找到最多的就行了。
        Map<Integer, Integer> m=new HashMap<Integer, Integer>();
        for(int i=0;i<array.length;i++){
            if(!m.containsKey(array[i])){
                m.put(array[i],1);
            }
            else{
                m.put(array[i],m.get(array[i])+1);
            }
        }
        int max=0;
        int n=0;
        for(int key:m.keySet()){
            if(m.get(key)>max){
                n=key;
                max=m.get(key);
            }
        }
        if(max<=array.length/2) return 0;
        else return n;
    }
}