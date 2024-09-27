// 10:34 -> 11:06
import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> sub = new Stack<>();
        
        int max = order.length;
        int newB = 0;
        int selectB = 0;
        
        while(true){
            if(newB > max-1 || selectB > max-1) {
                //System.out.println(newB > max-1 || selectB > max-1);
                break;
            }
            if(newB+1 == order[selectB]){
              //  System.out.println(newB+1 + "==" + order[selectB]);
                answer++;
                newB++; selectB++;
            }else if(newB+1 > order[selectB]){
                if(sub.isEmpty() || sub.peek() != order[selectB]) break;
                else{
                    int s = sub.pop();  selectB++;  answer++;
                //    System.out.println(s + "==" + order[--selectB]);
                //    selectB++;
                }
            }else{
                sub.push(++newB);
               // System.out.println("push " + (newB));
            }
        }
        
        while(!sub.isEmpty() && selectB <= max-1){
            if(sub.peek() != order[selectB]) break;
            else{
                int s = sub.pop();  selectB++;  answer++;
               // System.out.println(s + "==" + order[--selectB]);
               // selectB++;
            }
        }
       
        return answer;
    }
}
