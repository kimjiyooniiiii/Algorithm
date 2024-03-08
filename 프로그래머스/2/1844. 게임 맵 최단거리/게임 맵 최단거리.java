import java.util.*;

class Solution {
    Queue<int[]> q = new LinkedList<>();
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    int h = 0, w = 0;
    boolean[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        h = maps.length;
        w = maps[0].length;
        
        visited = new boolean[h][w];
        visited[0][0] = true;
        q.add(new int[]{0,0});
        
        answer = bfs(maps);
        
        return answer;
    }
    
    public int bfs(int[][] maps) {
        while(!q.isEmpty()){
            int[] peek = q.poll();
            int y = peek[0];
            int x = peek[1];
            
            if(y == h-1 && x == w-1){
                return maps[y][x];
            }
            
            for(int i=0; i<4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];
                
               // System.out.println(h + " " + w);
                
                if(nextY>=0 && nextY<h && nextX>=0 && nextX<w) {
                  //  System.out.println(nextY + " " + nextX);
                    if(maps[nextY][nextX] == 1 && visited[nextY][nextX] == false) {
                        visited[nextY][nextX] = true;
                        q.add(new int[]{nextY,nextX});
                        maps[nextY][nextX] += maps[y][x];

                    }
                }
            }
        }
        return -1;
    }
}