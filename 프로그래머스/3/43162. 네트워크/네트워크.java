import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[][] visit = new boolean[n][n];
        
        for(int i=0; i<n; i++){
                if(!visit[i][i]){
                    visit[i][i] = true;
                    answer++;
                    //System.out.println(i + " -> " + i);
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    bfs(q, n, visit, computers);
                    //System.out.println("-------------");
                }
        }
        return answer;
    }
    public void bfs(Queue<Integer> q, int n, boolean[][] visit, int[][] computers){
        while(!q.isEmpty()){
            int poll = q.poll();
            for(int j=0; j<n; j++){
                if(!visit[poll][j] && computers[poll][j] == 1){
                    visit[poll][j] = true;
                    q.add(j);
                    //System.out.println(poll + " -> " + j);
                }
            }
        }
    }
}
