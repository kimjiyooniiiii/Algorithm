import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0, height = triangle.length;
        
        for(int i=height-2; i>=0; i--){
            for(int j=0; j<triangle[i].length; j++){
                triangle[i][j] = triangle[i][j] + Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }
        
        answer = triangle[0][0];

        return answer;
    }
}
