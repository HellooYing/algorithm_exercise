import java.util.*;

public class testComparator {
    private Set<Map.Entry<Integer, Integer>> s;

    public static void main(String[] args) {
//        List<Integer> l= Arrays.asList(1,2,3,5,-3);
//        l.sort(new MyComparator());
//        System.out.println(l);
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(1,2);
        map.put(12,-3);
        map.put(3,24);
        List<Map.Entry<Integer,Integer>> l=new ArrayList<>();
        Set<Map.Entry<Integer,Integer>> s=map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> it = s.iterator();
        while(it.hasNext()){
            l.add(it.next());
        }
        l.sort(new MyComparator2());
        System.out.println(l);
    }
    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i,Integer j) {
            return j*j-i*i;
        }
    }
    static class MyComparator2 implements Comparator<Map.Entry<Integer,Integer>> {
        @Override
        public int compare(Map.Entry<Integer,Integer> i,Map.Entry<Integer,Integer> j) {
            return i.getValue()-j.getValue();
        }
    }
}
