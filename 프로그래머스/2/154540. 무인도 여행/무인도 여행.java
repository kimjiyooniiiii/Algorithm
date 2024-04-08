import java.util.*;
class Solution {
    public int[] dy = {-1,1,0,0};
    public int[] dx = {0,0,1,-1};
    public boolean[][] visit;
    public Queue<int[]> q  = new LinkedList<>();
    public int sum = 0;
    
    public int[] solution(String[] maps) {
        int[] answer;
        List<Integer> result = new ArrayList<>();
        visit = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(maps[i].charAt(j) != 'X' && !visit[i][j]){
                    sum = (maps[i].charAt(j)-'0');
                    q.add(new int[]{i,j});
                    visit[i][j] = true;
                    result.add(bfs(maps.length, maps[0].length(), maps)); 
                }
            }
        }
        Collections.sort(result);
        
        if(result.size() != 0){
           answer = new int[result.size()];
            for(int i=0; i<result.size(); i++){
                answer[i] = result.get(i);
            } 
        }else{
            answer = new int[]{-1};
        }
               
        return answer;
    }
    
    public int bfs(int h, int w, String[] maps){
        while(!q.isEmpty()){
            int[] poll = q.poll();
            for(int i=0; i<4; i++){
                int nextY = poll[0] + dy[i];
                int nextX = poll[1] + dx[i];
                if(nextY < h && nextX < w && nextY >= 0 && nextX >= 0 && !visit[nextY][nextX]){
                    if(maps[nextY].charAt(nextX) != 'X'){
                        visit[nextY][nextX] = true;
                        q.add(new int[]{nextY,nextX});
                        sum += maps[nextY].charAt(nextX)-'0';
                        bfs(h,w, maps);
                    }
                }
            }
        }
        return sum;
    }
}