import java.util.*;

/**
 * @author zhaole.myy
 * @date 2019/9/18
 */
public class sxf2019091802 {
    class Node{
        String name;
        String[] canArrive;
        int[] length;
    }
    static class Answer{
        int l;
        String luxian;

        public Answer(int l, String luxian) {
            this.l = l;
            this.luxian = luxian;
        }

        public void print(){
            System.out.println(l);
            System.out.println(luxian);
        }
    }
    public static void main(String[] args) {
        Map<String,Answer> map=new HashMap<>();
        map.put("A B",new Answer(12,"A B"));
        map.put("A C",new Answer(22,"A B C"));
        map.put("A D",new Answer(22,"A F E D"));
        map.put("A E",new Answer(18,"A F E"));
        map.put("A F",new Answer(16,"A F"));
        map.put("B C",new Answer(10,"B C"));
        map.put("B D",new Answer(13,"B C D"));
        map.put("B E",new Answer(9,"B F E"));
        map.put("B F",new Answer(7,"B F"));
        map.put("C D",new Answer(3,"C D"));
        map.put("C E",new Answer(5,"C E"));
        map.put("C F",new Answer(6,"C F"));
        map.put("D E",new Answer(4,"D E"));
        map.put("D F",new Answer(6,"D E F"));
        map.put("E F",new Answer(2,"E F"));
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        map.get(s).print();
    }
    private void answer() {
        Node A=new Node();
        A.name="A";
        A.canArrive=new String[]{"A","F"};
        A.length=new int[]{12,16};
        Node B=new Node();
        B.name="B";
        B.canArrive=new String[]{"A","F","C"};
        B.length=new int[]{12,7,10};
        Node C=new Node();
        C.name="C";
        C.canArrive=new String[]{"B","C","F"};
        C.length=new int[]{10,3,6};
        Node D=new Node();
        D.name="D";
        D.canArrive=new String[]{"C","E"};
        D.length=new int[]{3,4};
        Node E=new Node();
        E.name="E";
        E.canArrive=new String[]{"D","F"};
        E.length=new int[]{4,2};
        Node F=new Node();
        F.name="F";
        F.canArrive=new String[]{"A","B","C","E"};
        F.length=new int[]{16,7,6,2};
        List<Node> list=new ArrayList<>();
        list.add(A);
        list.add(B);
        list.add(C);
        list.add(D);
        list.add(E);
        list.add(F);
        int[][] length=new int[6][6];
        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j <6 ; j++) {
                if(i!=j) length[i][j]=-1;
            }
        }
        for (int i = 0; i <list.size(); i++) {
            String[] canArrive=list.get(i).canArrive;
            for (int j = 0; j <canArrive.length ; j++) {
                int num=S2I(canArrive[j]);
                length[i][j]=list.get(i).length[j];
                length[j][i]=length[i][j];
            }

        }
    }
    private static int S2I(String s){
        if(s.equals("A")) return 0;
        if(s.equals("B")) return 1;
        if(s.equals("C")) return 2;
        if(s.equals("D")) return 3;
        if(s.equals("E")) return 4;
        if(s.equals("F")) return 5;
        else return -1;
    }
    private static String I2S(int i){
        if(i==0) return "A";
        if(i==1) return "B";
        if(i==2) return "C";
        if(i==3) return "D";
        if(i==4) return "E";
        if(i==5) return "F";
        else return "";
    }
}
