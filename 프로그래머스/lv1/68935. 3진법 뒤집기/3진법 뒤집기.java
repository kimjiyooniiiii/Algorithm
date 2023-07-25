import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String three = Integer.toString(n, 3);
        StringBuffer sb = new StringBuffer(three);
        sb.reverse();

        answer = Integer.parseInt(String.valueOf(sb), 3);
        
        return answer;
    }
}