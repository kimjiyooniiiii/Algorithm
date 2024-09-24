import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> q = new PriorityQueue<>();
        boolean isZero = true;
        for(int s : scoville){
            q.add(s);
        }
        
        while(!q.isEmpty()){
            if(q.peek() >= K) break;
            
            if(q.size() == 1) {
                answer = -1;
                break;
            }
            
            q.add(q.poll() + q.poll() * 2);
            answer++;
        }
        
        return answer;
    }
}

// 배열에 있는 수를 반복해서 가장 작은 수를 꺼내야함 -> 우선순위 큐