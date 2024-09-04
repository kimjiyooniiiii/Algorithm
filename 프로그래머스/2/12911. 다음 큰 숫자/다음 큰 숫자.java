// 2 : 10
import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = n;
        int oneOfN = countOne(Integer.toBinaryString(n));
        
        while(true){
            answer++;
            if(countOne(Integer.toBinaryString(answer)) == oneOfN){
                break;
            }
        }
        return answer;
    }
    
    public int countOne(String binaryStr){
        int result = 0;
        
        for(int i=0; i<binaryStr.length(); i++){
            if(binaryStr.charAt(i) == '1'){
                result++;
            }
        }
        
        return result;
    }
}