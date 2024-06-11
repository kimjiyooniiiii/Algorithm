import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int[] num = new int[number.length()];
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<number.length(); i++){
            num[i] = number.charAt(i) - '0';
        }
        
        int start = 0;
        for(int i=k; i<number.length(); i++){
            //System.out.print(start + " ~ " + i);
            int maxIndex = max(num, start, i);
            start = maxIndex + 1;
            sb.append(String.valueOf(num[maxIndex]));
            //System.out.println(" max " + num[maxIndex]);
        }
        answer = sb.toString();
        return answer;
    }
    
    public int max(int[] num, int start, int end){  // 가장 큰 수의 위치 반환
        int max = -1;
        int maxIndex = 0;
        for(int i=start; i<=end; i++){
            if(num[i] > max){
                max = num[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    
}