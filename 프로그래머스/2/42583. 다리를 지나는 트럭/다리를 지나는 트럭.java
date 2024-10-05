// 6:32
import java.util.*;
class Solution {
    private Queue<Integer> q = new LinkedList<>();
    private Queue<Integer> location = new LinkedList<>();
    private int time = 0, index = 0, curWeight = 0;
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        for(int i=0; i<bridge_length; i++)  location.add(0);

        int count = 0;
        while(true){
            if(index >= truck_weights.length) {
                time += bridge_length;
                break;
            }
            int w = truck_weights[index];
            int isTruck = location.poll();
            
            if(isTruck == 1){
                //System.out.println("무게 빼기 " + q.peek());
                curWeight -= q.poll();
            }
            
            if(q.size() < bridge_length && curWeight + w <= weight){    
                plus(w);
            }else{
                location.add(0);
            }
            time++;
            count++;
            //System.out.println("시간 " + time + "------------");
        }
        //System.out.println("끝 시간 " + time);
        return time;
    }
    public void plus(int w){
        curWeight += w;
        q.add(w);
        index++;
        location.add(1);
        //System.out.println("무게 추가 " + w + " 총 " + curWeight);
    }
}