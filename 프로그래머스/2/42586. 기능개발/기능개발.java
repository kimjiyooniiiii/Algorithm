import java.util.*;
import java.math.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        List<Integer> deployCount = new ArrayList<>();
        int day = 0;
        
        Queue<int[]> order = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            order.add(new int[]{progresses[i], speeds[i]});
        }
        
        int size = 0;
        while(!order.isEmpty()){
            int[] peek = order.peek();
            peek[0] += (peek[1] * day);     // 날짜가 지난만큼 진도 업데이트 하기
            
            int divide = (100 - peek[0])/peek[1];
            int spare = (100 - peek[0])%peek[1];
            //System.out.println("몫 " + divide + " 나머지 "  + spare);
            
            if(spare > 0){
                day += (divide + 1);
            }else {
                day += divide;
            }
            int result = deploy(order, day);
            deployCount.add(result);
            
            //System.out.println("day " + day);
            //System.out.println("count " + result +" ----------------");
            size++;
        }
        
        answer = new int[size];
        for(int i=0; i<size; i++){
            answer[i] = deployCount.get(i);
        }
        return answer;
    }
    
    public int deploy(Queue<int[]> order, int day){
        int count = 0;
        while(!order.isEmpty()){
            int[] peek = order.peek();  // [0]은 진척도, [1]은 속도
            if(peek[1] * day + peek[0] >= 100){
                order.poll();
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}

// 배포 순서가 주어짐.  각 속도와 연관지어 진척도를 더하고 하루를 더함
// 만약 앞에 있는게 100 이상이 되었다면 앞에서부터 전부 배포시킴. 배포가 끝나면 개수를 배열에 저장함.
// 만약 큐가 끝났다면 프로그램을 끝냄


// 진척도가 1이고 속도가 1일 때, 최대 100일이 걸림.

// 큐의 맨 앞부터 걸리는 일수를 구함. 일수는 전역변수. 그리고 하나씩 탐색하면서 개수를 셈.
// 