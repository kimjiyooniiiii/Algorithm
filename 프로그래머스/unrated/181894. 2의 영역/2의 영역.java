import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
    
        int first = -1;
        int last = -1;
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 2){
                first = i;
                break;
            }
        }
        for(int i=arr.length-1; i>=0; i--) {
            if(arr[i] == 2){
                last = i;
                break;
            }
        }
        
        int[] answer = new int[last-first+1];
        
        if(first == -1) {
            answer[0] = -1;
        }
        else{
            answer = Arrays.copyOfRange(arr,first,last+1);
        }
        
        return answer;
            
    }
}