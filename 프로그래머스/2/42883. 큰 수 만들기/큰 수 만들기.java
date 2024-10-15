
import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Deque<Integer> q = new LinkedList<>();
        int resultLen = number.length() - k;

        int lastIndex = 0;
        for(int i=0; i<number.length(); i++){
            int cur = number.charAt(i)-'0';
            
            while(!q.isEmpty()){
                int prev = q.peekLast();
                if(prev < cur){
                    //System.out.println(prev + " 제거"); 
                    q.pollLast();
                    k--;
                    if(k <= 0)  break;
                }else{
                    break;
                }
            }
            if(k <= 0) {
                lastIndex = i;
                //System.out.println(i); 
                break;
            } 
            q.addLast(cur);
            //System.out.println(cur + " 추가"); 
        }
        if(k > 0) {
            lastIndex = number.length()-1;
        }
       //System.out.println(lastIndex);
        
        
        StringBuilder sb = new StringBuilder();
        
        while(!q.isEmpty()){
            sb.append(q.pollFirst());
            if(--resultLen <= 0)    break;
        }
        //System.out.println(lastIndex + " " + resultLen);
        
        for(int i=lastIndex; i<lastIndex + resultLen; i++){
            sb.append(String.valueOf(number.charAt(i)));
        }
        
        return sb.toString();
    }
}
