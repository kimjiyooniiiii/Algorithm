
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        
        for(int i=0; i<len; i++){   // i만큼 왼쪽 회전
            answer += count(i, s);
        }
            
        return answer;
    }
    
    public int count(int left, String s){
        Stack<Character> stack = new Stack<>();
        
        for(int i=left; i<s.length(); i++){ 
            char c = s.charAt(i);
            check(stack, c);
        }
        for(int i=0; i<left; i++){
            char c = s.charAt(i);
            check(stack, c);
        }
        
        if(stack.isEmpty()) return 1;
        else return 0;
    }
    
    public void check(Stack<Character> stack, char c){
        if(stack.isEmpty()){
                stack.push(c);
            }
            else if(c == '[' || c == '(' || c == '{'){
                stack.push(c);
            }
            else if(c == ']' && stack.peek() == '['
              || c == '}' && stack.peek() == '{'
              || c == ')' && stack.peek() == '('){
                stack.pop();
            }
    }

}