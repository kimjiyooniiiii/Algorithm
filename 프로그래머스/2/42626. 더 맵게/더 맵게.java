import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++) {
            queue.offer(scoville[i]);
        }
        
        while(!queue.isEmpty()){
            // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없을 때
            if(queue.size() == 1 && queue.peek() < K){
                answer = -1;
                break;
            }
            
            // 제일 안 매운 음식
            int first = queue.poll();
            
            // 제일 안 매운 음식의 스코빌 지수가 K 이상일 때
            if(first >= K){
                break;
            }
            
            // 두번 째로 안 매운 음식과 섞는다.
            if(!queue.isEmpty()){
                int second = queue.poll();
                queue.offer(first + second * 2);
                answer++;
            }
            
        }
        
        return answer;
    }
}