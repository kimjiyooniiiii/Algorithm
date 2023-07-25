import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();        
        
        for(int i=0; i<arr.length; i++) {
            queue.offer(arr[i]);
        }
        if(queue.peek() != null){    // 첫번째 요소 넣기
            list.add(queue.poll());
        }
        
        while(queue.peek() != null){
            
            if(list.get(list.size()-1) != queue.peek()){
                list.add(queue.poll());
            }else{
                queue.poll();
            }
        }
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}