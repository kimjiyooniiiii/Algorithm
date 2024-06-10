import java.util.*;
class Solution {
    private int answer = 0;
    Queue<Integer> bridge = new LinkedList<>();
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        for(int i=0; i<truck_weights.length; i++){
            if(bridge.size() == bridge_length){
                weight += bridge.poll();
            }
            if(weight < truck_weights[i]){
                bridge.add(0);
                answer++;
                i--;
            }else{
                bridge.add(truck_weights[i]);
                weight -= truck_weights[i];
                answer++;
            }
        }
        return answer + bridge_length;
    }

}