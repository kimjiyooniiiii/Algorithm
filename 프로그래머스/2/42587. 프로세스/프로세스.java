import java.util.*;
class Solution {

    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<int[]> process = new LinkedList<>();      // [순위, 인덱스]
        for(int i=0; i<priorities.length; i++){
            process.add(new int[]{priorities[i],i});
        }
        Arrays.sort(priorities);
        
        int curPriorityIndex = priorities.length-1;     // 현재 가장 높은 우선 순위의 위치
        
        while(!process.isEmpty()){
            int[] p = process.poll();
            int curPriority = priorities[curPriorityIndex]; 
            //System.out.println(curPriority + " " + location);
                
            if(p[0] == curPriority && p[1] == location){
                //System.out.println("찾음 " + curPriority + " " + location);
                return answer;
            }
            if(p[0] != curPriority){
                //System.out.println("후순위 " + p[0] + " " + p[1]);
                process.add(p);
            }else{
                //System.out.println("먼저 나감 " + curPriority + " " + p[1]);
                curPriorityIndex--;
                answer++;
            }
        }

        return answer;
    }

}