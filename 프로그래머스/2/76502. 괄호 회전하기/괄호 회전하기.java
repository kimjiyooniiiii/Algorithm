// 시간복잡도 O(n^2)
// 공간복잡도 O(n)

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        // 컬렉션을 선언하기 위해 char의 wrapper 클래스인 Character를 사용한다.
        Deque<Character> letters = new LinkedList<>();
        
        for(int i=0; i<s.length(); i++){
            letters.add(s.charAt(i));
        }
        
        // 왼쪽으로 회전 시켜서 올바른 괄호인지 확인하기
        for(int i=0; i<s.length(); i++){
            if(i != 0){
                letters.addLast(letters.pollFirst());
            }
            // 참조 변수 깊은 복사하기
            Deque<Character> copy = new LinkedList<>();
            copy.addAll(letters);
            
            // 올바른 괄호인지 확인하기
            if(isCorrect(copy)){
                answer++;
            }
        }
            
        return answer;
    }
    
    public boolean isPair(char current, char peek){
        char[] open = {'{','(','['};
        char[] close = {'}',')',']'};
        
        for(int i=0; i<3; i++){
            if(open[i] == current && close[i] == peek){
                return true;
            }
        }
        return false;
    }

    // 함수를 분리하여 코드의 재사용성을 높이고, 가독성을 높이겠습니다.
    public boolean isCorrect(Deque<Character> letters){
        // 짝이 맞는 괄호가 있는지 확인하기 위해 괄호를 저장해놓는 임시 스택
        Stack<Character> compare = new Stack<>();
        
        while(!letters.isEmpty()){
            char current = letters.pollLast();
            if(compare.isEmpty()){
                compare.push(current);
            }
            else{
                // 비교군의 최근 괄호와 짝이 맞고, 열려있는 괄호라면 비교군에서 삭제
                if(isPair(current,compare.peek())){ 
                    compare.pop();
                }else{
                    compare.push(current);
                }
            }
        }
        // 모든 비교가 끝난 후, 짝이 안맞는 괄호가 남아있다면 올바른 괄호 배열이 아님
        if(compare.size() != 0){    
            return false;
        }
        return true;
    }
}