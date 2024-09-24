// 20분 동안 풀이
import java.util.*;

class Solution {
    private int[] dy = {-1,1,0,0};
    private int[] dx = {0,0,1,-1};
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    public int bfs(int[][] maps){
        boolean[][] visit = new boolean[maps.length][maps[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visit[0][0] = true;
        
        while(!q.isEmpty()){
            int[] poll = q.poll();
            for(int i=0; i<4; i++){
                int nextY = poll[0] + dy[i];
                int nextX = poll[1] + dx[i];
                if(nextY == maps.length-1 && nextX == maps[0].length-1) {
                    return maps[poll[0]][poll[1]] + 1;
                }
                
                if(nextY >= 0 && nextX >=0 && nextY < maps.length && nextX < maps[0].length){
                    if(!visit[nextY][nextX] && maps[nextY][nextX] == 1){
                        //System.out.println(nextY + " " + nextX + " " + (maps[poll[0]][poll[1]] + 1));
                        q.add(new int[]{nextY, nextX});
                        maps[nextY][nextX] = maps[poll[0]][poll[1]] + 1;
                        visit[nextY][nextX] = true;
                    }
                }
            }
        }
        return -1;
    }
}
