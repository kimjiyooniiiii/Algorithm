import java.util.*;

class Solution {
    private boolean[][] visit;
    private int[][] matrix;
    private int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
      
        return answer;
    }
    
    public void dfs(int[] numbers, int sum, int depth, int target){
        if(depth == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        dfs(numbers, sum+numbers[depth], depth+1, target);
        dfs(numbers, sum-numbers[depth], depth+1, target);
    }
}

