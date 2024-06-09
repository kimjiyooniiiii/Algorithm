import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int cur = 1;    // 컨테이너 벨트에서 나오는 순서
        Stack<Integer> sub = new Stack<>();
        
        for(int i=0; i<order.length; i++){  // 기사님이 말씀한 순서
            int search = order[i];
            boolean isSame = false;
            //System.out.println("찾는 물건 " + search);
            
            if(!sub.isEmpty() && sub.peek() == search){ // 보조 컨테이너에 있다면
                //System.out.println("보조에 있음 " + search);
                sub.pop();
                answer++;
                continue;
            }
            while(cur <= order.length){
                if(search == cur){
                    //System.out.println("컨테이너에 있음 " + search);
                    answer++;
                    cur++;
                    isSame = true;
                    break;
                }
                //System.out.println("컨테이너 뒤지기 " + cur);
                sub.push(cur++);
            }
            if(!isSame){
                //System.out.println("아무데서도 못찾음");
                break;
            }
        }
        
        return answer;
    }
}

// 보조 컨테이너 벨트 - 스택