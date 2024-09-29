// 9:13
import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        
        for(int[] r : routes) q.add(r);
        
        while(!q.isEmpty()){
            int inTime = q.poll()[1];
            //System.out.println("inTime " + inTime);
            answer++;
            
            while(!q.isEmpty() && q.peek()[0] <= inTime){
               // System.out.println("poll " + q.peek()[0]);
                q.poll();
            }
        }

        
        return answer;
    }
}
