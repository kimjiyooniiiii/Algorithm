import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list
            = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toList());
        
        int len = arr.length;
        if(!isPower(len)){
            int count = plus(len) - len;
            while(count > 0){
                list.add(0);
                count--;
            }
        }
        
        int[] answer = list.stream()
            .mapToInt(i -> i)
            .toArray();
        
        return answer;
    }
    
    public boolean isPower(int size){
        double d = (double)size;
        boolean result = true;
        
        while(d != 1.0){
            d /= 2;
            
            if(d != (int)d){
                result = false;
                break;
            }
            
        }
        return result;
    }
    
    public int plus(int size){
        while(!isPower(size)){
            size++;
        }
        return size;
    }
}