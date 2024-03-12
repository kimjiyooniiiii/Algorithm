import java.util.*;
import java.lang.Math;

class Solution {
    boolean[][] visited;
    int h,w;
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    Set<Integer> column;    // 열에 해당하는 size를 넣기 위한 임시 리스트
    int[] sizeArray;
    int size = 0;
    int[][] matrix;
    Queue<int[]> q = new LinkedList<>();
    
    public int solution(int[][] land) {
        int answer = 0;
        h = land.length;
        w = land[0].length;
        visited = new boolean[h][w];
        sizeArray = new int[w];
        matrix = new int[h][w];
        
         for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++){
                matrix[i][j] = land[i][j];
            }
         }
        
        
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++){
                if(visited[i][j] == false && land[i][j] == 1){
                    column = new HashSet<>();
                    column.add(j); 
                    visited[i][j] = true;
                    size = 1;
                    q.add(new int[]{i,j});
                    bfs();
                
                    sizeCalculate(size);
                }
            }
        }
        
        answer = maxSize();
        
        return answer;
    }
    
    public int bfs(){
        while(!q.isEmpty()){
            int[] poll = q.poll();
            int startY = poll[0];
            int startX = poll[1];
            
            for(int i=0; i<4; i++){
            int nextY = startY + dy[i];
            int nextX = startX + dx[i];
            
              if(nextY>=0 && nextY<h && nextX>=0 && nextX<w){
                   if(visited[nextY][nextX] == false && matrix[nextY][nextX] == 1) {
                       visited[nextY][nextX] = true;
                        column.add(nextX); 
                       q.add(new int[]{nextY, nextX});
                     size++;
                   }
               }
            }
        }
        
        return size;
    }
    
    // 각 열에서 뽑을 수 있는 석유량을 추가함
    public void sizeCalculate(int size) {
        Iterator<Integer> it = column.iterator();
        while(it.hasNext()){
            sizeArray[it.next()] += size;
        }
    }
    
    // 제일 많은 석유량 반환
    public int maxSize() {
        int max = 0;
        for(int i=0; i<sizeArray.length; i++){
            max = Math.max(max, sizeArray[i]);
        }
        return max;
    }
}