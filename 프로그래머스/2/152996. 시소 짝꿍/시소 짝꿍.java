import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> prev = new HashMap<>();
        
        for(int i=0; i<weights.length; i++){
            if(prev.containsKey(weights[i]*1.0)){
                answer += prev.get(weights[i]*1.0);
                //System.out.println(weights[i]);
            }
            if(prev.containsKey(weights[i]*2.0/3.0)){
                answer += prev.get(weights[i]*2.0/3.0);
                //System.out.println(weights[i]*2.0/3.0);
            }
            if(prev.containsKey(weights[i]*3.0/4.0)){
                answer += prev.get(weights[i]*3.0/4.0);
                // System.out.println(weights[i]*3.0/4.0);
            }
            if(prev.containsKey(weights[i]*2.0/4.0)){
                answer += prev.get(weights[i]*2.0/4.0);
                // System.out.println(weights[i]*2.0/4.0);
            }
            prev.put(weights[i]*1.0, prev.getOrDefault(weights[i]*1.0,0)+1);
        }
        return answer;
    }
}
