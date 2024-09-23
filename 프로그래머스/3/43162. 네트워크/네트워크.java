// 10:22
import java.util.*;
class Solution {
    private boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visit[i]){
                visit[i] = true;
                answer++;
                dfs(n, computers, answer, i);
            }
        }
        
        return answer;
    }
    
    public void dfs(int n, int[][] computers, int answer, int i){
        for(int j=0; j<n; j++){
            if(!visit[j] && computers[i][j] == 1){
                visit[j] = true;
                dfs(n, computers, answer, j);
            }
        }
    }
}
// 방문 자체가 없다면 다음에 방문할 수 있다.