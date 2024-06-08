import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> compare = new Stack<>();
        compare.push(0);
        
        for(int i=1; i<prices.length; i++){
            while(!compare.isEmpty() && prices[compare.peek()] > prices[i]){
                int prev = compare.pop();   // 이전 가격 인덱스
                answer[prev] = i - prev;
            }
            compare.push(i);
        }
        
        while(!compare.isEmpty()){
            int i = compare.pop();
            answer[i] = prices.length - 1 - i;
        }
        
        return answer;
    }
}

// 뒤에 자기보다 작은 수가 있다면 (그 인덱스 - 자신의 인덱스)를 결과에 넣기
// 그렇지 않다면 (배열 길이 - 1 - 자신의 인데스) 넣기