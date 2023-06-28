import java.util.Arrays;

class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        
        for(int i=numLog.length-1; i>0; i--) {
            if(numLog[i] - numLog[i-1] == 1) {
                answer = "w" + answer;
            }
            else if(numLog[i] - numLog[i-1] == -1) {
                answer = "s" + answer;
            }
            else if(numLog[i] - numLog[i-1] == 10) {
                answer = "d" + answer;
            }
            else if(numLog[i] - numLog[i-1] == -10) {
                answer = "a" + answer;
            }
        }

        return answer;
    }
}