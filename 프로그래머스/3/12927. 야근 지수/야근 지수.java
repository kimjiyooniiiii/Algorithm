// 5:00
import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for(int w : works) q.add(w);
        
        for(int i=0; i<n; i++){
            if(q.isEmpty()) break;
            int peek = q.peek();
            //System.out.println(peek);
            
            if(peek > 1) q.add(q.poll() - 1);
            else q.poll();
        }
        
        while(!q.isEmpty()){
            answer += Math.pow(q.poll(),2);
        }
        
        return answer;
    }
}