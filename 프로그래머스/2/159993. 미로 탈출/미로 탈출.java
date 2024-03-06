import java.util.*;

class Solution {
    
    class Node {
        int y;
        int x;
        int value;
        
        public Node(int y, int x, int value){
            this.y = y;
            this.x = x;
            this.value = value;
        }
    }
    
    public Character[][] graph;
    public int[] dx = {-1,0,1,0};
    public int[] dy = {0,-1,0,1};
    public int h,w;
    
    public int solution(String[] maps) {
        int answer = 0;
        h = maps.length;
        w = maps[0].length();
        int startY = 0, startX = 0;
        
        graph = new Character[h][w];
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                graph[i][j] = maps[i].charAt(j);
                if(graph[i][j] == 'S'){
                    startY = i;
                    startX = j;
                }
            }
        }
        
        answer = bfs(startY, startX, 'L');
        return answer;
    }
    
    public int bfs(int startY, int startX, char goal) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];
        visited[startY][startX] = true;
        q.add(new Node(startY, startX, 0));
        
        while(!q.isEmpty()) {
            Node front = q.poll();
            int y = front.y;
            int x = front.x;
            int value = front.value;
            
             if (graph[y][x] == goal) {
                    if (goal == 'L') {
                        int e = bfs(y, x, 'E');
                        if(e == -1){
                            return -1;
                        }else {
                            return value + e;
                        }
                    } else {
                        return value;
                    }
                }
            
            for(int i=0; i<4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];
                
                if(nextY>=0 && nextY<h && nextX>=0 && nextX<w) {
                    if(graph[nextY][nextX] != 'X' && visited[nextY][nextX] == false) {
                        q.add(new Node(nextY, nextX, value+1));
                        visited[nextY][nextX] = true;
                    }
                }
            }
        }
        return -1;
    }
}