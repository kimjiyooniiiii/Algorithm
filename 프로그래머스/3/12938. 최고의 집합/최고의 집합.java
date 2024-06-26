import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {-1};
        
        if(n <= s){
            answer = new int[n];
            int index = 0;
            while(n > 0){
                int divide = s / n;
                answer[index++] = divide;
                s -= divide;
                n--;
            }
        }
        
        return answer;
    }
}