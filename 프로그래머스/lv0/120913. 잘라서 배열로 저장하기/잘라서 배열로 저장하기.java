import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        int count = (int)(Math.ceil((double)my_str.length()/n));
        String[] answer = new String[count];

        for(int i=0; i<count; i++) {
            if(i==count-1){
                answer[i] = my_str.substring(n*i,my_str.length());
            }
            else{
                 answer[i] = my_str.substring(n*i,n*i+n);
            }
        }
        
        return answer;
    }
}