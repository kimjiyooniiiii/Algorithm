import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> compare = new Stack<>();
        compare.push(0);    // 첫 번째 인덱스 넣기
        
        for(int i=1; i<numbers.length; i++){
            while(!compare.isEmpty() && numbers[compare.peek()] < numbers[i]){
                //int prevIndex = compare.peek();
                //if(numbers[prevIndex] < numbers[i]){
                    int prevIndex = compare.pop();
                    answer[prevIndex] = numbers[i];
                //}
            }
            compare.push(i);
        }
        
        while(!compare.isEmpty()){
            int popIndex = compare.pop();
            answer[popIndex] = -1;
        }
        
        return answer;
    }
}