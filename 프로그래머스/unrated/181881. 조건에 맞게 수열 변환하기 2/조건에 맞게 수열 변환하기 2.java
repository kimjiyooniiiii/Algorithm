import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int same = 0;
        int[] newArr = new int[arr.length];
        
        while(true){
            answer++;
            
            for(int i=0; i<arr.length; i++) {
                if((arr[i]>=50) && (arr[i]%2 == 0)){
                    newArr[i] = arr[i] / 2;
                    if(newArr[i] == arr[i]){
                        same++;
                    }
                }
                else if((arr[i]<50) && (arr[i]%2 == 1)){
                    newArr[i] = arr[i] * 2 + 1;
                    if(newArr[i] == arr[i]){
                        same++;
                    }   
                }
                else{
                    newArr[i] = arr[i];
                    same++;
                }
            }
            if(same == arr.length){
                break;
            }else{
                same = 0;
                arr = newArr.clone();
            }

        }
        
        return answer-1;
    }
}