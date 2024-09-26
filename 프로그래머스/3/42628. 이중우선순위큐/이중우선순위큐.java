// 8:00
import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String o : operations){
            String[] split = o.split(" ");
            if(split[0].equals("I")) q.add(Integer.parseInt(split[1]));
            else if(split[1].equals("1") && !q.isEmpty()) q.poll();
            else {
                lastNumber(q);
            }
            
            // Iterator<Integer> it = q.iterator();
            // while(it.hasNext()) {
            //     System.out.print(it.next() + " ");
            // }
            // System.out.println();
        }
        
        if(!q.isEmpty()){
            answer[0] = q.peek();
            answer[1] = lastNumber(q);
        }
        
        return answer;
    }
    
    public int lastNumber(PriorityQueue<Integer> q) {
        int last = 0;
        if(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            while(q.size() > 1) temp.add(q.poll());
            last = q.poll();
            for(int t : temp) q.add(t);
        }
        return last;
    }
}