// 2:54 -> 3:20
import java.util.*;

class Solution {
    private int answer = 0;    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int depth, int sum){
        if(depth >= numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        } 
        dfs(numbers, target, depth+1, sum + numbers[depth]);
        dfs(numbers, target, depth+1, sum + (-1) * numbers[depth]);
    }
}

