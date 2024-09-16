// 2 : 27
import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> timesList = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++){
            int remain = 100 - progresses[i];
            int times = (remain % speeds[i]) > 0 ? remain / speeds[i] + 1 : remain / speeds[i];
            timesList.add(times);
        }
        
        List<Integer> deployCount = new ArrayList<>();
        
        while(!timesList.isEmpty()){
            int stand = timesList.poll();
            int count = 1;
            
            while(!timesList.isEmpty() && timesList.peek() <= stand) {
                count++; 
                timesList.poll();
            }
            deployCount.add(count);
        }
        
        
        return deployCount;
    }
    
}
