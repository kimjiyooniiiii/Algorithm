import java.util.*;
class Solution {
    private List<int[]> route = new ArrayList<>();
    public int[][] solution(int n) {
        int[][] answer;
        recur(n, 1, 2, 3);
        
        answer = new int[route.size()][2];
        for(int i=0; i<route.size(); i++){
            answer[i][0] = route.get(i)[0];
            answer[i][1] = route.get(i)[1];
        }
        return answer;
    }
    
    public void recur(int n, int first, int second, int third){
        if(n == 1){
            route.add(new int[]{first, third});
            return;
        }
        recur(n-1, first, third, second);
        route.add(new int[]{first, third});
        recur(n-1, second, first, third);
    }
}