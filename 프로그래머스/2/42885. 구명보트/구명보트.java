import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int start = 0, end = people.length-1;
        
        while(true){
           // System.out.println("start " + start + " end " + end);
        if(start == end){
            answer++;
            break;
        }else if(start > end){
            break;
        }else{
           // System.out.println("sum " + (people[start] + people[end]));
            if(people[start] + people[end] <= limit){
                start++;
                end--;
                answer++;
            }else{
                end--;
                answer++;
            }   
        }
            //System.out.println("answer " + answer);
            
        }
        
        
        return answer;
    }
}