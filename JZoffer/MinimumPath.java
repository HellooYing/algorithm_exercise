/**
 * @author zhaole.myy
 * @date 2019/9/15
 */
public class MinimumPath {
    public int getMin(int[][] map, int n, int z) {
        for (int i = 1; i < map.length; i++) {
            map[i][0]+=map[i-1][0];
        }
        for (int i = 1; i <map[0].length ; i++) {
            map[0][i]+=map[0][i-1];
        }
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j <map[0].length ; j++) {
                map[i][j]+=Math.min(map[i-1][j],map[i][j-1]);
            }
        }
        return map[map.length-1][map[0].length-1];
    }
}
