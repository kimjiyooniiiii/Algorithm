import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> oper = new PriorityQueue<>(Comparator.reverseOrder());
        for(int w : works){
            oper.add(w);
        }
        
        for(int i=0; i<n; i++){
            if(!oper.isEmpty()){
                int work = oper.poll();
                if(--work > 0){
                    oper.add(work);
                }
            }
        }
        
        while(!oper.isEmpty()){
            int work = oper.poll();
            answer += (work * work);
        }
        
        return answer;
    }
}
// 야근을 시작한 시점에 양이 작아지도록