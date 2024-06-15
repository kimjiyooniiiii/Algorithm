import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> number = new PriorityQueue<>(Comparator.reverseOrder());
        Stack<Integer> temp = new Stack<>();
        
        for(int i=0; i<operations.length; i++){
            String[] oper = operations[i].split(" ");
            if(oper[0].equals("I")){
                number.add(Integer.parseInt(oper[1]));
                //System.out.println(oper[1] + "삽입");
            }else if(oper[1].equals("-1")){     // 최소값 삭제
                removeMin(number, temp);
            }else{
                if(!number.isEmpty()){
                    int n = number.poll();
                   // System.out.println(n + "삭제");
                }
            }
        }
        
        if(number.size() == 1){
            int n = number.poll();
            answer[0] = n; answer[1] = n;
        }else if(number.size() > 1){
            answer[0] = number.poll();
            answer[1] = removeMin(number, temp);
        }
        
        return answer;
    }
    
    public int removeMin(PriorityQueue<Integer> number, Stack<Integer> temp){
        int n = 0;
        if(!number.isEmpty()){
            while(!number.isEmpty()){
                temp.push(number.poll());
            }
            n = temp.pop();
            //System.out.println(n + "삭제");
            while(!temp.isEmpty()){
                number.add(temp.pop());
            }
        }
        return n;
    }
}