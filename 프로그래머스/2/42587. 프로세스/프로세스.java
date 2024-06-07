import java.util.*;
class Solution {
    class Process{
        private int name;
        private int priority;
        public Process(int name, int priority){
            this.name = name;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> processQ = new LinkedList<>();    // 2 1 3 2
        for(int i=0; i<priorities.length; i++){
            processQ.add(new Process(i,priorities[i]));
        }
        
        Arrays.sort(priorities);    //  3 2 2 1 실행되어야 하는 우선순위
        
        answer = run(priorities, location, processQ);
        return answer;
    }
    
    public int run(int[] priorities, int location, Queue<Process> processQ){
        int current = priorities.length-1;    // 현재 실행되어야 하는 우선순위
        int result = 1;
        while(!processQ.isEmpty()){
            Process p = processQ.poll();
            // 큐에서 나온 프로세스의 우선순위가 현재 실행해야 하는 우선순위와 같은지 비교
            if(priorities[current] == p.priority){  
                if(p.name == location){ // 찾고자하는 프로세스 였다면 몇번째 실행인지 반환
                    return result;
                }
                result++;   // 프로세스 실행 후
                current--;
            }
            else{   // 아직 순서가 되지 않은 프로세스라면
                processQ.add(p);
            }
        }
        return -1;
    }
}