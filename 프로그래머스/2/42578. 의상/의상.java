import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> type = new HashMap<>();
        
        for(String[] cloth : clothes){
            String key = cloth[1];
            type.put(key, type.getOrDefault(key, 0) + 1);
        }
        
        for(String k : type.keySet()){
            answer *= (type.get(k) + 1);
        }
       
        return answer-1;
    }
    
}