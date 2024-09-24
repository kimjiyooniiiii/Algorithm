// 뒤 작은 수
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<prices.length; i++){
            int count = 1;
            while(!stack.isEmpty()){
                int prevI = stack.peek();
                if(prices[prevI] > prices[i]){
                    //answer[stack.pop()] = count++;
                    answer[stack.pop()] = i - prevI;
                }else break;
            }
            stack.push(i);
        }
        
        for(int i=0; i<answer.length; i++){
            if(answer[i] == 0){
                answer[i] = answer.length - i - 1;
            }
        }
        return answer;
    }
}

// 같은 배열 안에서 여러개와 비교할 때는 스택을 사용하는 거 같다.
// 1,2,2,0,3    [0,0,1,0,0] 전체 길이 - 자신의 인덱스 - 1